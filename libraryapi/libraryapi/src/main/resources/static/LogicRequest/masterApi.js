/**
 * masterApi.js — cliente HTTP singleton com CRUD genérico.
 * Interfaces por model importam este módulo e usam RESOURCES + crudFor() ou os métodos diretos.
 */

const DEFAULT_TIMEOUT_MS = 8000;

const CONFIG = {
  get baseUrl() {
    if (typeof window !== "undefined" && window.location?.protocol !== "file:") {
      return window.location.origin;
    }
    return "http://localhost:8080";
  },
  timeoutMs: DEFAULT_TIMEOUT_MS,
  headers: {
    "Content-Type": "application/json",
    Accept: "application/json",
  },
};

/** Endpoints alinhados aos @RequestMapping dos controllers Spring. */
export const RESOURCES = Object.freeze({
  BOOK: "Book",
  AUTHOR: "Author",
});

export class ApiError extends Error {
  constructor(status, message, data = null) {
    super(message);
    this.name = "ApiError";
    this.status = status;
    this.data = data;
  }
}

class MasterApi {
  static #instance = null;

  #defaultHeaders;

  constructor() {
    this.#defaultHeaders = { ...CONFIG.headers };
  }

  /**
   * @returns {MasterApi}
   */
  static getInstance() {
    if (!MasterApi.#instance) {
      MasterApi.#instance = new MasterApi();
    }
    return MasterApi.#instance;
  }

  setAuthToken(token) {
    if (token) {
      this.#defaultHeaders.Authorization = `Bearer ${token}`;
    } else {
      delete this.#defaultHeaders.Authorization;
    }
  }

  #buildUrl(endpoint) {
    const base = CONFIG.baseUrl.replace(/\/$/, "");
    const path = String(endpoint).replace(/^\//, "");
    return `${base}/${path}`;
  }

  async #request(endpoint, options = {}) {
    const url = this.#buildUrl(endpoint);
    const controller = new AbortController();
    const timeoutId = setTimeout(() => controller.abort(), CONFIG.timeoutMs);

    try {
      const response = await fetch(url, {
        ...options,
        headers: {
          ...this.#defaultHeaders,
          ...options.headers,
        },
        signal: controller.signal,
      });

      if (!response.ok) {
        const errorBody = await response.json().catch(() => ({}));
        const msg =
          errorBody.message ||
          errorBody.error ||
          response.statusText ||
          `HTTP ${response.status}`;
        throw new ApiError(response.status, msg, errorBody);
      }

      if (response.status === 204) return null;
      const text = await response.text();
      if (!text) return null;
      return JSON.parse(text);
    } catch (err) {
      if (err instanceof ApiError) throw err;
      if (err.name === "AbortError") {
        throw new ApiError(408, `Timeout após ${CONFIG.timeoutMs}ms em ${endpoint}`);
      }
      throw err;
    } finally {
      clearTimeout(timeoutId);
    }
  }

  /**
   * READ — lista (GET com query opcional).
   * @param {string} resource — ex.: RESOURCES.BOOK
   * @param {Record<string, string|number|boolean>} [queryParams]
   */
  async getAll(resource, queryParams = {}) {
    const q = new URLSearchParams(queryParams).toString();
    const path = q ? `${resource}?${q}` : resource;
    return this.#request(path, { method: "GET" });
  }

  /**
   * READ — um registro por id (GET /resource/:id).
   */
  async getById(resource, id) {
    return this.#request(`${resource}/${id}`, { method: "GET" });
  }

  /**
   * CREATE (POST /resource).
   */
  async create(resource, data) {
    return this.#request(resource, {
      method: "POST",
      body: JSON.stringify(data ?? {}),
    });
  }

  /**
   * UPDATE completo (PUT /resource/:id).
   */
  async update(resource, id, data) {
    return this.#request(`${resource}/${id}`, {
      method: "PUT",
      body: JSON.stringify(data ?? {}),
    });
  }

  /**
   * UPDATE parcial (PATCH /resource/:id).
   */
  async patch(resource, id, data) {
    return this.#request(`${resource}/${id}`, {
      method: "PATCH",
      body: JSON.stringify(data ?? {}),
    });
  }

  /**
   * DELETE (DELETE /resource/:id).
   */
  async remove(resource, id) {
    return this.#request(`${resource}/${id}`, { method: "DELETE" });
  }

  /**
   * Fábrica de interface CRUD já “amarrada” a um resource.
   * Cada model pode ter um arquivo que só chama crudFor(RESOURCES.BOOK), por exemplo.
   *
   * @param {string} resource
   * @returns {{
   *   list: (query?: Record<string, string|number|boolean>) => Promise<unknown>,
   *   get: (id: string|number) => Promise<unknown>,
   *   create: (data: object) => Promise<unknown>,
   *   update: (id: string|number, data: object) => Promise<unknown>,
   *   patch: (id: string|number, data: object) => Promise<unknown>,
   *   remove: (id: string|number) => Promise<unknown>
   * }}
   */
  crudFor(resource) {
    const self = this;
    return {
      list: (query) => self.getAll(resource, query ?? {}),
      get: (id) => self.getById(resource, id),
      create: (data) => self.create(resource, data),
      update: (id, data) => self.update(resource, id, data),
      patch: (id, data) => self.patch(resource, id, data),
      remove: (id) => self.remove(resource, id),
    };
  }
}

/** Instância singleton exportada para uso direto. */
export const masterApi = MasterApi.getInstance();

export { MasterApi };

export default masterApi;

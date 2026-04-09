import { masterApi, RESOURCES } from '../LogicRequest/masterApi.js';

export class LivroService {
    constructor(apiClient) {
        this.bookApi = apiClient.crudFor(RESOURCES.BOOK);
    }

    async listarTodos() {
        return await this.bookApi.list();
    }

    async buscarPorId(id) {
        return await this.bookApi.get(id);
    }

    async criar(livro) {
        // Validações antes de criar
        if (!livro.titulo || !livro.autor) {
            throw new Error('Título e autor são obrigatórios');
        }
        return await this.bookApi.create(livro);
    }

    async atualizar(id, livro) {
        return await this.bookApi.update(id, livro);
    }

    async deletar(id) {
        return await this.bookApi.remove(id);
    }

    // Métodos específicos do domínio
    async buscarPorIsbn(isbn) {
        const todos = await this.listarTodos();
        return todos.find(livro => livro.isbn === isbn);
    }

    async buscarDisponiveis() {
        const todos = await this.listarTodos();
        return todos.filter(livro => livro.disponivel === true);
    }

}
export const livroService = new LivroService(masterApi);


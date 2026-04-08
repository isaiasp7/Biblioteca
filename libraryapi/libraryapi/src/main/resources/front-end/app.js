const sectionsData = {
  novidades: [
    { title: "Os Sete Maridos de Evelyn Hugo", author: "Taylor Jenkins Reid", tag: "Romance" },
    { title: "A Hipotese do Amor", author: "Ali Hazelwood", tag: "Comedia" },
    { title: "Duna", author: "Frank Herbert", tag: "Ficcao" },
    { title: "Sapiens", author: "Yuval Noah Harari", tag: "Historia" },
    { title: "A Paciente Silenciosa", author: "Alex Michaelides", tag: "Suspense" },
    { title: "Amanha, e Amanha, e Amanha", author: "Gabrielle Zevin", tag: "Drama" }
  ],
  maisLidos: [
    { title: "Dom Casmurro", author: "Machado de Assis", tag: "Classico" },
    { title: "1984", author: "George Orwell", tag: "Distopia" },
    { title: "O Pequeno Principe", author: "Antoine de Saint-Exupery", tag: "Ficcao" },
    { title: "Cem Anos de Solidao", author: "Gabriel Garcia Marquez", tag: "Realismo" }
  ],
  maisAvaliados: [
    { title: "A Revolucao dos Bichos", author: "George Orwell", tag: "4.8 ★" },
    { title: "O Hobbit", author: "J. R. R. Tolkien", tag: "4.9 ★" },
    { title: "Memorias Postumas de Bras Cubas", author: "Machado de Assis", tag: "4.8 ★" },
    { title: "Orgulho e Preconceito", author: "Jane Austen", tag: "4.7 ★" }
  ]
};

const novidadesTrack = document.getElementById("novidades-track");
const maisLidosGrid = document.getElementById("mais-lidos-grid");
const maisAvaliadosGrid = document.getElementById("mais-avaliados-grid");
const template = document.getElementById("book-card-template");

function createCard(book) {
  const clone = template.content.cloneNode(true);
  clone.querySelector(".book-title").textContent = book.title;
  clone.querySelector(".book-author").textContent = book.author;
  clone.querySelector(".book-tag").textContent = book.tag;
  return clone;
}

function renderSkeletons(container, amount = 4) {
  for (let i = 0; i < amount; i += 1) {
    const sk = document.createElement("div");
    sk.className = "skeleton";
    container.appendChild(sk);
  }
}

function clearSkeletons(container) {
  container.querySelectorAll(".skeleton").forEach((node) => node.remove());
}

function loadSections() {
  renderSkeletons(novidadesTrack, 5);
  renderSkeletons(maisLidosGrid, 4);
  renderSkeletons(maisAvaliadosGrid, 4);

  setTimeout(() => {
    clearSkeletons(novidadesTrack);
    clearSkeletons(maisLidosGrid);
    clearSkeletons(maisAvaliadosGrid);

    sectionsData.novidades.forEach((book) => novidadesTrack.appendChild(createCard(book)));
    sectionsData.maisLidos.forEach((book) => maisLidosGrid.appendChild(createCard(book)));
    sectionsData.maisAvaliados.forEach((book) => maisAvaliadosGrid.appendChild(createCard(book)));
  }, 1100);
}

function setupScrollReveal() {
  const observer = new IntersectionObserver(
    (entries) => {
      entries.forEach((entry) => {
        if (entry.isIntersecting) {
          entry.target.classList.add("in-view");
          observer.unobserve(entry.target);
        }
      });
    },
    { threshold: 0.12 }
  );

  document.querySelectorAll(".reveal").forEach((el) => observer.observe(el));
}

function setupCarouselNavigation() {
  document.querySelectorAll(".nav-btn").forEach((button) => {
    button.addEventListener("click", () => {
      const direction = Number(button.dataset.direction || 1);
      const trackId = button.dataset.track;
      const track = document.getElementById(trackId);
      if (!track) return;
      const step = Math.max(260, track.clientWidth * 0.75);
      track.scrollBy({ left: direction * step, behavior: "smooth" });
    });
  });
}

loadSections();
setupScrollReveal();
setupCarouselNavigation();

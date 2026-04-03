
-- Inserir 10 autores
INSERT INTO public.autor (id, nome, nacionalidade) VALUES
                                                       ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Machado de Assis', 'Brasileira'),
                                                       ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'J.K. Rowling', 'Britânica'),
                                                       ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'George R.R. Martin', 'Americana'),
                                                       ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a14', 'Agatha Christie', 'Britânica'),
                                                       ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a15', 'Stephen King', 'Americana'),
                                                       ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a16', 'Jane Austen', 'Britânica'),
                                                       ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a17', 'Paulo Coelho', 'Brasileira'),
                                                       ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a18', 'Isaac Asimov', 'Russa'),
                                                       ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a19', 'Clarice Lispector', 'Brasileira'),
                                                       ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a20', 'Gabriel García Márquez', 'Colombiana');

-- Inserir 10 livros
INSERT INTO public.livro (id, titulo, isbn, data_publicacao, preco, genero, id_autor) VALUES
                                                                                          ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380b01', 'Dom Casmurro', '9788535902819', '1899-12-15', 49.90, 'Romance', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11'),
                                                                                          ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380b02', 'Harry Potter e a Pedra Filosofal', '9788532530783', '1997-06-26', 59.90, 'Fantasia', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12'),
                                                                                          ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380b03', 'A Guerra dos Tronos', '9788599296231', '1996-08-01', 79.90, 'Fantasia', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a13'),
                                                                                          ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380b04', 'Assassinato no Expresso do Oriente', '9788578270568', '1934-01-01', 45.90, 'Suspense', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a14'),
                                                                                          ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380b05', 'It - A Coisa', '9788599296330', '1986-09-15', 69.90, 'Terror', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a15'),
                                                                                          ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380b06', 'Orgulho e Preconceito', '9788578270698', '1813-01-28', 39.90, 'Romance', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a16'),
                                                                                          ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380b07', 'O Alquimista', '9788575427321', '1988-01-01', 54.90, 'Ficção', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a17'),
                                                                                          ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380b08', 'Eu, Robô', '9788578271350', '1950-12-02', 49.90, 'CienciaFiccao', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a18'),
                                                                                          ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380b09', 'A Hora da Estrela', '9788525406895', '1977-10-20', 44.90, 'Ficção', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a19'),
                                                                                          ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380b10', 'Cem Anos de Solidão', '9788535902246', '1967-06-05', 64.90, 'Ficção', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a20');

-- Inserir 10 clientes
INSERT INTO public.cliente (id, nome, cpf, email, endereco, cidade, estado, ddd, numero) VALUES
                                                                                             ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380c01', 'Ana Silva', '12345678901', 'ana.silva@email.com', 'Rua das Flores, 123', 'São Paulo', 'SP', 11, 912345678),
                                                                                             ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380c02', 'Carlos Santos', '23456789012', 'carlos.santos@email.com', 'Av. Brasil, 456', 'Rio de Janeiro', 'RJ', 21, 987654321),
                                                                                             ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380c03', 'Mariana Oliveira', '34567890123', 'mariana.oliveira@email.com', 'Rua Minas Gerais, 789', 'Belo Horizonte', 'MG', 31, 998765432),
                                                                                             ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380c04', 'Pedro Costa', '45678901234', 'pedro.costa@email.com', 'Av. Paulista, 1000', 'São Paulo', 'SP', 11, 976543210),
                                                                                             ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380c05', 'Fernanda Lima', '56789012345', 'fernanda.lima@email.com', 'Rua XV de Novembro, 500', 'Curitiba', 'PR', 41, 988776655),
                                                                                             ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380c06', 'Roberto Alves', '67890123456', 'roberto.alves@email.com', 'Av. Beira Mar, 2000', 'Salvador', 'BA', 71, 919876543),
                                                                                             ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380c07', 'Juliana Ferreira', '78901234567', 'juliana.ferreira@email.com', 'Rua das Palmeiras, 321', 'Porto Alegre', 'RS', 51, 955443322),
                                                                                             ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380c08', 'Lucas Rodrigues', '89012345678', 'lucas.rodrigues@email.com', 'Av. Getúlio Vargas, 150', 'Recife', 'PE', 81, 977889900),
                                                                                             ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380c09', 'Patrícia Gomes', '90123456789', 'patricia.gomes@email.com', 'Rua Goiás, 789', 'Goiânia', 'GO', 62, 993344556),
                                                                                             ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380c10', 'Ricardo Nunes', '01234567890', 'ricardo.nunes@email.com', 'Av. Amazonas, 2345', 'Manaus', 'AM', 92, 922334455);
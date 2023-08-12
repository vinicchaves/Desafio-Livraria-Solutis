CREATE TABLE Livro (
    DTYPE VARCHAR(31) NOT NULL,
    id BIGINT PRIMARY KEY,
    titulo VARCHAR(255),
    autores VARCHAR(255),
    editora VARCHAR(255),
    preco FLOAT,
    tamanho FLOAT,
    frete FLOAT,
    estoque INT
);

CREATE TABLE Venda_Livro (
    venda_id BIGINT,
    livro_id BIGINT,
    FOREIGN KEY (venda_id) REFERENCES Venda(id),
    FOREIGN KEY (livro_id) REFERENCES Livro(id)
);

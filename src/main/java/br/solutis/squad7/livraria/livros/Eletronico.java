package br.solutis.squad7.livraria.livros;

import br.solutis.squad7.livraria.Livro;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Eletronico")
public class Eletronico extends Livro {
    private float tamanho;

    public Eletronico(String titulo, String autores, String editora, float preco, float tamanho) {
        super(titulo, autores, editora, preco);
        this.tamanho = tamanho;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return "Eletrônico";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTamanho: " + tamanho + " KB";
    }
}

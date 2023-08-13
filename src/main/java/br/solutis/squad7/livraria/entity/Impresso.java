package br.solutis.squad7.livraria.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Impresso")
public class Impresso extends Livro {
    @Column(name = "frete")
    private float frete;
    @Column(name = "estoque")
    private int estoque;

    public Impresso() {

    }

    public Impresso(String titulo, String autores, String editora, float preco, float frete, int estoque) {
        super(titulo, autores, editora, preco);
        this.frete = frete;
        this.estoque = estoque;
    }


    // setters e getters

    public float getFrete() {
        return frete;
    }

    public void setFrete(float frete) {
        this.frete = frete;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String toString() {
        return super.toString() +
                "\nFrete: " + frete +
                "\nEstoque: " + estoque;
    }

    public void atualizarEstoque() {
        if (estoque > 0) {
            estoque--;
        }
    }

    public String getTipo() {
        return "Impresso";
    }
}

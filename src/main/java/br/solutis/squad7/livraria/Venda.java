package br.solutis.squad7.livraria;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Livro> livros = new ArrayList<>();
    private static int numVendas = 0;
    private int numero;
    private String cliente;
    private float valor;

    public Venda() {
        numVendas++;
        numero = numVendas;
    }

    public void addLivro(Livro livro, int index) {
        if (index >= 0) {
            livros.add(index, livro);
            valor += livro.getPreco();
        } else {
            throw new IllegalArgumentException("Índice inválido para adicionar livro à venda.");
        }
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    //getters e setters

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getValor() {
        return valor;
    }

}

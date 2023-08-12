package br.solutis.squad7.livraria;
import br.solutis.squad7.livraria.livros.*;


import java.util.*;

public class LivrariaVirtual{
    private final int MAX_IMPRESSOS = 10;
    private final int MAX_ELETRONICOS = 20;
    private final int MAX_VENDAS = 50;

    private List<Impresso> impressos;
    private List<Eletronico> eletronicos;
    private List<Venda> vendas;

    private int numImpressos;
    private int numEletronicos;
    private int numVendas;


    public LivrariaVirtual() {
        impressos = new ArrayList<>();
        eletronicos = new ArrayList<>();
        vendas = new ArrayList<>();
    }
    public void cadastrarLivro() {
        // Implementação do sistema de cadastrar livro
    }

    public void realizarVenda() {
        // Implementação do sistema de realizar venda
    }

    public void listarLivrosImpressos() {
        System.out.println("Lista de Livros Impressos:");
        System.out.println("+------+---------------------+----------------------+-------+---------+");
        System.out.println("| ID   | Título              | Autores              | Preço | Estoque |");
        System.out.println("+------+---------------------+----------------------+-------+---------+");
        for (Impresso impresso : impressos) {
            System.out.printf("| %-4d | %-19s | %-20s | %-5.2f | %-7d |%n",
                    impresso.getId(), impresso.getTitulo(), impresso.getAutores(), impresso.getPreco(), impresso.getEstoque());
        }
        System.out.println("+------+---------------------+----------------------+-------+---------+");
    }

    public void listarLivrosEletronicos() {
        System.out.println("Lista de Livros Eletrônicos:");
        System.out.println("+------+---------------------+----------------------+-------+---------+");
        System.out.println("| ID   | Título              | Autores              | Preço | Tamanho |");
        System.out.println("+------+---------------------+----------------------+-------+---------+");
        for (Eletronico eletronico : eletronicos) {
            System.out.printf("| %-4d | %-19s | %-20s | %-5.2f | %-7d |%n",
                    eletronico.getId(), eletronico.getTitulo(), eletronico.getAutores(), eletronico.getPreco(), eletronico.getTamanho());
        }
        System.out.println("+------+---------------------+----------------------+-------+---------+");
    }

    public void listarVendas() {
        System.out.println("Lista de Vendas:");
        System.out.println("+------+---------+------------+------------+");
        System.out.println("| Venda| Cliente | Valor Total| Número Livros |");
        System.out.println("+------+---------+------------+------------+");
        for (Venda venda : vendas) {
            System.out.printf("| %-4d | %-7s | %-10.2f | %-12d |%n",
                    venda.getNumero(), venda.getCliente(), venda.getValor(), venda.listarLivros().size());
        }
        System.out.println("+------+---------+------------+------------+");
    }

    public void listarLivros() {
        System.out.println("Listagem de Livros:");
        System.out.println("+--------+---------------------+----------------------+-------+---------+---------+");
        System.out.println("| Tipo   | Título              | Autores              | Preço | Estoque | Tamanho |");
        System.out.println("+--------+---------------------+----------------------+-------+---------+---------+");

        for (Impresso impresso : impressos) {
            System.out.printf("| Impresso | %-19s | %-20s | %-5.2f | %-7d |         |%n",
                    impresso.getTitulo(), impresso.getAutores(), impresso.getPreco(), impresso.getEstoque());
        }

        for (Eletronico eletronico : eletronicos) {
            System.out.printf("| Eletrônico | %-17s | %-20s | %-5.2f |         | %-7d |%n",
                    eletronico.getTitulo(), eletronico.getAutores(), eletronico.getPreco(), eletronico.getTamanho());
        }

        System.out.println("+--------+---------------------+----------------------+-------+---------+---------+");
    }
    public static void main(String[] args) {
        LivrariaVirtual livraria = new LivrariaVirtual();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Realizar Venda");
            System.out.println("3. Listar Livros");
            System.out.println("4. Listar Vendas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    livraria.cadastrarLivro();
                    break;
                case 2:
                    livraria.realizarVenda();
                    break;
                case 3:
                    livraria.listarLivros();
                    break;
                case 4:
                    livraria.listarVendas();
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    break;
            }
        } while (opcao != 5);
    }
}



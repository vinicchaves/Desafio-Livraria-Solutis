package br.solutis.squad7.livraria.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class MenuService {

    @Autowired
    private LivrariaVirtual livraria;

    public void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 -> livraria.cadastrarLivro();
                case 2 -> livraria.realizarVenda();
                case 3 -> {
                    exibirSubMenuListarLivros();
                    int listarOpcao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    listarLivros(listarOpcao);
                }
                case 4 -> livraria.listarVendas();
                case 5 -> {
                    System.out.println("Saindo do programa...");
                    return; // Sair do método
                }
                default -> System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Realizar Venda");
        System.out.println("3. Listar Livros");
        System.out.println("4. Listar Vendas");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void exibirSubMenuListarLivros() {
        System.out.println("Selecione uma opção:");
        System.out.println("1. Listar todos os livros");
        System.out.println("2. Listar livros impressos");
        System.out.println("3. Listar livros eletrônicos");
        System.out.print("Escolha uma opção: ");
    }

    private void listarLivros(int listarOpcao) {
        switch (listarOpcao) {
            case 1 -> livraria.listarLivrosConsole();
            case 2 -> livraria.listarLivrosImpressos();
            case 3 -> livraria.listarLivrosEletronicos();
            default -> System.out.println("Opção inválida. Escolha uma opção válida.");
        }
    }

}

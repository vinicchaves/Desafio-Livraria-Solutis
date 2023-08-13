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
                    System.out.println("Selecione uma opção:");
                    System.out.println("1. Listar todos os livros");
                    System.out.println("2. Listar livros impressos");
                    System.out.println("3. Listar livros eletrônicos");
                    int listarOpcao = scanner.nextInt();
                    switch (listarOpcao) {
                        case 1:
                            livraria.listarLivrosConsole();
                            break;
                        case 2:
                            livraria.listarLivrosImpressos();
                            break;
                        case 3:
                            livraria.listarLivrosEletronicos();
                            break;
                        default:
                            System.out.println("Opção inválida. Escolha uma opção válida.");
                            break;
                    }
                case 4:
                    livraria.listarVendas();
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    break;
            }
        } while (opcao != 5);
    }
}

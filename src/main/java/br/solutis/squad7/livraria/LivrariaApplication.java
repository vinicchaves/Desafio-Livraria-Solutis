package br.solutis.squad7.livraria;

import br.solutis.squad7.livraria.livros.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LivrariaApplication {

	public static void main(String[] args) {

		SpringApplication.run(LivrariaApplication.class, args);
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

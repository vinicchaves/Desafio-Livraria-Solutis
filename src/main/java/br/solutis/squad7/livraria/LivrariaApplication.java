package br.solutis.squad7.livraria;

import br.solutis.squad7.livraria.livros.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariaApplication {

	public static void main(String[] args) {

		SpringApplication.run(LivrariaApplication.class, args);
		System.out.println("teste");
	}

}

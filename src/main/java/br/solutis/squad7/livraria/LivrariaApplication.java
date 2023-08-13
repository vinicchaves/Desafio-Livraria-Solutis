package br.solutis.squad7.livraria;

import br.solutis.squad7.livraria.service.MenuService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class LivrariaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(LivrariaApplication.class, args);
		MenuService menuService = configurableApplicationContext.getBean(MenuService.class);
		menuService.iniciarMenu();
	}
}


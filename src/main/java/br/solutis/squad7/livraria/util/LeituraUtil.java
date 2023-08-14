package br.solutis.squad7.livraria.util;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LeituraUtil {
    public static String lerString(Scanner sc, String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static float lerFloatPositivo(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            if (sc.hasNextFloat()) {
                float valor = sc.nextFloat();
                if (valor >= 0) {
                    return valor;
                } else {
                    System.out.println("O valor deve ser maior ou igual a zero.");
                }
            } else {
                System.out.println("Entrada inválida. Certifique-se de inserir um valor numérico.");
                sc.next();
            }
        }
    }

    public static int lerIntPositivo(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                if (valor >= 0) {
                    return valor;
                } else {
                    System.out.println("O valor deve ser maior ou igual a zero.");
                }
            } else {
                System.out.println("Entrada inválida. Certifique-se de inserir um valor numérico inteiro.");
                sc.next();
            }
        }
    }
}

package br.com.alura.conversor.menu;

import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);

    public MenuOption askOption() {
        while (true) {
            printMenu();

            String line = sc.nextLine().trim();
            int code;
            try {
                code = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número.");
                System.out.println();
                continue;
            }

            MenuOption option = MenuOption.fromCode(code);
            if (option == null) {
                System.out.println("Opção inexistente. Tente novamente.");
                System.out.println();
                continue;
            }
            return option;
        }
    }

    public double askValue() {
        while (true) {
            System.out.print("Digite o valor a converter: ");
            String line = sc.nextLine().trim().replace(",", ".");
            try {
                double value = Double.parseDouble(line);
                if (value < 0) {
                    System.out.println("Informe um valor positivo.");
                    continue;
                }
                System.out.println();
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Ex.: 100 ou 100.50");
            }
        }
    }

    private void printMenu() {
        System.out.println("""
                ==========================
                CONVERSOR DE MOEDAS
                1) USD -> BRL
                2) BRL -> USD
                3) EUR -> BRL
                4) BRL -> EUR
                5) USD -> EUR
                6) EUR -> USD
                0) Sair
                ==========================
                Escolha uma opção:
                """);
    }
}

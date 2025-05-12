package br.com.alura.conversordemoedas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaxaCambioService service = new TaxaCambioService();
        Conversor converter = new Conversor(service);

        while (true) {
            System.out.println("\nBem-vindo ao Conversor de Moedas!");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1. USD para BRL");
            System.out.println("2. BRL para USD");
            System.out.println("3. EUR para BRL");
            System.out.println("4. BRL para EUR");
            System.out.println("5. USD para EUR");
            System.out.println("6. EUR para USD");
            System.out.println("0. Sair");

            System.out.print("Digite a opção desejada: ");
            int option = scanner.nextInt();

            if (option == 0) {
                System.out.println("Encerrando o programa. Até mais!");
                break;
            }

            String fromCurrency = "";
            String toCurrency = "";

            switch (option) {
                case 1 -> {
                    fromCurrency = "USD";
                    toCurrency = "BRL";
                }
                case 2 -> {
                    fromCurrency = "BRL";
                    toCurrency = "USD";
                }
                case 3 -> {
                    fromCurrency = "EUR";
                    toCurrency = "BRL";
                }
                case 4 -> {
                    fromCurrency = "BRL";
                    toCurrency = "EUR";
                }
                case 5 -> {
                    fromCurrency = "USD";
                    toCurrency = "EUR";
                }
                case 6 -> {
                    fromCurrency = "EUR";
                    toCurrency = "USD";
                }
                default -> {
                    System.out.println("Opção inválida! Tente novamente.");
                    continue;
                }
            }

            System.out.print("Digite o valor a ser convertido: ");
            double amount = scanner.nextDouble();

            try {
                double convertedAmount = converter.convert(fromCurrency, toCurrency, amount);
                System.out.printf("Valor convertido: %.2f %s%n", convertedAmount, toCurrency);
            } catch (Exception e) {
                System.out.println("Erro ao realizar a conversão: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
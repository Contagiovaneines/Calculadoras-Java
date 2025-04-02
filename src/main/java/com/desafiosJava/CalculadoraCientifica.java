package com.desafiosJava;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class CalculadoraCientifica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar;

        do {
            String operacao = "";
            boolean operacaoValida = false;
            while (!operacaoValida) {
                System.out.println("Digite a operação (+, -, /, *, ^, sqrt, sin, cos, tan, log): ");
                operacao = scanner.next();

                if (operacao.matches("[+\\-*/^]|sqrt|sin|cos|tan|log")) {
                    operacaoValida = true;
                } else {
                    System.out.println("Operação inválida. Tente novamente.");
                }
            }

            double valorUm = 0, valorDois = 0;
            boolean entradaValida = false;

            while (!entradaValida) {
                try {
                    if (operacao.equals("sqrt") || operacao.equals("sin") || operacao.equals("cos") || operacao.equals("tan") || operacao.equals("log")) {
                        System.out.println("Digite um valor: ");
                        valorUm = scanner.nextDouble();
                    } else {
                        System.out.println("Digite o primeiro valor: ");
                        valorUm = scanner.nextDouble();

                        System.out.println("Digite o segundo valor: ");
                        valorDois = scanner.nextDouble();
                    }
                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite apenas números.");
                    scanner.next(); // Limpa o buffer do scanner
                }
            }

            System.out.println("Resultado: " + realizarCalculo(valorUm, valorDois, operacao));

            continuar = verificarNovaOperacao(scanner);
        } while (continuar);
    }

    public static boolean verificarNovaOperacao(Scanner scanner) {
        System.out.println("Deseja realizar uma nova operação? (S ou N) ");
        return !scanner.next().toUpperCase(Locale.ROOT).equals("N");
    }

    public static Double realizarCalculo(Double valorUm, Double valorDois, String operacao) {
        switch (operacao) {
            case "+": return valorUm + valorDois;
            case "-": return valorUm - valorDois;
            case "*": return valorUm * valorDois;
            case "/": return valorDois != 0 ? valorUm / valorDois : Double.NaN;
            case "^": return Math.pow(valorUm, valorDois);
            case "sqrt": return Math.sqrt(valorUm);
            case "sin": return Math.sin(Math.toRadians(valorUm));
            case "cos": return Math.cos(Math.toRadians(valorUm));
            case "tan": return Math.tan(Math.toRadians(valorUm));
            case "log": return valorUm > 0 ? Math.log(valorUm) : Double.NaN;
            default:
                return null;
        }
    }
}
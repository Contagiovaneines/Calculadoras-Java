package com.desafiosJava;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Objeto Scanner para entrada de dados in é de input pq o scanner vai le oq o usuario colocou

        Double valorUm;
        Double valorDois;
        String operacao;
        boolean continuar = true; // Variável de controle para repetir a execução

        while (continuar) { // Loop para manter a calculadora em execução
            try {
                System.out.println("Digite o primeiro valor: ");
                valorUm = scanner.nextDouble(); // Lê o primeiro número

                System.out.println("Digite a operação(+, -, /, *): ");
                operacao = scanner.next(); // Lê o operador

                System.out.println("Digite o segundo valor: ");
                valorDois = scanner.nextDouble(); // Lê o segundo número

                System.out.println("Resultado: " + realizarCalculo(valorUm, valorDois, operacao));

                continuar = verificarNovaOperacao(); // Pergunta se deseja continuar
            } catch (InputMismatchException ex) {
                System.out.println("Os valores para o cálculo devem ser numéricos.");
                scanner.nextLine(); // Limpa o buffer para evitar erro na próxima entrada
            }
        }
        scanner.close(); // Fecha o Scanner ao sair do loop
    }

    public static Boolean verificarNovaOperacao() {
        Scanner sc = new Scanner(System.in); // Criação de novo Scanner para entrada de resposta
        System.out.println("Deseja realizar uma nova operação? (S ou N) ");
        return !sc.nextLine().toUpperCase(Locale.ROOT).equals("N"); // Retorna verdadeiro se não for "N"
    }

    public static Double realizarCalculo(Double valorUm, Double valorDois, String operacao) {
        Double respostaCalculo = 0.0;
        switch (operacao) { // Escolhe a operação com base no operador digitado
            case "+":
                respostaCalculo = valorUm + valorDois;
                break;
            case "-":
                respostaCalculo = valorUm - valorDois;
                break;
            case "/":
                if (valorDois == 0) { // Verifica se há divisão por zero
                    System.out.println("Erro: Divisão por zero não permitida.");
                    return 0.0;
                }
                respostaCalculo = valorUm / valorDois;
                break;
            case "*":
                respostaCalculo = valorUm * valorDois;
                break;
            default:
                System.out.println("Operação inválida.");
        }
        return respostaCalculo; // Retorna o resultado da operação
    }
}
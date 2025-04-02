package com.desafiosJava;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double valorUm;
        double valorDois;
        String operacao;

        System.out.println("Digita o primeiro valor: ");
        valorUm = scanner.nextDouble();

        System.out.println("digita a opercao (+, -, *,/) ");
        operacao = scanner.next();

        System.out.println("Digita o segundo valor: ");
        valorDois = scanner.nextDouble();

        System.out.println("Resultado: " + realizarCalculo(valorUm, valorDois, operacao));
    }

    public static double realizarCalculo(double valorUm, double valorDois, String operacao) {
        double resultado = 0;
        switch (operacao) {
            case "+":
                resultado = valorUm + valorDois;
                break;
            case "-":
                resultado = valorUm - valorDois;
                break;
            case "/":
                resultado = valorUm / valorDois;
                break;
            case "*":
                resultado = valorUm * valorDois;
                break;
        }
         return resultado;
    }
}

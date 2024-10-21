package m2s01;

import java.util.Scanner;

public class exercicio05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] comprimentoUnidades = {"Metros", "Centímetros", "Polegadas"};
        String[] pesoUnidades = {"Quilogramas", "Gramas", "Libras"};

        System.out.println("Escolha a categoria:\n1. Comprimento\n2. Peso");
        int categoria = scan.nextInt();

        int unidadeOrigem = 0;
        int unidadeDestino = 0;
        String[] unidades = null;

        switch (categoria) {
            case 1: // Comprimento
                System.out.println("Escolha a unidade de origem:\n1. Metros\n2. Centímetros\n3. Polegadas");
                unidadeOrigem = scan.nextInt();

                System.out.println("Escolha a unidade de destino:\n1. Metros\n2. Centímetros\n3. Polegadas");
                unidadeDestino = scan.nextInt();

                unidades = comprimentoUnidades;
                break;
            case 2: // Peso
                System.out.println("Escolha a unidade de origem:\n1. Quilogramas\n2. Gramas\n3. Libras");
                unidadeOrigem = scan.nextInt();

                System.out.println("Escolha a unidade de destino:\n1. Quilogramas\n2. Gramas\n3. Libras");
                unidadeDestino = scan.nextInt();

                unidades = pesoUnidades;
                break;
        }

        System.out.println("Digite o valor:");
        double valor = scan.nextDouble();

        double resultado = 0;

        switch (categoria) {
            case 1: // Comprimento
                switch (unidadeOrigem) {
                    case 1: // Metros
                        switch (unidadeDestino) {
                            case 2: // Centímetros
                                resultado = valor * 100;
                                break;
                            case 3: // Polegadas
                                resultado = valor * 39.37;
                                break;
                        }
                        break;
                    case 2: // Centímetros
                        switch (unidadeDestino) {
                            case 1: // Metros
                                resultado = valor / 100;
                                break;
                            case 3: // Polegadas
                                resultado = valor / 2.54;
                                break;
                        }
                        break;
                    case 3: // Polegadas
                        switch (unidadeDestino) {
                            case 1: // Metros
                                resultado = valor / 39.37;
                                break;
                            case 2: // Centímetros
                                resultado = valor * 2.54;
                                break;
                        }
                        break;
                }
                break;
            case 2: // Peso
                switch (unidadeOrigem) {
                    case 1: // Quilogramas
                        switch (unidadeDestino) {
                            case 2: // Gramas
                                resultado = valor * 1000;
                                break;
                            case 3: // Libras
                                resultado = valor * 2.20462;
                                break;
                        }
                        break;
                    case 2: // Gramas
                        switch (unidadeDestino) {
                            case 1: // Quilogramas
                                resultado = valor / 1000;
                                break;
                            case 3: // Libras
                                resultado = valor / 453.592;
                                break;
                        }
                        break;
                    case 3: // Libras
                        switch (unidadeDestino) {
                            case 1: // Quilogramas
                                resultado = valor / 2.20462;
                                break;
                            case 2: // Gramas
                                resultado = valor * 453.592;
                                break;
                        }
                        break;
                }
                break;
        }

        System.out.printf("Resultado da conversão: %.2f %s = %.2f %s\n", valor, unidades[unidadeOrigem - 1], resultado, unidades[unidadeDestino - 1]);
        scan.close();
    }
}
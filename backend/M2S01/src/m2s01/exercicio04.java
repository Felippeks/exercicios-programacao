package m2s01;

import java.util.Scanner;

public class exercicio04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] calorias = new double[7];
        double totalCalorias = 0;
        String[] diasDaSemana = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};

        // Solicita ao usuário a quantidade de calorias consumidas em cada dia da semana
        for (int i = 0; i < 7; i++) {
            System.out.println("Digite a quantidade de calorias consumidas no " + diasDaSemana[i] + ": ");
            calorias[i] = scan.nextDouble();
            totalCalorias += calorias[i];
        }

        // Calcula e exibe a média diária de calorias consumidas
        double mediaCalorias = totalCalorias / 7;
        System.out.printf("A média diária de calorias consumidas é %.2f\n", mediaCalorias);

        // Determina e exibe os dias em que o consumo de calorias foi superior à recomendação diária de 2000 calorias
        System.out.println("Dias com consumo acima da recomendação diária de 2000 calorias:");
        for (int i = 0; i < 7; i++) {
            if (calorias[i] > 2000) {
                System.out.println(diasDaSemana[i]);
            }
        }

        scan.close();
    }
}
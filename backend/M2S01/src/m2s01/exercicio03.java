package m2s01;

import java.util.Scanner;

public class exercicio03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double tempo, velocidade, distancia;
        System.out.println("Digite o tempo em segundos: ");
        tempo = scan.nextDouble();
        distancia = 1;
        velocidade = distancia / tempo;
        System.out.printf("A velocidade média é de %.2f m/s\n", velocidade);
    }
}
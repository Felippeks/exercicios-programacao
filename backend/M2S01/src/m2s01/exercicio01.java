package m2s01;

import java.util.Scanner;

public class exercicio01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double largura, comprimento, area;
        System.out.println("Digite a largura do terreno: ");
        largura = scan.nextDouble();
        System.out.println("Digite o comprimento do terreno: ");
        comprimento = scan.nextDouble();
        area = largura * comprimento;
        System.out.printf("A área do terreno é %.2f m²\n", area);
        scan.close();
    }
}
package m2s01;

import java.util.Scanner;

public class exercicio02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double salarioMinimo = 1412.00, salario, qtdSalarios;
        System.out.println("Digite o salário: ");
        salario = scan.nextDouble();
        qtdSalarios = salario / salarioMinimo;
        System.out.printf("Você recebe %.1f salários mínimos\n", qtdSalarios);
    }
}

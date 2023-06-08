import java.util.Scanner;
import calculadora.Calculadora;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("digite a expressão aritmética:");
        String eqc = sc.nextLine();
        double result = Calculadora.calcular(eqc);
        System.out.print(String.format("o resultado da expressão aritmética é %.2f", result));
        sc.close();
    }
}

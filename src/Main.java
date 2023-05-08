import java.util.Scanner;
import calculadora.Calculadora;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        println("digite a expressão aritmética:");
        String eqc = sc.nextLine();
        double result = Calculadora.calcular(eqc);
        print(String.format("o resultado da expressão aritmética é %.2f", result));

        sc.close();
    }

    public static <T> void println(T msg) {
        System.out.println(msg);
    }

    public static <T> void print(T msg) {
        System.out.println(msg);
    }
}

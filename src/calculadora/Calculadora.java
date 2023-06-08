package calculadora;

import java.util.HashSet;
import java.util.Set;

/** 
 * <h1>Calculadora</h1>
 * 
 * A calculadora é um programa que faz cálculos aritméticos e será usada <br>
 * para fazer projetos
 * 
 * <hr>
 * 
 * Esta caculadora terá melhorias, e no final, toda a classe será implementado numa <br>
 * interface gráfica
 * 
 * @author Lucas Daniel
*/

public class Calculadora {
    private static final String msgForException = 
    "a expressão aritmética foi digitada de forma incorreta!";

   public static double calcular(String eqc) throws Exception{
        String[] vect = eqc.split(" ");
        if (vect.length <= 2 || lastIsOperator(vect[vect.length - 1]))
            throw new IllegalArgumentException(msgForException);
        for (int i=0;i<vect.length;i++){
            if(hasComma(vect[i])){
                String aux = vect[i].replace(',', '.');
                vect[i] = aux;
            }
        }
        // verifica se é uma expressao aritmética ou é cálculo simples
        // se o lenght do vetor for maior que 3, é expressao aritmética, senao, é calculo simples
        if (vect.length > 3){
            while (hasPowOperation(vect) || hasMutiplicationOrDivision(vect)){
                if (hasPowOperation(vect)) {
                    String[] aux = doPower(vect);
                    vect = null;
                    vect = aux;
                } else if (hasMutiplicationOrDivision(vect)) {
                    String[] aux = doMutiplication(vect);
                    vect = null;
                    vect = aux;
                }
            }
            while (vect.length != 1){
                String[] aux = doPlusAndMinusOperation(vect);
                vect = null;
                vect = aux;
            }
            if (vect.length == 1){
                return Double.parseDouble(vect[0]);
            } else {
                throw new RuntimeException("tu fez algo errado kkkkk burro");
            }
        } else {
            return doCalculation(Double.parseDouble(vect[0]), Double.parseDouble(vect[2]), vect[1]);
        }
   }

   private static boolean hasPowOperation(String[] vect) {
        for (String x: vect){
            if (x.equals("^"))
                return true;
        }
        return false;
   }

   private static boolean hasMutiplicationOrDivision(String[] vect) {
        for (String x: vect){
            if (x.equals("*") || x.equals("/"))
                return true;
        }
        return false;
   }

    private static boolean hasComma(String numb){
        for (int i=0;i<numb.length();i++){
            if (numb.charAt(i) == ',')
                return true;
        }
        return false;
   }

   private static double doCalculation(double arg1, double arg2, String operation) {
    double result = 0.0;
    double x1 = arg1;
    double x2 = arg2;
    switch (operation){
        case "+":
            result = x1 + x2;
            break;
        case "-":
            result = x1 - x2;
            break;
        case "*":
            result = x1 * x2;
            break;
        case "/":
            result = x1 / x2;
            break;
        case "^":
            result = Math.pow(x1,x2);
            break;
    }
    return result;
   }

   private static String[] doMutiplication(String[] vect){
        double result = 0.0;
        for(int i = 0; i < vect.length ; i++){
            if (vect[i].equals("*")) {
                double a = Double.parseDouble(vect[i - 1]);
                double b = Double.parseDouble(vect[i + 1]);
                result = a * b;
                vect[i - 1] = Double.toString(result);
                vect[i] = " ";
                vect[i + 1] = " ";
            } else if (vect[i].equals("/")) {
                double a = Double.parseDouble(vect[i - 1]);
                double b = Double.parseDouble(vect[i + 1]);
                result = a / b;
                vect[i - 1] = Double.toString(result);
                vect[i] = " ";
                vect[i + 1] = " ";
            }
        }
        return remakeVector(vect);
   }

   private static String[] doPower(String[] vect){
        double result = 0.0;
        for (int i=0 ; i < vect.length ; i++) {
            if (vect[i].equals("^")) {
                double a = Double.parseDouble(vect[i - 1]);
                double b = Double.parseDouble(vect[i + 1]);
                result = Math.pow(a,b);
                vect[i - 1] = Double.toString(result);
                vect[i] = " ";
                vect[i + 1] = " ";
            }
        }
        return remakeVector(vect);
   }

   private static String[] doPlusAndMinusOperation(String[] vect){
        double x1 = Double.parseDouble(vect[0]);
        double x2 = Double.parseDouble(vect[2]);
        String operation = vect[1];
        double result = doCalculation(x1, x2, operation);
        vect[0] = Double.toString(result);
        vect[1] = " ";
        vect[2] = " ";
        return remakeVector(vect);
   }

   private static boolean lastIsOperator(String str) throws Exception {
        Set<String> operators = new HashSet<>();
        operators.add("+"); 
        operators.add("-"); 
        operators.add("*");
        operators.add("/");
        operators.add("^");
        for(String operator: operators){
            if (str.equals(operator))
                return true;
        }
        return false;
    }

    public static String[] remakeVector(String[] vect){
        for (int i = 0; i < vect.length; i++) {
            //em andamento
        }
        return vect;
    }
}

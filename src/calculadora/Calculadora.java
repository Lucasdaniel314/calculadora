package calculadora;

import java.util.ArrayList;
import java.util.List;

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
        if ((vect.length <= 2) || (lastIsOperator(vect[vect.length - 1])))
            throw new IllegalArgumentException(msgForException);
        for (int i=0;i<vect.length;i++){
            if(hasComma(vect[i])){
                String aux = vect[i].replace(',', '.');
                vect[i] = aux;
            }
        }
        return doCalculation(Double.parseDouble(vect[0]), Double.parseDouble(vect[2]), vect[1]);
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
            result = Math.pow(x1, x2);
            break;
    }
    return result;
   }

   private static boolean lastIsOperator(String str) throws Exception {
        List<String> operators = new ArrayList<>();
        //operators = ; Arrays.asList("+","-","*","/","^")
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        operators.add("^");
        for(int i = 0 ; i < operators.size() ; i++){
            if (str.equals(operators.get(i)))
                return true;
        }
        return false;
    }
}

package calculadora;

/** 
 * <h1>Calculadora</h1>
 * 
 * Esta caculadora terá melhorias, e no final, toda a classe será implementado numa <br>
 * interface gráfica
 * 
 * @author Lucas Daniel
*/

public class Calculadora {
    private static final String msgForException = 
    "a equacao tem apenas 1 argumento ou foi digitada de forma incorreta!";

   public static double calcular(String eqc){
        String[] vect = eqc.split(" ");
        if (vect.length <= 2)
            throw new IllegalArgumentException(msgForException);
        for (int i=0;i<vect.length;i++){
            if(temVirgula(vect[i])){
                String aux = vect[i].replace(',', '.');
                vect[i] = aux;
            }
        }
        double result = 0;
        double x1 = parseDouble(vect[0]);
        double x2 = parseDouble(vect[2]);
        switch (vect[1]){
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

   private static boolean temVirgula(String numb){
        for (int i=0;i<numb.length();i++){
            if (numb.charAt(i) == ',')
                return true;
        }
        return false;
   }

   private static double parseDouble(String x) {
        return Double.parseDouble(x);
   }
}

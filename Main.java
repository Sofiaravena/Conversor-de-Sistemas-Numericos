import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String read;
        boolean breaker = false;

        while (breaker == false) {
            System.out.println("--Coversion de Sistemas Numericos--");
            read=JOptionPane.showInputDialog("Ingrese un numero binario de maximo 16 bits");
            if (read.length()<=16&&read.matches("[01]+")) {

                double resultDecimal=0;
                for (int i = 0; i < read.length(); i++){
                    char charDigit=read.charAt(i);
                    int digit=Character.getNumericValue(charDigit);
                    int exponent=(read.length()-1) - i;
                    resultDecimal=resultDecimal+digit*Math.pow(2, exponent);
                }

                while (read.length() < 16) {
                    read="0"+read;
                }

                String octal = "";
                if (read.length() == 16) {
                    double resultOctal = 0;
                    for (int i = read.length(); i > 0; i -= 3) {
                        int startIndex=Math.max(0, i - 3);
                        String part=read.substring(startIndex, i);
                        int contador=0;
                        for (int j = 0; j < part.length(); j++) {
                            char charDigit=part.charAt(j);
                            int digit=Character.getNumericValue(charDigit);
                            int exponent=(part.length()-1) - j;
                            resultOctal=resultOctal+digit*Math.pow(2, exponent);
                            contador=(int) resultOctal;
                        }
                        resultOctal=0;
                        octal=contador+octal ;
                    }
                }

                String hexadecimal = "";
                if (read.length() == 16) {
                    double resultHexadecimal=0;
                    for (int i = read.length(); i > 0; i -= 4) {
                        int startIndex = Math.max(0, i - 4);
                        String part = read.substring(startIndex, i);
                        int contador = 0;
                        for (int j = 0; j < part.length(); j++) {
                            char charDigit = part.charAt(j);
                            int digit = Character.getNumericValue(charDigit);
                            int exponent = (part.length()-1) - j;
                            resultHexadecimal=resultHexadecimal+digit * Math.pow(2, exponent);
                            contador =  (int) resultHexadecimal;
                        }
                        resultHexadecimal = 0;
                        String contaHexadecimal = "";
                        switch (contador) {
                            case 0:
                                contaHexadecimal = "0";
                                break;
                            case 1:
                                contaHexadecimal = "1";
                                break;
                            case 2:
                                contaHexadecimal = "2";
                                break;
                            case 3:
                                contaHexadecimal = "3";
                                break;
                            case 4:
                                contaHexadecimal = "4";
                                break;
                            case 5:
                                contaHexadecimal = "5";
                                break;
                            case 6:
                                contaHexadecimal = "6";
                                break;
                            case 7:
                                contaHexadecimal = "7";
                                break;
                            case 8:
                                contaHexadecimal = "8";
                                break;
                            case 9:
                                contaHexadecimal = "9";
                                break;
                            case 10:
                                contaHexadecimal = "A";
                                break;
                            case 11:
                                contaHexadecimal = "B";
                                break;
                            case 12:
                                contaHexadecimal = "C";
                                break;
                            case 13:
                                contaHexadecimal = "D";
                                break;
                            case 14:
                                contaHexadecimal = "E";
                                break;
                            case 15:
                                contaHexadecimal = "F";
                                break;
                        }
                        hexadecimal=contaHexadecimal+hexadecimal ;
                    }
                }

                JOptionPane.showMessageDialog(null, "El nro :" + read + " Es equivalente a: " + " Decimal: " + resultDecimal + " " + " Octal: " + octal + " "+ "Hexadecimal: " + hexadecimal );
                breaker = true;

            } else {
                JOptionPane.showMessageDialog(null, "Valor incorrecto, debe tener maximo 16 digitos con 0 y 1 unicamente");
                breaker = false;
            }
        }
    }
}

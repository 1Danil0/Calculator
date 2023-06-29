package Calculator;

import java.io.*;
import java.util.Scanner;



public class Main {
    public static  void main(String[] args) {
        byte[] buffer = new byte[256];
        String s = "";
        try (FileInputStream fis = new FileInputStream("/C:/Users/zer0c/Desktop/Butusov/input.txt");
                BufferedInputStream bis = new BufferedInputStream(fis);
                FileOutputStream fos = new FileOutputStream("/C:/Users/zer0c/Desktop/Butusov/output.txt");
                BufferedOutputStream bos = new BufferedOutputStream(fos) ) {
            int count;
                    while ((count = bis.read()) != -1) {
                        s += (char) count;
                    }
            String[] str = s.split(" ");
            double a = 0, b = 0;
            boolean flag = true;
            try {
                a = Double.parseDouble(str[0]);
                b = Double.parseDouble(str[2]);
            } catch (NumberFormatException numberFormatException) {
                flag = false;
                s += " = Error! Not number";
                System.out.println("Error! Not number");
            }
            if (flag) {
                if ("+-*/".contains(str[1])) {
                    switch (str[1]) {
                        case "+":
                            s += " = " + (a + b);
                            break;
                        case "-":
                            s += " = " + (a - b);
                            break;
                        case "*":
                            s += " = " + a * b;
                            break;
                        case "/":
                            try {
                                if (b != 0) {
                                    s += a / b;
                                } else {
                                    s += " = Error! Division by zero";
                                }
                            } catch (ArithmeticException ae) {
                                System.out.println("Error! Division by zero");
                                s += " = Error! Not number";
                            }

                    }
                } else {
                    s += " = Operation error!";
                }
            }
            buffer = s.getBytes();
            bos.write(buffer, 0, buffer.length);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


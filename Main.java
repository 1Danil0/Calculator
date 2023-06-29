package Calculator;

import java.io.*;
import java.io.BufferedReader;


public class Main {
    public static  void main(String[] args) {

        String line;
        try (FileReader fw = new FileReader("/C:/Users/zer0c/Desktop/Butusov/input.txt");
                BufferedReader br = new BufferedReader(fw);
                BufferedWriter bw = new BufferedWriter(new FileWriter("/C:/Users/zer0c/Desktop/Butusov/output.txt")))
                {
                while ((line = br.readLine()) != null) {
                String[] str = line.split(" ");
                double a = 0, b = 0;
                boolean flag = true;
                try {
                    a = Double.parseDouble(str[0]);
                    b = Double.parseDouble(str[2]);
                } catch (NumberFormatException numberFormatException) {
                    flag = false;
                    line += " = Error! Not number";
                    System.out.println("Error! Not number");
                }
                if (flag) {
                    if ("+-*/".contains(str[1])) {
                        switch (str[1]) {
                            case "+":
                                line += " = " + (a + b);
                                break;
                            case "-":
                                line += " = " + (a - b);
                                break;
                            case "*":
                                line += " = " + a * b;
                                break;
                            case "/":
                                if (b != 0) {
                                    line += " = " + a / b;
                                } else {
                                    line += " = Error! Division by zero";
                                }
                                break;
                        }
                    } else {
                        line += " = Operation error!";
                    }
                }
                bw.write(line + "\n");

            }
            } catch(FileNotFoundException e){
                System.out.println("File was not found");
            } catch(IOException e){
                throw new RuntimeException(e);
            }

    }
}


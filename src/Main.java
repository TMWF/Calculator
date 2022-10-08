import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите выражение вида: \"a Операция b\" (через пробел), где a и b - арабские либо римские числа от 1 до 10 включительно. Операции: + - * /");

            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();
            String result = calc(inputString);
            System.out.println(result);
        }
    }


    public static String calc(String input) {
        Calc calc = new Calc();
        String result = null;
        try {
            result = calc.calculate(input);
        } catch (CalculatorException e) {
            throw new RuntimeException(e);
        }
        return result;
    }



}
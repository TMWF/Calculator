public class Calc {
    private int integer1, integer2, result;
    private String operator;
    Helper helper = new Helper();

    public String calculate(String input) throws CalculatorException {
        boolean isRoman;
        String[] strings = input.split(" ");

        if(strings.length != 3) {
            throw new CalculatorException("ERROR OCCURRED. Выражение должно иметь вид: \"Число1 Операция Число2\", с разделением через пробел");
        }

        if (helper.checkOperator(strings[1])){
            operator = strings[1];
        } else {
            throw new CalculatorException("ERROR OCCURRED. Оператор '" + strings[1] + "' не корректен, должен быть: + - * / ");
        }

        if (helper.isNumeric(strings[0]) && helper.isNumeric(strings[2])){
            integer1 = Integer.parseInt(strings[0]);
            integer2 = Integer.parseInt(strings[2]);
            isRoman = false;
        } else if (helper.isRoman(strings[0]) && helper.isRoman(strings[2])){
            integer1 = helper.romanToArabConvert(strings[0]);
            integer2 = helper.romanToArabConvert(strings[2]);
            isRoman = true;
        } else {
            throw new CalculatorException("ERROR OCCURRED. Используются разные системы счисления");
        }

        if (!(integer1 >= 1 && integer1 <= 10)){
            throw new CalculatorException("ERROR OCCURRED. Число #1 должно быть от 1 до 10 или от I до X включительно");
        }

        if (!(integer2 >= 1 && integer2 <= 10)){
            throw new CalculatorException("ERROR OCCURRED. Число #2 должно быть от 1 до 10 или от I до X включительно");
        }

        switch (operator) {
            case "+":
                result = integer1 + integer2;
                break;
            case "-":
                result = integer1 - integer2;
                if (result <= 0 && isRoman == true) {
                    throw new CalculatorException("ERROR OCCURRED. В римской системе счисления нет отрицательных чисел");
                }
                break;
            case "*":
                result = integer1 * integer2;
                break;
            case "/":
                result = integer1 / integer2;
                break;
            default:
                throw new AssertionError();
        }

        if (isRoman == true) {
            String resultingString = helper.integerToRoman(result);
            return resultingString;
        } else {
            return String.valueOf(result);
        }

    }
}

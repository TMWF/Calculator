public class Helper {

    public boolean checkOperator(String op){
        return "*".equals(op) || "/".equals(op) || "+".equals(op) || "-".equals(op);
    }

    public boolean isRoman(String str) {
        String[] allowedRomanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for(String romanNumber: allowedRomanNumbers) {
            if(romanNumber.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String integerToRoman(int num) {
        int[] values = {100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }

    public Integer romanToArabConvert(String str){

        switch(str) {
            case("I"):
                return 1;
            case("II"):
                return  2;
            case("III"):
                return 3;
            case("IV"):
                return 4;
            case("V"):
                return 5;
            case("VI"):
                return 6;
            case("VII"):
                return 7;
            case("VIII"):
                return 8;
            case("IX"):
                return 9;
            case("X"):
                return 10;
        }
        return null;
    }
}

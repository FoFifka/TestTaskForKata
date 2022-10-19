import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println(calc(scanner.nextLine().trim()));
        }
    }

    public static String calc(String input) {
        String mode = "";
        for(int i = 1; i <= 10; i++) {
            if (input.contains(String.valueOf(i))) {
                mode = "arabic";
                break;
            }
        }
        if(input.contains("I") || input.contains("V") || input.contains("X")){
            if (mode.equals("arabic")) throw new RuntimeException("Нельзя проводить опирации с арабскими и римскими числами");
            mode = "roman";
        }

        if(mode.equals("arabic")) {
            if(input.contains("+")) {
                String[] strings =  input.split("\\+");
                if(strings.length > 2) throw new RuntimeException("Считать можно, только 2 числа между собой"); // Runtime Exception
                int firstNumber = Integer.parseInt(strings[0].trim());
                int secondNumber = Integer.parseInt(strings[1].trim());
                if(firstNumber < 1 || firstNumber > 10 || secondNumber < 1 || secondNumber > 10) throw new RuntimeException("Допустимо вводить числа от 1 до 10"); // Runtime Exception
                return String.valueOf(firstNumber + secondNumber);
            } else if(input.contains("-")) {
                String[] strings =  input.split("-");
                if(strings.length > 2) throw new RuntimeException("Считать можно, только 2 числа между собой"); // Runtime Exception
                int firstNumber = Integer.parseInt(strings[0].trim());
                int secondNumber = Integer.parseInt(strings[1].trim());
                if(firstNumber < 1 || firstNumber > 10 || secondNumber < 1 || secondNumber > 10) throw new RuntimeException("Допустимо вводить числа от 1 до 10");
                return String.valueOf(firstNumber - secondNumber);
            } else if(input.contains("*")) {
                String[] strings =  input.split("\\*");
                if(strings.length > 2) throw new RuntimeException("Считать можно, только 2 числа между собой"); // Runtime Exception
                int firstNumber = Integer.parseInt(strings[0].trim());
                int secondNumber = Integer.parseInt(strings[1].trim());
                if(firstNumber < 1 || firstNumber > 10 || secondNumber < 1 || secondNumber > 10) throw new RuntimeException("Допустимо вводить числа от 1 до 10");
                return String.valueOf(firstNumber * secondNumber);
            } else if(input.contains("/")) {
                String[] strings =  input.split("/");
                if(strings.length > 2) throw new RuntimeException("Считать можно, только 2 числа между собой"); // Runtime Exception
                int firstNumber = Integer.parseInt(strings[0].trim());
                int secondNumber = Integer.parseInt(strings[1].trim());
                if(firstNumber < 1 || firstNumber > 10 || secondNumber < 1 || secondNumber > 10) throw new RuntimeException("Допустимо вводить числа от 1 до 10");
                return String.valueOf(firstNumber / secondNumber);
            } else {
                throw new RuntimeException("Произошла ошибка, возможно введён неизвестный символ"); // Runtime Exception
            }
        } else if (mode.equals("roman")) {
            if(input.contains("+")) {
                String[] strings =  input.split("\\+");
                int firstNumber = romanNumbersToArabic(strings[0]);
                int secondNumber = romanNumbersToArabic(strings[1]);
                int result = firstNumber + secondNumber;
                return arabicNumbersToRoman(result);
            } else if(input.contains("-")) {
                String[] strings =  input.split("-");
                int firstNumber = romanNumbersToArabic(strings[0]);
                int secondNumber = romanNumbersToArabic(strings[1]);
                int result = firstNumber - secondNumber;
                return arabicNumbersToRoman(result);
            } else if(input.contains("*")) {
                String[] strings =  input.split("\\*");
                int firstNumber = romanNumbersToArabic(strings[0]);
                int secondNumber = romanNumbersToArabic(strings[1]);
                int result = firstNumber * secondNumber;
                return arabicNumbersToRoman(result);
            } else if(input.contains("/")) {
                String[] strings =  input.split("/");
                int firstNumber = romanNumbersToArabic(strings[0]);
                int secondNumber = romanNumbersToArabic(strings[1]);
                int result = firstNumber / secondNumber;
                return arabicNumbersToRoman(result);
            } else {
                throw new RuntimeException("Произошла ошибка, возможно введён неизвестный символ"); // Runtime Exception
            }
        } else {
            throw new RuntimeException("Ошибка режима");
        }
    }

    static Integer romanNumbersToArabic(String romanNumber) {
        return switch (romanNumber.trim()) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new RuntimeException("Ошибка при переводе из римских чисел в арабские");
        };
    }
    static String arabicNumbersToRoman(Integer arabicNumber) {
        if(arabicNumber <= 0) {
            throw new RuntimeException("Римские числа могут быть только положительными");
        }
        if (arabicNumber >= 1 && arabicNumber <= 10) {
            String arabicNumberResult = "";
            arabicNumberResult += arabicToRoman(arabicNumber);
            return arabicNumberResult;
        }
        if(arabicNumber > 10 && arabicNumber < 20) {
            String arabicNumberResult = "X";
            arabicNumberResult += arabicToRoman(arabicNumber-10);
            return arabicNumberResult;
        }
        if (arabicNumber >= 20 && arabicNumber < 30) {
            String arabicNumberResult = "XX";
            arabicNumberResult += arabicToRoman(arabicNumber - 20);
            return arabicNumberResult;
        }
        if (arabicNumber >= 30 && arabicNumber < 40) {
            String arabicNumberResult = "XXX";
            arabicNumberResult += arabicToRoman(arabicNumber - 30);
            return arabicNumberResult;
        }
        if (arabicNumber >= 40 && arabicNumber < 50) {
            String arabicNumberResult = "XL";
            arabicNumberResult += arabicToRoman(arabicNumber - 40);
            return arabicNumberResult;
        }
        if (arabicNumber >= 50 && arabicNumber < 60) {
            String arabicNumberResult = "L";
            arabicNumberResult += arabicToRoman(arabicNumber - 50);
            return arabicNumberResult;
        }
        if (arabicNumber >= 60 && arabicNumber < 70) {
            String arabicNumberResult = "LX";
            arabicNumberResult += arabicToRoman(arabicNumber - 60);
            return arabicNumberResult;
        }
        if (arabicNumber >= 70 && arabicNumber < 80) {
            String arabicNumberResult = "LXX";
            arabicNumberResult += arabicToRoman(arabicNumber - 70);
            return arabicNumberResult;
        }
        if (arabicNumber >= 80 && arabicNumber < 90) {
            String arabicNumberResult = "LXXX";
            arabicNumberResult += arabicToRoman(arabicNumber - 80);
            return arabicNumberResult;
        }
        if (arabicNumber >= 90 && arabicNumber < 100) {
            String arabicNumberResult = "XC";
            arabicNumberResult += arabicToRoman(arabicNumber - 90);
            return arabicNumberResult;
        }
        if(arabicNumber == 100) {
            return "C";
        }
        throw new RuntimeException("Ошибка при переводе в римские числа");
    }
    static String arabicToRoman(Integer arabicNumber) {
        return switch (arabicNumber) {
            case 0 -> "";
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            case 10 -> "X";
            default -> throw new RuntimeException("Ошибка при переводе из арабских чисел в римские");
        };
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите выражение в формате: число оператор число");
            String input = scanner.nextLine();

            // Разделяем строку на части
            String[] tokens = input.split(" ");
            if (tokens.length != 3) {
                throw new IllegalArgumentException("Неверный формат математической операции");
            }

            try {
                // Парсим числа
                int a = Integer.parseInt(tokens[0]);
                int b = Integer.parseInt(tokens[2]);

                //Проверяем, что числа в диапазоне от 1 до 10
                if (a < 1 || a > 10 || b < 1 || b > 10) {
                    throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10 включительно");
                }

                // Выполняем операции
                int result;
                switch (tokens[1]) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if (b == 0) {
                            throw  new ArithmeticException("Деление на ноль");
                        }
                        result = a / b; // Целочисленное деление
                        break;
                    default:
                        throw new IllegalArgumentException("Неверный оператор");
                }

                // Выводим результат
                System.out.println(result);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Операнды должны быть целыми числами");
            }
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("throws Exception // " + e.getMessage());
        }
    }
}
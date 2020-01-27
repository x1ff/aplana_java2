import java.util.Scanner;

/**
 * Задание №2
 * 1. Начинаем писать калькулятор:
 * Реализовать сложение дробных чисел, которые пользователь вводит в консоль.
 * Использовать комментарии и JavaDoc при описании метода.
 * Использовать форматирование при выводе результата в консоль.
 * Полученный результат округлять до 4-х знаков после запятой.
 * 2. Запушить проект в свой репозиторий на GitHub
 * * Добавить возможность выбора другой операции (сложение, вычитание, деление, умножение)
 */
public class Calc {
    private double a;
    private double b;

    /**
     * Конструктор
     * @param sc
     */
    public Calc (Scanner sc) {
        try{
            System.out.println("INFO: Введите a");
            a = Double.parseDouble(sc.nextLine().replace(',','.'));
            System.out.println("INFO: Введите b");
            b = Double.parseDouble(sc.nextLine().replace(',','.'));
        } catch (NumberFormatException e) {
            System.out.println("ERR: ошибка формата данных");
        }
    }
    public void doOper (Scanner sc) {
        System.out.println("INFO: Введи знак оператора +, /");
        String operator = sc.nextLine();
        switch (operator) {
            case "+":
                System.out.printf("INFO: Итого: %.4f %n", a + b);
                break;
            case "-":
                System.out.printf("INFO: Итого: %.4f %n", a - b);
                break;
            case "*":
                System.out.printf("INFO: Итого: %.4f %n", a * b);
                break;
            case "/":
                if (b != 0) {
                    System.out.printf("INFO: Итого: %.4f %n", a / b);
                } else {
                    System.out.println("INFO: Итого: на ноль делить нельзя");
                }
                break;
            default: System.out.println("INFO: Такая операция не реализована");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calc calc = new Calc(sc);
        calc.doOper(sc);
        sc.close();
    }
}

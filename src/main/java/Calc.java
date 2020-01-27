import java.util.Scanner;

/**
 * @author Loginov M.Y.
 * @see <a href="https://moodle.aplana.com/course/view.php?id=41&section=2"> Задание в moodle</a>
 */
public class Calc {
    private double a;
    private double b;

    /**
     * @author Loginov M.Y.
     * Конструктор при вызове просит у пользователя числа a  и b
     * @param sc для ввода из консоли
     */
    private Calc(Scanner sc) {
        try{
            System.out.println("INFO: Введите a");
            a = Double.parseDouble(sc.nextLine().replace(',','.'));
            System.out.println("INFO: Введите b");
            b = Double.parseDouble(sc.nextLine().replace(',','.'));
        } catch (NumberFormatException e) {
            System.out.println("ERR: ошибка формата данных");
        }
    }

    /**
     * @author Loginov M.Y.
     * Просит у пользователя ввести оператор и выполняет действие согласно оператору для чисел a  и b
     * @param sc для ввода из консоли
     */
    private void doOper(Scanner sc) {
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

    /**
     * Главная функция, от сюда все начинается
     * @param args параметры не обрабатываются в программе.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calc calc = new Calc(sc);
        calc.doOper(sc);
        sc.close();
    }
}

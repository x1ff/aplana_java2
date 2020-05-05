import SweetGifts.Gift;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

/**
 * Задание №3.
 * @author Loginov M.Y.
 * @see <a href="https://moodle.appline.ru/course/view.php?id=41&section=3"> Задание в moodle</a>
 * @see Calc для запуска выбрпть 1
 * @see Words для запуска выбрать 2
 */
public class TaskRunner {
    private int taskNumber;

    /**
     * Конструктор создает экземпляр класса, задает номер задания
     * @param sc для ввода из консоли
     */
    private TaskRunner(Scanner sc) {
        System.out.println("INFO: введите номер задания: \n1 - калькулятор, \n2 - поиск максимального слова, " +
                "\n3 - Найти максимальный отрицательный и минимальный положительный элементы массива." +
                "\n4 - Подарок");
        taskNumber = Integer.parseInt(sc.nextLine());
    }

    /**
     * Исходя из номера задния выполняет задание.
     * @param sc Scanner for scan console
     * @exception IOException can happen if sc will not correctly
     * @exception ParseException can happen if parse input value will wrong
     */
    public void run (Scanner sc) throws IOException, ParseException {
        switch(taskNumber) {
            case 1 :
                Calc calc = new Calc(sc);
                calc.doOper(sc);
                break;
            case 2 :
                Words words = new Words(sc);
                words.searchTheLongestWord();
                break;
            case 3 :
                /**
                 * 1. Массив размерностью 20, заполняется случайными целыми числами от -10 до 10.
                 * Найти максимальный отрицательный и минимальный положительный элементы массива. Поменять их местами.
                 */
                MyArray arr = new MyArray();
                arr.showNumbers();
                arr.swapElements(arr.findIndexOfMaxNegativeInt(), arr.findIndexOfMinPositiveInt());
                arr.showNumbers();
                break;
            case 4 :
                /**
                 * 2. Формируется новогодний подарок. Он может включать в себя разные сладости (Candy, Jellybean, etc.)
                 * У каждой сладости есть название, вес, цена и свой уникальный параметр.
                 * Необходимо собрать подарок из сладостей. Найти общий вес подарка, общую стоимость подарка и
                 * вывести на консоль информацию о всех сладостях в подарке.
                 */
                Gift g = new Gift(15);
                g.printInfo();
                break;
            default: System.out.println("ERR: нету заданиея с таким номером");
        }
    }

    /**
     * Главная функция, отсюда все запускается
     * @param args программа не работает с параметрами
     * @exception IOException can happen if sc will not correctly
     * @exception ParseException can happen if parse input value will wrong
     */
    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        TaskRunner runner = new TaskRunner(sc);
        runner.run(sc);
        sc.close();
    }
}

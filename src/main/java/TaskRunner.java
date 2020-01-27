import java.util.Scanner;

/**
 * Задание №3
 * @author Loginov M.Y.
 * @see <a href="https://moodle.aplana.com/course/view.php?id=41&section=3"> Задание в moodle</a>
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
        System.out.println("INFO: введите номер задания: 1 - калькулятор, 2 - поиск максимального слова");
        taskNumber = Integer.parseInt(sc.nextLine());
    }

    /**
     * Исходя из номера задния выполняет задание.
     * @param sc
     */
    public void run (Scanner sc) {
        switch(taskNumber) {
            case 1 :
                Calc calc = new Calc(sc);
                calc.doOper(sc);
                break;
            case 2 :
                Words words = new Words(sc);
                words.searchTheLongestWord();
                break;
            default: System.out.println("ERR: нету заданиея с таким номером");
        }
    }

    /**
     * Главная функция, отсюда все запускается
     * @param args программа не работает с параметрами
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskRunner runner = new TaskRunner(sc);
        runner.run(sc);
    }
}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Задание №3.
 * @author Loginov M.Y.
 * @see <a href="https://moodle.aplana.com/course/view.php?id=41&section=3"> Задание в moodle</a>
 */
public class Words {
    private ArrayList<String> stringsWords;
    private int count;

    /**
     * Контруктор создает экземпляр класса и запрашивая у пользователя данные заполняет объект.
     * @param sc для ввода из консоли
     * @author Loginov M. Y.
     */
    public Words(Scanner sc) {
        System.out.println("INFO: Введите колличество слов");
        try {
            count = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERR: Колличество слов должно быть целым чисчлом");
        }
        stringsWords = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            stringsWords.add(sc.next());
        }
    }

    /**
     * Метод ищет и выводит на экран самое длинное слово
     */
    public void searchTheLongestWord() {
        String currentWord = "";
        for(int i = 0; i < count; i++) {
            if(currentWord.length() < stringsWords.get(i).length()) currentWord  = stringsWords.get(i);
        }
        System.out.println("INFO: Самое длинное слово: " + currentWord);
    }

    /**
     * Главная функция, тут все начинается
     * @param args программа не работает с параметрами
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("INFO: введите номер задания: 1 - калькулятор, 2 - поиск максимального слова");
        Words words = new Words(sc);
        words.searchTheLongestWord();
        sc.close();
    }
}

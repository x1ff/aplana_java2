/**
 * Задание №4 Массивы, классы.
 * 1. Массив размерностью 20, заполняется случайными целыми числами от -10 до 10.
 * Найти максимальный отрицательный и минимальный положительный элементы массива.
 * Поменять их местами.
 * @author Loginov M.Y.
 * @see <a href="https://moodle.aplana.com/course/view.php?id=41&section=4"> Задание в moodle</a>
 */
public class MyArray {
    private int[] numbers;

    /**
     * Конструктор создает с 20 рандомными числами
     */
    public MyArray() {
        this.numbers = new int[20];
        for (int i =0; i < 20; i++) {
            this.numbers[i] = (int) (Math.random() * 21) - 10;
        }
    }

    /**
     * Метод отображет элементы массива
     */
    public void showNumbers() {
        System.out.println("INFO: this is numbers");
        System.out.println("i \t value");
        for(int i = 0; i < 20; i++) {
            System.out.println("" + i + " \t " + this.numbers[i]);
        }
    }

    /**
     * Метод возвращает @return индекс элемента массива с максимальным отприцательным числом
     */
    public int findIndexOfMaxNegativeInt() {
        int currentInt = this.numbers[0];
        int currentIndex = 0;
        for(int i = 1; i < 20; i++) {
           if ((this.numbers[i] < 0 && this.numbers[i] > currentInt) || currentInt >= 0) {
               currentInt = this.numbers[i];
               currentIndex = i;
           }
        }
        if(currentInt > 0) {
            System.out.println("INFO: no one negative int here");
            return  -1;
        }
        return currentIndex;
    }

    /**
     *  Метод возвращает @return индекс элемента массива с минимальным положительным числом
     */
    public int findIndexOfMinPositiveInt() {
        int currentInt = this.numbers[0];
        int currentIndex = 0;
        for(int i = 1; i < 20; i++) {
            if ((this.numbers[i] > 0 && this.numbers[i] < currentInt) || currentInt <= 0) {
                currentInt = this.numbers[i];
                currentIndex = i;
            }
        }
        if(currentInt < 0) {
            System.out.println("INFO: no one positive int here");
            return  -1;
        }
        return currentIndex;
    }

    /**
     * Метод меняет элементы с заданными индексами местами
     * @param index1 - 1 индекс
     * @param index2 - 2 индекс
     */
    public void swapElements(int index1, int index2) {
        numbers[index1] ^= numbers[index2];
        numbers[index2] ^= numbers[index1];
        numbers[index1] ^= numbers[index2];
    }

    public static void main(String[] args) {
        MyArray arr = new MyArray();
        arr.showNumbers();
        arr.swapElements(arr.findIndexOfMaxNegativeInt(), arr.findIndexOfMinPositiveInt());
        arr.showNumbers();
    }
}

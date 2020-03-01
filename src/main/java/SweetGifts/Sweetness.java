package SweetGifts;

/**
 * Задание №4 Массивы, классы
 * 2. Формируется новогодний подарок. Он может включать в себя разные сладости (Candy, Jellybean, etc.)
 * У каждой сладости есть название, вес, цена и свой уникальный параметр.
 * Необходимо собрать подарок из сладостей. Найти общий вес подарка,
 * общую стоимость подарка и вывести на консоль информацию о всех сладостях в подарке.
 * @author Loginov M.Y.
 * @see <a href="https://moodle.aplana.com/course/view.php?id=41&section=4"> Задание в moodle</a>
 */
public abstract class Sweetness {
    private static int counter = 0;
    private double weight; // kg
    private double price; // $

    public Sweetness(double weight, double price) {
        this.weight = weight;
        this.price = price;
    }

    public static int getCounter() {
        return counter;
    }
    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "\t weight = " + weight + "\t  price = " + price;
    }

    public synchronized static int nextCounter() {
        return counter++;
    }
}
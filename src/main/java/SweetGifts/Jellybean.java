package SweetGifts;

/**
 * Класс описывает жевательную конфету
 */
public class Jellybean extends Sweetness{
    public final int id;

    /**
     * Коструктор создает класс с заданными параметрами
     * @param weight - вес
     * @param price - цена
     */
    public Jellybean(double weight, double price) {
        super(weight, price);
        this.id = nextCounter();
    }

    /**
     * Метод возвращает @return id  сладости
     */
    public int getId() {
        return id;
    }

    /**
     * Метод возвращает @return информацию о сладости
     */
    @Override
    public String toString() {
        return "\t Jellybean " + super.toString() + ", id = " + id;
    }
}

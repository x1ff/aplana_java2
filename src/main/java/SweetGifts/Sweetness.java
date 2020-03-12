package SweetGifts;

/**
 * Базовый класс сладостей
 */
public abstract class Sweetness {
    private static int counter = 0;
    private double weight; // kg
    private double price; // $

    /**
     * Конструктор создает сладость заданными параметрами
     * @param weight - вес
     * @param price - цена
     */
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

    /**
     * Метод возвращает @return информацию о сладости
     */
    @Override
    public String toString() {
        return "\t weight = " + weight + "\t  price = " + price;
    }

    public synchronized static int nextCounter() {
        return counter++;
    }
}
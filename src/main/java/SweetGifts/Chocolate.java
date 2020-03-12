package SweetGifts;

/**
 * Класс описывающий шоколад
 */
public class Chocolate extends Sweetness{
    public final int id;

    /**
     * Конструктор создающий шоколад с нужными параметрами
     * @param weight вес
     * @param price цена
     */
    public Chocolate(double weight, double price) {
        super(weight, price);
        this.id = nextCounter();
    }

    /**
     * Метод возвращает  id  слодости
     * @return id  шоколада
     */
    public int getId() {
        return id;
    }

    /**
     * Метод возвращает информацию о шоколаде
     * @return информация о шоколаде для вывода
     */
    @Override
    public String toString() {
        return "\t Chocolate " + super.toString() + ", id = " + id;
    }
}

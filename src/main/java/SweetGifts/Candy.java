package SweetGifts;

/**
 * Задание №4 Массивы, классы: класс описывающий конфету.
 */
public class Candy extends Sweetness{
    public final int id;

    /**
     * Конструктор, создающий конфету с нуцжными параметрами
     * @param weight - вес конфеты
     * @param price - цена конфеты
     */
    public Candy(double weight, double price) {
        super(weight, price);
        this.id = nextCounter();
    }

    /**
     * @return - id  конфеты
     */
    public int getId() {
        return id;
    }

    /**
     * @return - информация о конфете для вывода
     */
    @Override
    public String toString() {
        return "\t Candy\t  " + super.toString() + ", id = " + id ;
    }
}

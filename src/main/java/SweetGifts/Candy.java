package SweetGifts;

/**
 * Класс описывающий конфету.
 */
public class Candy extends Sweetness{
    public final int id;

    /**
     * Конструктор, создающий конфету с нуцжными параметрами
     * @param weight вес конфеты
     * @param price цена конфеты
     */
    public Candy(double weight, double price) {
        super(weight, price);
        this.id = nextCounter();
    }

    /**
     * Метод возвращает id сладости
     * @return - id  конфеты
     */
    public int getId() {
        return id;
    }

    /**
     * Метод возвращает информацию о конфете
     * @return - информация о конфете для вывода
     */
    @Override
    public String toString() {
        return "\t Candy\t  " + super.toString() + ", id = " + id ;
    }
}

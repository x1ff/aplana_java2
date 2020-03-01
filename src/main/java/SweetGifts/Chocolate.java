package SweetGifts;

public class Chocolate extends Sweetness{
    public final int id;

    public Chocolate(double weight, double price) {
        super(weight, price);
        this.id = nextCounter();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\t Chocolate " + super.toString() + ", id = " + id;
    }
}

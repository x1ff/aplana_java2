package SweetGifts;

public class Jellybean extends Sweetness{
    public final int id;

    public Jellybean(double weight, double price) {
        super(weight, price);
        this.id = nextCounter();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\t Jellybean " + super.toString() + ", id = " + id;
    }
}

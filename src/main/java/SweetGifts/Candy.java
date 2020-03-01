package SweetGifts;

public class Candy extends Sweetness{
    public final int id;

    public Candy(double weight, double price) {
        super(weight, price);
        this.id = nextCounter();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\t Candy\t  " + super.toString() + ", id = " + id ;
    }
}

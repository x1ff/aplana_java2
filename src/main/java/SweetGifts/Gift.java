package SweetGifts;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Gift {
    private Sweetness [] gift;
    private double weight; // g
    private double price; // $

    public double getWeight() {
        return weight;
    }
    public double getPrice() {
        return price;
    }

    /**
     * @auther Loginov M.Y.
     * @param count random sweetness in the gift
     * @throws IOException
     * @throws ParseException
     */
    public Gift(int count) throws IOException, ParseException {
        File file = new File("src/main/resources/Sweetness.json");
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(file));
        JSONObject jsonObject = (JSONObject) obj;
        // System.out.println(jsonObject);
        this.gift = new Sweetness[count];
        weight = 0;
        price = 0;

        for (int i = 0; i < count; i++) {
            Random r = new Random();
            switch (r.nextInt(3) + 1){
                case 1:
                    JSONObject jsonCandy = (JSONObject) jsonObject.get("Candy");
                    this.gift[i] = new Candy((double) jsonCandy.get("weight"), (double) jsonCandy.get("price"));
                    this.weight += (double) jsonCandy.get("weight");
                    this.price += (double) jsonCandy.get("price");
                    break;
                case 2:
                    JSONObject jsonJellybean = (JSONObject) jsonObject.get("Jellybean");
                    this.gift[i] = new Jellybean((double) jsonJellybean.get("weight"), (double) jsonJellybean.get("price"));
                    this.weight += (double) jsonJellybean.get("weight");
                    this.price += (double) jsonJellybean.get("price");
                    break;
                default:
                    JSONObject jsonChocolate = (JSONObject) jsonObject.get("Chocolate");
                    this.gift[i] = new Chocolate((double) jsonChocolate.get("weight"), (double) jsonChocolate.get("price"));
                    this.weight += (double) jsonChocolate.get("weight");
                    this.price += (double) jsonChocolate.get("price");
                    break;
            }
        }
    };
    public void printInfo(int count) {
        System.out.println("INFO: weight = " + getWeight() + "g");
        System.out.println("INFO: price = " + getPrice() + "$");
        System.out.println("INFO: Gift contains:");
        for (int i = 0; i < count; i++) {
            System.out.println(gift[i].toString());
        }
    }
    public static void main(String[] args) throws IOException, ParseException {

        Gift g = new Gift(15);
        g.printInfo(Sweetness.getCounter());
    }
}

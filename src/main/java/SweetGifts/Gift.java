package SweetGifts;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Задание №4 Массивы, классы: класс описывающий подарок.
 */
public class Gift {
    private ArrayList<Sweetness> gift;
    private double weight; // g
    private double price; // $
    private JSONObject sweetnessParam;

    public double getWeight() {
        return weight;
    }
    public double getPrice() {
        return price;
    }

    /**
     * @author Логонов М. Ю.
     * @param count - колличество конфет в подарке
     * @throws IOException может случиться при не коректном ввода
     * @throws ParseException может случиться при не корректном парсе
     * Конструктор формирует подарок случайными сладостями, но с фиксированным их колличеством
     */
    public Gift(int count) throws IOException, ParseException {
        weight = 0;
        price = 0;
        gift = new ArrayList<>();
        setSweetnessParam();
        for (int i = 0; i < count; i++) {
            int type = (new Random()).nextInt(3) + 1;
            addSweetness(type);
        }
    };

    /**
     * Метод задает параметры сладостей из файла:
     * @see <a href=file:..\src\main\resources\Sweetness.json>\src\main\resources\Sweetness.json</a>
     * */
    private void setSweetnessParam() throws IOException, ParseException {
        File config = new File("src/main/resources/Sweetness.json");
        JSONParser parser = new JSONParser();
        this.sweetnessParam = (JSONObject) parser.parse(new FileReader(config));
    }

    /**
     * Метод добавляет сладость с нудным типом в подарок
     * @param type - тип сладости: 1 - Candy, 2 - Jellybean, default - Chocolate
     * @throws IOException может случиться при не коректном ввода
     * @throws ParseException  может случиться при не корректном парсе
     */
    private void addSweetness(int type) throws IOException, ParseException {
        JSONObject jsonSweetness;
        switch (type) {
            case 1:
                jsonSweetness = (JSONObject) sweetnessParam.get("Candy");
                this.gift.add(new Candy((double) jsonSweetness.get("weight"), (double) jsonSweetness.get("price")));
                break;
            case 2:
                jsonSweetness = (JSONObject) sweetnessParam.get("Jellybean");
                this.gift.add(new Jellybean((double) jsonSweetness.get("weight"), (double) jsonSweetness.get("price")));
                break;
            default:
                jsonSweetness = (JSONObject) sweetnessParam.get("Chocolate");
                this.gift.add(new Chocolate((double) jsonSweetness.get("weight"), (double) jsonSweetness.get("price")));
                break;
        }
        this.weight += (double) jsonSweetness.get("weight");
        this.price += (double) jsonSweetness.get("price");
    }

    /**
     * Метод реализует отображение информации о сладостях в падарке
     * @param counter
     */
    public void printInfo(int counter) {
        System.out.println("INFO: weight = " + getWeight() + "g");
        System.out.println("INFO: price = " + getPrice() + "$");
        System.out.println("INFO: Gift contains:");
        for (int i = 0; i < Sweetness.getCounter(); i++) {
            System.out.println(gift.get(i).toString());
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        Gift g = new Gift(15);
        g.printInfo(Sweetness.getCounter());
    }
}

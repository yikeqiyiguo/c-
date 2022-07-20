//²Λµ¥ΚµΜε
public class Dishes {
    private int id;
    private String dish_name;
    private Double price;

    public Dishes(int id, String dish_name, Double price) {
        this.id = id;
        this.dish_name = dish_name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getDish_name() {
        return dish_name;
    }

    public Double getPrice() {
        return price;
    }
}


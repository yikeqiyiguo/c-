//已点菜品实体
public class AlreadyDishes {
    private int id;
    private String dish_name;
    private Double price;
    private int num;

    public AlreadyDishes(int id, String dish_name, Double price, int num) {
        this.id = id;
        this.dish_name = dish_name;
        this.price = price;
        this.num = num;
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

    public int getNum() {
        return num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

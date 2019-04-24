package dao.entities;

public class Dish {
    private Integer id;
    private String name;
    private String type;
    private float price;

    public Dish(Integer id, String name, String type, float price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }
}

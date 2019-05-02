package entities;

import java.util.Objects;

public class Dish {
    private Integer id;
    private String name;
    private String type;
    private Double price;
    private Double weight;
    private Integer quantity;

    public Dish() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(id, dish.id) &&
                Objects.equals(name, dish.name) &&
                Objects.equals(type, dish.type) &&
                Objects.equals(price, dish.price) &&
                Objects.equals(weight, dish.weight) &&
                Objects.equals(quantity, dish.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, price, weight, quantity);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", quantity=" + quantity +
                '}';
    }
}

package entities;

import java.util.Objects;

public class Menu {
    private Integer id;
    private Integer dish_id;

    public Menu() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDish_id() {
        return dish_id;
    }

    public void setDish_id(Integer dish_id) {
        this.dish_id = dish_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(dish_id, menu.dish_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dish_id);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", dish_id=" + dish_id +
                '}';
    }
}

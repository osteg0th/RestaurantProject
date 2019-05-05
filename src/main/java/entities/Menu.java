package entities;

import java.util.Objects;

public class Menu {
    private Integer id;
    private Integer dishId;

    public Menu() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(dishId, menu.dishId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dishId);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", dishId=" + dishId +
                '}';
    }
}

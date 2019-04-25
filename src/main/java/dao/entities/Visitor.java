package dao.entities;

import java.util.Objects;

public class Visitor {
    private Integer id;
    private String name;
    private Integer table_id;

    public Visitor() {

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

    public Integer getTable_id() {
        return table_id;
    }

    public void setTable_id(Integer table_id) {
        this.table_id = table_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return Objects.equals(id, visitor.id) &&
                Objects.equals(name, visitor.name) &&
                Objects.equals(table_id, visitor.table_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, table_id);
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", table_id=" + table_id +
                '}';
    }
}

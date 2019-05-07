package entities;

import java.sql.Timestamp;
import java.util.Objects;

public class Order {
    private Integer id;
    private Double priceTotal;
    private Integer menuId;
    private Timestamp orderTime; //right type?
    private Byte confirm;
    private Byte paid;
    private Integer userId;
    private Integer tableId;

    public static class Builder {
        private Order newOrder;

        public Builder setId(Integer id) {
            newOrder.id = id;
            return this;
        }
        public Builder setPriceTotal(Double priceTotal) {
            newOrder.priceTotal = priceTotal;
            return this;
        }
        public Builder setMenuId(Integer menuId) {
            newOrder.menuId = menuId;
            return this;
        }
        public Builder setOrderTime(Timestamp orderTime) {
            newOrder.orderTime = orderTime;
            return this;
        }

        public Builder setConfirm(Byte confirm) {
            newOrder.confirm = confirm;
            return this;
        }

        public Builder setPaid(Byte paid) {
            newOrder.paid = paid;
            return this;
        }
        public Builder setUserId(Integer userId) {
            newOrder.userId = userId;
            return this;
        }
        public Builder setTableId(Integer tableId) {
            newOrder.tableId = tableId;
            return this;
        }
        public Order build(){
            return new Order();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Byte getConfirm() {
        return confirm;
    }

    public void setConfirm(Byte confirm) {
        this.confirm = confirm;
    }

    public Byte getPaid() {
        return paid;
    }

    public void setPaid(Byte paid) {
        this.paid = paid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(priceTotal, order.priceTotal) &&
                Objects.equals(menuId, order.menuId) &&
                Objects.equals(orderTime, order.orderTime) &&
                Objects.equals(confirm, order.confirm) &&
                Objects.equals(paid, order.paid) &&
                Objects.equals(userId, order.userId) &&
                Objects.equals(tableId, order.tableId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, priceTotal, menuId, orderTime, confirm, paid, userId, tableId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", priceTotal=" + priceTotal +
                ", menuId=" + menuId +
                ", orderTime=" + orderTime +
                ", confirm=" + confirm +
                ", paid=" + paid +
                ", userId=" + userId +
                ", tableId=" + tableId +
                '}';
    }
}



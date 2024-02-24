package lk.ijse.ManyToMany.entity;

import lk.ijse.ManyToMany.embedd.OrderDetailPK;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailPK orderDetailPKl;
    @Column(name = "order_qty")
    private int orderQty;
    @Column(name = "order_price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id",
            referencedColumnName = "order_id",
            insertable = false,
            updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="item_id",
            referencedColumnName = "item_id",
            insertable = false,
            updatable = true)
    private Item item;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailPK orderDetailPKl, int orderQty, double price) {
        this.orderDetailPKl = orderDetailPKl;
        this.orderQty = orderQty;
        this.price = price;
    }

    public OrderDetailPK getOrderDetailPKl() {
        return orderDetailPKl;
    }

    public void setOrderDetailPKl(OrderDetailPK orderDetailPKl) {
        this.orderDetailPKl = orderDetailPKl;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailPKl=" + orderDetailPKl +
                ", orderQty=" + orderQty +
                ", price=" + price +
                '}';
    }
}

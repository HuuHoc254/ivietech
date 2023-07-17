package entity;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int quantity;
    private Double unitPrice;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderDetail() {
    }

    public OrderDetail(Long id, String productName, int quantity, Double unitPrice, Order order) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", order=" + order +
                '}';
    }
}

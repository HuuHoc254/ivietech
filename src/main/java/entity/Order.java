package entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate;
    private String customerName;
    private String customerAddress;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetailList;

    public Order() {
    }

    public Order(Long id, LocalDateTime orderDate, String customerName, String customerAddress, List<OrderDetail> orderDetailList) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.orderDetailList = orderDetailList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}

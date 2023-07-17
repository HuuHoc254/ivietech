package service;

import entity.Order;
import entity.OrderDetail;

public interface OrderService{
    void save(Order order, OrderDetail orderDetail) throws Exception;
}

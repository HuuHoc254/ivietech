package service;

import entity.Order;
import entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.OrderDetailRepository;
import repository.OrderRepository;

@Service("orderService")
public class IOrderService implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Order order, OrderDetail orderDetail)  throws Exception {
        order = orderRepository.save(order);
        if (order.getId() %2==0){
            throw new Exception("Id là chẵn");
        }
        orderDetail.setOrder(order);
        orderDetailRepository.save(orderDetail);
    }
}

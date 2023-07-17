import configuration.SpringConfiguration;
import entity.Order;
import entity.OrderDetail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.OrderDetailRepository;
import repository.OrderRepository;
import service.OrderService;

import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        OrderDetailRepository orderDetailRepository = (OrderDetailRepository) context.getBean("orderDetailRepository");
        OrderRepository orderRepository = (OrderRepository) context.getBean("orderRepository");
        OrderService orderService = context.getBean("orderService", OrderService.class);
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now().minusMonths(1));
        order.setCustomerName("HuuHoc1");
        order.setCustomerAddress("QN");

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductName("ip 2");
        orderDetail.setQuantity(3);
        orderDetail.setUnitPrice(166.0);
        orderDetail.setOrder(order);

        orderRepository.save(order);

//        orderRepository.findAll().stream().forEach(order -> {
//            System.out.println(order.toString());
//        });
//        orderDetailRepository.findAll().forEach(orderDetail -> {
//            System.out.println(orderDetail.toString());
//        });
//        orderRepository.findByCurrentMonth().forEach(order ->
//                System.out.println(order.getId()));
//
    }
}

package labshopmonolith.service;

import java.util.List;
import java.util.Optional;
import labshopmonolith.domain.*;

public interface OrderService {
    List<Order> getAllOrders() throws Exception;
    Optional<Order> getOrderById(Long id) throws Exception;
    Order createOrder(Order order) throws Exception;
    Order updateOrder(Order order) throws Exception;
    void deleteOrder(Long id) throws Exception;
}

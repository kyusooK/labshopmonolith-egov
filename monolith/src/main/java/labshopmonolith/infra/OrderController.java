package labshopmonolith.infra;

import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import labshopmonolith.domain.*;
import labshopmonolith.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/orders")
@Transactional
public class OrderController {

    @Resource(name = "orderService")
    private OrderService orderService;

    @GetMapping("/order")
    public List<Order> getAllOrders() throws Exception {
        // Get all orders via OrderService
        return orderService.getAllOrders();
    }

    @GetMapping("/order/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id)
        throws Exception {
        // Get a order by ID via OrderService
        return orderService.getOrderById(id);
    }

    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order) throws Exception {
        // Create a new order via OrderService
        return orderService.createOrder(order);
    }

    @PutMapping("/order/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order)
        throws Exception {
        // Update an existing order via OrderService
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable Long id) throws Exception {
        // Delete a order via OrderService
        orderService.deleteOrder(id);
    }
}

package spring_boot.session15bt03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring_boot.session15bt03.model.Order;
import spring_boot.session15bt03.service.OrderService;

import java.util.List;

@Controller
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String orders(
            String status,
            String sortBy,
            String direction,
            Model model
    ) {

        if (status == null) status = "ALL";
        if (sortBy == null) sortBy = "createdDate";
        if (direction == null) direction = "desc";

        List<Order> orders =
                orderService.getOrders(status, sortBy, direction);

        model.addAttribute("orders", orders);

        return "orders";
    }
}

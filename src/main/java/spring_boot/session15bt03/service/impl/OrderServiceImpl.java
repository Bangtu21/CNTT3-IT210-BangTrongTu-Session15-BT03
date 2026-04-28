package spring_boot.session15bt03.service.impl;

import org.springframework.stereotype.Service;
import spring_boot.session15bt03.model.Order;
import spring_boot.session15bt03.repository.OrderRepository;
import spring_boot.session15bt03.service.OrderService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrders(String status, String sortBy, String direction) {

        List<Order> orders = orderRepository.findAll();

        // lọc trạng thái
        if (status != null && !status.equals("ALL")) {
            orders = orders.stream()
                    .filter(order -> order.getStatus().equalsIgnoreCase(status))
                    .collect(Collectors.toList());
        }

        // chống sortBy linh tinh
        if (!"createdDate".equals(sortBy) && !"totalPrice".equals(sortBy)) {
            sortBy = "createdDate";
        }

        Comparator<Order> comparator;

        if (sortBy.equals("totalPrice")) {
            comparator = Comparator.comparing(Order::getTotalPrice);
        } else {
            comparator = Comparator.comparing(Order::getCreatedDate);
        }

        // asc hoặc desc
        if ("desc".equalsIgnoreCase(direction)) {
            comparator = comparator.reversed();
        }

        return orders.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}

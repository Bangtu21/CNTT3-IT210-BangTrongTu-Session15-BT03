package spring_boot.session15bt03.repository;

import org.springframework.stereotype.Repository;
import spring_boot.session15bt03.model.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    public OrderRepository() {
        orders.add(new Order(1L, 1L, "Đang giao", 2000000.0, LocalDate.now().minusDays(1)));
        orders.add(new Order(2L, 1L, "Đã hủy", 500000.0, LocalDate.now().minusDays(5)));
        orders.add(new Order(3L, 1L, "Đang giao", 7000000.0, LocalDate.now().minusDays(2)));
        orders.add(new Order(4L, 1L, "Hoàn thành", 3000000.0, LocalDate.now().minusDays(10)));
        orders.add(new Order(5L, 1L, "Đang giao", 1500000.0, LocalDate.now().minusDays(3)));
        orders.add(new Order(6L, 1L, "Đã hủy", 9000000.0, LocalDate.now().minusDays(7)));
        orders.add(new Order(7L, 1L, "Hoàn thành", 2500000.0, LocalDate.now().minusDays(4)));
    }

    public List<Order> findAll() {
        return orders;
    }
}

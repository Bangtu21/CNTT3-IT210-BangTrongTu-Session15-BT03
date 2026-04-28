package spring_boot.session15bt03.service;

import spring_boot.session15bt03.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders(String status, String sortBy, String direction);
}

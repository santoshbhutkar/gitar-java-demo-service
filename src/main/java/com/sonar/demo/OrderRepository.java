package com.sonar.demo;

import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
  private final Map<Long, Order> orders = Map.of(
      1001L, new Order(1001L, "alice", "Demo headset", 1),
      1002L, new Order(1002L, "bob", "Demo keyboard", 2));

  public Optional<Order> findById(long id) {
    return Optional.ofNullable(orders.get(id));
  }
}

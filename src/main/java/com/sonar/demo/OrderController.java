package com.sonar.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
  private final OrderRepository repository;

  public OrderController(OrderRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/orders/{id}")
  public ResponseEntity<Order> getOrder(
      @PathVariable long id,
      @RequestHeader("X-User-Id") String userId) {
    return repository.findById(id)
        .map(order -> {
          if (!order.ownerId().equals(userId)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).<Order>build();
          }
          return ResponseEntity.ok(order);
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}

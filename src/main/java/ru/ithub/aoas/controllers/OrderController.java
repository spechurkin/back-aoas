package ru.ithub.aoas.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ithub.aoas.payload.response.OrderDto;
import ru.ithub.aoas.services.OrderService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

  @Autowired
  private final OrderService orderService;

  @GetMapping
  public List<OrderDto> getAll() {
    return orderService.getAll();
  }

  @GetMapping("{/id}")
  public OrderDto getOrder(@PathVariable Long id) {
    return orderService.getOrder(id);
  }

  @PostMapping
  public OrderDto create(@RequestBody OrderDto dto) {
    return orderService.createOrder(dto);
  }

  @PutMapping("/{id}")
  public OrderDto update(@PathVariable Long id, @RequestBody OrderDto dto) {
    return orderService.updateOrder(id, dto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Long id) {
    return orderService.delete(id);
  }
}

package rafal.kwiatkowski.shopasssistent_springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rafal.kwiatkowski.shopasssistent_springmvc.model.OrderTbl;
import rafal.kwiatkowski.shopasssistent_springmvc.model.Product;
import rafal.kwiatkowski.shopasssistent_springmvc.service.OrderService;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("order")
    public List<OrderTbl> findAllOrders() {
        return orderService.findAll();
    }

    @GetMapping(value = "order/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public OrderTbl findOrder(@PathVariable("id") Integer id) {
        return orderService.findOne(id);
    }

    @PostMapping("order")
    public OrderTbl createOrder(@RequestBody OrderTbl order) {
        return orderService.save(order);
    }

    @PutMapping(value = "order")
    public OrderTbl updateProduct(@RequestBody OrderTbl orderWithChanges) {
        return orderService.save(orderWithChanges);
    }

    @DeleteMapping(value = "order/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer id) {
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "order")
    public ResponseEntity<Product> deleteAllProduct() {
        orderService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

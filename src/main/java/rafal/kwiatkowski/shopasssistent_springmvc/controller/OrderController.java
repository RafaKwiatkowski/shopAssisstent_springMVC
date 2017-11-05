package rafal.kwiatkowski.shopasssistent_springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rafal.kwiatkowski.shopasssistent_springmvc.model.Customer;
import rafal.kwiatkowski.shopasssistent_springmvc.repository.OrderRepository;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderService;

    @GetMapping("/order/")
    public ResponseEntity<List<Customer>> findAllOrders() {
        List<Customer> orders = orderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}

package rafal.kwiatkowski.shopasssistent_springmvc.service;

import rafal.kwiatkowski.shopasssistent_springmvc.model.OrderTbl;
import rafal.kwiatkowski.shopasssistent_springmvc.model.Product;

import java.util.List;

public interface OrderService {
    List<OrderTbl> findAll();
    OrderTbl findOne(Integer orderId);
    void delete(Integer orderId);
    void deleteAll();
    OrderTbl save(OrderTbl order);
}

package rafal.kwiatkowski.shopasssistent_springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rafal.kwiatkowski.shopasssistent_springmvc.model.OrderTbl;
import rafal.kwiatkowski.shopasssistent_springmvc.model.Product;
import rafal.kwiatkowski.shopasssistent_springmvc.repository.OrderRepository;
import rafal.kwiatkowski.shopasssistent_springmvc.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<OrderTbl> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderTbl findOne(Integer orderId) {
        return orderRepository.findOne(orderId);
    }

    @Override
    public void delete(Integer orderId) {
        orderRepository.delete(orderId);
    }

    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }


    @Override
    public OrderTbl save(OrderTbl order) {
        calculateTotalPrice(order);
        return orderRepository.save(order);
    }

    private void calculateTotalPrice(OrderTbl order) {
        BigDecimal totalPrice = new BigDecimal("0");
        List<Integer> products = order.getProducts();
        for (Integer productId : products) {
            if (productRepository.findOne(productId) != null) {
                Product product = productRepository.getOne(productId);
                totalPrice = totalPrice.add(product.getUnitPrice());
            }
        }
        order.setTotalPrice(totalPrice);
    }
}

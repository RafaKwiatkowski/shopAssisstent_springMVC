//package rafal.kwiatkowski.shopasssistent_springmvc.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import rafal.kwiatkowski.shopasssistent_springmvc.model.OrderTbl;
//import rafal.kwiatkowski.shopasssistent_springmvc.repository.OrderRepository;
//
//import java.util.List;
//
//@Service
//public class OrderServiceImpl implements OrderService {
//
//    @Autowired
//    OrderRepository orderRepository;
//
//    @Override
//    public List<OrderTbl> findAll() {
//        return orderRepository.findAll();
//    }
//
//    @Override
//    public OrderTbl findOne(Integer orderId) {
//        return orderRepository.findOne(orderId);
//    }
//
//    @Override
//    public void delete(OrderTbl order) {
//        orderRepository.delete(order);
//    }
//
//    @Override
//    public void save(OrderTbl order) {
//        orderRepository.save(order);
//    }
//}

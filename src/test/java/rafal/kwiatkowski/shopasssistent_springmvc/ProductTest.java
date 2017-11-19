package rafal.kwiatkowski.shopasssistent_springmvc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import rafal.kwiatkowski.shopasssistent_springmvc.model.Customer;
import rafal.kwiatkowski.shopasssistent_springmvc.model.OrderTbl;
import rafal.kwiatkowski.shopasssistent_springmvc.model.Product;
import rafal.kwiatkowski.shopasssistent_springmvc.repository.OrderRepository;
import rafal.kwiatkowski.shopasssistent_springmvc.repository.ProductRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    @Test
    @Transactional
    public void getSingleProduct() throws Exception {
        Product product = new Product();

        product.setName("Masło2");
        product.setUnitPrice(BigDecimal.valueOf(1));
        productRepository.save(product);
        Product savedProduct = productRepository.getOne(product.getId());
        Assert.assertEquals(product.getName(),savedProduct.getName());
    }
}

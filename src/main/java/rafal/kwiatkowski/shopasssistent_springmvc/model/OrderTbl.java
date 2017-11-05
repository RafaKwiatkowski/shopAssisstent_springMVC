package rafal.kwiatkowski.shopasssistent_springmvc.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class OrderTbl {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @ManyToMany
    @JoinTable(
            name = "Order_Product",
            joinColumns = {@JoinColumn(name = "orderId")},
            inverseJoinColumns = {@JoinColumn(name = "productId")}
    )
    private List<Product> products;
    private BigDecimal totalPrice;
    private LocalDateTime orderDt;

    public OrderTbl() {
    }

    public OrderTbl(Customer customer, List<Product> products, BigDecimal totalPrice, LocalDateTime orderDt) {
        this.customer = customer;
        this.products = products;
        this.totalPrice = totalPrice;
        this.orderDt = orderDt;
    }

    public Integer getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getTotalPrice() {
//        totalPrice = BigDecimal.ZERO;
//        for (Product product : products) {
//            totalPrice = totalPrice.add(product.getUnitPrice().multiply(product.getQuantity()));
//        }
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getOrderDt() {
        return orderDt;
    }

    public void setOrderDt(LocalDateTime orderDt) {
        this.orderDt = orderDt;
    }
}

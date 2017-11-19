package rafal.kwiatkowski.shopasssistent_springmvc.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;

@Entity
@XmlRootElement
public class OrderTbl {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer customerId;

    @ElementCollection(targetClass = Integer.class)
    private List<Integer> products;
    private BigDecimal totalPrice;

    public OrderTbl() {
    }

    public OrderTbl(Integer customerId, List<Integer> products, BigDecimal totalPrice) {
        this.customerId = customerId;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<Integer> getProducts() {
        return products;
    }

    public void setProducts(List<Integer> products) {
        this.products = products;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderTbl{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", products=" + products +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

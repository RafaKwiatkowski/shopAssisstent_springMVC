package rafal.kwiatkowski.shopasssistent_springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rafal.kwiatkowski.shopasssistent_springmvc.model.Product;
import rafal.kwiatkowski.shopasssistent_springmvc.repository.ProductRepository;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "product")
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public Product findProduct(@PathVariable Integer id) {
        return productRepository.findOne(id);
    }

    @PostMapping(value = "product")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping(value = "product/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product productWithChanges) {
        Product product = productRepository.findOne(id);
        product.setName(productWithChanges.getName());
        product.setUnitPrice(productWithChanges.getUnitPrice());
        product.setQuantity(productWithChanges.getQuantity());
        productRepository.save(product);
        return product;
    }

    @DeleteMapping(value = "product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer id) {
        productRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "product")
    public ResponseEntity<Product> deleteAllProduct() {
        productRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

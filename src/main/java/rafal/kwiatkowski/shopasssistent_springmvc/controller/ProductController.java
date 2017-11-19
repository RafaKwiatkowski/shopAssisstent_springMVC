package rafal.kwiatkowski.shopasssistent_springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rafal.kwiatkowski.shopasssistent_springmvc.model.Product;
import rafal.kwiatkowski.shopasssistent_springmvc.repository.ProductRepository;

import java.util.List;

// 38 linni kodu

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "product")
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @GetMapping(value = "product/{name}")
    public List<Product> findByName(@PathVariable String name) {
        return productRepository.findByName(name);
    }

    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public Product findProduct(@PathVariable Integer id) {
        return productRepository.findOne(id);
    }

    @PostMapping(value = "product", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping(value = "product")
    public Product updateProduct(@RequestBody Product productWithChanges) {
        return productRepository.save(productWithChanges);
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

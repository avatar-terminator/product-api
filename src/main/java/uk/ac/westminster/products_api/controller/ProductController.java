package uk.ac.westminster.products_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.ac.westminster.products_api.dto.DigitalProduct;
import uk.ac.westminster.products_api.dto.Product;
import uk.ac.westminster.products_api.service.ProductService;

import java.util.List;

@RestController
//@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    // Since Product class is now Abstract Jackson cannot create the Product objects from JSON.
    // Temporarily changed the Product to DigitalProduct.
    @PostMapping("/products")
    public Product addProduct(@RequestBody DigitalProduct product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/products/search/{name}")
    public List<Product> findByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @GetMapping("/products/cheaper-than")
    public List<Product> cheaperThan(@RequestParam Double amount) {
        return productService.cheaperThan(amount);
    }

    @GetMapping("/products/summaries")
    public List<String> getAllSummaries() {
        return productService.getAllSummaries();
    }
}

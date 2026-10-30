package uk.ac.westminster.products_api.service;

import org.springframework.stereotype.Service;
import uk.ac.westminster.products_api.dto.DigitalProduct;
import uk.ac.westminster.products_api.dto.PhysicalProduct;
import uk.ac.westminster.products_api.dto.Product;

import java.util.*;

@Service
public class ProductService {
    private Map<Long, Product> productMap = new HashMap<>();
    private Long nextId = 1L;

    public ProductService() {

        productMap.put(nextId, new PhysicalProduct(nextId, "Monitor", 299.99, 5.4, "1280x720"));
        nextId++;
        productMap.put(nextId, new DigitalProduct(nextId, "E-Book", 99.99, "url/digital", 3.5));
        nextId++;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        productMap.put(product.getId(), product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return Optional.ofNullable(productMap.get(id));
    }

    public void deleteProduct(Long id) {
        productMap.remove(id);
    }

    public List<Product> findByName(String name) {
       return productMap.values().stream().filter(p -> p.getName().contains(name)).toList();
    }

    public List<Product> cheaperThan(Double amount) {
        return productMap.values().stream().filter(p -> p.getPrice() < amount).toList();
    }
}

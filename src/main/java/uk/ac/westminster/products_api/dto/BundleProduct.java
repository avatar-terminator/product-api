package uk.ac.westminster.products_api.dto;

import java.util.ArrayList;
import java.util.List;

public class BundleProduct extends Product {
    private List<Product> productList = new ArrayList<>();

    public BundleProduct() {}

    public BundleProduct(Long id, String name, Double price, List<Product> productList) {
        super(id, name, price);
        this.productList = productList;
    }

    public BundleProduct(Long id, String name, Double price) {
        super(id, name, price);
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}


// Is BundleProduct really an IS-A Product, or have you just found a HAS-A hiding inside an extends?
// BundleProduct is also a product which has one or more products. So it is a HAS-A hiding inside an extends.
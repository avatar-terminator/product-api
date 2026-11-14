package uk.ac.westminster.products_api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BundleProduct extends Product {
    private List<Product> productList = new ArrayList<>();

    public BundleProduct() {}

    public BundleProduct(Long id, String name, Double price, List<Product> productList) {
        super(id, name, price);
        this.productList = productList;
    }

    @Override
    public String getSummary() {
        String products = productList.stream()
                .map(Product::getName) // Or Product::getSummary if you want full details for each
                .collect(Collectors.joining(", "));
        return String.format("Id : %d, Name : %s, Price : %.2f, Products List : [%s], Item Count : %d", getId(), getName(), getPrice(), products, products.length());
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


// Should BundleProduct implement Discountable?
/*
    It depends on how the business rules want to handle the applicability of discounts. If we are to add BundleProducts a discount then the Products which are bundled in that BundleProduct shouldn't be applying any discounts individually.
    In that case the BundleProduct can have a discount on the total price, not on individual products. In Bundled Products applying the discount for each Bundled Product individually is not common.
*/
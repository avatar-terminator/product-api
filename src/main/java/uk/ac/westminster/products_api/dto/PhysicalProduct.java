// A PhysicalProduct IS-A Product because it inherits the attributes and methods(behaviours) of Product by extending the Product Class.
// Customer. Because it doesn't related to Product and doesn't extend it.

package uk.ac.westminster.products_api.dto;

public class PhysicalProduct extends Product implements Discountable {
    private Double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct() {}

    public PhysicalProduct(long id, String name, Double price, Double weightKg, String dimensions) {
        super(id, name, price);
        this.dimensions = dimensions;
        this.weightKg = weightKg;
        this.discountedPrice = price;
    }

    public PhysicalProduct(long id, String name, Double price) {
        super(id, name, price);
    }

    // Adding this annotation is not mandatory for application to run. It only adds a compile time safety, code readability and maintainability.
    // Which means if the method is supposed to override a method in the parent class then typo mistakes will be shown.
    // The compiler will use the overridden method for the subclass and prevent using the parent class's method.
    // Also if a developer refactor the parent or subclass methods in the future, application will not compile if the classes are not synced.
    @Override
    public String getSummary() {
        return String.format(
                "Id : %d, Name : %s, Price : %.2f, Discounted Price : %.2f, Weight in KG : %.2f, Dimensions : %s",
                getId(), getName(), getPrice(), getDiscountedPrice(), getWeightKg(), getDimensions()
        );
    }

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        setDiscountedPrice(getPrice() * (1 - capped));
    }

    @Override
    public double getDiscountedPrice() {
        return this.discountedPrice;
    }

    public String getDimensions() {
        return this.dimensions;
    }

    public Double getWeightKg() {
        return this.weightKg;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}

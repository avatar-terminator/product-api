// A PhysicalProduct IS-A Product because it inherits the attributes and methods(behaviours) of Product by extending the Product Class.
// Customer. Because it doesn't related to Product and doesn't extend it.

package uk.ac.westminster.products_api.dto;

public class PhysicalProduct extends Product{
    private Double weightKg;
    private String dimensions;

    public PhysicalProduct() {}

    public PhysicalProduct(long id, String name, Double price, Double weightKg, String dimensions) {
        super(id, name, price);
        this.dimensions = dimensions;
        this.weightKg = weightKg;
    }

    public PhysicalProduct(long id, String name, Double price) {
        super(id, name, price);
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
}

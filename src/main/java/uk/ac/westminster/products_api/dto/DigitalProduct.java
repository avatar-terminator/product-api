package uk.ac.westminster.products_api.dto;

// This class was committed in a previous commit.
public class DigitalProduct extends Product implements Discountable {
    private String downloadUrl;
    private Double fileSizeMB;
    private double discountedPrice;

    public DigitalProduct(Long id, String name, Double price, String downloadUrl, Double fileSizeMB) {
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
        this.discountedPrice = price;
    }

    public DigitalProduct(Long id, String name, Double price) {
        super(id, name, price);
    }

    public DigitalProduct() {}

    @Override
    public String getSummary() {
        return String.format(
                "Id : %d, Name : %s, Price : %.2f, Discounted Price : %.2f, DownloadURL: %s, FileSizeMB : %.2f",
                getId(), getName(), getPrice(), getDiscountedPrice(), getDownloadUrl(), getFileSizeMB()
        );
    }

    @Override
    public void applyDiscount(double rate) {
        setDiscountedPrice(getPrice() * (1 - rate));
    }

    @Override
    public double getDiscountedPrice() {
        return this.discountedPrice;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public Double getFileSizeMB() {
        return fileSizeMB;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public void setFileSizeMB(Double fileSizeMB) {
        this.fileSizeMB = fileSizeMB;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;}
}
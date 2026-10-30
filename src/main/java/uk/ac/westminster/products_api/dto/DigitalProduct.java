package uk.ac.westminster.products_api.dto;

// This class was committed in a previous commit.
public class DigitalProduct extends Product {
    private String downloadUrl;
    private Double fileSizeMB;

    public DigitalProduct(Long id, String name, Double price, String downloadUrl, Double fileSizeMB) {
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
    }

    public DigitalProduct(Long id, String name, Double price) {
        super(id, name, price);
    }

    public DigitalProduct() {}



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
}
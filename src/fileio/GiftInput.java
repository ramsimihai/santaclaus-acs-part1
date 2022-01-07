package fileio;

public class GiftInput {
    private final String productName;
    private final Double price;
    private final String category;

    public GiftInput(final String productName,
                     final double price,
                     final String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "GiftInput{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}

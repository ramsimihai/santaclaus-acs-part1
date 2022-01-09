package fileio;

public class GiftInput {
    /** product name of a gift */
    private final String productName;
    /** price of a gift */
    private final Double price;
    /** the category of the gift */
    private final String category;

    /**
     * constructor for a gift collected from input
     */
    public GiftInput(final String productName,
                     final double price,
                     final String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public final String getProductName() {
        return productName;
    }

    public final Double getPrice() {
        return price;
    }

    public final String getCategory() {
        return category;
    }

    @Override
    public final String toString() {
        return "{"
                + "productName='" + productName + '\''
                + ", price=" + price
                + ", category='" + category + '\''
                + '}';
    }
}

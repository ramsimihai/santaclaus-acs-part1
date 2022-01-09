package gifts;

public class Gift {
    private final String productName;
    private final Double price;
    private final String category;

    /**
     * constructor with parameters to create a Gift object
     * @param productName
     * @param price
     * @param category
     */
    public Gift(final String productName,
                 final double price,
                 final String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    /**
     * getter for productName
     * @return productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * getter for price
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * getter for category
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * toString() method for printing purposes
     * @return String
     */
    @Override
    public String toString() {
        return "{"
                + "productName='" + productName + '\''
                + ", price=" + price
                + ", category='" + category + '\''
                + '}';
    }
}

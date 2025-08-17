package ra.edu.btvn04;

public class Product {
    private int id;
    private String productName;
    private double price;
    private String description;
    private int stock;
    private boolean status;

    public Product(int id, String productName, double price, String description, int stock, boolean status) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.status = status;
    }

    // Getters
    public int getId() { return id; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public int getStock() { return stock; }
    public boolean isStatus() { return status; }
}

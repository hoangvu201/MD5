package ra.edu.btvn02.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    public static List<Product> products = new ArrayList<>(Arrays.asList(
            (new Product(1, "iPhone 13", 999.99, "Apple smartphone 2021", "https://example.com/img1.jpg")),
            (new Product(2, "Samsung Galaxy S21", 899.99, "Samsung flagship", "https://example.com/img2.jpg")),
            (new Product(3, "Xiaomi Mi 11", 599.99, "Powerful budget phone", "https://example.com/img3.jpg")),
            (new Product(4, "Google Pixel 6", 799.99, "Google AI camera phone", "https://example.com/img4.jpg")),
            (new Product(5, "Sony Xperia 5", 850.00, "Sony compact phone", "https://example.com/img5.jpg")),
            (new Product(6, "OnePlus 9", 729.99, "Flagship killer", "https://example.com/img6.jpg")),
            (new Product(7, "Oppo Find X3", 780.00, "Oppo premium phone", "https://example.com/img7.jpg")),
            (new Product(8, "Realme GT", 500.00, "Gaming performance", "https://example.com/img8.jpg")),
            (new Product(9, "Nokia XR20", 600.00, "Durable 5G phone", "https://example.com/img9.jpg")),
            (new Product(10, "Asus ROG Phone 5", 999.00, "Gaming beast", "https://example.com/img10.jpg"))
    ));
}

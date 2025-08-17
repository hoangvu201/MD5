package ra.edu.btvn02.repository;

import org.springframework.stereotype.Repository;
import ra.edu.btvn02.model.Data;
import ra.edu.btvn02.model.Product;

import java.util.List;

@Repository
public class ProductRepository {
    public List<Product> productLists(){
        return Data.products;
    };

    public void addProduct(Product product){
        Data.products.add(product);
    }
}

package ra.edu.btvn02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.btvn02.model.Product;
import ra.edu.btvn02.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.productLists();
    }

    public void addProduct(Product product){
        productRepository.addProduct(product);
    }
}

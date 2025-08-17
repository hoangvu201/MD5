package ra.edu.btvn08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.btvn08.model.Category;
import ra.edu.btvn08.reponsitory.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> categories(){
     return categoryRepository.getCategories();
    }

    public boolean addCategory(Category c){
        return categoryRepository.addCategory(c);
    }

    public boolean updateCategory(Category c){
        return categoryRepository.updateCategory(c);
    }

    public boolean deleteCategory(int id){
        return categoryRepository.deleteCategory(id);
    }
}

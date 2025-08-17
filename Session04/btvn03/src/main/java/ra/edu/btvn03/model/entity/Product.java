package ra.edu.btvn03.model.entity;

public class Product {
    private int id;
    private String name;
    private int categoryId;
    private int count;

    public Product() {
    }

    public Product(int id, String name, int categoryId, int count) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

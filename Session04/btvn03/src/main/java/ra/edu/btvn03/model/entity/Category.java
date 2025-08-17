package ra.edu.btvn03.model.entity;

public class Category {
    private Integer id;
    private String cateName;
    private String description;
    private Boolean status;

    public Category() {
    }

    public Category(Integer id, String cateName, String description, Boolean status) {
        this.id = id;
        this.cateName = cateName;
        this.description = description;
        this.status = status;
    }

    public Category(String cateName, String description, Boolean status) {
        this.cateName = cateName;
        this.description = description;
        this.status = status;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

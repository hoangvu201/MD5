package ra.edu.btvn03.model;

import jakarta.validation.constraints.NotBlank;

public class User {
    @NotBlank(message = "Username is not empty")
    private String name ;
    @NotBlank(message = "password is not empty")
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

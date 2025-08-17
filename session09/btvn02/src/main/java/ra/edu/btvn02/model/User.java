package ra.edu.btvn02.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class User {
    private Long id;
    @NotBlank(message = "UseName is not empty")
    private String username;
    @NotBlank(message = "Email is not empty")
    @Email(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",message = "Email is invalid")
    private String email;
    @NotBlank(message = "Password is not empty")
    private String password;

    public User() {
    }

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

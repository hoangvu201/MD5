package ra.edu.btvn01.service;

import ra.edu.btvn01.model.entity.User;

public interface UserService {
    void register(User user);
    User login(String email, String password);
    boolean existsByEmail(String email);
}

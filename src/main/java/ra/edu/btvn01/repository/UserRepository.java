package ra.edu.btvn01.repository;

import ra.edu.btvn01.model.entity.User;

public interface UserRepository {

    User findByEmail(String email);

    void save(User user);

    User findByEmailAndPassword(String email, String password);

}

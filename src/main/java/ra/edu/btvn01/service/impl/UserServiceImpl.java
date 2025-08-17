package ra.edu.btvn01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.btvn01.model.entity.User;
import ra.edu.btvn01.repository.UserRepository;
import ra.edu.btvn01.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(User user) {
        if (existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email đã tồn tại.");
        }
        userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
      return userRepository.findByEmailAndPassword(email.trim(), password.trim());
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email) != null;
    }
}

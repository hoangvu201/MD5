package ra.edu.btvn01.service;

import ra.edu.btvn01.model.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> findAllByUserId(int userId);

    Post findById(Long id);

    void deleteById(Long id);

    void save(Post post);
}

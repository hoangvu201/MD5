package ra.edu.btvn01.repository;

import ra.edu.btvn01.model.entity.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAllByUserId(int userId);

    void deleteById(Long id);

    Post findById(Long id);

    void save(Post post);
}

package ra.edu.btvn01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.edu.btvn01.model.entity.Post;
import ra.edu.btvn01.repository.PostRepository;
import ra.edu.btvn01.service.PostService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAllByUserId(int userId){
        return postRepository.findAllByUserId(userId);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void save(Post post) {
        if (post.getContent() == null || post.getContent().isBlank()) {
            throw new IllegalArgumentException("Nội dung bài viết không được để trống.");
        }
        postRepository.save(post); ;
    }
}

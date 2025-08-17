package ra.edu.btvn01.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.edu.btvn01.dto.PostDTO;
import ra.edu.btvn01.model.entity.Post;
import ra.edu.btvn01.model.entity.User;
import ra.edu.btvn01.service.PostService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/home")
    public String showPosts(HttpSession session, Model model) {
        User user = (User)session.getAttribute("user");
        List<Post> posts = postService.findAllByUserId( user.getId());
        model.addAttribute("posts", posts);
        return "postList";
    }

    @GetMapping("/add")
    public String showAdd(HttpSession session, Model model) {
        User user = (User)session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("postDTO", new PostDTO());
        return "addPost";
    }

    @PostMapping("/add")
    public String addPost(@Valid @ModelAttribute("postDTO") PostDTO postDTO,
                          BindingResult bindingResult,
                          HttpSession session,
                          Model model) {
        if (bindingResult.hasErrors()) {
            return "addPost";
        }
        User user = (User)session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        String url = null;
        if (postDTO.getImage() != null && !postDTO.getImage().isEmpty()) {
            try {
                Map uploadResult = cloudinary.uploader().upload(
                        postDTO.getImage().getBytes(),
                        ObjectUtils.emptyMap()
                );
                 url = uploadResult.get("secure_url").toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Post post = new Post();
        post.setContent(postDTO.getContent());
        post.setImage(url);
        post.setCreatedDate(LocalDate.now());
        post.setUser(user);

        postService.save(post);
        return "redirect:/posts/home";
    }

    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable("id") Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        Post post = postService.findById(id);
        if (post != null && post.getUser().getId() == user.getId()) {
            postService.deleteById(id);
        }

        return "redirect:/posts";
    }

}

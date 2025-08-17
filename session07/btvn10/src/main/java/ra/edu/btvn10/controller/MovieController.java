package ra.edu.btvn10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ra.edu.btvn10.config.CloudinaryConfig;
import ra.edu.btvn10.model.Movie;
import ra.edu.btvn10.service.MovieService;

import java.util.Map;

@Controller
@RequestMapping({"/", "/movies"})
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private CloudinaryConfig cloudinaryConfig;

    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "add";
    }

    @PostMapping("/add")
    public String addMovie(@Validated @ModelAttribute("movie") Movie movie,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }
        model.addAttribute("movie", movie);
        movieService.save(movie);
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") int id, Model model) {
        Movie movie = movieService.findById(id);
        if (movie == null) {
            return "list";
        }
        model.addAttribute("movie", movie);
        return "edit";
    }

    @PostMapping("edit/{id}")
    public String editMovie(@Validated @ModelAttribute("movie") Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit";
        }
        movieService.save(movie);
        return "list";
    }
}

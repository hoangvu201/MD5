package ra.edu.btvn10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.btvn10.model.Movie;
import ra.edu.btvn10.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll(){
        return movieRepository.getMovies();
    }

    public Movie findById(int id){
        return movieRepository.getMovie(id);
    }

    public boolean save(Movie movie){
        return movieRepository.addMovie(movie);
    }

    public boolean delete(int id){
        return movieRepository.deleteMovie(id);
    }

    public boolean update(Movie movie){
        return movieRepository.updateMovie(movie);
    }
}

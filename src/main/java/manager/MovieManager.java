package manager;

import domain.Movie;
import lombok.NoArgsConstructor;
import repository.MovieRepository;


@NoArgsConstructor

public class MovieManager {
    private MovieRepository repository;
    private int showMovies;

    public MovieManager(int showMovies) {
        this.showMovies = showMovies;
    }

//    public Movie[] getRepository() {
//        Movie[] moviesInRepository = repository.findAll();
//        return moviesInRepository;
//    }

    public void setRepository(MovieRepository repository) {
        this.repository = repository;
    }

    public int getShowMovies() {
        return showMovies;
    }

    public void setShowMovies(int showMovies) {
        this.showMovies = showMovies;
    }

    public void addMovie(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getMoviesForFeed() {
        Movie[] movies = repository.findAll();
        int moviesCount = movies.length;
        if (moviesCount <= 0) {
            return null;
        }
        if (moviesCount > showMovies) {
            Movie[] result = new Movie[showMovies];
            for (int i = 0; i < result.length; i++) {
                int index = result.length - i - 1;
                result[i] = movies[index];
            }
            return result;
        }

        Movie[] result = new Movie[repository.findAll().length];
        for (int i = 0; i < result.length; i++) {
            int index = result.length - i - 1;
            result[i] = movies[index];
        }
        return result;

    }
}


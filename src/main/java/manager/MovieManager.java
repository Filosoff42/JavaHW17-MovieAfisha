package manager;

import domain.Movie;
import lombok.NoArgsConstructor;


@NoArgsConstructor

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int showMovies;

    public MovieManager(int showMovies) {
        this.showMovies = showMovies;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }

    public int getShowMovies() {
        return showMovies;
    }

    public void setShowMovies(int showMovies) {
        this.showMovies = showMovies;
    }

    public void addMovie(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getMoviesForFeed() {
        int moviesCount = getMovies().length;
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

        Movie[] result = new Movie[getMovies().length];
        for (int i = 0; i < result.length; i++) {
            int index = result.length - i - 1;
            result[i] = movies[index];
        }
        return result;

    }
}


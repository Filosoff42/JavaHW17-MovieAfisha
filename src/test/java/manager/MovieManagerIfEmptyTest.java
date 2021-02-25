package manager;

import domain.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerIfEmptyTest {

    private MovieManager manager = new MovieManager(10);
    private Movie first = new Movie(1, "url1", "First Movie", "action");

    @Test
    void shouldAddMovie() {
        manager.addMovie(first);
        Movie[] actual = manager.getMovies();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetMoviesForFeed() {
        Movie[] actual = manager.getMoviesForFeed();
        Movie[] expected = null;
        assertArrayEquals(expected, actual);
    }

}
package manager;

import domain.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerIfNotEmptyTest {

    private MovieManager manager = new MovieManager(10);
    private Movie first = new Movie(1, "url1", "First Movie", "action");
    private Movie second = new Movie(2, "url2", "Second Movie", "horror");
    private Movie third = new Movie(3, "url3", "Third Movie", "comedy");
    private Movie fourth = new Movie(4, "url4", "Fourth Movie", "documentary");

    @BeforeEach
    public void setUp() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
    }

    @Test
    void shouldAddMovie() {
        manager.addMovie(fourth);
        Movie[] actual = manager.getMovies();
        Movie[] expected = new Movie[]{first, second, third, fourth};
        assertArrayEquals(expected, actual);
        }

    @Test
    void shouldGetMoviesForFeed() {
        Movie[] actual = manager.getMoviesForFeed();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(expected, actual);
    }

}
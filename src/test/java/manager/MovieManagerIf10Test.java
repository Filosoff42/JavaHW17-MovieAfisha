package manager;

import domain.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MovieManagerIf10Test {

    private MovieManager manager = new MovieManager(10);
    private Movie first = new Movie(1, "url1", "First Movie", "action");
    private Movie second = new Movie(2, "url2", "Second Movie", "horror");
    private Movie third = new Movie(3, "url3", "Third Movie", "comedy");
    private Movie fourth = new Movie(4, "url4", "Fourth Movie", "documentary");
    private Movie fifth = new Movie(5, "url5", "Fifth Movie", "action");
    private Movie sixth = new Movie(6, "url6", "Sixth Movie", "horror");
    private Movie seventh = new Movie(7, "url7", "Seventh Movie", "comedy");
    private Movie eighth = new Movie(8, "url8", "Eighth Movie", "documentary");
    private Movie ninth = new Movie(9, "url9", "Ninth Movie", "action");
    private Movie tenth = new Movie(10, "url10", "Tenth Movie", "horror");
    private Movie eleventh = new Movie(11, "url11", "Eleventh Movie", "comedy");

    @BeforeEach
    public void setUp() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
    }

    @Test
    void shouldAddMovie() {
        manager.addMovie(eleventh);
        Movie[] actual = manager.getMovies();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getMoviesForFeed() {
        manager.addMovie(eleventh);
        Movie[] actual = manager.getMoviesForFeed();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

}
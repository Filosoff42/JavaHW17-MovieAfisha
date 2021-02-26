package repository;

import domain.Movie;
import manager.MovieManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    private MovieRepository movies = new MovieRepository();
    private Movie first = new Movie(1, "url1", "First Movie", "action");
    private Movie second = new Movie(2, "url2", "Second Movie", "horror");
    private Movie third = new Movie(3, "url3", "Third Movie", "comedy");
    private Movie fourth = new Movie(4, "url4", "Fourth Movie", "documentary");

    @BeforeEach
    public void setUp() {
        movies.save(first);
        movies.save(second);
        movies.save(third);
    }

    @Test
    void shouldSave() {
        movies.save(fourth);
        Movie[] actual = movies.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Movie actual = movies.findById(2);
        Movie expected = second;
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        movies.removeById(2);
        Movie[] actual = movies.findAll();
        Movie[] expected = new Movie[]{first, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        movies.removeAll();
        Movie[] actual = movies.findAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }
}
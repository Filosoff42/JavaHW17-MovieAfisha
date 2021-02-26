package manager;

import domain.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieManagerIfEmptyTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager = new MovieManager(10);

    private Movie first = new Movie(1, "url1", "First Movie", "action");

    @Test
    void shouldAddMovie() {
        Movie[] returned = new Movie[0];
        doReturn(returned).when(repository).findAll();
        manager.addMovie(first);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetMoviesForFeed() {
        Movie[] returned = new Movie[0];
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getMoviesForFeed();
        Movie[] expected = null;
        assertArrayEquals(expected, actual);
    }

}
package manager;

import domain.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MovieManagerIfNotEmptyTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager = new MovieManager(10);

    private Movie first = new Movie(1, "url1", "First Movie", "action");
    private Movie second = new Movie(2, "url2", "Second Movie", "horror");
    private Movie third = new Movie(3, "url3", "Third Movie", "comedy");
    private Movie fourth = new Movie(4, "url4", "Fourth Movie", "documentary");

//    @BeforeEach
//    public void setUp() {
//        manager.addMovie(first);
//        manager.addMovie(second);
//        manager.addMovie(third);
//    }

    @Test
    void shouldAddMovie() {
        Movie[] returned = new Movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        manager.addMovie(fourth);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetMoviesForFeed() {
        Movie[] returned = new Movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getMoviesForFeed();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(expected, actual);
    }

}
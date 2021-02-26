package repository;

import domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class MovieRepository {
    private Movie[] movies = new Movie[0];


    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie findById(int id) {
        int i = 0;
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movies[i];
            }
            i++;
        }
        return null;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int i = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[i] = movie;
                i++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        movies = new Movie[0];
    }
}
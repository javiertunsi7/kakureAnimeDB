

import controller.MovieController;
import repository.MovieRepositoryImpl;
import view.MovieView;

public class Main {
    public static void main(String[] args) {

        MovieRepositoryImpl movieRepository = new MovieRepositoryImpl();
        MovieController movieController = new MovieController(movieRepository);
        MovieView movieView = new MovieView(movieController);

        // Create: pide datos por scanner e inserta en la BD
        movieView.CreateMovieView();

        // Read: lee todas las películas de la BD y las imprime
        movieView.showMovies();
    }
}
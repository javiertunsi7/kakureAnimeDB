package view;

import controller.MovieController;
import model.Movies;

import java.util.List;
import java.util.Scanner;

public class MovieView {

    private MovieController movieController;

    public MovieView(MovieController movieController) {
        this.movieController = movieController;
    }

    public void CreateMovieView() {
        Movies movie = generateMovie();
        movieController.createMovieController(movie);
    }

    public Movies generateMovie() {
        Scanner scanner = new Scanner(System.in).useLocale(java.util.Locale.US);

        System.out.println("Escribe el título de la película: ");
        String title = scanner.nextLine();

        System.out.println("Escribe el año (ej: 2023): ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Escribe la duración (minutos): ");
        float duration = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Escribe el género: ");
        String genre = scanner.nextLine();

        System.out.println("Escribe el estudio: ");
        String studio = scanner.nextLine();

        System.out.println("Escribe la puntuación (ej: 8.6): ");
        float rating = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Escribe la URL del póster: ");
        String poster = scanner.nextLine();

        System.out.println("Escribe la sinopsis: ");
        String synopsis = scanner.nextLine();

        return new Movies(title, year, duration, genre, studio, rating, poster, synopsis);
    }

    public void showMovies() {
        List<Movies> movieList = movieController.findAllController();

        for (Movies movie : movieList) {
            System.out.println("Título: " + movie.getTitle()
                    + " | Año: " + movie.getYear()
                    + " | Género: " + movie.getGenre()
                    + " | Estudio: " + movie.getStudio()
                    + " | Puntuación: " + movie.getRating());
        }
    }
}
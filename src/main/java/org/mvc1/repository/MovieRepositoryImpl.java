package repository;

import config.DBManager;
import model.Movies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieRepositoryImpl {

    private Connection connection;

    public void createMovie(Movies movie) {
        String query = "INSERT INTO movies(title, year, duration, genre, studio, rating, poster, synopsis) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = DBManager.initConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, movie.getTitle());
            statement.setInt(2, movie.getYear());
            statement.setFloat(3, movie.getDuration());
            statement.setString(4, movie.getGenre());
            statement.setString(5, movie.getStudio());
            statement.setFloat(6, movie.getRating());
            statement.setString(7, movie.getPoster());
            statement.setString(8, movie.getSynopsis());
            statement.execute();
            System.out.println("Película creada con éxito");
        } catch (Exception e) {
            System.out.println("Error al crear película: " + e.getMessage());
        } finally {
            DBManager.closeConnection();
        }
    }

    public List<Movies> findAll() {
        List<Movies> movieList = new ArrayList<>();
        String query = "SELECT * FROM movies";

        try {
            connection = DBManager.initConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String title    = rs.getString("title");
                int year        = rs.getInt("year");
                float duration  = rs.getFloat("duration");
                String genre    = rs.getString("genre");
                String studio   = rs.getString("studio");
                float rating    = rs.getFloat("rating");
                String poster   = rs.getString("poster");
                String synopsis = rs.getString("synopsis");

                Movies movie = new Movies(title, year, duration, genre, studio, rating, poster, synopsis);
                movieList.add(movie);
            }
        } catch (Exception e) {
            System.out.println("Error al leer películas: " + e.getMessage());
        } finally {
            DBManager.closeConnection();
        }

        return movieList;
    }
}
package com.moviefy.backend.Database;

import com.moviefy.backend.movie.Movie;

import java.sql.*;

public class DatabaseExample {
    public static void showMovie() {
        Connection connection = null;
        try {
            Statement statement = connectToTheDatabase();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM movie");
            // Pobieramy i wyświetlamy wyniki
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("title") +
                        " " + resultSet.getInt("rating"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void addMovie(Movie movie) {
        Connection connection = null;
        try {
            Statement statement = connectToTheDatabase();
            statement.executeUpdate("INSERT INTO movie(title, rating, direction, scenario, genre, production, premiere, poster, moviePhotos, awards) VALUES " +
                    "('" + movie.getTitle() + "', " + movie.getRating() + ", '" + movie.getDirection() + "', '" + movie.getScenario() + "', '" + movie.getGenre() + "', '" + movie.getProduction() + "', '" + movie.getPremiere() + "', '" + movie.getPoster() + "', '" + movie.getMoviePhotos() + "', '" + movie.getAwards() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Zamykamy połączenie
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void findMovieById(int id) {
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            Statement statement = connectToTheDatabase();
            resultSet = statement.executeQuery("SELECT * FROM movie");
            while (resultSet.next()) {
                if (resultSet.getInt("id") == id) {
                    System.out.println(resultSet.getInt("id") + " " + resultSet.getString("title") +
                            " " + resultSet.getInt("rating"));
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void findMovieByTitle(String title) {
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            Statement statement = connectToTheDatabase();
            resultSet = statement.executeQuery("SELECT * FROM movie");
            while (resultSet.next()) {
                if (resultSet.getString("title").equals(title)) {
                    System.out.println(resultSet.getInt("id") + " " + resultSet.getString("title") +
                            " " + resultSet.getInt("rating"));
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static Statement connectToTheDatabase() {
        try {
            Connection connection = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/baza", "root", "root");
            return connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


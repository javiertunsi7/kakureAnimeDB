package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:3306/karureanime_app";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private static Connection connection;

    public static Connection initConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión BBDD exitosa");
        } catch (SQLException e) {
            System.out.println("Conexión fallida: " + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada con éxito");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la BBDD: " + e.getMessage());
        }
    }
}
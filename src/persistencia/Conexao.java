/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao { 
    private static final String URL = "jdbc:mysql://localhost/BatalhaNaval";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static int cadastrarConta(String usuario, String senha) {
        String query = "INSERT INTO jogador (usuario,senha) VALUES (?,?)";
        System.out.println(query);
        int rs = 0;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            rs = stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
    
    
    public static boolean validarLogin(String usuario, String senha) {
        String query = "SELECT usuario,senha FROM jogador WHERE usuario = ? AND senha = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    
       
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Connector;

public class ControllerLogin {

    public boolean authenticate(String username, String password) {
       
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            
            connection = Connector.Connect();

            
            String query = "SELECT * FROM mahasiswa WHERE nama = ? AND password = ?";

            
            statement = connection.prepareStatement(query);

            
            statement.setString(1, username);
            statement.setString(2, password);

           
            ResultSet resultSet = statement.executeQuery();

           
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
          
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                 e.printStackTrace();
            }
        }

        return false;
    }
}
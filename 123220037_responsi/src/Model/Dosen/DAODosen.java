/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dosen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Connector;


public class DAODosen implements InterfaceDAODosen {

    public void insert(ModelDosen dosen) {
       try {
 
            String query = "INSERT INTO dosen (nama, no_hp, email) VALUES (?, ?);";
           
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNohp());
            statement.setString(2, dosen.getEmail());
            
            statement.executeUpdate();
           
            statement.close();
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        } 
    }

    public void update(ModelDosen dosen) {
        try {
            
            String query = "UPDATE dosen SET nama=?, no_hp=? email=? WHERE id=?;";
      
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNohp());
            statement.setString(3, dosen.getEmail());
            statement.setInt(4, dosen.getId());
            
            statement.executeUpdate();
        
            statement.close();
        } catch (SQLException e) {
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    public void delete(int id) {
        try {
           
            String query = "DELETE FROM dosen WHERE id=?;";
      
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            
          
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    public List<ModelDosen> getAll() {
         List<ModelDosen> listDosen = null;

        try {
      
            listDosen = new ArrayList<>();
            
            // Membuat objek statement yang digunakan untuk melakukan query.
            Statement statement = Connector.Connect().createStatement();

            String query = "SELECT * FROM dosen;";
            
            ResultSet resultSet = statement.executeQuery(query);
  
            while (resultSet.next()) {
           
                ModelDosen dsn = new ModelDosen();

                dsn.setId(resultSet.getInt("id"));
                dsn.setNama(resultSet.getString("nama"));
                dsn.setNohp(resultSet.getString("nohp"));
                dsn.setEmail(resultSet.getString("email"));
             
                listDosen.add(dsn);
            }
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal mengambil data.
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listDosen;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.ControllerLogin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener{
    JLabel tulisan1 = new JLabel("Selamat Datang !");
    
    JLabel tulisan2 = new JLabel("Silahkan masuk untuk melanjutkan.");
    
    JLabel labelinput1 = new JLabel("Username");

    JTextField Inputuser = new JTextField();    
    
    
    JLabel labelpassword = new JLabel("Password");
    JTextField inputpassword = new JTextField(); 
   
    
    JButton login1 = new JButton("Login");
    
    
    
    public LoginPage(){
        setVisible(true);
        setSize(720,480);
        setResizable(false);
        
        
        setTitle("Login Page");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        
        add(tulisan1);
        tulisan1.setHorizontalAlignment(JLabel.CENTER);
        tulisan1.setBounds(100, 10, 500, 30);
        tulisan1.setFont(new Font("Arial", Font.BOLD, 25));
        
        
        add(tulisan2);
        tulisan2.setBounds(5, 50, 300, 20);
        tulisan2.setFont(new Font("Arial", Font.BOLD, 15));
        
        add(labelinput1);
        labelinput1.setBounds(5,110 ,200,20);
        labelinput1.setFont(new Font("Arial", Font.BOLD, 15));
        
        add(Inputuser);
        Inputuser.setBounds(4,130,690,35);
        
        add(labelpassword);
        labelpassword.setFont(new Font("Sans", Font.BOLD,15));
        labelpassword.setBounds(4,180,200,25);
        
        add(inputpassword);
        inputpassword.setBounds(4,200,690,35);
        
        
        add(login1);
        login1.setBounds(10,320,680,35);
        login1.setBackground(Color.white);
        login1.setFont(new Font("Arial", Font.BOLD, 15));
        login1.addActionListener(this);
    }
        @Override
        public void actionPerformed(ActionEvent e) {
    try {
        // Mengambil nilai dari username dan password
        String username = Inputuser.getText();
        String password = inputpassword.getText();

        // Memberikan error handling jika username atau password kosong
        if (username.isEmpty()) {
            throw new Exception("Username tidak boleh kosong");
        }
        if (password.isEmpty()) {
            throw new Exception("Password tidak boleh kosong");
        }

        // Memeriksa autentikasi menggunakan ControllerLogin
        ControllerLogin controller = new ControllerLogin();
        boolean isAuthenticated = controller.authenticate(username, password);

        // Jika autentikasi berhasil, lakukan tindakan selanjutnya
        if (isAuthenticated) {
            JOptionPane.showMessageDialog(this, "Login berhasil");
            
            new halamanAwal();
            this.dispose();
            
            // Lakukan tindakan setelah login berhasil di sini
        } else {
            throw new Exception("Username atau password salah");
        }
    } catch (Exception error) {
        // Menampilkan error dalam bentuk pop up
        JOptionPane.showMessageDialog(this, error.getMessage());
    }
  }
}
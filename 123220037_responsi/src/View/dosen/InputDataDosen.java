
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.dosen;

import Controller.ControllerDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputDataDosen extends JFrame {

    ControllerDosen controller;
    
    JLabel header = new JLabel("Input Dosen");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNohp = new JLabel("Nohp");
    JLabel labelInputEmail = new JLabel("Email"); 
    JTextField inputNama = new JTextField();
    JTextField inputNohp = new JTextField();
    JTextField inputEmail = new JTextField();
    JButton tombolTambah = new JButton("Tambah Dosen");
    JButton tombolKembali = new JButton("Kembali");

    public InputDataDosen() {
        setTitle("Input Dosen");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(480, 480);

        add(header);
        add(labelInputNama);
        add(labelInputNohp);
        add(labelInputEmail);
        add(inputNama);
        add(inputNohp);
        add(inputEmail);
        add(tombolTambah);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputNohp.setBounds(20, 96, 440, 24);
        inputNohp.setBounds(18, 120, 440, 36);
        labelInputEmail.setBounds(20, 160, 440, 24); 
        inputEmail.setBounds(18, 184, 440, 36); 
        tombolKembali.setBounds(20, 240, 215, 40);
        tombolTambah.setBounds(240, 240, 215, 40);
        
        controller = new ControllerDosen(this);

   
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               
                new ViewDataDosen();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.insertDosen();
                } catch (Exception ex) {
                    Logger.getLogger(InputDataDosen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    

    public String getInputNama() {
        return inputNama.getText();
    }
    
    public String getInputNohp() {
        return inputNohp.getText();
    }
     public String getInputEmail() {
        return inputEmail.getText();
    }
}
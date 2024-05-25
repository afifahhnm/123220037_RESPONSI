/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import View.dosen.ViewDataDosen;
import View.mahasiswa.ViewData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class halamanAwal extends JFrame implements ActionListener {
    JLabel header = new JLabel (" Halo, Selamat datang " );
    JLabel teks = new JLabel (" Silahkan pilih data yang ingin anda lihat ");
    JButton mhs = new JButton (" Data Mahasiswa ");
    JButton dsn = new JButton (" Data Dosen ");
    JButton keluar = new JButton("Keluar");

    public halamanAwal (){
        setTitle(" Halaman Utama ");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(600, 400);
        
        add(header);
        add(teks);
        add(mhs);
        add(dsn);
        add(keluar);
        
        header.setBounds(220, 40, 200, 30);
        teks.setBounds(170, 80, 500, 40);
        mhs.setBounds(30, 180, 220, 50);
        dsn.setBounds(285, 180, 220, 50);
        keluar.setBounds(200, 280, 200, 40);
    
        mhs.addActionListener(this);
        dsn.addActionListener(this);
        keluar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== mhs){
            new ViewData();
        }
        
        if(e.getSource()== dsn){
            new ViewDataDosen();
        }
        
        if(e.getSource() == keluar){
            System.exit(0);
        }
       
        this.dispose();
    }
}
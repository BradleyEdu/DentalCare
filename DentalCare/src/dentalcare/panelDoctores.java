package dentalcare;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class panelDoctores extends JPanel{
    JLabel lbDoctor=new JLabel("Doctor:");
    JLabel lbPaciente=new JLabel("Pacienetes:");
    JLabel lbTratamiento=new JLabel("Tratamiento:");
    JLabel lbCobro=new JLabel("Cobro: $");
    JLabel lbGanancias=new JLabel("Ganancias: $");
    
    public panelDoctores(){
        this.setSize(900,500);
        this.setLayout(null);
        JTabbedPane pestañas=new JTabbedPane();
        
        JPanel pnl1=new JPanel();
        JPanel pnl2=new JPanel();
        JPanel pnl3=new JPanel();        
        lbDoctor.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
        lbPaciente.setFont(new Font("Arial", Font.PLAIN, 20));
        lbTratamiento.setFont(new Font("Arial", Font.PLAIN, 20));
        lbCobro.setFont(new Font("Arial", Font.PLAIN, 20));
        
        lbDoctor.setBounds(50,20,150,30);
        lbPaciente.setBounds(50,75,250,25);
        lbTratamiento.setBounds(150,75,150,25);
        lbCobro.setBounds(250,75,250,25);
        lbGanancias.setBounds(50,400,200,25);
        pnl1.add(lbDoctor);
        pnl1.add(lbPaciente);
        pnl1.add(lbTratamiento);
        pnl1.add(lbCobro);
        pnl1.add(lbGanancias);
        
        pestañas.addTab("Ortodoncista",pnl1);
        pestañas.addTab("Maxilofacial", pnl2);
        pestañas.addTab("Endodoncista", pnl3);
        
        pestañas.setBounds(10,20,850,500);
        this.add(pestañas);
    }
    
}

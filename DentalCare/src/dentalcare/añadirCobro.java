package dentalcare;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class añadirCobro extends JFrame implements ActionListener{
    JLabel lbID=new JLabel();
    JLabel lbEspecialista=new JLabel("Especialista:");
    String[] espe={"-Seleccione-","Ortodonsista","Maxilofacial","Endodoncista"};
    JComboBox comEspe=new JComboBox(espe);
    JLabel lbTrabajo=new JLabel("Trabajo Realizado:");
    JTextArea txtaTrabajo=new JTextArea();
    JLabel lbCobro=new JLabel("Cobro:  $");
    JTextField txtCobro=new JTextField();
    JButton btnAñadir=new JButton("Añadir");
    JButton btnCancelar=new JButton("Cancelar");
    
    public añadirCobro(Paciente p){
        super("Añadir Cobro-SistemaDePagos");
        setSize(400,450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        
        JPanel pnl=new JPanel();
        pnl.setLayout(null);
        
        lbID.setFont(new Font("Arial", Font.PLAIN, 20));
        lbID.setText(p.DNI);
        lbEspecialista.setFont(new Font("Arial", Font.PLAIN, 15));
        lbTrabajo.setFont(new Font("Arial", Font.PLAIN, 15));
        lbCobro.setFont(new Font("Arial", Font.PLAIN, 15));
        lbID.setBounds(30,20,100,25);
        lbEspecialista.setBounds(30,60,100,25);
        comEspe.setBounds(30,90,150,25);
        lbTrabajo.setBounds(30,120,300,25);
        txtaTrabajo.setBounds(30,150,300,100);
        lbCobro.setBounds(30,260,100,25);
        txtCobro.setBounds(100,260,150,25);
        btnAñadir.setBounds(40,340,125,25);
        btnCancelar.setBounds(215,340,125,25);
        
        btnAñadir.addActionListener(this);
        btnCancelar.addActionListener(this);
        
        txtaTrabajo.setLineWrap(true);
        comEspe.setEditable(true);
        
        pnl.add(lbID);
        pnl.add(lbEspecialista);
        pnl.add(comEspe);
        pnl.add(lbTrabajo);
        pnl.add(txtaTrabajo);
        pnl.add(lbCobro);
        pnl.add(txtCobro);
        pnl.add(btnAñadir);
        pnl.add(btnCancelar);
        
        setContentPane(pnl);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ev){
        //Devuelve una referencia al objeto donde se generó el evento
        Object obj = ev.getSource();
        if(obj instanceof JButton){
            if(obj == btnAñadir){
                int respuesta;
        
                respuesta=JOptionPane.showConfirmDialog(null, 
                "Se añadira un cobro al Paciente.\n"
               +"                          Desea Continuar?",
                "ADVERTENCIA",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
                
                if(respuesta==0){
                    try {
                        añadirCobros();
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(añadirCobro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "El cobro se hizo exitosamente");
                    dispose();
                }
            }else if(obj == btnCancelar){
                int respuesta;
        
                respuesta=JOptionPane.showConfirmDialog(null, 
                "El cobro no sera añadido.\n"
               +"                          Desea Continuar?",
                "ADVERTENCIA",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
                
                if(respuesta==0){
                    dispose();
                }
            }
        }
    }
    
    public void añadirCobros() throws IOException, ClassNotFoundException{
        
        int pago;
        ArchivoClientes ag = new ArchivoClientes();
        Paciente p=new Paciente();
        p=ag.recuperar(lbID.getText());
        
        p.Doctor += (String)comEspe.getSelectedItem()+"\n\n";
        p.Trabajo += txtaTrabajo.getText()+"\n\n";
        p.Costo += txtCobro.getText()+"\n\n$";
        pago = Integer.parseInt(txtCobro.getText());
        p.pago+=pago;
        ag.guardar();
    
    }
    
    public void añadirDoctor(Paciente p) throws IOException, ClassNotFoundException{
        try {
            ArchivoDoctor Ad=new ArchivoDoctor();
            int pago;
            if(comEspe.getSelectedItem().equals("Ortodonsista")){
                Doctor d=new Doctor();
                d.Paciente += p.Nombre+" "+p.ApellidoP+" "+p.ApellidoM+"\n\n";
                d.Tratamiento += txtaTrabajo.getText()+"\n\n";
                d.Cobro += txtCobro.getText()+"\n\n$";
                pago = Integer.parseInt(txtCobro.getText());
                d.Total += pago;
                Ad.agregar("OR", d);
            }else if(comEspe.getSelectedItem().equals("Maxilofacial")){
                int a=0;
                Doctor d=new Doctor(a);
                d.Paciente += p.Nombre+" "+p.ApellidoP+" "+p.ApellidoM+"\n\n";
                d.Tratamiento += txtaTrabajo.getText()+"\n\n";
                d.Cobro += txtCobro.getText()+"\n\n$";
                pago = Integer.parseInt(txtCobro.getText());
                d.Total += pago;
                Ad.agregar("MA", d);
            }else if(comEspe.getSelectedItem().equals("Endodoncista")){
                String a="";
                Doctor d=new Doctor(a);
                d.Paciente += p.Nombre+" "+p.ApellidoP+" "+p.ApellidoM+"\n\n";
                d.Tratamiento += txtaTrabajo.getText()+"\n\n";
                d.Cobro += txtCobro.getText()+"\n\n$";
                pago = Integer.parseInt(txtCobro.getText());
                d.Total += pago;
                Ad.agregar("EN", d);
            }
            Ad.guardar();
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(añadirCobro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}

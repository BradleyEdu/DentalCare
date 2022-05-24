package dentalcare;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModificarCita extends JFrame implements ActionListener {
    JLabel lbDNI=new JLabel("DNI del Paciente");
    JLabel lbDNI1=new JLabel();
    JLabel lbDia=new JLabel("Día:");
    JLabel lbMes=new JLabel("Mes:");
    JLabel lbAño=new JLabel("Año:");
    JLabel lbHora=new JLabel("Hora:");
    JLabel lbEspecialista=new JLabel("Especialista:");
    JLabel lbTrabajo=new JLabel("Trabajo a realizar:");
    
    JTextField txtDni=new JTextField();
    JTextArea TxtComents=new JTextArea();
    
    String[] dia={"-Seleccione-","1","2","3","4","5","6","7","8","9","10",
        "11","12","13","14","15","16","17","18","19","20","21","22","23",
        "24","25","26","27","28","29","30","31"};
    String[] mes={"-Seleccione-","1","2","3","4","5","6","7","8","9"
    ,"10","11","12"};
    String[] año={"-Seleccione-","2020","2021","2022","2023"};
    String[] hora={"-Seleccione-","09:00","10:00","11:00","12:00","13:00","14:00","16:00","17:00","18:00","19:00","20:00","21:00"};
    String[] espe={"-Seleccione-","Ortodonsista","Maxilofacial","Endodoncista"};
    JComboBox comDia = new JComboBox(dia);
    JComboBox comMes = new JComboBox(mes);
    JComboBox comAño = new JComboBox(año);
    JComboBox comHora=new JComboBox(hora);
    JComboBox comEspe=new JComboBox(espe);
    
    
    JButton btnModificar=new JButton("Modificar");
    JButton btnEliminar=new JButton("Eliminar");
    JButton btnRegresar=new JButton("Regresar");
    
    public ModificarCita(Cita c){
        super("Citas-Nueva Cita");
        setSize(410,450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        
        JPanel pnl=new JPanel();
        pnl.setLayout(null);
        
        seleccionarCombo(c);
        
        comDia.setEditable(true);
        comMes.setEditable(true);
        comAño.setEditable(true);
        comHora.setEditable(true);
        comEspe.setEditable(true);

        lbDNI.setBounds(20,10,300,25);
        
        lbDNI1.setText(c.N);
        lbDNI1.setBounds(20,40,300,25);
        
        lbDia.setBounds(20,80,100,25);
        comDia.setBounds(20,110,100,25);
        lbMes.setBounds(145,80,100,25);
        comMes.setBounds(145,110,100,25);
        lbAño.setBounds(270,80,100,25);
        comAño .setBounds(270,110,100,25);
        lbHora.setBounds(30,150,200,25);
        comHora .setBounds(30,180,200,25);
        lbEspecialista.setBounds(30,210,200,25);
        comEspe.setBounds(30,240,200,25);
        btnRegresar.setBounds(260,290,100,25);
        
        btnModificar.setBounds(75,350,100,25);
        btnEliminar.setBounds(225,350,100,25);
        
        btnModificar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnRegresar.addActionListener(this);
        
        pnl.add(lbDNI);
        pnl.add(lbDNI1);
        pnl.add(btnRegresar);
        pnl.add(lbDia);
        pnl.add(lbMes);
        pnl.add(lbAño);
        pnl.add(lbEspecialista);
        pnl.add(comDia);
        pnl.add(comMes);
        pnl.add(comAño);
        pnl.add(lbHora);
        pnl.add(comHora);
        pnl.add(comEspe);
        pnl.add(btnModificar);
        pnl.add(btnRegresar);
        
        setContentPane(pnl);
        this.setVisible(true);
        
    }
    
    public void seleccionarCombo(Cita c){
        for(int i=0;i<dia.length;i++){
            if(c.Cdia.equals(comDia.getItemAt(i))){
                comDia.setSelectedIndex(i);
            }
        }
        for(int i=0;i<mes.length;i++){
            if(c.Cmes.equals(comMes.getItemAt(i))){
                comMes.setSelectedIndex(i);
            }
        }
        for(int i=0;i<año.length;i++){
            if(c.Caño.equals(comAño.getItemAt(i))){
                comAño.setSelectedIndex(i);
            }
        }
        for(int i=0;i<hora.length;i++){
            if(c.Chora.equals(comHora.getItemAt(i))){
                comHora.setSelectedIndex(i);
            }
        }
        for(int i=0;i<espe.length;i++){
            if(c.Especial.equals(comEspe.getItemAt(i))){
                comEspe.setSelectedIndex(i);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ev){
        //Devuelve una referencia al objeto donde se generó el evento
        Object obj = ev.getSource();
        
        if (obj instanceof JButton){

            if (obj == btnModificar){
                try {
                    int respuesta;
        
                    respuesta=JOptionPane.showConfirmDialog(null, 
                    "Advertencia se modificaran los datos de la cita.\n"
                   +"                          Desea Continuar?",
                    "ADVERTENCIA",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

                    if(respuesta==0){
                        ArchivoCitas ac=new ArchivoCitas();
                        Cita c=new Cita();
                        c=ac.recuperar(lbDNI1.getText());
                        c.Cdia=(String)comDia.getSelectedItem();
                        c.Cmes=(String)comMes.getSelectedItem();
                        c.Caño=(String)comAño.getSelectedItem();
                        c.Chora=(String)comHora.getSelectedItem();
                        c.Especial=(String)comEspe.getSelectedItem();

                        ac.agregar(c.N, c);
                        ac.guardar();
                        JOptionPane.showMessageDialog(null,"Se agendo con Exito la Cita");
                        this.setVisible(false);
                        PagPrincipal pagMod=new PagPrincipal();
                        dispose();
                    }   
                } catch (IOException ex) {
                    Logger.getLogger(NuevaCita.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NuevaCita.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else if(obj == btnEliminar){
                int respuesta;
        
                respuesta=JOptionPane.showConfirmDialog(null, 
                "Advertencia se eliminara la cita del sistema.\n"
               +"                          Desea Continuar?",
                "ADVERTENCIA",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
                
                if(respuesta==0){
                    try {
                        ArchivoCitas ac=new ArchivoCitas();
                        ac.eliminar(lbDNI1.getText());                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(ModificarCliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ModificarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                
            }else if(obj == btnRegresar){
                int respuesta;
        
                respuesta=JOptionPane.showConfirmDialog(null, 
                "Advertencia NO se aplicaran los cambios realizados.\n"
               +"                          Desea Continuar?",
                "ADVERTENCIA",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
                
                if(respuesta==0){
                    dispose();
                }
            }
        }
        repaint();//Dibuja nuevamente el contenido gráfico de la ventana
    }
    
}

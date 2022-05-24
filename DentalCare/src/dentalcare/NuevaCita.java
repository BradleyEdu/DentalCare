package dentalcare;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NuevaCita extends JFrame implements ActionListener{
    JLabel lbBuscar=new JLabel("No sabes tu DNI?");
    JLabel lbDNI=new JLabel("DNI del Paciente");
    JLabel lbDia=new JLabel("Día:");
    JLabel lbMes=new JLabel("Mes:");
    JLabel lbAño=new JLabel("Año:");
    JLabel lbHora=new JLabel("Hora:");
    JLabel lbEspecialista=new JLabel("Especialista:");
    JLabel lbTrabajo=new JLabel("Trabajo a realizar:");
    
    JTextField txtNombre=new JTextField();
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
    
    
    JButton btnGuardar=new JButton("Guardar");
    JButton btnCancelar=new JButton("Cancelar");
    JButton btnBusc=new JButton("Buscar");
    
    public NuevaCita(){
        super("Citas-Nueva Cita");
        setSize(410,450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        
        JPanel pnl=new JPanel();
        pnl.setLayout(null);
        pnl.setBackground(Color.pink);
        
        comDia.setEditable(true);
        comMes.setEditable(true);
        comAño.setEditable(true);
        comHora.setEditable(true);
        comEspe.setEditable(true);
        
        lbDNI.setBounds(20,10,300,25);
        txtDni.setBounds(20,40,300,25);
        
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
        lbBuscar.setBounds(145,290,200,25);
        btnBusc.setBounds(260,290,100,25);
        
        btnGuardar.setBounds(75,350,100,25);
        btnCancelar.setBounds(225,350,100,25);
        
        btnGuardar.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnBusc.addActionListener(this);
        
        pnl.add(lbDNI);
        pnl.add(txtDni);
        pnl.add(lbBuscar);
        pnl.add(btnBusc);
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
        //pnl.add(lbTrabajo);
        //pnl.add(TxtComents);
        pnl.add(btnGuardar);
        pnl.add(btnCancelar);
        
        setContentPane(pnl);
        this.setVisible(true);
        
    }
    
     @Override
    public void actionPerformed(ActionEvent ev){
        //Devuelve una referencia al objeto donde se generó el evento
        Object obj = ev.getSource();
        
        if (obj instanceof JButton){

            if (obj == btnGuardar){
                try {
                    Random r=new Random();
                    int n=r.nextInt(9000)+1000;
                    String primerL,d;
                    ArchivoClientes ag=new ArchivoClientes();
                    Paciente p=new Paciente();
                    p=ag.recuperar(txtDni.getText());
                    ArchivoCitas ac=new ArchivoCitas();
                    Cita c=new Cita();
                    primerL=p.Nombre.substring(0, 1);
                    c.N=Integer.toString(n)+primerL;
                    d=c.N;
                    c.Nombre=p.Nombre;
                    c.Apellido=p.ApellidoP;
                    c.ApellidoM=p.ApellidoM;
                    c.Cdia=(String)comDia.getSelectedItem();
                    c.Cmes=(String)comMes.getSelectedItem();
                    c.Caño=(String)comAño.getSelectedItem();
                    c.Chora=(String)comHora.getSelectedItem();
                    c.Especial=(String)comEspe.getSelectedItem();
                    
                    ac.agregar(d, c);
                    ac.guardar();
                    JOptionPane.showMessageDialog(null,"Se agendo con Exito la Cita");
                    this.setVisible(false);
                    PagPrincipal pagMod=new PagPrincipal();
                    dispose();
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(NuevaCita.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NuevaCita.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else if(obj == btnCancelar){
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
                
            }else if(obj == btnBusc){
                buscarDNI();
            }
        }
        repaint();//Dibuja nuevamente el contenido gráfico de la ventana
    }
    
    public void buscarDNI(){
        int clave=0;
        
        try {
            ArchivoClientes ag=new ArchivoClientes();
            Paciente p=new Paciente();
            Enumeration e=ag.total();
            String d,nom,ap,am,llave;
            nom=JOptionPane.showInputDialog("Nombre: ");
            ap=JOptionPane.showInputDialog("Apellido Paterno: ");
            am=JOptionPane.showInputDialog("Apellido Materno: ");
                        while(e.hasMoreElements()){
                            d=(String)e.nextElement();
                            p=ag.recuperar(d);
                            if((p.Nombre.equals(nom))&&(p.ApellidoP.equals(ap))&&(p.ApellidoM.equals(am))){
                                llave=p.DNI;
                                JOptionPane.showMessageDialog(null,"Tu DNI es: "+llave);
                                clave=1;
                            }
                        }

                        if(clave==0){
                             int respuesta;
        
                            respuesta=JOptionPane.showConfirmDialog(null, 
                            "No existe el Paciente.\nDesea Agregar Paciente?",
                            "No existe",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);

                            if(respuesta==0){
                                NuevoPaciente np=new NuevoPaciente();
                            }
                        }
            
        } catch (IOException ex) {
            Logger.getLogger(NuevaCita.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NuevaCita.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    public static void main(String[] args) {
        NuevaCita obj=new NuevaCita();
    }
    
}

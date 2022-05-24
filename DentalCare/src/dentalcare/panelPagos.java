package dentalcare;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 
import java.awt.event.*;
import java.io.*;
import java.util.Enumeration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


public class panelPagos extends JPanel implements ActionListener{
    JLabel lbPago=new JLabel("Sistemas de Pagos");
        ImageIcon imagenPago= new ImageIcon("C:\\Users\\bradl\\OneDrive\\Documentos\\NetBeansProjects\\DentalCare\\"
                + "src\\imag\\e928306ecfe83395ec9d65c8fe502226-monedas-bolsa-de-dinero-by-vexels.png");
        JLabel lbImagenPago= new JLabel(imagenPago);
                
        JLabel lbDNI=new JLabel("Ingrese DNI del Paciente:");
        JTextField txtDni=new JTextField();
        JButton btnBuscar=new JButton("Buscar");
       
        JButton btnAñadir=new JButton("Añadir Cobro");
        JButton btnAbonar=new JButton("Abonar");
        JButton btnLiquidar=new JButton("Liquidar ");
        JButton btnExpediente=new JButton("Expediente Pagos");
        JButton btnCerrar=new JButton("Cerrar");
        //Datos del Paciente
        JLabel lbID=new JLabel();
        JLabel lbNombre=new JLabel();
        JLabel lbEdad=new JLabel();
        JLabel lbTelefono=new JLabel();
        JLabel lbCuenta=new JLabel();
        
        //Titulos del expediente
        JLabel lbTitulos=new JLabel("Nombre:                          Doctor:                     "
                + "              Tratamiento:                            Costo:  $");
        JLabel lbeNombre=new JLabel();
        JTextArea lbeDoctor=new JTextArea();
        JTextArea lbeTrabajo=new JTextArea();
        JTextArea lbeCosto=new JTextArea();
                
        //Tabla de clientes
        String[] vector = new String[5];
        //Modelo de tabla para manipular el contenido
        DefaultTableModel dtm = new DefaultTableModel();
        
    public panelPagos(){
        this.setLayout(null);
        this.setBackground(Color.white);
        lbPago.setFont(new Font("Baskerville Old Face", Font.PLAIN, 40));
        lbPago.setBounds(280,20,300,50);
        lbImagenPago.setBounds(380,10,514,514);
        
        lbDNI.setFont(new Font("Arial", Font.PLAIN, 20));
        lbDNI.setBounds(47,110,250,25);
        txtDni.setBounds(50,145,200,25);
        btnBuscar.setBounds(130,180,100,25);
        
        lbID.setBounds(50,230,100,25);
        lbNombre.setBounds(50,260,250,25);
        lbEdad.setBounds(50,290,100,25);
        lbTelefono.setBounds(50,320,250,25);
        lbCuenta.setBounds(50,370,100,25);
        
        
        
        btnCerrar.setBounds(750,480,100,25);
        
        btnBuscar.addActionListener(this);
        btnAñadir.addActionListener(this);
        btnAbonar.addActionListener(this);
        btnLiquidar.addActionListener(this);
        btnExpediente.addActionListener(this);
        btnCerrar.addActionListener(this);
        
        btnCerrar.setVisible(false);
        
        this.add(lbPago);
        this.add(lbImagenPago);
        this.add(lbDNI);
        this.add(txtDni);
        this.add(btnBuscar);
        this.add(btnCerrar);
        
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e){
        Object obj=e.getSource();
        
        if(obj instanceof JButton){
            if(obj == btnBuscar){
                try {
                BuscarP();
                } catch (IOException ex) {
                    Logger.getLogger(panelPagos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelPagos.class.getName()).log(Level.SEVERE, null, ex);
                }catch(NullPointerException ex){
                    JOptionPane.showMessageDialog(null, "Ingre un DNI");
                } 
                
                lbTitulos.setVisible(false);
                lbeNombre.setVisible(false);
                lbeDoctor.setVisible(false);
                lbeTrabajo.setVisible(false);
                lbeCosto.setVisible(false);
                lbImagenPago.setVisible(true);
                
                repaint();
            }else if(obj == btnAñadir){
                try {
                    ArchivoClientes ag = new ArchivoClientes();
                    Paciente p=new Paciente();
                    p=ag.recuperar(txtDni.getText());
                    añadirCobro añC=new añadirCobro(p);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(panelPagos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else if(obj == btnAbonar){
                try {
                    ArchivoClientes ag = new ArchivoClientes();
                    Paciente p=new Paciente();
                    p=ag.recuperar(txtDni.getText());
                    Abonar añC=new Abonar(p);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(panelPagos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(obj == btnLiquidar){
                try {
                    Liquidar();
                } catch (IOException ex) {
                    Logger.getLogger(panelPagos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelPagos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(obj == btnExpediente){
                lbImagenPago.setVisible(false);
                try {
                    añadirExpediente();
                } catch (IOException ex) {
                    Logger.getLogger(panelPagos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelPagos.class.getName()).log(Level.SEVERE, null, ex);
                }
                lbTitulos.setVisible(true);
                lbeNombre.setVisible(true);
                lbeDoctor.setVisible(true);
                lbeTrabajo.setVisible(true);
                lbeCosto.setVisible(true);
                btnCerrar.setVisible(true);
                repaint();
                
            }else if(obj == btnCerrar){
                lbImagenPago.setVisible(true);
                
                lbTitulos.setVisible(false);
                lbeNombre.setVisible(false);
                lbeDoctor.setVisible(false);
                lbeTrabajo.setVisible(false);
                lbeCosto.setVisible(false);
                
                btnCerrar.setVisible(false);
            }
            
        }
    }
    
    public void BuscarP()throws IOException,ClassNotFoundException{
        ArchivoClientes ag=new ArchivoClientes();
        Paciente p=new Paciente();
        p=ag.recuperar(txtDni.getText());
        lbID.setText("ID: "+p.DNI);
        lbNombre.setText("Nombre: "+p.Nombre+" "+p.ApellidoP+" "+p.ApellidoM);
        lbEdad.setText("Edad: "+p.Edad);
        lbTelefono.setText("Telefono: "+p.Numero);
        lbCuenta.setText("Saldo:  $"+p.pago);
        
        this.add(lbID);
        this.add(lbNombre);
        this.add(lbEdad);
        this.add(lbTelefono);
        this.add(lbCuenta);
        
        añadirBotones();
    }
    
    public void añadirBotones(){
        btnAñadir.setBounds(170,370,130,25);
        btnAbonar.setBounds(50,420,110,25);
        btnLiquidar.setBounds(190,420,110,25);
        btnExpediente.setBounds(280,480,150,25);
        
        this.add(btnAñadir);
        this.add(btnAbonar);
        this.add(btnLiquidar);
        this.add(btnExpediente);
    }
    
    public void Liquidar() throws IOException, ClassNotFoundException{
        int respuesta;
        ArchivoClientes ag=new ArchivoClientes();
                    Paciente p=new Paciente();
                    p=ag.recuperar(txtDni.getText());
                respuesta=JOptionPane.showConfirmDialog(null, 
                "Esta apunto de Liquidar la cuenta de:\n"
               +p.Nombre+" "+p.ApellidoP+" "+p.ApellidoM+"\nCon un Adeudo de: $"+p.pago+"\nDesea Continuar?",
                "ADVERTENCIA",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
                
                if(respuesta==0){
                    p.pago=0;
                    ag.guardar();
                    JOptionPane.showMessageDialog(null, "Se ha liquidado la cuenta");
                }
    }
    
    public void añadirExpediente() throws IOException, ClassNotFoundException{
        ArchivoClientes ag=new ArchivoClientes();
        Paciente p=new Paciente();
        p=ag.recuperar(txtDni.getText());
        
        lbeNombre.setText(p.Nombre);
        lbeDoctor.setText(p.Doctor);
        System.out.println(p.Doctor);
        lbeTrabajo.setText(p.Trabajo);
        System.out.println(p.Trabajo);
        lbeCosto.setText(p.Costo);
                
        lbTitulos.setBounds(400,150,460,25);
        lbeNombre.setBounds(400,155,150,80);
        lbeDoctor.setBounds(527,180,100,250);
        lbeTrabajo.setBounds(665,180,145,250);
        lbeCosto.setBounds(810,180,100,250);
        
        
        this.add(lbTitulos);
        this.add(lbeNombre);
        this.add(lbeDoctor);
        this.add(lbeTrabajo);
        this.add(lbeCosto);
    }
}

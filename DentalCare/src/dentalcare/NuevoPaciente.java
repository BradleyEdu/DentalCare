  package dentalcare;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NuevoPaciente extends JFrame implements ActionListener{
    
    JLabel lbNombre=new JLabel("Nombre(s):");
    JLabel lbApellidoP=new JLabel("Apellido Paterno:");
    JLabel lbApellidoM=new JLabel("Apellido Materno:");
    JLabel lbSexo=new JLabel("Sexo:");
    JLabel lbEdad=new JLabel("Edad: ");
    JLabel lbTelefono=new JLabel("Teléfono:");
    
    JTextField txtNombre=new JTextField();
    JTextField txtApellidoP=new JTextField();
    JTextField txtApellidoM=new JTextField();
    JTextField txtDireccion=new JTextField();
    JTextField txtTelefono=new JTextField();
    JTextField txtEdad=new JTextField();
    
    JButton btnGuardar=new JButton("Guardar");
    JButton btnCancelar=new JButton("Cancelar");
    
    ButtonGroup RadioBoton =new ButtonGroup();
        JRadioButton opMas=new JRadioButton("Masculino",false);
        JRadioButton opFem=new JRadioButton("Femenino",false);
        
    
    public NuevoPaciente(){
        super("Nuevo Paciente");
        setSize(400,380);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        
        JPanel pnl=new JPanel();
        pnl.setLayout(null);
        pnl.setBackground(Color.pink);
        
        
        lbNombre.setBounds(30,10,150,25);
        txtNombre.setBounds(155,10,200,25);
        lbApellidoP.setBounds(30,40,150,25);
        txtApellidoP.setBounds(155,40,200,25);
        lbApellidoM.setBounds(30,70,150,25);
        txtApellidoM.setBounds(155,70,200,25);
        
        lbSexo.setBounds(30,110,50,25);
        opMas.setBounds(90,110,100,25);
        opFem.setBounds(190,110,100,25);
        
        lbEdad.setBounds(30,150,50,25);
        txtEdad.setBounds(80,150,50,25);
        
        lbTelefono.setBounds(30,190,150,25);
        txtTelefono.setBounds(110,190,200,25);
        btnGuardar.setBounds(65,250,100,25);
        btnCancelar.setBounds(215,250,100,25);
        
        btnGuardar.addActionListener(this);
        btnCancelar.addActionListener(this);
        
        
        pnl.add(lbNombre);
        pnl.add(txtNombre);
        pnl.add(lbApellidoP);
        pnl.add(txtApellidoP);
        pnl.add(lbApellidoM);
        pnl.add(txtApellidoM);
        pnl.add(lbTelefono);
        pnl.add(txtTelefono);
        pnl.add(btnGuardar);
        pnl.add(btnCancelar);
        pnl.add(lbEdad);
        pnl.add(txtEdad);
        
        RadioBoton.add(opMas);
        RadioBoton.add(opFem);
        pnl.add(lbSexo);
        pnl.add(opMas);
        pnl.add(opFem);
        setContentPane(pnl);
        this.setVisible(true);        
    }
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        //Devuelve una referencia al objeto donde se generó el evento
        Object obj = ev.getSource();
        
        if (obj instanceof JButton){

            if (obj == btnGuardar){
                try {
                    AgregarCliente();
                    this.setVisible(false);
                    PagPrincipal pagMod=new PagPrincipal();
                } catch (IOException ex) {
                    Logger.getLogger(NuevoPaciente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NuevoPaciente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                dispose();
            }else if(obj == btnCancelar){
                
                int respuesta;
        
                respuesta=JOptionPane.showConfirmDialog(null, 
                "Advertencia NO se añadira la informacion del nuevo Paciente.\n"
               +"            Desea Continuar?",
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
    
    public void AgregarCliente()throws IOException,ClassNotFoundException{
        ArchivoClientes ag=new ArchivoClientes();
        String sexo="",primerL, d;
        
        Random r =new Random();
        int i=r.nextInt(9000)+1000;
        primerL=txtNombre.getText().substring(0, 1);
        d=Integer.toString(i)+primerL;
        if(opMas.isSelected()==true){
            sexo="Masculino";
        }
        if(opFem.isSelected()==true){
            sexo="Femenino";
        }
        
        ag.agregar(d,txtNombre.getText(), txtApellidoP.getText(), txtApellidoM.getText(),
                txtEdad.getText(),sexo, txtTelefono.getText() );
        
        JOptionPane.showMessageDialog(null, "Se guardo exitosamente");
        JOptionPane.showMessageDialog(null, "DNI: "+d+" Nombre: "+txtNombre.getText()+" "+txtApellidoP.getText()+" "+txtApellidoM.getText());
        ag.guardar();
        
    }
    
    public static void main(String[] args) {
        NuevoPaciente obj=new NuevoPaciente();
    }
}

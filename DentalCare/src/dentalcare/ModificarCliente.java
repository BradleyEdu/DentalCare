package dentalcare;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ModificarCliente extends JFrame implements ActionListener{
    JLabel lbNombre=new JLabel("Nombre(s):");
    JLabel lbApellidoP=new JLabel("Apellido Paterno:");
    JLabel lbApellidoM=new JLabel("Apellido Materno:");
    JLabel lbSexo=new JLabel("Sexo:");
    JLabel lbEdad=new JLabel("Edad: ");
    JLabel lbTelefono=new JLabel("Teléfono:");
    JLabel lbDNI=new JLabel("DNI: ");
    JLabel lbDNI1=new JLabel();
    
    
    JTextField txtNombre=new JTextField();
    JTextField txtApellidoP=new JTextField();
    JTextField txtApellidoM=new JTextField();
    JTextField txtDireccion=new JTextField();
    JTextField txtTelefono=new JTextField();
    JTextField txtEdad=new JTextField();
    
    JButton btnModificar=new JButton("Modificar");
    JButton btnEliminar=new JButton("Eliminar");
    JButton btnRegresar=new JButton("Regresar");
    
    ButtonGroup RadioBoton =new ButtonGroup();
        JRadioButton opMas=new JRadioButton("Masculino",false);
        JRadioButton opFem=new JRadioButton("Femenino",false);
        
    
    public ModificarCliente(Paciente p){
        super("Nuevo Paciente");
        setSize(400,380);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        
        JPanel pnl=new JPanel();
        pnl.setLayout(null);
        
        lbDNI1.setText(p.DNI);
        lbDNI.setBounds(30,10,50,25);
        lbDNI1.setBounds(90,10,100,25);
        lbNombre.setBounds(30,40,150,25);
        txtNombre.setBounds(155,40,200,25);
        lbApellidoP.setBounds(30,70,150,25);
        txtApellidoP.setBounds(155,70,200,25);
        lbApellidoM.setBounds(30,100,150,25);
        txtApellidoM.setBounds(155,100,200,25);
        
        if(p.Sexo.equals("Masculino")){
             opMas.setSelected(true);
        }else{
             opFem.setSelected(true);
        }
        
        lbSexo.setBounds(30,140,50,25);
        opMas.setBounds(90,140,100,25);
        opFem.setBounds(190,140,100,25);
        
        lbEdad.setBounds(30,170,50,25);
        txtEdad.setBounds(80,170,50,25);
        
        lbTelefono.setBounds(30,200,150,25);
        txtTelefono.setBounds(110,200,200,25);
        btnModificar.setBounds(25,250,100,25);
        btnEliminar.setBounds(150,250,100,25);
        btnRegresar.setBounds(275,250,100,25);
        
        btnModificar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnRegresar.addActionListener(this);
        
        txtNombre.setText(p.Nombre);
        txtApellidoP.setText(p.ApellidoP);
        txtApellidoM.setText(p.ApellidoM);
        txtEdad.setText(p.Edad);
        txtTelefono.setText(p.Numero);
        
        pnl.add(lbDNI);
        pnl.add(lbDNI1);
        pnl.add(lbNombre);
        pnl.add(txtNombre);
        pnl.add(lbApellidoP);
        pnl.add(txtApellidoP);
        pnl.add(lbApellidoM);
        pnl.add(txtApellidoM);
        pnl.add(lbTelefono);
        pnl.add(txtTelefono);
        pnl.add(btnModificar);
        pnl.add(btnEliminar);
        pnl.add(btnRegresar);
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

            if (obj == btnModificar){
                ArchivoClientes ag;
                try {
                     int respuesta;
        
                    respuesta=JOptionPane.showConfirmDialog(null, 
                    "Se Modificara la información del paciente. Desea Continuar?",
                    "ADVERTENCIA",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
                    
                    if(respuesta==0){
                        ag = new ArchivoClientes();
                        Paciente p=new Paciente();
                        p=ag.recuperar(lbDNI1.getText());

                        p.Nombre=txtNombre.getText();
                        p.ApellidoP=txtApellidoP.getText();
                        p.ApellidoM=txtApellidoM.getText();
                        p.Edad=txtEdad.getText();
                        p.Numero=txtTelefono.getText();

                        if(opMas.isSelected()==true){
                            p.Sexo="Masculino";
                        }
                        if(opFem.isSelected()==true){
                            p.Sexo="Femenino";
                        }

                        ag.guardar();
                        this.setVisible(false);
                        PagPrincipal pagMod=new PagPrincipal();
                        dispose();
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(ModificarCliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ModificarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
            }else if(obj == btnEliminar){
                try {
                     int respuesta;
        
                    respuesta=JOptionPane.showConfirmDialog(null, 
                    "Se Eliminara el paciente. Desea Continuar?",
                    "ADVERTENCIA",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
                    
                    if(respuesta==0){
                        ArchivoClientes ag=new ArchivoClientes();
                        ag.eliminar(lbDNI1.getText());
                        PagPrincipal obj1= new PagPrincipal();
                        dispose();
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(ModificarCliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ModificarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else if(obj == btnRegresar){
                int respuesta;
        
                    respuesta=JOptionPane.showConfirmDialog(null, 
                    "Desea Regresar?, No se modificara la informacion",
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

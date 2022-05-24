package dentalcare;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MatrTable extends JFrame implements ActionListener{
    JButton btnCapturar = new JButton("Capturar");
    String[] vector = new String[6];
    //Modelo de tabla para manipular el contenido
    DefaultTableModel dtm = new DefaultTableModel();
    
    public MatrTable(){
        super("Matriz de datos");
        btnCapturar.addActionListener(this);
        setSize(500,500);
        JPanel pnl = new JPanel();
        pnl.add(btnCapturar);
        //Arreglo de objetos con el contenido de las columnas
        Object[] datos = new Object[5];
        //La tabla con el modelo DefaultTableModel
        final JTable miTabla = new JTable(dtm);
        //Titulo de las columnas 
        dtm.addColumn("Nombre : ");
        dtm.addColumn("Apellido : ");
        dtm.addColumn("Apellido 2 : ");
        dtm.addColumn("Edad: : ");
        dtm.addColumn("Sexo : ");
        dtm.addColumn("Telefono : ");
        
        
        
        //Tamaño de la tabla
        miTabla.setPreferredScrollableViewportSize(new Dimension(700,100));
        //Scroll que se agrega a la JTable
        JScrollPane scrollpane = new JScrollPane(miTabla);
        //Agregamos el JScrollPane al contenedor
        getContentPane().add(btnCapturar,BorderLayout.NORTH);
        getContentPane().add(scrollpane,BorderLayout.CENTER);
        //La salida del programa
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        setVisible(true);
    }
    
    public static void main(String args[]){
        MatrTable ventana = new MatrTable();
        ventana.setSize(500,500);
        ventana.setVisible(true);
    }
    
    public void guardar(String cero,String uno,String dos,String tres,String cuatro,String cinco){
        vector[0]=cero;
        vector[1]=uno;
        vector[2]=dos;
        vector[3]=tres;
        vector[4]=cuatro;
        vector[5]=cinco;
        dtm.addRow(vector);
    }
    
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        if(obj==btnCapturar){
            int pregunta;
            String[] dato = new String [6];
            boolean resp = true;
            Paciente p=new Paciente();
            
            try {
                p=BuscarP();
            dato[0]=p.Nombre;
            dato[1]=p.ApellidoP;
            dato[2]=p.ApellidoM;
            dato[3]=p.Edad;
            dato[4]=p.Sexo;
            dato[5]=p.Numero; 
                guardar(dato[0],dato[1],dato[2],dato[3],dato[4],dato[5]);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(MatrTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
        
    public Paciente BuscarP()throws IOException,ClassNotFoundException{
        ArchivoClientes ag=new ArchivoClientes();
        Paciente p=new Paciente();
        String d=JOptionPane.showInputDialog("Ingrese su DNI");
        
        p=ag.recuperar(d);
        System.out.println("Nombre: "+p.Nombre+" "+p.ApellidoP+" "+p.ApellidoM+"\nEdad: "+p.Edad+"\nSexo: "+p.Sexo+"\nTelefono: "+p.Numero);
        return p;
    }
    
} //Fin de la clase

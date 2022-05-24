package dentalcare;
import java.awt.Dimension;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class ExpedienteCobro extends JFrame{
    //Tabla de clientes
        String[] vector = new String[5];
    //Modelo de tabla para manipular el contenido
    DefaultTableModel dtm = new DefaultTableModel();
    
    public ExpedienteCobro(){
        
    }
    
    public JScrollPane ExpedienteCobro(String ID){
        //Arreglo de objetos con el contenido de las columnas
        Object[] datos = new Object[5];
        //La tabla con el modelo DefaultTableModel
        final JTable miTabla = new JTable(dtm);
        //Titulo de las columnas 
        dtm.addColumn("Clave:");
        dtm.addColumn("Nombre: ");
        dtm.addColumn("Doctor: ");
        dtm.addColumn("Trabajo: ");
        dtm.addColumn("Costo: ");
        
        //Tamaño de la tabla
        miTabla.setPreferredScrollableViewportSize(new Dimension(600,100));
        //Scroll que se agrega a la JTable
        JScrollPane scrollpane = new JScrollPane(miTabla);
        this.add(miTabla);
        //this.add(dtm);
        DatosTabla(ID);
        return scrollpane;
    }
    
    public void DatosTabla(String ID){
        String[] dato = new String [5];
        String d;
            try {
                ArchivoClientes ag=new ArchivoClientes();
                Paciente p=new Paciente();
                p=ag.recuperar(ID);
                ArchivoPagos ap=new ArchivoPagos();
                Pagos pg=new Pagos();
                Enumeration e=ap.total();
                
                while(e.hasMoreElements()){
                    //Recuperamos la clave del objeto
                    d=(String)e.nextElement();
                    pg=ap.recuperar(d);
                    
                    try{
                        if(pg.ClaveP.equals(p.DNI)){
                            JOptionPane.showMessageDialog(null, pg.ClaveP+" "+pg.Nombre);
                            dato[0]=pg.ClaveP;
                            dato[1]=pg.Nombre;
                            dato[2]=pg.Doctor;
                            dato[3]=pg.Trabajo;
                            dato[4]=pg.Costo;
                            guardar(dato[0],dato[1],dato[2],dato[3],dato[4]);
                        }
                    }catch(NullPointerException ex){
                        JOptionPane.showMessageDialog(null, "VAcio no se porque verdad pero asi sale");
                    }
                    
                    
                    
                }
                 
            } catch (IOException ex) {
                Logger.getLogger(PagPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PagPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void guardar(String cero,String uno,String dos,String tres,String cuatro){
        vector[0]=cero;
        vector[1]=uno;
        vector[2]=dos;
        vector[3]=tres;
        vector[4]=cuatro;
        dtm.addRow(vector);
    }
}

package dentalcare;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.*;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class PagPrincipal extends JFrame implements ActionListener{
    //Atributos para la parte de Inicio
        JLabel lbTitulo=new JLabel("DentalCare");
        JLabel lbFecha=new JLabel();
        JLabel lbHora=new JLabel();
        JButton btnCerrar=new JButton("Cerrar Sesión");
        JButton btnSalir=new JButton("Salir");
        JScrollPane jpCitas=new JScrollPane();
        ImageIcon imagenInicio= new ImageIcon("C:\\Users\\bradl\\OneDrive\\Documentos\\NetBeansProjects\\"
                + "DentalCare\\src\\imag\\inicio.png");
        JLabel lbImagenInicio= new JLabel(imagenInicio);
    //Atributos para la parte de Citas
        JLabel lbCitas=new JLabel("Sistema de Citas");
        JLabel lbBuscar=new JLabel("Modificar o Eliminar Cita");
        JButton btnConsultar=new JButton("Buscar Cita");
        JTextField txtClave=new JTextField(); 
        JButton btnNueva=new JButton("Nueva Cita");
        
    //Atributos para la parte de Clientes
        JLabel lbNombre=new JLabel("DNI del Paciente:");
        //JLabel lbNombre1=new JLabel();
        JLabel lbDni=new JLabel("Modificar o Eliminar:");
        JTextField txtDni=new JTextField();
        JButton btnBuscar=new JButton("Buscar");
        JButton btnDni=new JButton("Conocer DNI");
        JButton btnNuevo=new JButton("Nuevo Cliente");
        JButton btnExpe=new JButton("Expediente");
        JScrollPane jp=new JScrollPane();
        ImageIcon imagenCliente= new ImageIcon("C:\\Users\\bradl\\OneDrive\\Documentos\\NetBeansProjects\\"
                + "DentalCare\\src\\imag\\usuario.png");
        JLabel lbImagenClientes= new JLabel(imagenCliente);
        ImageIcon imagenDiente= new ImageIcon("C:\\Users\\bradl\\OneDrive\\Documentos\\NetBeansProjects\\"
                + "DentalCare\\src\\imag\\fondo-diente.png");
        JLabel lbImagenDiente= new JLabel(imagenDiente);
        
        
        //Tabla de clientes
        String[] vector = new String[7];
    //Modelo de tabla para manipular el contenido
    DefaultTableModel dtm = new DefaultTableModel();
     //Tabla de Citas
        String[] vector1 = new String[5];
    //Modelo de tabla para manipular el contenido
    DefaultTableModel dtm1 = new DefaultTableModel();

    public PagPrincipal(){
        super("Pagina Principal");
        this.setSize(900,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JTabbedPane pestañas=new JTabbedPane();
        
//=====================--------------------Inicio-------------------------============================
        JPanel pnlInicio=new JPanel();
        pnlInicio.setLayout(null);
        
        Calendar calendario = Calendar.getInstance();
        int hora, minutos, segundos;
        String h,m,reloj,fecha,dia,mes,año;
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        h=Integer.toString(hora);
        m=Integer.toString(minutos);
        reloj=h+" : "+m;
        lbHora.setText(reloj);
        dia = Integer.toString(calendario.get(Calendar.DATE));
        mes = Integer.toString((calendario.get(Calendar.MONTH))+1);
        año = Integer.toString(calendario.get(Calendar.YEAR));
        fecha=dia+"/"+mes+"/"+año;
        lbFecha.setText(fecha);
        jpCitas=TablaCitas();
        jpCitas.setBackground(Color.cyan);
        
        lbTitulo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 45));
        lbHora.setFont(new Font("Arial", Font.PLAIN, 22));
        lbFecha.setFont(new Font("Arial", Font.PLAIN, 22));
        lbTitulo.setBounds(350,10,400,60);
        lbFecha.setBounds(750,10,100,25);
        lbHora.setBounds(765,35,100,25);
        jpCitas.setBounds(10,80,850,250);
        lbImagenInicio.setBounds(450,320,400,157);
        btnCerrar.setBounds(530,485,150,25);
        btnSalir.setBounds(700,485,150,25);
        
        lbBuscar.setFont(new Font("Arial", Font.PLAIN, 20));
        lbBuscar.setBounds(50,350,250,30);
        txtClave.setBounds(50,385,220,25);
        btnConsultar.setBounds(290,365,150,30);
        btnNueva.setBounds(50,440,200,30);
       
        
        btnConsultar.addActionListener(this);
        btnNueva.addActionListener(this);
        
        pnlInicio.setBackground(Color.white);
        pnlInicio.add(lbBuscar);
        pnlInicio.add(txtClave);
        pnlInicio.add(btnConsultar);
        pnlInicio.add(btnNueva);
        
        
        pnlInicio.add(lbTitulo);
        pnlInicio.add(lbHora);
        pnlInicio.add(lbFecha);
        pnlInicio.add(jpCitas);
        pnlInicio.add(lbImagenInicio);
        pnlInicio.add(btnCerrar);
        pnlInicio.add(btnSalir);
        pnlInicio.add(btnSalir);
        
        btnCerrar.addActionListener(this);
        btnSalir.addActionListener(this);
//====================---------------------Clientes--------------------------=========================
        JPanel pnlClientes=new JPanel();
        pnlClientes.setLayout(null);
        lbDni.setFont(new Font("Arial", Font.PLAIN, 20));
        lbDni.setBounds(100,25,200,25);
        lbNombre.setBounds(100,55,150,25);
        txtDni.setBounds(100,85,250,25);
        //lbNombre1.setBounds(190,75,250,25);
        btnBuscar.setBounds(375,70,150,30);
        btnDni.setBounds(690,380,170,40);
        btnNuevo.setBounds(690,430,170,40);
        btnExpe.setBounds(10,365,150,30);
        lbImagenClientes.setBounds(550,0,200,190);
        lbImagenDiente.setBounds(50,300,626,322);
        jp=TablaClientes();
        jp.setBounds(10,150,850,200);
        pnlClientes.setBackground(Color.white);
        pnlClientes.add(lbNombre);
        //pnlClientes.add(lbNombre1);
        pnlClientes.add(lbDni);
        pnlClientes.add(txtDni);
        pnlClientes.add(btnBuscar);
        pnlClientes.add(btnDni);
        pnlClientes.add(btnNuevo);
        pnlClientes.add(btnExpe);
        pnlClientes.add(jp);
        pnlClientes.add(lbImagenClientes);
        pnlClientes.add(lbImagenDiente);
        
        btnBuscar.addActionListener(this);
        btnDni.addActionListener(this);
        btnNuevo.addActionListener(this);
        btnExpe.addActionListener(this);
        
        //panelClientes panelC=new panelClientes();
//===================--------------------------PAGOS---------------------------==========================
        panelPagos pnlPago=new panelPagos();
        panelDoctores pnlDoc=new panelDoctores();
        
        pestañas.addTab("INICIO",pnlInicio);
        pestañas.addTab("CLIENTES", pnlClientes);
        pestañas.addTab("PAGOS", pnlPago);
        pestañas.addTab("DOCTORES", pnlDoc);
        
        
        getContentPane().add(pestañas);
        this.setVisible(true);
        
    }
    
     @Override
    public void actionPerformed(ActionEvent ev){
        //Devuelve una referencia al objeto donde se generó el evento
        Object obj = ev.getSource();
        
        if (obj instanceof JButton){
//---------------------------------PARTES DE INICIO-----------------------------------------------------------------
            if(obj == btnCerrar){
                int cerrar;
        
                cerrar=JOptionPane.showConfirmDialog(null, 
                "Cerrar Sesion\nDesea Continuar?",
                "ADVERTENCIA",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
                
                if(cerrar==0){
                    this.setVisible(false);
                    Inicio inicio=new Inicio();
                }
            }else if(obj == btnSalir){
                int salir;
        
                salir=JOptionPane.showConfirmDialog(null, 
                "DESEA CERRAR EL PROGRAMA?",
                "ADVERTENCIA",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
                
                if(salir==0){
                    System.exit(0);
                }
                
//----------------------------------Parte de CITAS-----------------------------------------------------------
            }else if (obj == btnConsultar){
                try {
                    ArchivoCitas ac=new ArchivoCitas();
                    String d;
                    int validar=0;
                    Enumeration e=ac.total();
                        while(e.hasMoreElements()){
                            d=(String)e.nextElement();
                            if(d.equals(txtDni.getText())){
                                validar=1;
                            }
                        }

                        if(validar==0){
                            JOptionPane.showMessageDialog(null, "Ese DNI no existe\nIngrese un DNI valido");
                        }
                   
                        Cita c=new Cita();
                        c=ac.recuperar(txtClave.getText());
                        ModificarCita MC=new ModificarCita(c);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(PagPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else if(obj == btnNueva){
                NuevaCita Nuev=new NuevaCita();
                
                
//----------------------------------Parte de CLIENTES--------------------------------------------------------
            }else if(obj == btnBuscar){
                try {
                    ArchivoClientes ag=new ArchivoClientes();
                    String d;
                    int validar=0;
                    Enumeration e=ag.total();
                        while(e.hasMoreElements()){
                            d=(String)e.nextElement();
                            if(d.equals(txtDni.getText())){
                                validar=1;
                            }
                        }

                        if(validar==0){
                            JOptionPane.showMessageDialog(null, "Ese DNI no existe\nIngrese un DNI valido");
                        }
                   
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(PagPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
                    try {
                    ArchivoClientes ag = new ArchivoClientes();
                    Paciente p=new Paciente();
                    p=ag.recuperar(txtDni.getText());
                    //lbNombre1.setText(p.Nombre+" "+p.ApellidoP+" "+p.ApellidoM);
                    ModificarCliente MC=new ModificarCliente(p);
                    
                     
                    } catch (IOException ex) {
                        Logger.getLogger(PagPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PagPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }catch(NullPointerException ex){
                    JOptionPane.showMessageDialog(null, "Ingrese el DNI");
                    }
            }else if(obj == btnNuevo){
                NuevoPaciente NuevoP=new NuevoPaciente();
            }else if(obj == btnDni){
                buscarDNI();
            }else if(obj == btnExpe){
                Expediente();
            }
            
        }
        repaint();//Dibuja nuevamente el contenido gráfico de la ventana
    }
    
    public void Expediente(){
        String llave=JOptionPane.showInputDialog("Ingrese DNI del Paciente");
            try {
                ArchivoClientes ag=new ArchivoClientes();
                String d;
                    int validar=0;
                    Enumeration e=ag.total();
                        while(e.hasMoreElements()){
                            d=(String)e.nextElement();
                            if(d.equals(llave)){
                                validar=1;
                            }
                        }

                        if(validar==0){
                            JOptionPane.showMessageDialog(null, "Ese DNI no existe\nIngrese un DNI valido");
                        }else{
                            Paciente p=new Paciente();
                            p=ag.recuperar(llave);
                            ExpedientePaciente expa=new ExpedientePaciente(p);
                        }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(PagPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        
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
                                txtDni.setText(llave);
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
    
    public JScrollPane TablaClientes(){
        //Arreglo de objetos con el contenido de las columnas
        Object[] datos = new Object[7];
        //La tabla con el modelo DefaultTableModel
        final JTable miTabla = new JTable(dtm);
        //Titulo de las columnas 
        dtm.addColumn("Clave:");
        dtm.addColumn("Nombre: ");
        dtm.addColumn("Apellido: ");
        dtm.addColumn("Apellido 2: ");
        dtm.addColumn("Edad: ");
        dtm.addColumn("Sexo: ");
        dtm.addColumn("Telefono: ");
        
        
        
        //Tamaño de la tabla
        miTabla.setPreferredScrollableViewportSize(new Dimension(600,100));
        //Scroll que se agrega a la JTable
        JScrollPane scrollpane = new JScrollPane(miTabla);
        
        DatosTabla();
        return scrollpane;
        
    }
    
    public JScrollPane TablaCitas(){
        //Arreglo de objetos con el contenido de las columnas
        Object[] datos3 = new Object[5];
        //La tabla con el modelo DefaultTableModel
        final JTable miTabla1 = new JTable(dtm1);
        //Titulo de las columnas 
        dtm1.addColumn("Clave Cita");
        dtm1.addColumn("Nombre:");
        dtm1.addColumn("Fecha:");
        dtm1.addColumn("Hora:");
        dtm1.addColumn("Especialista:");    
        
        //Tamaño de la tabla
        miTabla1.setPreferredScrollableViewportSize(new Dimension(600,100));
        //miTabla1.setBackground(Color.cyan);
        //Scroll que se agrega a la JTable
        JScrollPane scrollpane1 = new JScrollPane(miTabla1);
        
        scrollpane1.setBackground(Color.cyan);
        DatosTablaCita();
        return scrollpane1;
    }
    
    public void DatosTabla(){
        String[] dato = new String [7];
        String d;
            try {
                ArchivoClientes ag=new ArchivoClientes();
                Paciente p=new Paciente();
                Enumeration e=ag.total();
                
                while(e.hasMoreElements()){
                    //Recuperamos la clave del objeto
                    d=(String)e.nextElement();
                    p=ag.recuperar(d);
                    dato[0]=p.DNI;
                    dato[1]=p.Nombre;
                    dato[2]=p.ApellidoP;
                    dato[3]=p.ApellidoM;
                    dato[4]=p.Edad;
                    dato[5]=p.Sexo;
                    dato[6]=p.Numero;
                    
                    guardar(dato[0],dato[1],dato[2],dato[3],dato[4],dato[5],dato[6]);
                }
                 
            } catch (IOException ex) {
                Logger.getLogger(PagPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PagPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
    
    public void guardar(String cero,String uno,String dos,String tres,String cuatro,String cinco,String seis){
        vector[0]=cero;
        vector[1]=uno;
        vector[2]=dos;
        vector[3]=tres;
        vector[4]=cuatro;
        vector[5]=cinco;
        vector[6]=seis;
        dtm.addRow(vector);
    }
    
    public void DatosTablaCita(){
        String[] dato = new String [5];
        String d;
            try {
                ArchivoCitas ac=new ArchivoCitas();
                Cita c=new Cita();
                Enumeration en=ac.total();
                
                while(en.hasMoreElements()){
                    //Recuperamos la clave del objeto
                    d=(String)en.nextElement();
                    c=ac.recuperar(d);
                    dato[0]=c.N;
                    dato[1]=c.Nombre+" "+c.Apellido+" "+c.ApellidoM;
                    dato[2]=c.Cdia+"/"+c.Cmes+"/"+c.Caño;
                    dato[3]=c.Chora;
                    dato[4]=c.Especial;
                    
                    
                    guardarCita(dato[0],dato[1],dato[2],dato[3],dato[4]);
                }
                 
            } catch (IOException ex) {
                Logger.getLogger(PagPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PagPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
    
    public void guardarCita(String cero,String uno,String dos,String tres,String cuatro){
        vector1[0]=cero;
        vector1[1]=uno;
        vector1[2]=dos;
        vector1[3]=tres;
        vector1[4]=cuatro;
        dtm1.addRow(vector1);
    }
    
    public void BuscarP()throws IOException,ClassNotFoundException{
        ArchivoClientes ag=new ArchivoClientes();
        Paciente p=new Paciente();
        p=ag.recuperar(txtDni.getText());
        System.out.println("Nombre: "+p.Nombre+" "+p.ApellidoP+" "+p.ApellidoM+"\nEdad: "+p.Edad+"\nSexo: "+p.Sexo+"\nTelefono: "+p.Numero);
    }
    
    public static void main(String[] args) {
        PagPrincipal p=new PagPrincipal();
    }
    
}

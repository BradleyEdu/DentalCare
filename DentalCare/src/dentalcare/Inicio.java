package dentalcare;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Inicio extends JFrame implements ActionListener,KeyListener{
    JLabel lbUsuario=new JLabel("Ingrese Usuario: ");
    JLabel lbPassword=new JLabel("Ingrese Contraseña: ");
    JLabel lbBienvenido=new JLabel("Bienvenido: ");
    JLabel lbTitulo=new JLabel("DentalCare");
    
    JTextField txtUsuario=new JTextField();
    JPasswordField txtPassword=new JPasswordField();
    
    JButton btnIniciar=new JButton("Iniciar Sesión");
    
    ImageIcon imagen= new ImageIcon("C:\\Users\\bradl\\OneDrive\\Documentos\\NetBeansProjects\\"
            + "DentalCare\\src\\imag\\la-salud-bucal-y-la-diabetes.jpeg");
    JLabel lbImagen= new JLabel(imagen);
    
    ImageIcon logo= new ImageIcon("C:\\Users\\bradl\\OneDrive\\Documentos\\NetBeansProjects\\"
            + "DentalCare\\src\\imag\\dientito.png");
    JLabel lbLogo= new JLabel(logo);
    
    public Inicio(){
        super("DentalCare Software");
        this.setSize(700,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        JPanel pnl=new JPanel();
        pnl.setLayout(null);
        
        addKeyListener(this); //añado el keylistener
        
        lbTitulo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 60));
        lbTitulo.setBounds(195,30,400,60);
        
        lbLogo.setBounds(475,15,130,130);
        
        lbImagen.setBounds(40,120,300,310);
        
        lbBienvenido.setFont(new Font("Baskerville Old Face", Font.PLAIN, 35));
        lbBienvenido.setBounds(450,135,250,35);
        
        lbUsuario.setBounds(400,185,150,25);
        txtUsuario.setBounds(400,215,250,30);
        lbPassword.setBounds(400,250,150,25);
        txtPassword.setBounds(400,280,250,30);
        btnIniciar.setBounds(430,350,190,30);
                
        pnl.add(lbTitulo);
        //pnl.add(lbLogo);
        pnl.add(lbImagen);
        pnl.add(lbBienvenido);
        pnl.add(lbUsuario);
        pnl.add(txtUsuario);
        pnl.add(lbPassword);
        pnl.add(txtPassword);
        pnl.add(btnIniciar);
        
        btnIniciar.addActionListener(this);
        btnIniciar.addKeyListener(this);
        
        pnl.setBackground(Color.white);
        
        setContentPane(pnl);
        this.setVisible(true);
    }
    
    @Override
     public void actionPerformed(ActionEvent ev){
         Object obj = ev.getSource();
         String Usu="nomadas";
         String Pas="1234";
         
         if (obj == btnIniciar){
             //Si estan vacios los campos
             if((txtUsuario.getText().equals(""))||(txtPassword.getText().equals(""))){
                 JOptionPane.showMessageDialog(null, "LLENE TODOS LOS DATOS CORRECTAMENTE");
             }else
            //Comprobacion de usuario y contraseña
            if(!txtUsuario.getText().equals(Usu)&&!txtPassword.getText().equals(Pas)){
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectas");
            }else{
                JOptionPane.showMessageDialog(null,"Bienvenido");
                dispose();
                PagPrincipal pg=new PagPrincipal();
            }
         }
     }
     
    @Override
     public void keyTyped(KeyEvent e) {
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
         
    @Override
    public void keyPressed(KeyEvent e){
        
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
         String Usu="nomadas";
         String Pas="1234";
         
             //Si estan vacios los campos
             if((txtUsuario.getText().equals(""))||(txtPassword.getText().equals(""))){
                 JOptionPane.showMessageDialog(null, "LLENE TODOS LOS DATOS CORRECTAMENTE");
             }else
            //Comprobacion de usuario y contraseña
            if(!txtUsuario.getText().equals(Usu)&&!txtPassword.getText().equals(Pas)){
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectas");
            }else{
                JOptionPane.showMessageDialog(null,"Bienvenido");
                dispose();
                PagPrincipal pg=new PagPrincipal();
            }
         
        }
    }
}

package dentalcare;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
public class ExpedientePaciente extends JFrame implements ActionListener{
    JLabel lbExpediente=new JLabel("Expediente");
    JLabel lbDNI=new JLabel("DNI:");
    JLabel lbNombre=new JLabel();
    JLabel lbApellidoP=new JLabel();
    JLabel lbApellidoM=new JLabel();
    JLabel lbEdad=new JLabel();
    JLabel lbSexo=new JLabel();
    JLabel lbNumero=new JLabel();
    JLabel lbTrat=new JLabel("Tratamientos Realizados:");
    JLabel lbDoctor=new JLabel("Especialista:");
    JLabel lbTrata=new JLabel("Tratamiento:");
    
    JTextArea txtaDoctor=new JTextArea();
    JTextArea txtaTrat=new JTextArea();
    
    ImageIcon imagenPago= new ImageIcon("C:\\Users\\bradl\\OneDrive\\Documentos\\NetBeansProjects\\"
            + "DentalCare\\src\\imag\\c728796e46fb111cce09ffd324a40949-diente-colorido-icono-by-vexels (1).png");
    JLabel lbImagenPago= new JLabel(imagenPago);
    
    JButton btnCerrar=new JButton("Cerrar");
    JButton btnImprimir=new JButton("Imprimir");
    
    public ExpedientePaciente(Paciente p){
        super("Expediente");
        setSize(600,800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        
        JPanel pnl=new JPanel();

        pnl.setLayout(null);
        pnl.setBackground(Color.white);
        
        lbDNI.setText("DNI: "+p.DNI);
        lbNombre.setText(p.Nombre);
        lbApellidoP.setText(p.ApellidoP);
        lbApellidoM.setText(p.ApellidoM);
        lbEdad.setText(p.Edad+" años");
        lbSexo.setText(p.Sexo);
        lbNumero.setText("Tel: "+p.Numero);
        
        txtaDoctor.setText(p.Doctor);
        txtaTrat.setText(p.Trabajo);
                
        lbExpediente.setFont(new Font("Baskerville Old Face", Font.PLAIN, 45));
        lbDNI.setFont(new Font("Arial", Font.PLAIN, 20));
        lbNombre.setFont(new Font("Arial", Font.PLAIN, 20));
        lbApellidoP.setFont(new Font("Arial", Font.PLAIN, 20));
        lbApellidoM.setFont(new Font("Arial", Font.PLAIN, 20));
        lbEdad.setFont(new Font("Arial", Font.PLAIN, 20));
        lbSexo.setFont(new Font("Arial", Font.PLAIN, 20));
        lbNumero.setFont(new Font("Arial", Font.PLAIN, 20));
        lbTrat.setFont(new Font("Arial", Font.PLAIN, 25));
        lbDoctor.setFont(new Font("Arial", Font.PLAIN, 20));
        lbTrata.setFont(new Font("Arial", Font.PLAIN, 20));
        
//        txtaDoctor.setBackground(Color.red);
//        txtaTrat.setBackground(Color.red);
                
        lbExpediente.setBounds(170,50,250,50);
        lbImagenPago.setBounds(400,10,120,120);
        lbDNI.setBounds(50,120,250,30);
        lbNombre.setBounds(50,155,100,30);
        lbApellidoP.setBounds(50,190,100,30);
        lbApellidoM.setBounds(50,225,100,30);
        lbEdad.setBounds(50,260,260,30);
        lbSexo.setBounds(50,295,100,30);
        lbNumero.setBounds(50,330,300,30);
        lbTrat.setBounds(150,380,300,30);
        lbDoctor.setBounds(110,430,200,30);
        lbTrata.setBounds(340,430,200,30);
        txtaDoctor.setBounds(110,465,200,400);
        txtaTrat.setBounds(340,465,200,400);
        
        btnImprimir.setBounds(400,200,150,30);
        btnCerrar.setBounds(400,250,150,30);
        
        btnImprimir.addActionListener(this);
        btnCerrar.addActionListener(this);
        
        pnl.add(lbExpediente);
        pnl.add(lbImagenPago);
        pnl.add(lbDNI);
        pnl.add(lbNombre);
        pnl.add(lbApellidoP);
        pnl.add(lbApellidoM);
        pnl.add(lbEdad);
        pnl.add(lbSexo);
        pnl.add(lbNumero);
        pnl.add(lbTrat);
        pnl.add(lbDoctor);
        pnl.add(lbTrata);
        pnl.add(txtaDoctor);
        pnl.add(txtaTrat);
        pnl.add(btnImprimir);
        pnl.add(btnCerrar);
        
        setContentPane(pnl);
       
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ev) {
        //Devuelve una referencia al objeto donde se generó el evento
        Object obj = ev.getSource();
        
        if (obj instanceof JButton){
            if (obj == btnImprimir){
                JOptionPane.showMessageDialog(null, "Imprimiendo Expediente...");
                JOptionPane.showMessageDialog(null, "...");
            }else if(obj == btnCerrar){
                dispose();
            }
        }
    }
    
}

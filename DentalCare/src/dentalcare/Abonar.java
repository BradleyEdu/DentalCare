package dentalcare;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Abonar extends JFrame implements ActionListener{
    JLabel lbID=new JLabel();
    JLabel lbAdeudo=new JLabel("Adeudo: $");
    JLabel lbAdeudo1=new JLabel();
    JLabel lbAbono=new JLabel("Abono:");
    
    JTextField txtAbono=new JTextField();
    
    JButton btnAbonar=new JButton("Abonar");
    JButton btnCancelar=new JButton("Cancelar");
    
    public Abonar(Paciente p){
        super("Añadir Cobro-SistemaDePagos");
        setSize(350,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        
        JPanel pnl=new JPanel();
        pnl.setLayout(null);
        
        lbID.setText(p.DNI);
        lbAdeudo.setBounds(30,10,100,25);
        lbAdeudo1.setText(Integer.toString(p.pago));
        lbAdeudo1.setBounds(100,10,100,25);
        lbAbono.setBounds(30,40,100,25);
        txtAbono.setBounds(100,40,150,25);
        btnAbonar.setBounds(40,95,100,25);
        btnCancelar.setBounds(190,95,100,25);
                
        pnl.add(lbAdeudo);        
        pnl.add(lbAdeudo1);
        pnl.add(lbAbono);
        pnl.add(txtAbono);
        pnl.add(btnAbonar);
        pnl.add(btnCancelar);
        
        btnAbonar.addActionListener(this);
        btnCancelar.addActionListener(this);
        
        setContentPane(pnl);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ev){
        //Devuelve una referencia al objeto donde se generó el evento
        Object obj = ev.getSource();
        if(obj instanceof JButton){
            if(obj == btnAbonar){
                try {
                    Abonar();
                    dispose();
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(Abonar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(obj == btnCancelar){
                int respuesta;
        
                respuesta=JOptionPane.showConfirmDialog(null, 
                "El abono no sera añadido.\n"
               +"                          Desea Continuar?",
                "ADVERTENCIA",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
                
                if(respuesta==0){
                    dispose();
                }
            }
        }
    }
    
    public void Abonar() throws IOException, ClassNotFoundException{
        ArchivoClientes ag=new ArchivoClientes();
        Paciente p=new Paciente();
        p=ag.recuperar(lbID.getText());
        
        int respuesta,restante,abon;
        
                respuesta=JOptionPane.showConfirmDialog(null, 
                "Se añadira un abono al Paciente.\n"
               +"                          Desea Continuar?",
                "ADVERTENCIA",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
                
                if(respuesta==0){
                    abon=Integer.parseInt(txtAbono.getText());
                    restante=p.pago-abon;
                    p.pago=restante;
                    ag.guardar();
                    JOptionPane.showMessageDialog(null, "Se agrego un abono a la cuenta del paciente: "+p.Nombre+" "+p.ApellidoP
                    +"\nAbono de: $"+abon+"\nRestanto en la cuenta: $"+restante);
                }
    }
}

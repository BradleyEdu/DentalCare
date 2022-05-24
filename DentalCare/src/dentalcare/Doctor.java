package dentalcare;
import java.io.*;
public class Doctor implements Serializable {
    String clave,Doctor,Tratamiento="",Paciente="",Cobro="";
    int Total=0;
    public Doctor(){
        this.Doctor="Ortodencista";
        this.clave="OR";
    }
    
    public Doctor(int a){
        this.Doctor="Maxilofacial";
        this.clave="MA";
    }
    
    public Doctor(String a){
        this.Doctor="Endodoncista";
        this.clave="EN";
    }
}

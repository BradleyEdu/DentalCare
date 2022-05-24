package dentalcare;
import java.io.*;
public class Paciente implements Serializable {
    String DNI,Nombre,ApellidoP,ApellidoM,Edad,Sexo,Numero;
    String Trabajo="",Costo="$",Doctor="";
    int pago=0;
    public Paciente(){
    }
    
    public Paciente(String n,String N,String AP,String AM,String E,String S,String Num){
        this.DNI=n;
        this.Nombre=N;
        this.ApellidoP=AP;
        this.ApellidoM=AM;
        this.Edad=E;
        this.Sexo=S;
        this.Numero=Num;
    }
    
    public String getDni(){
        return DNI;
    } 
        
}

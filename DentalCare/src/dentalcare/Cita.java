package dentalcare;
import java.io.*;
import java.util.*;
public class Cita implements Serializable  {
    String N,Cdia,Cmes,Caño,Especial,Chora,Nombre,Apellido,ApellidoM;
    public Cita(){
        
    }
    public Cita(String a,String b,String c,String d,String e,String f,String g,String h){
        Random r=new Random();
        int n=r.nextInt(9000)+1000;
        this.N=Integer.toString(n);
        this.Chora=a;
        this.Nombre=b;
        this.Apellido=c;
        this.ApellidoM=d;
        this.Cdia=e;
        this.Cmes=f;
        this.Caño=g;
        this.Especial=h;
        
    }
}

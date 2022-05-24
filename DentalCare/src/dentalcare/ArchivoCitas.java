package dentalcare;
//importacion de paquetes
import java.util.*;
import java.io.*;

public class ArchivoCitas {
    //en la variable path se asigna el nombre fisico del archivo
    private final String path="ArchivoCita.obj";
    /*Declaraci�n de tabla que es de la clase Hastable
     *de tipo Persona....Hashtable es como un mapa*/

    Hashtable <String,Cita> tabla1;
     
    public ArchivoCitas() throws IOException,ClassNotFoundException{
        FileInputStream fi;
        ObjectInputStream oi;
        
        try{
            /*El par�metro path tiene nombre del archivo e
             indica el camino hacia el directorio donde se encuentra el archivo
           las clases: FileInPutStream y ObjectInputStream prepara para leer del archivo*/
            fi = new FileInputStream(path);
            //para leer objetos del archivo
            oi = new ObjectInputStream(fi);
            //lee los objetos del archivo y los asigna a la tabla
            tabla1 = (Hashtable) oi.readObject();
            //cierre del archivo
            oi.close();
        }catch(FileNotFoundException e){
            /*Excepci�n que se produce cuando se produce un error al
             intentar tener acceso a un archivo que no existe en el disco.*/
            tabla1 = new Hashtable <String, Cita> ();
        }
    }
    
    public boolean agregar(String d,Cita c){
       /*busca en la tabla la clave con la que se identifica al objeto
        sino existe se crea el objeto y se agrega a la tabla, mandando como
        argumentos la clave y al objeto (es decir la direccion de memoeria del objeto)*/
        if (!tabla1.containsKey(d)){
            
            tabla1.put(d,c);
            //objeto para grabar 
            try {
            	/*las clases FileOutputStream y ObjectOutputStream,
            	 *a traves de sus objetos permiten grabar en el archivo fisico*/
            	 FileOutputStream fo = new FileOutputStream(path);
                    //este objeto es de escritura
                    ObjectOutputStream os = new ObjectOutputStream(fo);
                    //pasa lo que tiene la tabla al archivo fisico y lo graba
                os.writeObject(tabla1);
                os.close();
                fo.close();
            }catch (IOException ex) {}
            return true;
        }else {
            return false;
        }
    }
    
    public boolean eliminar(String d){
        /*busca en la tabla la clave con la que se identifica al objeto
        si existe se elimina de la tabla*/
        if (tabla1.containsKey(d)){
            tabla1.remove(d);
            
            try{
            	FileOutputStream fo = new FileOutputStream(path);
                //este objeto es de escritura
                ObjectOutputStream os = new ObjectOutputStream(fo);
                os.writeObject(tabla1);
                os.close();
                fo.close();
            }
            catch(IOException ex){}
            return true;
        }else{
            return false;
        }
    }
    
    public Cita recuperar(String d){
        /*Se busca en la tabla la clave del objeto si se encuentra se
         recupera la direcci�n de memoria a trav�s del metodo get, sino existe
         se envia null (nulo)*/
        if (tabla1.containsKey(d)){
            return tabla1.get(d);
        }else{
            return null;
        }
    }
    
    public Enumeration total(){
    	/* recorre toda la tabla y envia todas las claves de los objetos*/
        return tabla1.keys();
    }
    
    public void guardar() throws IOException{
    	/*Utiliza las clases,metodos correspondientes
    	 *para escribir (grabar) los objetos*/
        FileOutputStream fo = new FileOutputStream(path);
        ObjectOutputStream os = new ObjectOutputStream(fo);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        os.writeObject(tabla1);
        os.flush();
        os.close();
    }
}


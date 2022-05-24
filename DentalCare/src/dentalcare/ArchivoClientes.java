  package dentalcare;
//importacion de paquetes
import java.util.*;
import java.io.*;

public class ArchivoClientes {
    //en la variable path se asigna el nombre fisico del archivo
    private final String path="ArchivoCliente.obj";
    /*Declaraci�n de tabla que es de la clase Hastable
     *de tipo Persona....Hashtable es como un mapa*/

    Hashtable <String,Paciente> tabla;
     
    public ArchivoClientes() throws IOException,ClassNotFoundException{
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
            tabla = (Hashtable) oi.readObject();
            //cierre del archivo
            oi.close();
        }catch(FileNotFoundException e){
            /*Excepci�n que se produce cuando se produce un error al
             intentar tener acceso a un archivo que no existe en el disco.*/
            tabla = new Hashtable <String, Paciente> ();
        }
    }
    
    public boolean agregar(String d,String N,String AP,String AM,String E,String S,String Num){
       /*busca en la tabla la clave con la que se identifica al objeto
        sino existe se crea el objeto y se agrega a la tabla, mandando como
        argumentos la clave y al objeto (es decir la direccion de memoeria del objeto)*/
        if (!tabla.containsKey(d)){
            Paciente p=new Paciente(d,N,AP,AM,E,S,Num);
            
            tabla.put(d,p);
            //objeto para grabar 
            try {
            	/*las clases FileOutputStream y ObjectOutputStream,
            	 *a traves de sus objetos permiten grabar en el archivo fisico*/
            	 FileOutputStream fo = new FileOutputStream(path);
                    //este objeto es de escritura
                    ObjectOutputStream os = new ObjectOutputStream(fo);
                    //pasa lo que tiene la tabla al archivo fisico y lo graba
                os.writeObject(tabla);
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
        if (tabla.containsKey(d)){
            tabla.remove(d);
            
            try{
            	FileOutputStream fo = new FileOutputStream(path);
                //este objeto es de escritura
                ObjectOutputStream os = new ObjectOutputStream(fo);
                os.writeObject(tabla);
                os.close();
                fo.close();
            }
            catch(IOException ex){}
            return true;
        }else{
            return false;
        }
    }
    
    public Paciente recuperar(String d){
        /*Se busca en la tabla la clave del objeto si se encuentra se
         recupera la direcci�n de memoria a trav�s del metodo get, sino existe
         se envia null (nulo)*/
        if (tabla.containsKey(d)){
            return tabla.get(d);
        }else{
            return null;
        }
    }
    
    public Enumeration total(){
    	/* recorre toda la tabla y envia todas las claves de los objetos*/
        return tabla.keys();
    }
    
    public void guardar() throws IOException{
    	/*Utiliza las clases,metodos correspondientes
    	 *para escribir (grabar) los objetos*/
        FileOutputStream fo = new FileOutputStream(path);
        ObjectOutputStream os = new ObjectOutputStream(fo);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        os.writeObject(tabla);
        os.flush();
        os.close();
    }
}


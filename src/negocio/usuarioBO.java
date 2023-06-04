package negocio;
import java.io.*;
import java.util.ArrayList;

import servicio.usuario;

public class usuarioBO {

    public void guardarUsuarios(usuario usu, String nom, String ape, String user, String pass){
        usu.setNombre(nom);
        usu.setApellido(ape);
        usu.setUser(user);
        usu.setPass(pass);
    }

    public usuario verUsuarios(usuario usu){
        return usu;
    }

    public void cargarUsuario(usuario usu){ 
        try {
            File archivo = new File("usuarios.txt");
            FileWriter writer;
            if(archivo.exists()){
                writer = new FileWriter(archivo,true);
            }
            else{
                writer = new FileWriter(archivo);
            }
            
            BufferedWriter buffer = new BufferedWriter(writer);
            String linea = usu.getNombre()+"#"+usu.getApellido()+"#"+usu.getUser()+"#"+usu.getPass()+"#";
            buffer.write(linea);
            buffer.newLine();
            buffer.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public ArrayList<usuario> verUsuarios(){
        ArrayList<usuario> vec = new ArrayList<usuario>();
        try{
            File archivo = new File("usuarios.txt");
            FileReader reader = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(reader);
            String linea = buffer.readLine();
            while(linea != null){
                String [] vector = linea.split("#");
                usuario usu = new usuario(null, null, null, null);
                usu.setNombre(vector[0]);
                usu.setApellido(vector[1]);
                usu.setUser(vector[2]);
                usu.setPass(vector[3]);
                vec.add(usu);
                linea = buffer.readLine();
            }
            buffer.close();
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return vec;
    }

    public usuario buscarUsuario(String user){
        usuario temp = new usuario(null,null,null,null);
        try {
            File archivo = new File("usuarios.txt");
            FileReader leer = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(leer);
            String linea = buffer.readLine();
            while(linea != null){
                String [] vector = linea.split("#");
                if(user.equalsIgnoreCase(vector[2])){
                    temp.setNombre(vector[0]);
                    temp.setApellido(vector[1]);
                    temp.setUser(vector[2]);
                    temp.setPass(vector[3]);
                }
                linea = buffer.readLine();
            }
            buffer.close();
            leer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public void eliminarUsuario(String user){
        //ARCHIVO ORIGINAL APERTURA LECTURA
        try {
            File archivo = new File("usuarios.txt");
            FileReader leer = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(leer);
            
            File archivo2 = new File("usuarios2.txt");
            FileWriter escribir = new FileWriter(archivo2);
            BufferedWriter buffer2 = new BufferedWriter(escribir);

            String linea = buffer.readLine();
            while(linea != null){
                String [] vector = linea.split("#");
                if(!user.equals(vector[2])){
                    buffer2.write(vector[0] + "#");   
                    buffer2.write(vector[1] + "#");
                    buffer2.write(vector[2] + "#");
                    buffer2.write(vector[3] + "#");
                    buffer2.newLine();
                }
                linea = buffer.readLine();
            }
            buffer.close();
            buffer2.close();
            leer.close();
            escribir.close();
            archivo.delete();
            archivo2.renameTo(new File("usuarios.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actualizarUsuario(String user, usuario usu){
        try {
            File archivo = new File("usuarios.txt");
            FileReader leer = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(leer);       
            
            File archivo2 = new File("usuarios2.txt");
            FileWriter escribir = new FileWriter(archivo2);
            BufferedWriter buffer2 = new BufferedWriter(escribir);

            String linea = buffer.readLine();
            while(linea != null){
                String [] vector = linea.split("#");
                if(user.equals(vector[2])){
                    vector[0]= usu.getNombre();
                    vector[1]= usu.getApellido();
                    vector[2]= usu.getUser();
                    vector[3]= usu.getPass();

                    buffer2.write(vector[0] + "#");   
                    buffer2.write(vector[1] + "#");
                    buffer2.write(vector[2] + "#");
                    buffer2.write(vector[3] + "#");
                    buffer2.newLine();
                }else{
                    buffer2.write(vector[0] + "#");   
                    buffer2.write(vector[1] + "#");
                    buffer2.write(vector[2] + "#");
                    buffer2.write(vector[3] + "#");
                    buffer2.newLine();
                }
                linea = buffer.readLine();
            }
            buffer.close();
            buffer2.close();
            leer.close();
            escribir.close();
            archivo.delete();
            archivo2.renameTo(new File("usuarios.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

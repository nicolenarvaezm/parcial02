package negocio;
import java.io.*;
import java.util.ArrayList;

import servicio.producto;

public class productoBO {
    public void guardarProducto(producto nuevoProducto, String codigo, String nombre, String descripcion, String precio, String cantidad){
        nuevoProducto.setCodigo(codigo);
        nuevoProducto.setNombre(nombre);
        nuevoProducto.setDescripcion(descripcion);
        nuevoProducto.setPrecio(precio);
        nuevoProducto.setCantidad(cantidad);
    }

    public void cargarProducto(producto nuevProducto){
        try {
            File archivo = new File("productos.txt");
            FileWriter writer;
            if(archivo.exists()){
                writer = new FileWriter(archivo,true);
            }
            else{
                writer = new FileWriter(archivo);
            }
            
            BufferedWriter buffer = new BufferedWriter(writer);
            String linea = nuevProducto.getCodigo()+"#"+nuevProducto.getNombre()+"#"+nuevProducto.getDescripcion()+"#"+nuevProducto.getPrecio()+"#"+nuevProducto.getCantidad()+"#";
            buffer.write(linea);
            buffer.newLine();
            buffer.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<producto> verProductos(){
        ArrayList<producto> vec = new ArrayList<producto>();
        try{
            File archivo = new File("productos.txt");
            FileReader reader = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(reader);
            String linea = buffer.readLine();
            while(linea != null){
                String [] vector = linea.split("#");
                producto productos = new producto(null, null, null, null, null);
                productos.setCodigo(vector[0]);
                productos.setNombre(vector[1]);
                productos.setDescripcion(vector[2]);
                productos.setPrecio(vector[3]);
                productos.setCantidad(vector[4]);
                vec.add(productos);
                linea = buffer.readLine();
            }
            buffer.close();
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return vec;
    }

    public producto buscarProducto(String codigo){
        producto productoTemp = new producto(null,null,null,null, null);
        try {
            File archivo = new File("productos.txt");
            FileReader leer = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(leer);
            String linea = buffer.readLine();
            while(linea != null){
                String [] vector = linea.split("#");
                if(codigo.equalsIgnoreCase(vector[0])){
                    productoTemp.setCodigo(vector[0]);
                    productoTemp.setNombre(vector[1]);
                    productoTemp.setDescripcion(vector[2]);
                    productoTemp.setPrecio(vector[3]);
                    productoTemp.setCantidad(vector[4]);
                }
                linea = buffer.readLine();
            }
            buffer.close();
            leer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productoTemp;
    }

    public void eliminarProducto(String codigo){
        try {
            File archivo = new File("productos.txt");
            FileReader leer = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(leer);
            
            File archivo2 = new File("productos2.txt");
            FileWriter escribir = new FileWriter(archivo2);
            BufferedWriter buffer2 = new BufferedWriter(escribir);

            String linea = buffer.readLine();
            while(linea != null){
                String [] vector = linea.split("#");
                if(!codigo.equals(vector[0])){
                    buffer2.write(vector[0] + "#");   
                    buffer2.write(vector[1] + "#");
                    buffer2.write(vector[2] + "#");
                    buffer2.write(vector[3] + "#");
                    buffer2.write(vector[4] + "#");
                    buffer2.newLine();
                }
                linea = buffer.readLine();
            }
            buffer.close();
            buffer2.close();
            leer.close();
            escribir.close();
            archivo.delete();
            archivo2.renameTo(new File("productos.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProducto(String codigo, producto productoA){
        try {
            File archivo = new File("productos.txt");
            FileReader leer = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(leer);       
            
            File archivo2 = new File("productos2.txt");
            FileWriter escribir = new FileWriter(archivo2);
            BufferedWriter buffer2 = new BufferedWriter(escribir);

            String linea = buffer.readLine();
            while(linea != null){
                String [] vector = linea.split("#");
                if(codigo.equals(vector[0])){
                    vector[0]= productoA.getCodigo();
                    vector[1]= productoA.getNombre();
                    vector[2]= productoA.getDescripcion();
                    vector[3]= productoA.getPrecio();
                    vector[4]= productoA.getCantidad();

                    buffer2.write(vector[0] + "#");   
                    buffer2.write(vector[1] + "#");
                    buffer2.write(vector[2] + "#");
                    buffer2.write(vector[3] + "#");
                    buffer2.write(vector[4] + "#");
                    buffer2.newLine();
                }else{
                    buffer2.write(vector[0] + "#");   
                    buffer2.write(vector[1] + "#");
                    buffer2.write(vector[2] + "#");
                    buffer2.write(vector[3] + "#");
                    buffer2.write(vector[4] + "#");
                    buffer2.newLine();
                }
                linea = buffer.readLine();
            }
            buffer.close();
            buffer2.close();
            leer.close();
            escribir.close();
            archivo.delete();
            archivo2.renameTo(new File("produtos.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

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
}

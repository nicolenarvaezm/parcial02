package negocio;
import java.io.*;
import java.util.ArrayList;

import servicio.compras;

public class comprasBO {
    public void guardarCompra(compras comprar, String codigo, String nombreUsuario, String nombreProducto, String fechaCompra){
        comprar.setCodigo(codigo);
        comprar.setNombreUsuario(nombreUsuario);
        comprar.setNombreProducto(nombreProducto);
        comprar.setFechaCompra(fechaCompra);
    }

    public void cargarCompra(compras comprar){
        try {
            File archivo = new File("compras.txt");
            FileWriter writer;
            if(archivo.exists()){
                writer = new FileWriter(archivo,true);
            }
            else{
                writer = new FileWriter(archivo);
            }
            
            BufferedWriter buffer = new BufferedWriter(writer);
            String linea = comprar.getCodigo()+"#"+comprar.getNombreUsuario()+"#"+comprar.getNombreProducto()+"#"+comprar.getFechaCompra()+"#";
            buffer.write(linea);
            buffer.newLine();
            buffer.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<compras> verCompras(){
        ArrayList<compras> vec = new ArrayList<compras>();
        try{
            File archivo = new File("compras.txt");
            FileReader reader = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(reader);
            String linea = buffer.readLine();
            while(linea != null){
                String [] vector = linea.split("#");
                compras compra = new compras(null, null, null, null);
                compra.setCodigo(vector[0]);
                compra.setNombreUsuario(vector[1]);
                compra.setNombreProducto(vector[2]);
                compra.setFechaCompra(vector[3]);
                vec.add(compra);
                linea = buffer.readLine();
            }
            buffer.close();
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return vec;
    }

    public compras buscarCompra(String codigoCompra){
        compras compraTemp = new compras(null,null,null,null);
        try {
            File archivo = new File("compras.txt");
            FileReader leer = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(leer);
            String linea = buffer.readLine();
            while(linea != null){
                String [] vector = linea.split("#");
                if(codigoCompra.equalsIgnoreCase(vector[0])){
                    compraTemp.setCodigo(vector[0]);
                    compraTemp.setNombreUsuario(vector[1]);
                    compraTemp.setNombreProducto(vector[2]);
                    compraTemp.setFechaCompra(vector[3]);
                }
                linea = buffer.readLine();
            }
            buffer.close();
            leer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compraTemp;
    }

    public void eliminarCompra(String codigoCompra){
        //ARCHIVO ORIGINAL APERTURA LECTURA
        try {
            File archivo = new File("compras.txt");
            FileReader leer = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(leer);
            
            File archivo2 = new File("compras2.txt");
            FileWriter escribir = new FileWriter(archivo2);
            BufferedWriter buffer2 = new BufferedWriter(escribir);

            String linea = buffer.readLine();
            while(linea != null){
                String [] vector = linea.split("#");
                if(!codigoCompra.equals(vector[0])){
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
            archivo2.renameTo(new File("compras.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCompra(String codigoCompra, compras comprar){
        try {
            File archivo = new File("compras.txt");
            FileReader leer = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(leer);       
            
            File archivo2 = new File("compras2.txt");
            FileWriter escribir = new FileWriter(archivo2);
            BufferedWriter buffer2 = new BufferedWriter(escribir);

            String linea = buffer.readLine();
            while(linea != null){
                String [] vector = linea.split("#");
                if(codigoCompra.equals(vector[0])){
                    vector[0]= comprar.getCodigo();
                    vector[1]= comprar.getNombreUsuario();
                    vector[2]= comprar.getNombreProducto();
                    vector[3]= comprar.getFechaCompra();

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
            archivo2.renameTo(new File("compras.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.util.Scanner;

import negocio.productoBO;
import negocio.usuarioBO;
import servicio.producto;
import servicio.usuario;

public class App {
    public static void main(String[] args) throws Exception {
        ingresarUsuario();
        mostrarUsuarios();
        buscar();
        eliminarUsuarios();
        actualizarUsuario();
        guardarProducto();
        buscarProducto();
    }

    public static void ingresarUsuario(){
        usuario usu = new usuario(null, null, null, null);
        usuarioBO usuBO = new usuarioBO();
        Scanner teclado = new Scanner(System.in);
        System.out.println("INGRESAR USUARIOS? 1. Si    2. No");
        int opcion = teclado.nextInt();
        while(opcion == 1){
            System.out.println("Ingrese nombre: ");
            String nombre = teclado.next();
            System.out.println("Ingrese apellido: ");
            String apellido = teclado.next();
            System.out.println("Ingrese Username");
            String username = teclado.next();
            System.out.println("Ingrese Password");
            String password = teclado.next();
            usuBO.guardarUsuarios(usu, nombre, apellido, username, password);
            usuBO.cargarUsuario(usu);
            System.out.println("INGRESAR USUARIOS? 1. Si    2. No");
            opcion = teclado.nextInt();
        }
    }

    public static void mostrarUsuarios(){
        usuarioBO usuBO = new usuarioBO();
        if(usuBO.verUsuarios().isEmpty())
        {
            System.out.println("No hay usuarios registrados");
        }
        else{
            int i = 0;
            int tam = usuBO.verUsuarios().size();
            System.out.println("DATOS DEL ARCHIVO USUARIO");
            for(i=0; i<tam; i++){
                String nombre = usuBO.verUsuarios().get(i).getNombre();
                System.out.println("NOMBRE: " + nombre);
                String apellido = usuBO.verUsuarios().get(i).getApellido();
                System.out.println("APELLIDO: " + apellido);
                String user = usuBO.verUsuarios().get(i).getUser();
                System.out.println("USUARIO: " + user);
            }
        }
        
    }

    public static void buscar(){
        usuario usu = new usuario(null,null,null,null);
        usuarioBO usuBO = new usuarioBO();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese usuario a buscar: ");
        String user = teclado.nextLine();
        usu = usuBO.buscarUsuario(user);
        if(usu.getNombre() != null){
            System.out.println("EL USUARIO BUSCADO ES: ");
            System.out.println(usu.getNombre());
            System.out.println(usu.getApellido());
            System.out.println(usu.getUser());
            System.out.println(usu.getPass());
        }
        else{
            System.out.println("DATO NO ENCONTRADO");
        }
    }

    public static void eliminarUsuarios(){
        usuarioBO usuBO = new usuarioBO();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese usuario a eliminar: ");
        String user = teclado.nextLine();
        usuBO.eliminarUsuario(user);
        mostrarUsuarios();
    }

    public static void actualizarUsuario(){
        usuarioBO usuBO = new usuarioBO();
        usuario usu = new usuario(null, null, null, null);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese usuario para actualizar: ");
        String usuarioActualizar = teclado.nextLine();
        System.out.println("Ingrese nombre: ");
        String nombre = teclado.next();
        System.out.println("Ingrese apellido: ");
        String apellido = teclado.next();
        System.out.println("Ingrese Username");
        String username = teclado.next();
        System.out.println("Ingrese Password");
        String password = teclado.next();
        usu.setNombre(nombre);
        usu.setApellido(apellido);
        usu.setUser(username);
        usu.setPass(password);
        
        usuBO.actualizarUsuario(usuarioActualizar, usu);
    }

    public static void guardarProducto(){
        productoBO productoBO = new productoBO();
        producto nuevoP= new producto(null, null, null, null, null);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Desea ingresar un nuevo producto? 1.Si  2.No");
        int opcion = teclado.nextInt();
        while(opcion ==1){
            System.out.println("Codigo del producto: ");
            String codigo = teclado.next();
            System.out.println("Nombre del producto: ");
            String nombre = teclado.next();
            System.out.println("Descripcion del producto: ");
            String descripcion = teclado.next();
            System.out.println("Precio del producto: ");
            String precio = teclado.next();
            System.out.println("Cantidad del producto: ");
            String cantidad = teclado.next();
            productoBO.guardarProducto(nuevoP, codigo, nombre, descripcion, precio, cantidad);
            System.out.println("Desea ingresar un nuevo producto? 1.Si  2.No");
            opcion = teclado.nextInt();
        }
    }

    public static void buscarProducto(){
        producto producto = new producto(null,null,null,null, null);
        productoBO productoBO = new productoBO();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese producto a buscar: ");
        String codigo = teclado.nextLine();
        producto = productoBO.buscarProducto(codigo);
        if(producto.getCodigo() != null){
            System.out.println("EL PRODUCTO BUSCADO ES: ");
            System.out.println(producto.getCodigo());
            System.out.println(producto.getNombre());
            System.out.println(producto.getDescripcion());
            System.out.println(producto.getPrecio());
            System.out.println(producto.getCantidad());
        }
        else{
            System.out.println("PRODUCTO NO ENCONTRADO");
        }
    }
}

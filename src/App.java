import java.util.Scanner;

import negocio.usuarioBO;
import servicio.usuario;

public class App {
    public static void main(String[] args) throws Exception {
        ingresarUsuario();
        mostrarUsuarios();
        buscar();
        eliminarUsuarios();
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
}

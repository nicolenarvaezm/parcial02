import java.util.Scanner;

import negocio.productoBO;
import negocio.usuarioBO;
import servicio.producto;
import servicio.usuario;
import servicio.compras;
import negocio.comprasBO;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Que opción desea realizar? 1.Usuarios   2.Productos    3.Compras    4.Salir");
        int opcion = teclado.nextInt();
        while(opcion < 4){
            if(opcion==1){
                ingresarUsuario();
                mostrarUsuarios();
                buscar();
                eliminarUsuarios();
                actualizarUsuario();
                System.out.println("Que opción desea realizar? 1.Usuarios   2.Productos    3.Compras    4.Salir");
                opcion = teclado.nextInt();
            }else if(opcion ==2){
                guardarProducto();
                buscarProducto();
                mostrarProductos();
                eliminarProducto();
                actualizarProducto();
                System.out.println("Que opción desea realizar? 1.Usuarios   2.Productos    3.Compras    4.Salir");
                opcion = teclado.nextInt();
            }else{
                ingresarCompra();
                mostrarCompra();
                buscarCompra();
                eliminarCompra();
                actualizarCompra();
                System.out.println("Que opción desea realizar? 1.Usuarios   2.Productos    3.Compras    4.Salir");
                opcion = teclado.nextInt();
            }
        }
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
            productoBO.cargarProducto(nuevoP);
            System.out.println("Desea ingresar un nuevo producto? 1.Si  2.No");
            opcion = teclado.nextInt();
        }
    }

    public static void mostrarProductos(){
        productoBO productosBO = new productoBO();
        if(productosBO.verProductos().isEmpty())
        {
            System.out.println("No hay productos registrados");
        }
        else{
            int i = 0;
            int tam = productosBO.verProductos().size();
            System.out.println("DATOS DEL ARCHIVO PRODUCTOS");
            for(i=0; i<tam; i++){
                String codigo = productosBO.verProductos().get(i).getCodigo();
                System.out.println("CODIGO: " + codigo);
                String nombre = productosBO.verProductos().get(i).getNombre();
                System.out.println("NOMBRE: " + nombre);
                String precio = productosBO.verProductos().get(i).getPrecio();
                System.out.println("PRECIO: " + precio);
                String cantidad = productosBO.verProductos().get(i).getCantidad();
                System.out.println("PRECIO: " + cantidad);
            }
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
            System.out.println("Codigo: "+producto.getCodigo());
            System.out.println("Nombre: "+producto.getNombre());
            System.out.println("Descripcion: "+producto.getDescripcion());
            System.out.println("Precio: "+producto.getPrecio());
            System.out.println("Cantidad: "+producto.getCantidad());
        }
        else{
            System.out.println("PRODUCTO NO ENCONTRADO");
        }

    }

    public static void eliminarProducto(){
        productoBO productoBO = new productoBO();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese codigo del producto a eliminar: ");
        String producto = teclado.nextLine();
        productoBO.eliminarProducto(producto);
    }

    public static void actualizarProducto(){
        productoBO productoBO = new productoBO();
        producto producto = new producto(null, null, null, null, null);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese codigo del producto para actualizar: ");
        String productoActualizar = teclado.nextLine();
        System.out.println("Ingrese codigo: ");
        String codigo = teclado.next();
        System.out.println("Ingrese nombre: ");
        String nombre = teclado.next();
        System.out.println("Ingrese descripcion: ");
        String descripcion = teclado.next();
        System.out.println("Ingrese precio: ");
        String precio = teclado.next();
        System.out.println("Ingrese cantidad: ");
        String cantidad = teclado.next();
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        
        productoBO.actualizarProducto(productoActualizar, producto);
    }

    public static void ingresarCompra(){
        compras comprar = new compras(null, null, null, null);
        comprasBO comprarBO = new comprasBO();
        Scanner teclado = new Scanner(System.in);
        System.out.println("INGRESAR COMPRAS? 1. Si    2. No");
        int opcion = teclado.nextInt();
        while(opcion == 1){
            System.out.println("Ingrese codigo: ");
            String codigo = teclado.next();
            System.out.println("Ingrese nombre de usuario: ");
            String nombreUsuario = teclado.next();
            System.out.println("Ingrese nombre del producto: ");
            String nombreProducto = teclado.next();
            System.out.println("Ingrese fecha de compra: ");
            String fechaCompra = teclado.next();
            comprarBO.guardarCompra(comprar, codigo, nombreUsuario, nombreProducto, fechaCompra);
            comprarBO.cargarCompra(comprar);
            System.out.println("INGRESAR COMPRAS? 1. Si    2. No");
            opcion = teclado.nextInt();
        }
    }

    public static void mostrarCompra(){
        comprasBO compraBO = new comprasBO();
        if(compraBO.verCompras().isEmpty())
        {
            System.out.println("No hay compras registrados");
        }
        else{
            int i = 0;
            int tam = compraBO.verCompras().size();
            System.out.println("DATOS DEL ARCHIVO COMPRAS");
            for(i=0; i<tam; i++){
                String codigo = compraBO.verCompras().get(i).getCodigo();
                System.out.println("CODIGO: " + codigo);
                String nombreProducto = compraBO.verCompras().get(i).getNombreProducto();
                System.out.println("PRODUCTO: " + nombreProducto);
                String fechaCompra = compraBO.verCompras().get(i).getFechaCompra();
                System.out.println("FECHA COMPRA: " + fechaCompra);
            }
        }
        
    }

    public static void buscarCompra(){
        compras comprar = new compras(null,null,null,null);
        comprasBO comprarBO = new comprasBO();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese codigo para buscar compra: ");
        String codigoCompra = teclado.nextLine();
        comprar = comprarBO.buscarCompra(codigoCompra);
        if(comprar.getCodigo() != null){
            System.out.println("LA COMPRA BUSCADA ES: ");
            System.out.println(comprar.getCodigo());
            System.out.println(comprar.getNombreUsuario());
            System.out.println(comprar.getNombreProducto());
            System.out.println(comprar.getFechaCompra());
        }
        else{
            System.out.println("COMPRA NO ENCONTRADA");
        }
    }

    public static void eliminarCompra(){
        comprasBO comprarBO = new comprasBO();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese codigo de la compra a eliminar: ");
        String codigoCompra = teclado.nextLine();
        comprarBO.eliminarCompra(codigoCompra);
    }

    public static void actualizarCompra(){
        comprasBO comprarBO = new comprasBO();
        compras compra = new compras(null, null, null, null);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese codigo para actualizar compra: ");
        String codigoActualizar = teclado.nextLine();
        System.out.println("Ingrese codigo: ");
        String codigo = teclado.next();
        System.out.println("Ingrese nombre del usuario: ");
        String nombreUsuario = teclado.next();
        System.out.println("Ingrese nombre del producto: ");
        String nombreProducto = teclado.next();
        System.out.println("Ingrese fecha de compra: ");
        String fechaCompra = teclado.next();
        compra.setCodigo(codigo);
        compra.setNombreUsuario(nombreUsuario);
        compra.setNombreProducto(nombreProducto);
        compra.setFechaCompra(fechaCompra);

        comprarBO.actualizarCompra(codigoActualizar, compra);
    }
}

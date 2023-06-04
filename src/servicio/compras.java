package servicio;

public class compras {
    private String codigo;
    private String nombreUsuario;
    private String nombreProducto;
    private String fechaCompra;
    public compras(String codigo, String nombreUsuario, String nombreProducto, String fechaCompra) {
        this.codigo = codigo;
        this.nombreUsuario = nombreUsuario;
        this.nombreProducto = nombreProducto;
        this.fechaCompra = fechaCompra;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public String getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}



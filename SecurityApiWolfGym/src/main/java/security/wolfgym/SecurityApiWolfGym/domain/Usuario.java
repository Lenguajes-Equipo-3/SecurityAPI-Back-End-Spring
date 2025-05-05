package security.wolfgym.SecurityApiWolfGym.domain;


public class Usuario {

    private int usuarioId;
    private String usuario;
    private String contrasena;
    private Empleado empleado;
    private Rol rol; // único rol asociado

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(int usuarioId, String usuario, String contrasena, Empleado empleado, Rol rol) {
        this.usuarioId = usuarioId;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.empleado = empleado;
        this.rol = rol;
    }

    // Getters y setters
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}

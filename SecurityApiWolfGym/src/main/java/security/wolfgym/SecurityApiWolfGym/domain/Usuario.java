package security.wolfgym.SecurityApiWolfGym.domain;

import java.util.List;

public class Usuario {

    private int usuarioId;
    private String usuario;
    private String contrasena;
    private Empleado empleado;
    private List<Rol> roles; // único rol asociado

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(int usuarioId, String usuario, String contrasena, Empleado empleado) {
        this.usuarioId = usuarioId;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.empleado = empleado;
      

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
    public List<Rol> getRoles() {
        return roles;
    }
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}

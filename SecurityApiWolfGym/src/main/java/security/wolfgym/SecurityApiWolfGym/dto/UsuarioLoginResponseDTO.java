package security.wolfgym.SecurityApiWolfGym.dto;

import java.util.List;

public class UsuarioLoginResponseDTO {
    private String usuario;
    private String nombreEmpleado;
    private String apellidosEmpleado;
    private List<String> roles;
    private String token;

    public UsuarioLoginResponseDTO() {}

    public UsuarioLoginResponseDTO(String usuario, String nombreEmpleado, String apellidosEmpleado, List<String> roles, String token) {
        this.usuario = usuario;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidosEmpleado = apellidosEmpleado;
        this.roles = roles;
        this.token = token;
    }

    // Getters y setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidosEmpleado() {
        return apellidosEmpleado;
    }

    public void setApellidosEmpleado(String apellidosEmpleado) {
        this.apellidosEmpleado = apellidosEmpleado;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

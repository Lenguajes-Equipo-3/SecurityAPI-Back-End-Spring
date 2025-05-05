package security.wolfgym.SecurityApiWolfGym.dto;

public class UsuarioLoginResponseDTO {
    private String usuario;
    private String nombreEmpleado;
    private String apellidosEmpleado;
    private String rol;
    private String token;

    public UsuarioLoginResponseDTO() {}

    public UsuarioLoginResponseDTO(String usuario, String nombreEmpleado, String apellidosEmpleado, String rol, String token) {
        this.usuario = usuario;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidosEmpleado = apellidosEmpleado;
        this.rol = rol;
        this.token = token;
    }

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

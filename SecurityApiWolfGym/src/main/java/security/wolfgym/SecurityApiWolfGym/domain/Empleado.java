package security.wolfgym.SecurityApiWolfGym.domain;



	public class Empleado {

	    private int idEmpleado;
	    private String nombreEmpleado;
	    private String apellidosEmpleado;

	    public Empleado() {
	    }

	    public Empleado(int idEmpleado, String nombreEmpleado, String apellidosEmpleado) {
	        this.idEmpleado = idEmpleado;
	        this.nombreEmpleado = nombreEmpleado;
	        this.apellidosEmpleado = apellidosEmpleado;
	    }

	    public int getIdEmpleado() {
	        return idEmpleado;
	    }

	    public void setIdEmpleado(int idEmpleado) {
	        this.idEmpleado = idEmpleado;
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
	}

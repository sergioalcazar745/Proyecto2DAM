
public class Administrador {
	String usuario="admin", contraseña="admin2020";

	Administrador() {
		
	}
	
	Administrador(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	protected String getUsuario() {
		return usuario;
	}

	protected void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	protected String getContraseña() {
		return contraseña;
	}

	protected void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}

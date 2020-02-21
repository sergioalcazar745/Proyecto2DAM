
public class Empleado extends Persona {
	protected String inicio_contrato, turno, jornada, estado;
	protected double hora;
	
	
	Empleado() {
	}

	Empleado(String estado, String tipo, String ID, String DNI, String nombre, String apellidos, String fecha_nac, String domicilio, String telefono, String inicio_contrato, String turno, String jornada, double hora) {
		super(tipo, ID, DNI, nombre, apellidos, fecha_nac, domicilio, telefono);
		this.estado = estado;
		this.inicio_contrato = inicio_contrato;
		this.turno = turno;
		this.jornada = jornada;
		this.hora=hora;
	}	

	protected String getInicio_contrato() {
		return inicio_contrato;
	}

	protected void setInicio_contrato(String inicio_contrato) {
		this.inicio_contrato = inicio_contrato;
	}

	protected String getTurno() {
		return turno;
	}

	protected void setTurno(String turno) {
		this.turno = turno;
	}
	
	protected String getJornada() {
		return jornada;
	}

	protected void setJornada(String jornada) {
		this.jornada = jornada;
	}

	protected double getHora() {
		return hora;
	}

	protected void setHora(double hora) {
		this.hora = hora;
	}

	protected String getEstado() {
		return estado;
	}

	protected void setEstado(String estado) {
		this.estado = estado;
	}

	public String toString () {		
		return "Estado: "+estado+"\nID: "+ID+"\nDNI: "+DNI+"\nNombre: "+nombre+"\nApellidos: "+apellidos+"\nFecha de nacimiento: "+fecha_nac+"\nDomicilio: "+domicilio+"\nTelefono: "+telefono+"\nInicio de contrato: "+inicio_contrato+"\nHoras semanales: "+hora+"\nJornada: "+jornada+"\nTurno: "+turno+"";
	}
}

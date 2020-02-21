
public class Cliente extends Persona{
	protected Cliente ce;
	protected String anomalia;
	protected double ojo_der, ojo_izq;
	
	Cliente() {
	}

	Cliente(String tipo, String ID, String DNI, String nombre, String apellidos, String fecha_nac, String domicilio, String telefono, String anomalia, double ojo_izq, double ojo_der) {
		super(tipo, ID, DNI, nombre, apellidos, fecha_nac, domicilio, telefono);
		this.ojo_der = ojo_der;
		this.anomalia = anomalia;
		this.ojo_izq = ojo_izq;
	}
	
	protected String getAnomalia() {
		return anomalia;
	}

	protected void setAnomalia(String anomalia) {
		this.anomalia = anomalia;
	}

	protected double getOjo_der() {
		return ojo_der;
	}

	protected void setOjo_der(double ojo_der) {
		this.ojo_der = ojo_der;
	}

	protected double getOjo_izq() {
		return ojo_izq;
	}

	protected void setOjo_izq(double ojo_izq) {
		this.ojo_izq = ojo_izq;
	}
	
	protected Cliente getCe() {
		return ce;
	}

	protected void setCe(Cliente ce) {
		this.ce = ce;
	}

	public String toString() {
		String mostrar = "ID: " +ID+"\nDNI: "+DNI+"\nNombre: " + nombre + "\nApellidos: " + apellidos + "\nFecha de nacimiento:" + fecha_nac+"\nDomicilio: " + domicilio + "\nTel\u00e9fono: "+ telefono +  "\nDioptria ojo derecho:" + ojo_der+ "\nDioptria ojo izquierdo:" + ojo_izq+ "\nAnomalias:" + anomalia;
		return mostrar;
	}

	protected boolean comprobarDioptrias(double ojo) {
		 boolean valido=true;
		 
		 
		 if(ojo >= -3 && ojo < 0) {
			 System.out.println("Tiene miopía leve");
			 ojo=10;
		 	}else if(ojo <= -3 && ojo >= -6) {
		 		System.out.println("Tiene miopía moderada");
		 		} else if(ojo <= -6 && ojo >= -8) {
		 			System.out.println("Tiene miopía grave");
		 			} else if(ojo >= 5) {
		 				System.out.println("Tiene hipermetropía alta");
		 				} else if(ojo >= 2.25 && ojo < 5) {
		 					System.out.println("Tiene hipermetropia media");
		 					} else if(ojo > 0 && ojo <= 2) {
		 						System.out.println("Tiene hipermetropia baja");
		 						} else if(ojo == 0) {
		 							System.out.println("No tiene nada");
		 							}else {
		 								System.out.println("Doptria no concluida realizar mas pruebas.");
		 							}
		 return valido;		 
	}
}

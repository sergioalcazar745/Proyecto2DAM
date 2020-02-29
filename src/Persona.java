
abstract class Persona {
	protected String Tipo, ID, DNI, nombre, apellidos, fecha_nac, domicilio, telefono;
	
	Persona() {
		
	}	

	public Persona(String tipo, String iD, String dNI, String nombre, String apellidos, String fecha_nac, String domicilio, String telefono) {
		Tipo = tipo;
		ID = iD;
		DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nac = fecha_nac;
		this.domicilio = domicilio;
		this.telefono = telefono;
	}

	protected String getTipo() {
		return Tipo;
	}

	protected void setTipo(String tipo) {
		Tipo = tipo;
	}

	protected String getFecha_nac() {
		return fecha_nac;
	}

	protected void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	protected String getID() {
		return ID;
	}

	protected void setID(String iD) {
		this.ID = ID;
	}

	protected String getDNI() {
		return DNI;
	}

	protected void setDNI(String dNI) {
		DNI = dNI;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}

	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	protected String getEdad() {
		return fecha_nac;
	}

	protected void setEdad(String edad) {
		this.fecha_nac = edad;
	}

	protected String getDomicilio() {
		return domicilio;
	}

	protected void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	protected String getTelefono() {
		return telefono;
	}

	protected void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String toString () {
		return "ID: "+ID+"\nDNI: "+DNI+"\nNombre: "+nombre+"\nApellidos: "+apellidos+"\nFecha de nacimiento: "+fecha_nac+"\nDomicilio: "+domicilio+"\nTelefono: "+telefono+"";
	}
	
	protected boolean validar(String dni) {
		boolean valido = false;
        int caracter= 0, miDNI = 0, resto = 0, i= 0;
        char letra = ' ';
        char[] asigLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
 
 
        if(dni.length() == 9 && Character.isLetter(dni.charAt(8))) {

        	do {
                caracter = dni.codePointAt(i);
                valido = (caracter > 47 && caracter < 58);
                i++;
            } while(i < dni.length() - 1 && valido);

        }
 
        if(valido) {
            letra = Character.toUpperCase(dni.charAt(8));
            miDNI = Integer.parseInt(dni.substring(0,8));
            resto = miDNI % 23;
            valido = (letra == asigLetra[resto]);
        }
        return valido;
	}
	
	protected boolean comprobarTelefono(String telefono) {
		
		boolean valido=true, letras=true;
		int miNumero;
		
		if(telefono.matches("[0-9]+")) {
			letras=true;
		}else {
			letras=false;
		}
		
		if(letras==true) {
			
			miNumero = Integer.parseInt(telefono.substring(0,1));
			
			if (telefono.length()==9 && (miNumero==6 || miNumero==7)) {
				valido=true;
			}else {
				valido=false;
			}		
			
		}else if(letras==false) {
			valido=false;
		}
		
		return valido;
	}
	
	protected boolean comprobarFecha(String fecha) {
		boolean valido=true;
		
		int diaMes[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		
		if(fecha.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")) {
			int dia= Integer.parseInt(fecha.substring(0,2));
			int mes= Integer.parseInt(fecha.substring(3,5));
			int ano= Integer.parseInt(fecha.substring(6,10));
			
			if(dia>28 && mes==2) {
				if(((ano%400==0) || (ano%100!=0)) && (ano%4==0)) {
					valido=true;
				}else {
					System.out.println("Incorrecto, el año no es bisiesto");
				}
			}else {
				valido=dia>0 && dia<=diaMes[mes-1];
			}
			
			if(ano<1900 && ano>2020) {
				valido=false;
			}else {
				valido=true;
			}
			
			if(mes<1 && mes>12) {
				valido=false;
			}else {
				valido=true;
			}
			
		}else {
			valido=false;
		}
		
		return valido;
	}
	
	protected boolean comprobarMayoriaEdad(String nacimiento, String contrato) {
		boolean valido=true;
		
		String año_nacimiento=nacimiento.substring(6,10);
		String año_contrato=contrato.substring(6,10);
		
		int año_nac=Integer.parseInt(año_nacimiento);
		int año_con=Integer.parseInt(año_contrato);
		
		if(año_con-año_nac<18) {
			System.out.println("Debe ser mayor de edad");
			System.out.println("-----------------------");
			valido=false;
		}else {
			valido=true;
		}
		
		return valido;
		
	}
	
	protected boolean comprobarHoras(String s) {
		boolean valido=true;
		
		if (s.matches("-?[0-9]+")) {
			valido=true;
		}else {
			valido=false;
		}
		
		if (valido==true) {
			int numero=Integer.parseInt(s);
			
			if (numero>=20 && numero<=40) {
				valido=true;
			}else {
				valido=false;
			}
		}
		
		return valido;
	}
	
	protected boolean comprobarNumero(String num) {
		boolean valido=true;
		
		if (num.matches("-?[0-9]+")) {
			valido=true;
		}else {
			valido=false;
		}
		
		return valido;
	}
	
	protected boolean comprobarCaracter(String n) {
		boolean valido=true;
		
		if (n.matches("[a-zA-Z]+")) {
			valido=true;
		}else {
			valido=false;
		}
		
		return valido;
	}
}

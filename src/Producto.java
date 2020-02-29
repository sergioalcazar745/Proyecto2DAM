
abstract class Producto {
	String nombre, ID;
	double precio_compra, precio_venta;
	int cantidad, cantidad_comprada;
	
	Producto() {
		
	}

	Producto(String ID, String nombre, double precio_compra, double precio_venta, int cantidad, int cantidad_comprada) {
		this.ID = ID;
		this.nombre = nombre;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.cantidad = cantidad;
		this.cantidad_comprada = cantidad_comprada;
	}	

	protected String getID() {
		return ID;
	}

	protected void setID(String iD) {
		ID = iD;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected double getPrecio_compra() {
		return precio_compra;
	}

	protected void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}

	protected double getPrecio_venta() {
		return precio_venta;
	}

	protected void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	protected int getCantidad() {
		return cantidad;
	}

	protected void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	protected int getCantidad_comprada() {
		return cantidad_comprada;
	}

	protected void setCantidad_comprada(int cantidad_comprada) {
		this.cantidad_comprada = cantidad_comprada;
	}

	public String toString () {
		return "ID: "+ID+"\nNombre: "+nombre+"\nCantidad: "+cantidad+"\nPrecio de venta: "+precio_venta+"\nPrecio de compra: "+precio_compra+"";
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
	
	public boolean esDecimal(String cad){
		boolean hayPunto=true, valido=true;
	    int NDigitos = 0;
	    int posicionDelPunto = 0;
	    NDigitos = cad.length();
	    //boolean hayPunto=false;
	    StringBuffer parteEntera = new StringBuffer();
	    StringBuffer parteDecimal = new StringBuffer();
	    int i=0;
	 
	    for( i=0;i<cad.length(); i++ )                	      
	        if ( cad.charAt(i) == '.'){                          
	            hayPunto=true;
	        }
			if(hayPunto){                                       
	            posicionDelPunto=cad.indexOf('.');               
	        }
	        else{
	            valido=false;;                                      
	        }
	        if( posicionDelPunto == cad.length()-1 || posicionDelPunto== 0){    
	            valido=false;
	        }
	    for( i=0;i<posicionDelPunto; i++ ){
	        parteEntera.append(cad.charAt(i)) ;                 
	 
	    }
	 
	 
	    for(i = 0; i<parteEntera.length(); i++)
	        if( ! Character.isDigit(parteEntera.charAt(i)) ){    
	            valido=false;
	        }
	    for( i=posicionDelPunto+1;i<cad.length(); i++ )
	        parteDecimal.append(cad.charAt(i));                 
	 
	 
	    for(i = 0; i<parteDecimal.length(); i++)
	        if( ! Character.isDigit(parteDecimal.charAt(i))){   
	            valido=false;                                       
	        }
	    int cuantosEntera = parteEntera.length();
	    int cuantosDecimal = parteDecimal.length();
	 
	    return valido;                                        
	 
	}
}

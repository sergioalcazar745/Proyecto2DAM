
abstract class Producto {
	String nombre, ID;
	double precio_compra, precio_venta;
	int cantidad;
	
	Producto() {
		
	}

	Producto(String ID, String nombre, double precio_compra, double precio_venta, int cantidad) {
		this.ID = ID;
		this.nombre = nombre;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.cantidad = cantidad;
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
}

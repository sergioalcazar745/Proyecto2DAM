
public class Lentillas extends Producto{
	protected String tipo;
	
	Lentillas(){
		
	}

	public Lentillas(String nombre, String ID, double precio_compra, double precio_venta, int cantidad, int cantidad_comprada, String tipo) {
		super(nombre, ID, precio_compra, precio_venta, cantidad, cantidad_comprada);
		this.tipo = tipo;
	}

	protected String getTipo() {
		return tipo;
	}

	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString () {
		return "ID: "+ID+"\nNombre: "+nombre+"\nCantidad: "+cantidad+"\nCantidad comprada: "+cantidad_comprada+"\nPrecio de venta: "+precio_venta+"\nPrecio de compra: "+precio_compra+"\nTipo: "+tipo+"";
	}
}

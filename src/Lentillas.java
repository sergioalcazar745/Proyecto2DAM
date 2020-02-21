
public class Lentillas extends Producto{
	protected Lentillas lt;
	protected String tipo;
	
	Lentillas(){
		
	}

	public Lentillas(String ID, String nombre, double precio_compra, double precio_venta, int cantidad, String tipo) {
		super(nombre, ID, precio_compra, precio_venta, cantidad);
		this.tipo = tipo;
	}
	
	protected Lentillas getLt() {
		return lt;
	}

	protected void setCe(Lentillas lt) {
		this.lt = lt;
	}

	protected String getTipo() {
		return tipo;
	}

	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString () {
		return "ID: "+ID+"\nNombre: "+nombre+"\nCantidad: "+cantidad+"\nPrecio de venta: "+precio_venta+"\nPrecio de compra: "+precio_compra+"\nTipo: "+tipo+"";
	}
}


public class Gafas extends Producto{
	protected String tipo_montura, tipo_cristales;

	Gafas() {
		
	}

	public Gafas(String nombre, String ID, double precio_compra, double precio_venta, int cantidad, int cantidad_comprada, String tipo_montura, String cristales) {
		super(nombre, ID, precio_compra, precio_venta, cantidad, cantidad_comprada);
		this.tipo_montura = tipo_montura;
		this.tipo_cristales = cristales;
	}

	protected String getTipo_montura() {
		return tipo_montura;
	}

	protected void setTipo_montura(String tipo_montura) {
		this.tipo_montura = tipo_montura;
	}

	protected String getTipo_cristales() {
		return tipo_cristales;
	}

	protected void setTipo_cristales(String tipo_cristales) {
		this.tipo_cristales = tipo_cristales;
	}

	public String toString () {
		return "ID: "+ID+"\nNombre: "+nombre+"\nCantidad: "+cantidad+"\nCantidad comprada: "+cantidad_comprada+"\nPrecio de venta: "+precio_venta+"\nPrecio de compra: "+precio_compra+"\nMarca de montura: "+tipo_montura+"\nMarca de cristales: "+tipo_cristales+"\n\n";
	}
}

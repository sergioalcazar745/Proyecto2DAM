import java.util.ArrayList;

public class Pedidos {
	protected Cliente cl;
	protected ArrayList <Producto> listaProductos=new ArrayList <Producto>();
	protected ArrayList <Pedidos> listaPedidos=new ArrayList <Pedidos>();
	protected String fecha, precio;
	
	Pedidos(){
		
	}

	public Pedidos(Cliente cl, ArrayList<Producto> listaProductos, ArrayList<Pedidos> listaPedidos, String fecha) {
		this.cl = cl;
		this.listaProductos = listaProductos;
		this.listaPedidos = listaPedidos;
		this.fecha = fecha;
	}

	public Pedidos(Cliente cl, ArrayList<Producto> listaProductos, String fecha, String precio) {
		this.cl = cl;
		this.listaProductos = listaProductos;
		this.fecha = fecha;
		this.precio = precio;
	}

	protected Cliente getCl() {
		return cl;
	}

	protected void setCl(Cliente cl) {
		this.cl = cl;
	}

	protected ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	protected void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	protected ArrayList<Pedidos> getListaPedidos() {
		return listaPedidos;
	}

	protected void setListaPedidos(ArrayList<Pedidos> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	protected String getFecha() {
		return fecha;
	}

	protected void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	protected String getPrecio() {
		return precio;
	}

	protected void setPrecio(String precio) {
		this.precio = precio;
	}

	public String toString() {
		String mostrar = "Lista de pedidos "+listaPedidos+"";
		return mostrar;
	}
}


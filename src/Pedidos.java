import java.util.ArrayList;
import java.util.Iterator;

public class Pedidos {
	protected Cliente cl;
	protected ArrayList <Producto> listaProductos=new ArrayList <Producto>();
	protected String fecha, precio;
	
	Pedidos(){
		
	}

	public Pedidos(Cliente cl, ArrayList<Producto> listaProductos, ArrayList<Pedidos> listaPedidos, String fecha) {
		this.cl = cl;
		this.listaProductos = listaProductos;
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
	
	public String toString (ArrayList <Pedidos> listaPedidos) {
		boolean control=true;
		String resultado="";
		
		Iterator <Pedidos> it=listaPedidos.iterator();
		control=true;
		
		System.out.println("");
		System.out.println("--------------Resumen del Pedido------------");		
		while(it.hasNext() && control) {
			
			Pedidos ped=it.next();
			
			System.out.println("Cliente: ");
			System.out.println("");
			System.out.println(ped.getCl());
			System.out.println("");
			System.out.println("Productos:	");
			System.out.println("");
			System.out.println(ped.getListaProductos());
			System.out.println("-----");
			System.out.println("");
			System.out.println("Precio: "+ped.getFecha());
			System.out.println("");
			System.out.println("Precio: "+ped.getPrecio());
		}
		
		return resultado;
	}
}


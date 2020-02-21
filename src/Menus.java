import java.util.Scanner;

public class Menus {	
	String opcion;

	EntradaSalida es=new EntradaSalida();
	Metodos mt=new Metodos();
	
	protected void menuIncio() {
		
			System.out.println("");
			System.out.println("-------------Identificacion------------");
			System.out.println("");
			System.out.println("Pulsa 1 si eres empleado\nPulsa 2 si eres administrador\nPulsa 3 si quieres salir");
			System.out.println("");
			System.out.print("Opcion: ");			
	}
	
	protected void mostrarMenuAdministrador() {	
			
			System.out.println("");
			System.out.println("_______________Bienvenid@_______________");
			System.out.println("");
			System.out.println("1) Crear un empleado.");
			System.out.println("2) Modificar datos de un empleado.");
			System.out.println("3) Dar de baja a empleado");
			System.out.println("4) Listado de empleados.");
			System.out.println("5) Stock.");
			System.out.println("6) Volver");
			System.out.println("");
			System.out.print("Introduce el n\u00famero de tu opci\u00f3n: ");
			
	}
	
	protected void mostrarMenuEmpleado() {
		
			System.out.println("");
			System.out.println("_______________Bienvenid@_____________");
			System.out.println("");
			System.out.println("1) Crear un cliente.");
			System.out.println("2. Dar de baja a cliente");
			System.out.println("3) Buscar y modificar datos de un cliente");
			System.out.println("4) Listado de clientes.");
			System.out.println("5) Realizar pedidos");
			System.out.println("6) Volver");
			System.out.println("");
			System.out.print("Introduce el n\u00famero de tu opci\u00f3n: ");
	}
	
	protected void menuModificarDato() {
		
		System.out.println("");
		System.out.println("--------------Menu modificacion datos empleado----------");
		System.out.println("");
		System.out.println("Dime que dato quieres modificar");
		System.out.println("");
		System.out.println("1. Nombre");
		System.out.println("2. Apellidos");
		System.out.println("3. Domicilio");
		System.out.println("4. Telefono movil");
		System.out.println("5. Inicio de contrato");
		System.out.println("6. Horas semanales");
		System.out.println("7. Turno");
		System.out.println("8. Volver");
		System.out.println("");
		System.out.print("Introduce el n\u00famero de tu opci\u00f3n: ");
	}
	
	protected void modificarCliente() {
		
		System.out.println("Puedes modificar:");
		System.out.println("1. Nombre");
		System.out.println("2. Apellidos");
		System.out.println("3. Telefono");
		System.out.println("4. Domicilio");
	}
	
	protected void menuStock() {
		
		System.out.println("");
		System.out.println("-------------Inventario------------");
		System.out.println("");
		System.out.println("1) Añadir producto");
		System.out.println("2) Modificar producto o reponer producto");
		System.out.println("3) Borrar producto");
		System.out.println("4) Mostrar lista productos");
		System.out.println("5) Volver");
		System.out.println("");
		System.out.print("Introduce el n\u00famero de tu opci\u00f3n: ");
	}
	
	protected void menuModificarProducto() {
		
		System.out.println("¿Que quieres modificar?");
		System.out.println("");
		System.out.println("1. Nombre");
		System.out.println("2. Precio de compra");
		System.out.println("3. Precio de venta");
		System.out.println("4. Cantidad");
		System.out.println("5. Volver");
		System.out.println("");
		System.out.print("Introduce el n\\u00famero de tu opci\\u00f3n: ");
	}
	
	protected void menuClientes() {
		
		 System.out.println("");
		 System.out.println("Tienes dos opciones:");
		 System.out.println("");
		 System.out.println("1. Buscar un cliente por su nombre");
		 System.out.println("2. Ver la lista de todos los clientes");
		 System.out.println("");
		 System.out.print("Introduce tu eleccion: ");		
	}
}

import java.util.Scanner;

public class EntradaSalida {
	
	Scanner sc=new Scanner(System.in);
	
	protected String recogerTextoSinEspacio() {
		String texto=sc.next();
		return texto;
	}

	protected String reocogerTextoEspacios() {
		String texto=sc.nextLine();
		return texto;
	}
	
	protected int recogerEntero() {
		int entero=sc.nextInt();
		return entero;
	}
	
	protected double recogerDecimal() {
		double decimal=sc.nextDouble();
		return decimal;
	}
	
	protected char recogerCaracter() {
		char caracter=sc.next().charAt(0);
		return caracter;
	}
}

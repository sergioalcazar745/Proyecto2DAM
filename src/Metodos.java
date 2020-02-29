import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Metodos {
	String estado, tipo, ID, DNI, nombre, apellidos, fecha_nac, domicilio, telefono, inicio_contrato, fecha, año_cont, jornada, turno;
	String usuario, contraseña, opcion;
	double horas;
	boolean inicio=true, control=false;
	
	EntradaSalida es=new EntradaSalida();
	
	ArrayList <Persona> Gestion_personas=new ArrayList <Persona>();
	ArrayList <Producto> Gestion_productos=new ArrayList <Producto>();
	ArrayList <Pedidos> listaPedidos= new ArrayList<Pedidos>();
	
	Administrador ad=new Administrador();
	Menus menu;
	Persona ps;
	Producto pd;
	
	protected void switchPrincipal() {
		menu=new Menus();
		boolean inicio=true;
		
		do {
			
			menu.menuIncio();
			opcion=es.recogerTextoSinEspacio();
			
			switch(opcion) {
			
			case "1":
				comprobarInicioEmpleado();
			break;
			
			case "2":
				comprobarInicioAdministrador();
			break;
			
			case "3":
				System.out.println("Hasta luego, majete");
				inicio=false;
			break;
			
			default:
				System.out.println("Numero incorrecto");
			}
			
		}while(inicio);		
	}
	
	//METODOS QUE USA EL ADMINISTRADOR
	//-----------------------------------------------------------------------------------------------------------------//
	
	protected void comprobarInicioAdministrador() {
		menu=new Menus();
		boolean inicio=true;
		do {
			
			System.out.println("");
			System.out.println("--------------Inicio---------------");
			
			es.reocogerTextoEspacios();
			System.out.println("Usuario:");
			usuario=es.reocogerTextoEspacios();
			
			System.out.println("Contrase\u00f1a:");
			contraseña=es.reocogerTextoEspacios();			
				
			
				if (usuario.equals(ad.getUsuario()) && contraseña.equals(ad.getContraseña())) {
					switchAdministrador();
					inicio=false;
					System.out.println("");
				}else {
					System.out.println("El usuario o la contraseña son incorrectos. Vuelve a introducirlos.");
					System.out.println("");
					inicio=false;
				}
			
		}while(inicio);	
	}
	
	protected void switchAdministrador() {
		menu=new Menus();
		boolean Admin=true;
		
		do {
			
			menu.mostrarMenuAdministrador();
			opcion=es.recogerTextoSinEspacio();
			
			switch(opcion) {
			
			case "1":
				crearEmpleado();
			break;
			
			case "2":
				modificarDato();
			break;
			
			case "3":
				bajaEmpleado();
			break;
			
			case "4":
				boolean listado=true;
				do {
					
					System.out.println("");
					System.out.print("Si quieres ver todos los empleados pulsa 1. Si quieres ver un empleado pulsa 2: ");
					opcion=es.recogerTextoSinEspacio();
					
					switch(opcion) {
					
						case "1":
							listadoEmpleados();
							listado=false;
						break;
						
						case "2":
							listadoUnEmpleado();
							listado=false;
						break;
						
						default:
							System.out.println("Numero incorrecto");
					}
					
				}while(listado);
				
			break;
			
			case "5":
				switchStock();
			break;
			
			case "6":
				cambiarUsuarioContrasenaAdmin();
			break;
			
			case "7":
				Admin=false;
			break;
			
			default:
				System.out.println("Numero incorrecto");
			}
		
		}while(Admin);
	}
	
	protected void cambiarUsuarioContrasenaAdmin() {
		ps=new Empleado();
		String usuario, contraseña;
		
		es.reocogerTextoEspacios();
		System.out.println("Usuario nuevo: ");
		usuario=es.reocogerTextoEspacios();
		
		ad.setUsuario(usuario);
		
		System.out.println("Contraseña nueva: ");
		contraseña=es.reocogerTextoEspacios();
			
		ad.setContraseña(contraseña);
	}
	
	protected void crearEmpleado() {
		ps=new Empleado();
		Random rd=new Random();
		boolean crear=true, Telefono=true, dni=true, Horas=true, Turno=true, Apellidos=true, otra_persona=true,
		id=true, newID=true, Id=true, Nombre=true, Fecha=true, correcto=true;
		String desear, hora;
		
		do {
			
			System.out.println("");
			System.out.println("----------Crear un empleado---------");
			System.out.println("");
			
			tipo="empleado";
			estado="contratado";
			
			do {
				Id=true;
				
				int resultado= (int)(rd.nextInt(9999-1000)*10);
				ID=Integer.toString(resultado);
							
				Iterator <Persona> ite=Gestion_personas.iterator();
				control=false;
					
				while(ite.hasNext() && control==false) {	
						
					Persona p=ite.next();
					
					if(ID.equals(p.getID())) {
						control=true;
						Id=true;
					}else {
						control=false;
						Id=false;
					}
				}
				
				if(control==false) {
					System.out.println("Tu ID es: "+ID);
					Id=false;
				}
				
			}while(Id);
			
			do {
				
				System.out.println("Nombre: ");
				nombre=es.recogerTextoSinEspacio();
				es.reocogerTextoEspacios();
				
				if (ps.comprobarCaracter(nombre)==true) {
					Nombre=false;
				}else {
					System.out.println("El nombre debe ser una cadena de caracteres");
				}
				
			}while(Nombre);
			
			do {
				
				System.out.println("Apellidos: ");
				apellidos=es.reocogerTextoEspacios();			
				
				StringTokenizer tokens=new StringTokenizer(apellidos);
				control=true;
				
				while(tokens.hasMoreTokens() && control){
					
					String cadena=tokens.nextToken();
					
					if (ps.comprobarCaracter(cadena)==true) {
						control=true;
						Apellidos=false;
					}else {
						System.out.println("El nombre debe ser una cadena de caracteres");
						Apellidos=true;
						control=false;
					}
			    }
				
			}while(Apellidos);			
			
			do {
				
				System.out.println("Dime la fecha de nacimiento (Formato: dd/mm/YYYY)");
				fecha_nac=es.recogerTextoSinEspacio();
				es.reocogerTextoEspacios();
				
				if(ps.comprobarFecha(fecha_nac)==true) {
					Fecha=false;
				}else {
					System.out.println("Fecha incorrecta");
					System.out.println("-----------------");
				}
				
			}while(Fecha);
				
			System.out.println("Domicilio: ");
			domicilio=es.reocogerTextoEspacios();								
			
			do {
				correcto=true;
				Telefono=true;
				
				System.out.println("Tel\u00e9fono movil: ");
				telefono=es.recogerTextoSinEspacio();
				
				if (ps.comprobarTelefono(telefono)==true) {
					correcto=false;
				}else {
					correcto=true;
				}
				
				if (correcto==false) {
					
					if (Gestion_personas.size()==0) {
						Telefono=false;
					}else {
						
						Iterator <Persona> it=Gestion_personas.iterator();
						control=true;
						
						while (it.hasNext() && control) {
							
							Persona p=it.next();
							
							if (p.getTelefono().equals(telefono)) {
								
								System.out.println("El numero de telefono ya esta registrado");
								control=false;
								Telefono=true;
								
							}else {							
								control=true;								
							}
						}
						
						if (control==true) {
							Telefono=false;
						}
					}
				}else if (correcto==true) {
					System.out.println("Telefono incorrecto. Vuelve a intentarlo");
					Telefono=true;
				}
				
			}while(Telefono);
			
			do {
				
				System.out.println("DNI: ");
				DNI=es.recogerTextoSinEspacio();
				
					if (ps.validar(DNI)==true) {
						correcto=true;
						
					}else {
						correcto=false;
					}
				
				if (correcto==true) {
					
					if (Gestion_personas.size()==0) {
						dni=false;
						
					}else {
						
						Iterator <Persona> it=Gestion_personas.iterator();
						control=true;
						
						while (it.hasNext() && control) {
							
							Persona p=it.next();
							
							if(p instanceof Empleado) {
								
								if (p.getDNI().equals(DNI)) {
									
									System.out.println("Ese DNI ya esta registrado. Vuelve a intentarlo");
									dni=true;
									control=false;
									
								}else {
									control=true;
								}	
							}												
						}
						
						if(control==true) {
							dni=false;
						}
					}
					
				}else if (correcto==false) {
					System.out.println("El DNI es incorrecto");
					
				}
					
			}while(dni==true);	
			
			do {
				Fecha=true;
				
				System.out.println("Dime la fecha de contrato. Formato: dd/mm/YYYY");
				inicio_contrato=es.recogerTextoSinEspacio();
				
				if(ps.comprobarFecha(inicio_contrato)==true) {					
					
					if (ps.comprobarMayoriaEdad(fecha_nac, inicio_contrato)==true) {
						Fecha=false;
					}else {
						Fecha=true;
					}
					
				}else {
					System.out.println("Fecha incorrecta");
					System.out.println("------------------");
				}
				
			}while(Fecha);
			
			do {
				
				System.out.println("Horas semanales: ");
				hora=es.recogerTextoSinEspacio();
				
					if (ps.comprobarHoras(hora)==true) {
						horas=Double.parseDouble(hora);
						Horas=false;
					}else {
						System.out.println("Debe ser un numero entre 20 y 40");
					}
					
			}while(Horas);
			
				if (horas==40) {
					jornada="completa";
				}else if (horas>=30 && horas<40){
					jornada="parcial";
				}else {
					jornada="rotativa";
				}
				
			if (jornada.equals("rotativa")) {
				turno="No procede";
				
			}else {
				
				do {
					
					System.out.print("Tipo de turno. Pulsa 1 si es mañana y pulsa 2 si es tarde: ");
					turno=es.recogerTextoSinEspacio();
					
					if (turno.equals("1")) {
						turno="mañana";
						Turno=false;
					}else if(turno.equals("2")) {
						turno="tarde";
						Turno=false;
					}else {
						System.out.println("Numero incorrecto. Vuelve a introducirlo");
					}
					
				}while(Turno);
			}
			
			Persona e2=new Empleado(estado, tipo, ID, DNI, nombre, apellidos, fecha_nac, domicilio, telefono, inicio_contrato, turno, jornada, horas );
			
			while(otra_persona) {
				
				System.out.println("");
				System.out.print("Deseas crear otro empleado. Pulsa [1] en caso afirmativo sino pulsa [2]: ");
				desear=es.recogerTextoSinEspacio();
				
					if(desear.equals("1")) {
						Gestion_personas.add(e2);
						crear=true;
						otra_persona=false;
					}else if (desear.equals("2")) {
						Gestion_personas.add(e2);
						crear=false;
						otra_persona=false;
					}else {
						System.out.println("El numero introducido incorrecto");
					}				
			}
				
		}while(crear);		
	}
	
	protected void bajaEmpleado() {
		ps=new Empleado();
		boolean correcto=true, baja=true;
		
		do {
			
			System.out.println("");
			System.out.println("Dime el DNI del empleado que quieres dar de baja:");
			DNI=es.recogerTextoSinEspacio();
			
			if (Gestion_personas.size()==0) {
				correcto=false;
			}else {
				correcto=true;
			}
			
			if(correcto==true) {
				
				if(ps.validar(DNI)==true) {
					control=true;
				}else {
					control=false;
				}
				
				if (control==true) {
					
					Iterator<Persona> it=Gestion_personas.iterator();
					control=true;
					
					while(it.hasNext() && control) {
						
						Persona p=it.next();
						
						if (p.getDNI().equals(DNI)) {
							
							if(((Empleado) p).getEstado()=="despedido") {
								System.out.println("El empleado ya esta dado de baja");
								control=false;
								baja=false;
							}else {
								((Empleado) p).setEstado("despedido");
								System.out.println("La operacion se ha completado con exito");
								control=false;
								baja=false;
							}
							
						}else {
							control=true;
						}
					}
					
					if (control==true) {
						System.out.println("El DNI no esta registrado. Vuelve a intentarlo");
						System.out.println("-----------------------------------------------");
					}
					
				}else if(control==false) {
					System.out.println("El DNI no existe. Vuelve a intentarlo");
					System.out.println("--------------------------------------");
				}
				
			}else if(correcto==false) {
				System.out.println("No existe ningun empleado");
				System.out.println("");
				baja=false;
			}
			
		}while(baja);		
	}
	
	protected void modificarDato() {
		ps=new Empleado();
		menu=new Menus();
		String opcion, desear;
		boolean control=true, cambiar=true, modificar=true, correcto=true;
		
		do {
			
			menu.menuModificarDato();
			opcion=es.recogerTextoSinEspacio();
					
			switch (opcion) {
					
				case "1":
					String Nombre;
					boolean nombre=true, newNombre=true;					
					
					do {
						
						System.out.println("Dime el DNI del empleado");
						DNI=es.recogerTextoSinEspacio();
						
						if (Gestion_personas.size()==0) {
							System.out.println("No existe nigun empleado");
							System.out.println("");
							nombre=false;
							modificar=false;
						}else {
							
							if (ps.validar(DNI)==true) {
								correcto=true;
							}else {
								correcto=false;
							}
							
							if (correcto==true) {							
								
								Iterator<Persona> it=Gestion_personas.iterator();
								control=true;
								
								while(it.hasNext() && control) {
									
									Persona p=it.next();
									
									if (p.getDNI().equals(DNI)) {
										
										do {
											
											System.out.println("Dime el nuevo nombre del empleado");
											Nombre=es.recogerTextoSinEspacio();
											
											if (ps.comprobarCaracter(Nombre)==true) {
												((Empleado) p).setNombre(Nombre);
												control=false;
												newNombre=false;
											}else {
												System.out.println("El nombre deben ser una cadena de caracteres");
											}
											
										}while(newNombre);
										
									}else {
										control=true;
									}
								}
								
								if (control==false) {
									nombre=false;
								}else {
									System.out.println("El DNI no esta registrado");
									System.out.println("--------------------------");
									modificar=false;
								}							
								
							}else if (correcto==false) {
								System.out.println("Ese DNI es incorrecto. Vuelve a intentarlo");
								System.out.println("--------------------------------------------");
								modificar=false;
							}
						
						while(modificar==true) {
							boolean resultado=true;
							
							resultado=desearModificar();
							
							if(resultado==true) {
								modificar=false;
								nombre=false;
							}else {
								modificar=false;
								nombre=false;
								cambiar=false;
							}
						}
					}
					
				}while(nombre);		
					
				break;
						
				case "2":
					boolean apellido=true;
					
					do {
						
						System.out.println("Dime el DNI del empleado");
						DNI=es.recogerTextoSinEspacio();
						
						if (Gestion_personas.size()==0) {
							System.out.println("No existe nigun empleado");
							System.out.println("");
							apellido=false;
							modificar=false;							
						}else {
							
							if (ps.validar(DNI)==true) {
								correcto=true;
							}else {
								correcto=false;
							}
							
							if (correcto==true) {
								
								Iterator<Persona> it=Gestion_personas.iterator();
								control=true;
								
								while(it.hasNext() && control) {
									
									Persona p=it.next();
									
									if (p.getDNI().equals(DNI)) {
										
										es.reocogerTextoEspacios();
										System.out.println("Dime el nuevo apellido del empleado");
										p.setApellidos(es.reocogerTextoEspacios());
										control=false;
										
									}else {
										control=true;
									}
								}
								
								if (control==false) {
									apellido=false;
								}else {
									System.out.println("El DNI no existe");
									System.out.println("-------------------");
									modificar=false;
								}					
								
							}else if (correcto==false) {
								System.out.println("Ese DNI es incorrecto. Vuelve a intentarlo");
								System.out.println("--------------------------------------------");
								modificar=false;
							}
						}
						
						while(modificar==true) {
							boolean resultado=true;
							
							resultado=desearModificar();
							
							if(resultado==true) {
								modificar=false;
								apellido=false;
							}else {
								modificar=false;
								apellido=false;
								cambiar=false;
							}
						}
						
					}while(apellido);	
						
				break;
						
				case "3":
					
					boolean domicilio=true;
					
					do {
						
						System.out.println("Dime el DNI del empleado");
						DNI=es.recogerTextoSinEspacio();
						
						if (Gestion_personas.size()==0) {
							System.out.println("No existe nigun empleado");
							System.out.println("");
							apellido=false;
							modificar=false;							
						}else {
						
							if (ps.validar(DNI)==true) {
								correcto=true;
							}else {
								correcto=false;
							}
							
								if (correcto==true) {
									
									Iterator<Persona> it=Gestion_personas.iterator();
									control=true;
									
									while(it.hasNext() && control) {
										
										Persona p=it.next();
										
										if (p.getDNI().equals(DNI)) {
											
											es.reocogerTextoEspacios();
											System.out.println("Dime el nuevo domicilio");
											p.setDomicilio(es.reocogerTextoEspacios());
											control=false;
											
										}else {
											control=true;
										}
									}
									
									if (control==false) {
										domicilio=false;
									}else {
										System.out.println("El DNI no existe");
										System.out.println("-----------------");
										modificar=false;
									}
									
								}else if (correcto==false) {
									System.out.println("Ese DNI es incorrecto. Vuelve a intentarlo");
									System.out.println("--------------------------------------------");
									modificar=false;
								}							
						}
						
							while(modificar==true) {
								boolean resultado=true;
								
								resultado=desearModificar();
								
								if(resultado==true) {
									modificar=false;
									domicilio=false;
								}else {
									modificar=false;
									domicilio=false;
									cambiar=false;
								}
							}
						
					}while(domicilio);		
							
				break;
						
				case "4":
					
					boolean Telefono=true, newTelefono=true;
					
					do {
						
						System.out.println("Dime el DNI del empleado");
						DNI=es.recogerTextoSinEspacio();
						
						if (Gestion_personas.size()==0) {
							System.out.println("No existe nigun empleado");
							System.out.println("");
							apellido=false;
							modificar=false;							
						}else {
						
							if (ps.validar(DNI)==true) {
								correcto=true;
							}else {
								correcto=false;
							}
							
								if (correcto==true) {
									
									Iterator<Persona> it=Gestion_personas.iterator();
									control=true;
									
									while(it.hasNext() && control) {
										
										Persona p=it.next();
										
										if (p.getDNI().equals(DNI)) {
											
											do {
												
												System.out.println("Dime el nuevo telefono movil del empleado");
												telefono=es.recogerTextoSinEspacio();
												
												if (ps.comprobarTelefono(telefono)==true) {
													
													p.setTelefono(telefono);
													control=false;
													newTelefono=false;
													
												}else{
													System.out.println("El telefono es incorrecto");
												}
												
											}while(newTelefono);						
											
										}else {
											control=true;
										}
									}
									
									if (control==false) {
										Telefono=false;
									}else {
										System.out.println("El DNI no existe");
										System.out.println("------------------");
										modificar=false;
									}
									
								}else if (correcto==false) {
									System.out.println("Ese DNI es incorrecto. Vuelve a intentarlo");
									System.out.println("--------------------------------------------");
									modificar=false;
								}
						}
						
							while(modificar==true) {
								boolean resultado=true;
								
								resultado=desearModificar();
								
								if(resultado==true) {
									modificar=false;
									Telefono=false;
								}else {
									modificar=false;
									Telefono=false;
									cambiar=false;
								}
							}
						
					}while(Telefono);		
							
				break;
						
				case "5":
					
					String año_nacimiento, año_contrato;
					boolean contrato=true, newContrato=true;
					
					do {
						
						System.out.println("Dime el DNI del empleado");
						DNI=es.recogerTextoSinEspacio();
						
						if (Gestion_personas.size()==0) {
							System.out.println("No existe nigun empleado");
							System.out.println("");
							contrato=false;
							modificar=false;
						}else {
							
							if (ps.validar(DNI)==true) {
								correcto=true;
							}else {
								correcto=false;
							}
							
							if (correcto==true) {							
								
								Iterator<Persona> it=Gestion_personas.iterator();
								control=true;
								
								while(it.hasNext() && control) {
									
									Persona p=it.next();
									
									if (p.getDNI().equals(DNI)) {
										
										do {
											
											System.out.println("Dime la nueva fecha de contrato. Formato: dd/mm/YYYY");
											inicio_contrato=es.recogerTextoSinEspacio();
											
											if(ps.comprobarFecha(inicio_contrato)==true) {
												
												año_contrato=(inicio_contrato.substring(6,10));
												
												año_nacimiento=((Empleado) p).getFecha_nac().substring(6,10);
												
													if (ps.comprobarMayoriaEdad(año_nacimiento, año_contrato)==true) {
														((Empleado) p).setInicio_contrato(inicio_contrato);
														control=false;
														contrato=false;
														newContrato=false;
													}else {
														newContrato=true;
													}
												
											}else {
												System.out.println("Fecha incorrecta");
												System.out.println("--------------------------");
											}
												
										}while(newContrato);
										
									}else {
										control=true;
									}
								}
								
								if (control==true) {
									System.out.println("El DNI no esta registrado");
									System.out.println("--------------------------");
									modificar=false;
								}							
								
							}else if (correcto==false) {
								System.out.println("Ese DNI es incorrecto. Vuelve a intentarlo");
								System.out.println("--------------------------------------------");
								modificar=false;
							}							
						}
						
						while(modificar==true) {
							boolean resultado=true;
							
							resultado=desearModificar();
							
							if(resultado==true) {
								modificar=false;
								contrato=false;
							}else {
								modificar=false;
								contrato=false;
								cambiar=false;
							}
						}
					
				}while(contrato);		
							
				break;
				
				case "6":
					
					boolean Horas=true, newHoras=true;
					String hora;
					
					do {
						
						System.out.println("Dime el DNI del empleado");
						DNI=es.recogerTextoSinEspacio();
						
						if (Gestion_personas.size()==0) {
							System.out.println("No existe nigun empleado");
							System.out.println("");
							contrato=false;
							modificar=false;
						}else {
					
						
							if (ps.validar(DNI)==true) {
								correcto=true;
							}else {
								correcto=false;
							}
							
								if (correcto==true) {
									
	
									Iterator<Persona> it=Gestion_personas.iterator();
									control=true;
									
									while(it.hasNext() && control) {
										
										Persona p=it.next();
										
										if (p.getDNI().equals(DNI)) {
											
											do {
												
												System.out.println("Dime las nuevas horas semanales");
												hora=es.recogerTextoSinEspacio();
												
												if (ps.comprobarHoras(hora)==true) {
													
													horas=Double.parseDouble(hora);
													((Empleado) p).setHora(horas);
													
													if (horas==40) {
														((Empleado) p).setJornada("completa");
													}else if (horas>=30 && horas<40){
														((Empleado) p).setJornada("parcial");
													}else {
														((Empleado) p).setJornada("rotativa");
													}
													
													if (((Empleado) p).getJornada().equals("rotativa")) {
														((Empleado) p).setTurno("No procede");
													}
													
													control=false;
													newHoras=false;
													Horas=false;
													
												}else {
													System.out.println("Debe ser un numero entre 20 y 40");
													System.out.println("---------------------------------");
												}	
												
											}while(newHoras);												
											
										}else {
											control=true;
										}
									}
									
									if (control==false) {
										Horas=false;
									}else {
										System.out.println("El DNI no esta registrado");
										System.out.println("--------------------------");
										modificar=false;
									}
									
								}else if (correcto==false) {
									System.out.println("Ese DNI es incorrecto. Vuelve a intentarlo");
									System.out.println("--------------------------------------------");
									modificar=false;
								}
						}
						
							while(modificar==true) {
								boolean resultado=true;
								
								resultado=desearModificar();
								
								if(resultado==true) {
									modificar=false;
									Horas=false;
								}else {
									modificar=false;
									Horas=false;
									cambiar=false;
								}
							}
						
					}while(Horas);	
					
				break;
				
				case "7":
					
					boolean Turno=true, newTurno=true;
					
					do {
						
						System.out.println("Dime el DNI del empleado");
						DNI=es.recogerTextoSinEspacio();
						
						if (Gestion_personas.size()==0) {
							System.out.println("No existe nigun empleado");
							System.out.println("");
							contrato=false;
							modificar=false;
						}else {
						
							if (ps.validar(DNI)==true) {
								correcto=true;
							}else {
								correcto=false;
							}
							
								if (correcto==true) {								
	
									Iterator<Persona> it=Gestion_personas.iterator();
									control=true;
									
									while(it.hasNext() && control) {
										
										Persona p=it.next();
										
										if (p.getDNI().equals(DNI)) {
											
											if (((Empleado) p).getJornada().equals("rotativa")) {
												
												((Empleado) p).setTurno("No procede");
												System.out.println("Como el contrato es menor de 30 horas se ha cambiado automaticamente.");
												System.out.println("");
												control=false;
												
											}else {
												
												do {
													
													if(((Empleado) p).getHora()>=30 && ((Empleado) p).getHora()<=40) {
														
														System.out.println("Tipo de turno nuevo. Pulsa 1 si es mañana y pulsa 2 si es tarde");
														turno=es.recogerTextoSinEspacio();
														
														if (turno.equals("1")) {
															turno="mañana";
															((Empleado) p).setTurno(turno);
															newTurno=false;
															control=false;
														}else if(turno.equals("2")) {
															turno="tarde";
															((Empleado) p).setTurno(turno);
															newTurno=false;
															control=false;
														}else {
															System.out.println("Numero incorrecto. Vuelve a introducirlo");
														}
														
													}else {
														System.out.println("No puede modificar el turno a un contrato con menos de 30 horas.");
													}
													
												}while(newTurno);
											}
											
										}else {
											control=true;
										}
									}
									
									if(control==true) {
										System.out.println("El DNI no esta registrado");
										System.out.println("--------------------------");
										modificar=false;
									}
									
								}else if (correcto==false) {
									System.out.println("El DNI es incorrecto. Vuelve a intentarlo");
									System.out.println("-------------------------------------------");
									modificar=false;
								}
						}
								
							while(modificar==true) {
								boolean resultado=true;
								
								resultado=desearModificar();
								
								if(resultado==true) {
									modificar=false;
									Turno=false;
								}else {
									modificar=false;
									Turno=false;
									cambiar=false;
								}
							}
							
					}while(Turno);
					
				break;
				
				case "8":
					cambiar=false;
					
				break;
				
				default:
					System.out.println("Error");
			}
			
		}while(cambiar);	
	}
	
	protected void listadoEmpleados() {

		System.out.println("-----------------Listado todos los empleados------------");
		Iterator <Persona> it= Gestion_personas.iterator();
		control=true;
		
		if (Gestion_personas.size()==0) {
			System.out.println("No existen empleados");
			System.out.println("");
		}
		
		while(it.hasNext() && control) {
			
			Persona p=it.next();
			
			if(p.getTipo()=="empleado") {
				
				System.out.println("");
				System.out.println(p.toString());
				System.out.println("");
				control=false;
			}
		}
		
		if(control==true) {
			System.out.println("No existe ningun empleado");
		}
	}
	
	protected void listadoUnEmpleado() {
		ps=new Empleado();
		boolean correcto=true, mostrar=true;
		
		do {
			
			System.out.println("");
			System.out.println("Dime el DNI del empleado que quieres ver: ");
			DNI=es.recogerTextoSinEspacio();
			
			if (Gestion_personas.size()==0) {
				correcto=false;
			}else {
				correcto=true;
			}
			
			if(correcto==true) {
				
				if(ps.validar(DNI)==true) {
					control=true;
				}else {
					control=false;
				}
				
				if (control==true) {
					
					Iterator<Persona> it=Gestion_personas.iterator();
					control=true;
					
					while(it.hasNext() && control) {
						
						Persona p=it.next();
						
						if (p.getDNI().equals(DNI)) {
							System.out.println("-----------------Listado del empleado solicitado--------------");
							System.out.println("");
							System.out.println(p.toString());
							System.out.println("");
							control=false;
							mostrar=false;
						}else {
							control=true;
						}
					}
					
					if (control==true) {
						System.out.println("El DNI no esta registrado. Vuelve a intentarlo");
					}
					
				}else if(control==false) {
					System.out.println("El DNI no existe. Vuelve a intentarlo");
				}
				
			}else if(correcto==false) {
				System.out.println("No existe ningun empleado");
				System.out.println("");
				mostrar=false;
			}
			
		}while(mostrar);
	}
	
	protected void switchStock() {
		menu=new Menus();
		boolean stock=true;
		
		do {
			
			menu.menuStock();
			opcion=es.recogerTextoSinEspacio();
			
			switch(opcion) {
			
				case "1":
					
					System.out.println("");
					System.out.println("Si quieres añadir gafas pulsa 1\nSi quieres añadir lentillas pulsa 2.");
					System.out.println("");
					System.out.print("Opcion: ");
					opcion=es.recogerTextoSinEspacio();
					
					switch(opcion) {
						
						case "1":
							añadirGafas();
						break;
						
						case "2":
							añadirLentillas();
						break;
						
						default:
							System.out.println("Numero incorrecto");
					}
					
				break;
				
				case "2":
					boolean bucle=true;
					do {
						
						System.out.println("");
						System.out.print("Si quieres modificar un producto pulsa 1\nSi quieres reponer un producto pulsa 2: ");
						System.out.println("");
						opcion=es.recogerTextoSinEspacio();
						
						switch(opcion) {
						
							case "1":
								modificarProductos();
								bucle=false;
							break;
							
							case "2":
								reponerProductos();
								bucle=false;
							break;
							
							default:
								System.out.println("Numero incorrecto");						
						}
						
					}while(bucle);
					
				break;
				
				case "3":
					borrarProductos();
				break;
				
				case "4":
					
					System.out.println("Si quieres ver todos los productos pulsa 1.\nSi quieres ver solo las gafas pulse 2. Si quieres ver solo las lentillas pulse 3.");
					String mostrar=es.recogerTextoSinEspacio();
					
					switch(mostrar) {
					case "1":
						mostrarProductos();
					break;
					
					case "2":
						mostrarGafas();
					break;
					
					case "3":
						mostrarLentillas();
					break;
					
					default:
						System.out.println();
					}
					
				break;
				
				case "5":
					stock=false;
				break;
				
				default:
					System.out.println("Numero incorrecto");
			}
			
		}while(stock);
	}
	
	protected void añadirGafas() {
		pd=new Gafas();
		ps= new Empleado();
		Random rd=new Random();
		String producto, cantidad1, compra1, venta1, desear, montura, cristales;
		int cantidad = 0, cantidad_comprada=0;
		double compra = 0, venta = 0;
		boolean productos=true, Cantidad=true, Compra=true, Venta=true, Montura=true, Cristales=true, Id=true, nombre=true;
		
		do {
			System.out.println("");
			System.out.println("------------Añadir gafas-----------");
			System.out.println("");
			
			do {
				
				int resultado= (int)(rd.nextInt(9999-1000)*10);
				ID=Integer.toString(resultado);
							
				Iterator <Producto> ite=Gestion_productos.iterator();
				control=false;
					
				while(ite.hasNext() && control) {	
						
					Producto p=ite.next();
					
					if(ID.equals(p.getID())) {
						control=false;
						Id=false;
					}else {
						control=true;
					}
				}
				
				if(control==false) {
					System.out.println("ID de producto: "+ID);
					Id=false;
				}
				
			}while(Id);
			
			producto="gafas";
			
			do {
				
				System.out.println("Cantidad");
				cantidad1=es.recogerTextoSinEspacio();
				
				if(ps.comprobarNumero(cantidad1)) {					
					cantidad=Integer.parseInt(cantidad1);
					
					if(cantidad<=0) {
						System.out.println("Debe ser mayor que 0");
					}else {
						Cantidad=false;
					}
					
				}else {
					System.out.println("La cantidad debe ser un numero");
				}
				
			}while(Cantidad);
			
			do {
				
				System.out.println("Precio de venta: ");
				venta1=es.recogerTextoSinEspacio();
		
				if(pd.esDecimal(venta1)==true) {					
					venta=Double.parseDouble(venta1);
					
					if(venta<=0) {
						System.out.println("Debe ser mayor que 0");
					}else {
						Venta=false;
					}
					
				}else {
					System.out.println("La cantidad debe ser un numero");
				}
				
			}while(Venta);
			
			do {
				
				System.out.println("Precio de compra: ");
				compra1=es.recogerTextoSinEspacio();
				
				if(pd.esDecimal(venta1)==true) {					
					venta=Double.parseDouble(venta1);
					
					if(venta<=0) {
						System.out.println("Debe ser mayor que 0");
					}else {
						Compra=false;
					}
					
				}else {
					System.out.println("La cantidad debe ser un numero");
				}		
				
			}while(Compra);
			
			do {
				
				System.out.println("Tipo de montura: ");
				montura=es.recogerTextoSinEspacio();
				
				if (pd.comprobarCaracter(montura)==true) {
					Montura=false;
				}else {
					System.out.println("La montura debe ser una cadena de caracteres");
				}				
				
			}while(Montura);
			
			do {
				
				System.out.println("Tipo de cristales: Si son unifocales pulsa 1. Si son bifocales pulsa 2. Si son progresivas pulsa 3.");
				cristales=es.recogerTextoSinEspacio();
				
				if(cristales.equals("1")) {
					cristales="unifocales";
					Cristales=false;
				}else if (cristales.equals("2")) {
					cristales="bifocales";
					Cristales=false;
				}else if (cristales.equals("3")) {
					cristales="progresivas";
					Cristales=false;
				}else {
					System.out.println("Numero incorrecto");
				}
				
			}while(Cristales);
						
			Producto pd1=new Gafas(ID, producto, compra, venta, cantidad, cantidad_comprada, montura, cristales);
			
			System.out.print("¿Deseas introducir otra gafa?. Pulsa 1 en caso afirmativo sino pulsa 2: ");
			desear=es.recogerTextoSinEspacio();
			
			if (desear.equals("1")) {
				Gestion_productos.add(pd1);
				productos=true;
			}else if (desear.equals("2")){
				Gestion_productos.add(pd1);
				productos=false;
			}else {
				System.out.println("Numero incorrecto");
			}
			
		}while(productos);
	}
	
	protected void añadirLentillas() {
		pd=new Lentillas();
		ps=new Empleado();
		Random rd=new Random();
		String lentilla, producto, cantidad1, compra1, venta1, desear;
		int cantidad = 0, cantidad_comprada = 0;
		double compra = 0, venta = 0, total, beneficio, ganancias=0;
		boolean productos=true, Cantidad=true, Compra=true, Venta=true, Id=true, nombre=true, lentillas=true, desea=true;
		
		do {
			
			System.out.println("------------Añadir Lentillas-----------");
			System.out.println("");
			
			do {
				
				int resultado= (int)(rd.nextInt(9999-1000)*10);
				ID=Integer.toString(resultado);
							
				Iterator <Producto> ite=Gestion_productos.iterator();
				control=false;
					
				while(ite.hasNext() && control) {	
						
					Producto p=ite.next();
					
					if(ID.equals(p.getID())) {
						control=false;
						Id=false;
					}else {
						control=true;
					}
				}
				
				if(control==false) {
					System.out.println("ID de producto: "+ID);
					Id=false;
				}
				
			}while(Id);
			
			producto="lentillas";
			
			do {
				
				System.out.println("Cantidad");
				cantidad1=es.recogerTextoSinEspacio();
				
				if(ps.comprobarNumero(cantidad1)) {					
					cantidad=Integer.parseInt(cantidad1);
					
					if(cantidad<=0) {
						System.out.println("Debe ser mayor que 0");
					}else {
						Cantidad=false;
					}
					
				}else {
					System.out.println("La cantidad debe ser un numero");
				}		
				
			}while(Cantidad);
			
			do {
				
				System.out.println("Precio de venta: ");
				venta1=es.recogerTextoSinEspacio();
				
				if(pd.esDecimal(venta1)==true) {					
					venta=Double.parseDouble(venta1);
					
					if(venta<=0) {
						System.out.println("Debe ser mayor que 0");
					}else {
						Venta=false;
					}
					
				}else {
					System.out.println("La cantidad debe ser un numero");
				}	
				
			}while(Venta);
			
			do {
				
				System.out.println("Precio de compra: ");
				compra1=es.recogerTextoSinEspacio();
				
				if(pd.esDecimal(venta1)==true) {					
					venta=Double.parseDouble(venta1);
					
					if(venta<=0) {
						System.out.println("Debe ser mayor que 0");
					}else {
						Compra=false;
					}
					
				}else {
					System.out.println("La cantidad debe ser un numero");
				}	
				
			}while(Compra);
			
			do {
							
				System.out.print("Tipo. Si es dura pulsa 1. Si es blanda pulsa 2: ");
				lentilla=es.recogerTextoSinEspacio();
				
					if(lentilla.equals("1")) {
						tipo="Dura";
						lentillas=false;
					}else if (lentilla.equals("2")) {
						tipo="blandas";
						lentillas=false;
					}else {
						System.out.println("Numero incorrecto");
					}
				
			}while(lentillas);
						
			Producto pd2=new Lentillas(ID, producto, compra, venta, cantidad, cantidad_comprada, tipo);
			
			while(desea==true) {
				
				System.out.println("");
				System.out.print("¿Deseas introducir otras lentillas?. Pulsa 1 en caso afirmativo sino pulsa 2: ");
				desear= es.recogerTextoSinEspacio();
				
				if (desear.equals("1")) {
					Gestion_productos.add(pd2);
					productos=true;
					desea=false;
				}else if (desear.equals("2")){
					Gestion_productos.add(pd2);
					productos=false;
					desea=false;
				}else {
					System.out.println("Numero incorrecto");
					System.out.println("-------------------");
					desea=true;
				}				
			}
			
		}while(productos);
	}
	
	protected void mostrarProductos() {
		
		Iterator<Producto>it=Gestion_productos.iterator();
		
		if (Gestion_productos.size()==0) {
			System.out.println("No existen productos");
			System.out.println("");
		}
		
		while(it.hasNext()) {
			
			Producto pd=it.next();
			System.out.println(pd.toString());
		}
	}
	
	protected void mostrarGafas(){
		
		Iterator<Producto>it=Gestion_productos.iterator();
		
		if (Gestion_productos.size()==0) {
			System.out.println("No existen productos");
			System.out.println("");
		}
		
		while(it.hasNext()) {
			
			Producto pd=it.next();

			if(pd instanceof Gafas) {
				System.out.println(pd.toString());
			}
		}
	}
	
	protected void mostrarLentillas() {
		
		Iterator<Producto>it=Gestion_productos.iterator();
		
		if (Gestion_productos.size()==0) {
			System.out.println("No existen productos");
			System.out.println("");
		}
		
		while(it.hasNext()) {
			
			Producto pd=it.next();

			if(pd instanceof Lentillas) {
				System.out.println(pd.toString());
			}
		}
	}
	
	protected void modificarProductos() {
		menu=new Menus();
		boolean modificar=true, modificar1=true;
		String desear;
		
			do {
			
				menu.menuModificarProducto();
				opcion=es.recogerTextoSinEspacio();
				
				switch (opcion) {
				
				case "1":
					boolean Nombre=true;
					
				do {
				
					System.out.println("Dime el ID del producto: ");
					ID=es.recogerTextoSinEspacio();
					
					Iterator<Producto>it=Gestion_productos.iterator();
					control=true;
					
					while(it.hasNext() && control) {
						
						Producto pd=it.next();
						
						if(ID.equals(pd.getID())) {
							
							es.reocogerTextoEspacios();
							System.out.println("Dime el nuevo nombre del producto: ");
							nombre=es.reocogerTextoEspacios();

							pd.setNombre(nombre);
							control=false;
							
						}else {
							control=true;
						}
					}
					
					if(control==true) {
						System.out.println("El producto no existe");
						System.out.println("");
					}else if (control==false) {
						System.out.println("Producto modificado");
						System.out.println("");
						Nombre=false;
					}
					
					while(modificar1) {
						
						System.out.println("¿Deseas modificar otro dato?. Pulsa 1 en caso afirmativo sino pulsa 2.");
						desear=es.recogerTextoSinEspacio();
						
						if (desear.equals("1")) {
							modificar1=false;
							Nombre=false;
						}else if (desear.equals("2")) {
							modificar1=false;
							modificar=false;
							Nombre=false;							
						}else {
							System.out.println("Numero incorrecto. Vuelve a intentarlo");							
						}						
					}
				
				}while(Nombre);
					
				break;
				
				case "2":
					String compra1;
					boolean Compra=true, precio_compra=true;
					double compra;
				
				do {
					
					System.out.println("Dime el ID del producto: ");
					ID=es.recogerTextoSinEspacio();
					
					Iterator<Producto>it1=Gestion_productos.iterator();
					control=true;
					
					while(it1.hasNext() && control) {
						
						Producto pd=it1.next();
						
						if(ID.equals(pd.getID())) {
							
							do {
								
								System.out.println("Dime el nuevo precio de compra");
								compra1=es.recogerTextoSinEspacio();
								
								compra=Double.parseDouble(compra1);
								if(compra<0) {
									System.out.println("Debe ser mayor que 0");
								}else {
									pd.setPrecio_compra(compra);
									precio_compra=false;
									Compra=false;
								}								
							}while(Compra);
							
							control=false;							
						}else {
							control=true;
						}
					}
					
					if(control==true) {
						System.out.println("El producto no existe. Vuelve a intentarlo");
						System.out.println("");
					}else if (control==false) {
						System.out.println("Producto modificado");
						System.out.println("");
						precio_compra=false;
					}
					
					while(modificar1) {
						
						System.out.println("¿Deseas modificar otro dato?. Pulsa 1 en caso afirmativo sino pulsa 2.");
						desear=es.recogerTextoSinEspacio();
						
						if (desear.equals("1")) {
							modificar1=false;
							precio_compra=false;
						}else if (desear.equals("2")) {
							modificar1=false;
							modificar=false;
							precio_compra=false;							
						}else {
							System.out.println("Numero incorrecto. Vuelve a intentarlo");							
						}						
					}
					
				}while(precio_compra);
				
				break;
				
				case "3":
					
					String venta1;
					boolean Venta=true, precio_venta=true;
					double venta;
					
				do {
					
					System.out.println("Dime el ID del producto: ");
					ID=es.recogerTextoSinEspacio();
					
					Iterator<Producto>it2=Gestion_productos.iterator();
					control=true;
					
					while(it2.hasNext() && control) {
						
						Producto pd=it2.next();
						
						if(ID.equals(pd.getID())) {
							
							do {
								
								System.out.println("Dime el nuevo precio de venta");
								venta1=es.recogerTextoSinEspacio();
								
								venta=Double.parseDouble(venta1);
								if(venta<0) {
									System.out.println("Debe ser mayor que 0");
								}else {
									pd.setPrecio_venta(venta);
									Venta=false;
									precio_venta=false;
								}								
							}while(Venta);
							
							control=false;							
						}else {
							control=true;
						}
					}
					
					if(control==true) {
						System.out.println("El producto no existe");
						System.out.println("");
					}else if (control==false) {
						System.out.println("Producto modificado");
						System.out.println("");
						precio_venta=false;
					}
					
					while(modificar1) {
						
						System.out.println("¿Deseas modificar otro dato?. Pulsa 1 en caso afirmativo sino pulsa 2.");
						desear=es.recogerTextoSinEspacio();
						
						if (desear.equals("1")) {
							modificar1=false;
							precio_venta=false;
						}else if (desear.equals("2")) {
							modificar1=false;
							modificar=false;
							precio_venta=false;							
						}else {
							System.out.println("Numero incorrecto. Vuelve a intentarlo");							
						}						
					}
					
				}while(precio_venta);			
					
				break;
				
				case "4":
					
					String cantidad1;
					int cantidad;
					boolean Cantidad=true, cantidad_total=true;
					
				do {
									
					System.out.println("Dime el ID del producto: ");
					ID=es.recogerTextoSinEspacio();
					
					Iterator<Producto>it3=Gestion_productos.iterator();
					control=true;
					
					while(it3.hasNext() && control) {
						
						Producto pd=it3.next();
						
						if(ID.equals(pd.getID())) {
							
							do {
								
								System.out.println("Dime la nueva cantidad");
								cantidad1=es.recogerTextoSinEspacio();
								
								cantidad=Integer.parseInt(cantidad1);
								if(cantidad<0) {
									System.out.println("Debe ser mayor que 0");
								}else {
									pd.setCantidad(cantidad);
									Cantidad=false;
									cantidad_total=false;
								}
								
							}while(Cantidad);
							
							control=false;							
						}else {
							control=true;
						}
					}
					
					if(control==true) {
						System.out.println("El producto no existe");
						System.out.println("");
					}else if (control==false) {
						System.out.println("Producto modificado");
						System.out.println("");
						cantidad_total=false;
					}
					
					while(modificar1) {
						
						System.out.println("¿Deseas modificar otro dato?. Pulsa 1 en caso afirmativo sino pulsa 2.");
						desear=es.recogerTextoSinEspacio();
						
						if (desear.equals("1")) {
							modificar1=false;
							cantidad_total=false;
						}else if (desear.equals("2")) {
							modificar1=false;
							modificar=false;
							cantidad_total=false;
							
						}else {
							System.out.println("Numero incorrecto. Vuelve a intentarlo");							
						}						
					}
					
				}while(cantidad_total);
				
				break;
				
				case "5":
					modificar=false;
					
				break;
					
				}
			
			}while(modificar);
		}		
	
	protected void borrarProductos() {
		
		System.out.println("Dime el ID del producto: ");
		ID=es.recogerTextoSinEspacio();
		
		Iterator<Producto>it=Gestion_productos.iterator();
		control=true;
		
		while(it.hasNext() && control) {
			
			Producto pd=it.next();
			
			if(ID.equals(pd.getID())) {
				it.remove();
				control=false;
			}else {
				control=true;
			}
		}
		
		if(control==true) {
			System.out.println("No existe el producto");
		}else if(control==false) {
			System.out.println("Producto eliminado");
		}
	}
	
	protected void reponerProductos() {
		String ID, reponer1;
		boolean Reponer=true;
		double reponer;
		
		System.out.println("Dime la ID del producto a reponer: ");
		ID=es.recogerTextoSinEspacio();
	
		Iterator <Producto> it=Gestion_productos.iterator();
		control=true;
		
		while(it.hasNext() && control) {
			
			Producto pd=it.next();
			
			if(pd.getID().equals(ID)) {
				
				do {
				
					System.out.println("Cantidad a reponer");
					reponer1=es.recogerTextoSinEspacio();
					
						reponer=Integer.parseInt(reponer1);
						if(reponer<0) {
							System.out.println("La cantidad debe ser mayor de 0");
						}else {
							int resultado=(int)(pd.getCantidad() + reponer);
							pd.setCantidad(resultado);
							Reponer=false;
						}
				
				}while(Reponer);				
			}
		}
		
		if(Reponer==false) {
			System.out.println("Cantidad actualizada");
		}
	}
	
	protected boolean desearModificar() {
		String desear;
		boolean modificar=true, nombre=true;
		
		do {
			
			System.out.print("¿Deseas modificar otro dato? Pulsa 1 si es asi si no 2: ");
			desear=es.recogerTextoSinEspacio();
				
				if(desear.equals("1")) {
					modificar=false;
					nombre=true;							
				}else if (desear.equals("2")) {
					nombre=false;
					modificar=false;
				}else {
					System.out.println("Numero incorrecto");
					modificar=true;
				}
				
		}while(modificar);
		
		return nombre;
	}
	
	//FIN DE METODOS ADMINISTRADOR-------------------------------------------------------------------------------------//
	//-----------------------------------------------------------------------------------------------------------------//
	
	//METODOS QUE USA EL EMPLEADO
	//-----------------------------------------------------------------------------------------------------------------//
	
	protected void comprobarInicioEmpleado() {
		inicio=true;
		
		do {
			
			System.out.println("");
			System.out.println("--------------Inicio---------------");
			
			System.out.println("Usuario (DNI):");
			usuario=es.recogerTextoSinEspacio();
			
			System.out.println("Contrase\u00f1a (ID):");
			contraseña=es.recogerTextoSinEspacio();
			
			Iterator <Persona> it=Gestion_personas.iterator();
			control=true;
			
			while(it.hasNext() && control) {
				
				Persona p=it.next();
				
				if(p instanceof Empleado) {
					
					if(usuario.equals(((Empleado) p).getDNI()) && contraseña.equals(((Empleado) p).getID())) {
						switchEmpleado();
						control=false;
						inicio=false;
					}else {
						System.out.println("El usuario o contraseña son incorrectos");
						inicio=false;
						control=false;
					}
				}			
			}
			
			if(control==true) {
				System.out.println("No existe el empleado");
				System.out.println("");
				inicio=false;				
			}
		
		}while(inicio); 
	}
	
	protected void switchEmpleado() {
		menu=new Menus();
		boolean empleado=true;
		
		do {
			
			menu.mostrarMenuEmpleado();
			opcion=es.recogerTextoSinEspacio();
			
			switch(opcion) {
			
				case "1":
					crearCliente();
				break;
				
				case "2":
					modificarCliente();
				break;
				
				case "3":
					listadoClientes();
				break;
				
				case "4":
					Pedidos();
				break;
				
				case "5":
					mostrarPedidos();
				break;
				
				case "6":
					empleado=false;
				break;
				
				default:
					System.out.println("Numero incorrecto");			
			}
			
		}while(empleado);
	}
	
	protected void crearCliente() {
		ps=new Cliente();
		Random rd=new Random();
		boolean crear=true, correcto=true, Id=true, Nombre=true, Fecha=true, Telefono=true,
		dni=true, id=true, newID=true, derecho=true, izquierdo=true;
		double ojo_der=0, ojo_izq=0;
		String desear, salario1, anomalia, ojo_derecho, ojo_izquierdo;
		
			do {
			
				System.out.println("");
				System.out.println("----------Dar de alta un cliente---------");
				System.out.println("");
				
				tipo="cliente";
				
				do {
					Id=true;
					
					int resultado= (int)(rd.nextInt(9999-1000)*10);
					ID=Integer.toString(resultado);
								
					Iterator <Persona> ite=Gestion_personas.iterator();
					control=false;
						
					while(ite.hasNext() && control==false) {	
							
						Persona p=ite.next();
						
						if(ID.equals(p.getID())) {
							control=true;
							Id=true;
						}else {
							control=false;
							Id=false;
						}
					}
					
					if(control==false) {
						System.out.println("Tu ID es: "+ID);
						Id=false;
					}
					
				}while(Id);
				
				do {
					
					System.out.println("Nombre: ");
					nombre=es.recogerTextoSinEspacio();
					es.reocogerTextoEspacios();
					
					if (ps.comprobarCaracter(nombre)==true) {
						Nombre=false;
					}else {
						System.out.println("El nombre debe ser una cadena de caracteres");
					}
					
				}while(Nombre==true);
				
				System.out.println("Apellidos: ");
				apellidos=es.reocogerTextoEspacios();
				
				do {
					
					System.out.println("Dime la fecha de nacimiento (Formato: dd/mm/YYYY)");
					fecha_nac=es.recogerTextoSinEspacio();
					es.reocogerTextoEspacios();
					
					if(ps.comprobarFecha(fecha_nac)==true) {
						Fecha=false;
					}else {
						System.out.println("Fecha incorrecta");
						System.out.println("-----------------");
					}
					
				}while(Fecha);
					
				System.out.println("Domicilio: ");
				domicilio=es.reocogerTextoEspacios();								
				
				do {
					correcto=true;
					Telefono=true;
					
					System.out.println("Tel\u00e9fono movil: ");
					telefono=es.recogerTextoSinEspacio();
					
					if (ps.comprobarTelefono(telefono)==true) {
						correcto=false;
					}else {
						correcto=true;
					}
					
					if (correcto==false) {
						
						if (Gestion_personas.size()==0) {
							Telefono=false;
						}else {
							
							Iterator <Persona> it=Gestion_personas.iterator();
							control=true;
							
							while (it.hasNext() && control) {
								
								Persona p=it.next();
								
								if (p.getTelefono().equals(telefono)) {
									
									System.out.println("El numero de telefono ya esta registrado");
									control=false;
									Telefono=true;
									
								}else {							
									control=true;								
								}
							}
							
							if (control==true) {
								Telefono=false;
							}
						}
					}else if (correcto==true) {
						System.out.println("Telefono incorrecto. Vuelve a intentarlo");
						Telefono=true;
					}
					
				}while(Telefono);
				
				do {
					
					System.out.println("DNI: ");
					DNI=es.recogerTextoSinEspacio();
					
						if (ps.validar(DNI)==true) {
							correcto=true;
							
						}else {
							correcto=false;
						}
					
					if (correcto==true) {
						
						if (Gestion_personas.size()==0) {
							dni=false;
							
						}else {
							
							Iterator <Persona> it=Gestion_personas.iterator();
							control=true;
							
							while (it.hasNext() && control) {
								
								Persona p=it.next();
								
								if (p.getDNI().equals(DNI)) {
									
									System.out.println("Ese DNI ya esta registrado. Vuelve a intentarlo");
									dni=true;
									control=false;
									
								}else {
									control=true;
								}						
							}
							
							if(control==true) {
								dni=false;
							}
						}
						
					}else if (correcto==false) {
						System.out.println("El DNI es incorrecto");
						
					}
						
				}while(dni==true);
				
				do {
					
					System.out.println("Dioptrias en ojo derecho: ");
					ojo_derecho=es.recogerTextoSinEspacio();
					
					if(ps.comprobarNumero(ojo_derecho)==true) {
						
						ojo_der=Double.parseDouble(ojo_derecho);
						
						if(((Cliente) ps).comprobarDioptrias(ojo_der)==true) {
							derecho=false;
						}else {
							System.out.println("Doptria no concluida realizar mas pruebas.");
							derecho=false;
						}
					}else {
						System.out.println("Doptria incorrecta");
					}
					
				}while(derecho);
					
				do {
					
					System.out.println("Dioptrias en ojo izquierdo: ");
					ojo_izquierdo=es.recogerTextoSinEspacio();
					
					if(ps.comprobarNumero(ojo_izquierdo)==true) {
						
						ojo_izq=Double.parseDouble(ojo_izquierdo);
						
						if(((Cliente) ps).comprobarDioptrias(ojo_izq)==true) {
							izquierdo=false;
						}else {
							izquierdo=false;
						}
					}else {
						System.out.println("Doptria incorrecta");
					}
					
				}while(izquierdo);
				
				es.reocogerTextoEspacios();
				System.out.println("¿Alguna anomalia?");
				anomalia=es.reocogerTextoEspacios();
				
				Persona c2=new Cliente(tipo, ID, DNI, nombre, apellidos, fecha_nac, domicilio, telefono, anomalia, ojo_izq, ojo_der);
				
				System.out.println("");
				System.out.print("Deseas crear otro cliente. Pulsa [1] en caso afirmativo sino pulsa [2]: ");
				desear=es.recogerTextoSinEspacio();
				
					if(desear.equals("1")) {
						Gestion_personas.add(c2);
					}else if (desear.equals("2")) {
						Gestion_personas.add(c2);
						crear=false;
					}else {
						System.out.println("El numero introducido incorrecto");
					}
				
			}while(crear); 
	} 
		
	protected void modificarCliente() {
			menu=new Menus();
			String ide, name, opc;
			boolean Telefono=true, encontrado=true, modificar=true, cliente=true;
			
		do {
			
			 System.out.println("");
			 System.out.println("Dime el nombre del cliente a modificar:");
			 name = es.recogerTextoSinEspacio();
			 
			 Iterator<Persona> puntero = Gestion_personas.iterator();
			 encontrado=false;
			 
			 while (puntero.hasNext()) {
				 
				 Persona c = puntero.next();

				 if(c instanceof Cliente) {
					 
					 if(c.getNombre().equalsIgnoreCase(name)) {
						 System.out.println("");
						 System.out.println(c.toString());
						 System.out.println("");
						 encontrado=true;
					 }							 
				 }
			 }
			
			if(encontrado==true) {
				
				System.out.println("");
				System.out.println("Dime el id del contacto que quieres modificar: ");
				ide = es.recogerTextoSinEspacio();
				
				Iterator<Persona>ite=Gestion_personas.iterator();
				control=true;
				
				while(ite.hasNext() && control) {
					
					Persona p=ite.next();
					
					if(p instanceof Cliente) {
						
						if(p.getID().equals(ide)) {						
						boolean bucle=true;
						do {
							
							menu.modificarCliente();
							opcion = es.recogerTextoSinEspacio();
							es.reocogerTextoEspacios();
							
							switch (opcion){
							
								case "1":
									boolean Nombre=true;
									modificar=true;
									do {
										
										System.out.println("Dime el nuevo nombre: ");
										nombre= es.reocogerTextoEspacios();
										
										if (ps.comprobarCaracter(nombre)==true) {
											p.setNombre(nombre);
											Nombre=false;
										}else {
											System.out.println("El nombre debe ser una cadena de caracteres");
										}
										
									}while(Nombre);
									
									System.out.println("Modificado correctamente");
									System.out.println("-------------------------");
									System.out.println(p.toString());
									
									while(modificar==true) {
										boolean resultado=true;
										
										System.out.println("");
										resultado=desearModificar();
										
										if(resultado==true) {
											modificar=false;
											Telefono=false;
										}else {
											modificar=false;
											cliente=false;
										}
									}
									
								break;
								
								case "2":
									boolean Apellidos=true;
									modificar=true;
									do {
										
										System.out.println("Dime los nuevos apellidos: ");
										apellidos= es.reocogerTextoEspacios();
										
										StringTokenizer tokens=new StringTokenizer(apellidos);
										control=true;
										
										while(tokens.hasMoreTokens() && control){
											
											String cadena=tokens.nextToken();
											
											if (ps.comprobarCaracter(cadena)==true) {
												control=true;
											}else {
												System.out.println("El nombre debe ser una cadena de caracteres");
												Apellidos=true;
												control=false;
											}
									    }
										
										if(control==true) {
											p.setApellidos(apellidos);
											System.out.println("Modificado correctamente");
											System.out.println("-------------------------");
											System.out.println(p.toString());
											Apellidos=false;
										}										
										
									}while(Apellidos);
									
									while(modificar==true) {
										boolean resultado=true;
										
										System.out.println("");
										resultado=desearModificar();
										
										if(resultado==true) {
											modificar=false;
											Telefono=false;
										}else {
											modificar=false;
											cliente=false;
										}
									}
									
								break;
								
								case "3":
									boolean correcto=true;
									modificar=true;
									do {
										System.out.println("");
										System.out.println("Dime el nuevo tel\u00e9fono movil: ");
										telefono=es.reocogerTextoEspacios();
										
										if (ps.comprobarTelefono(telefono)==true) {
											correcto=false;
										}else {
											correcto=true;
										}
									
										if (correcto==false) {
										
											if (Gestion_personas.size()==0) {
												Telefono=false;
											}else {
											
												Iterator <Persona> it1=Gestion_personas.iterator();
												control=true;
												
												while (it1.hasNext() && control) {
												
												Persona p1=it1.next();
												
													if (p1.getTelefono().equals(telefono)) {
													
													System.out.println("El numero de telefono ya esta registrado.");
													System.out.println("------------------------------------------");
													control=false;
													Telefono=true;
													modificar=false;
													
													}else { 
														control=true; 
													}
												}
											
												if (control==true) {
													p.setTelefono(telefono);
													System.out.println("Modificado correctamente");
													System.out.println("--------------------------");
													System.out.println(p.toString());
													inicio=true;
													Telefono=false;
												}
											}
											
										}else if (correcto==true) {
											System.out.println("Telefono incorrecto. Vuelve a intentarlo.");
											System.out.println("-------------------------------------------");
											Telefono=true;
										}
									
									}while(Telefono);
								
								while(modificar==true) {
									boolean resultado=true;
									
									System.out.println("");
									resultado=desearModificar();
									
									if(resultado==true) {
										modificar=false;
										Telefono=false;
									}else {
										modificar=false;
										cliente=false;
									}
								}
									
								break;
								
								case "4":
								modificar=true;
										
								System.out.println("Dime el nuevo domicilio: ");
								domicilio= es.reocogerTextoEspacios();
									
								p.setDomicilio(domicilio);
								System.out.println("Modificado correctamente");
								System.out.println("--------------------------");
								System.out.println(p.toString());
								
								while(modificar==true) {
									boolean resultado=true;
									
									System.out.println("");
									resultado=desearModificar();
									
									if(resultado==true) {
										modificar=false;
										Telefono=false;
									}else {
										modificar=false;
										cliente=false;
									}
								}
									
								break;
								
								case "5":
									bucle=false;
								break;
								
								default:
									System.out.println("Numero incorrecto");
							}
							
						}while(bucle);
						}
					}
				}
				
				Iterator<Persona> puntero2 = Gestion_personas.iterator();
				
			}else if (encontrado==false) {
				System.out.println("No existe");
				modificar=false;
			}
			
		}while (cliente);
	}
		
	protected void listadoClientes() {
			 String name;
			 boolean encontrado=true, cliente=true;
			 
			 menu.menuClientes();
			 opcion=es.recogerTextoSinEspacio();
			 
			 switch(opcion) {

				 case "1":
					 
				do {
						 
					 System.out.println("");
					 System.out.println("Dime el nombre del cliente a buscar:");
					 name = es.recogerTextoSinEspacio();
					 
					 Iterator<Persona> puntero = Gestion_personas.iterator();
					 encontrado=true;
					 
					 while (puntero.hasNext() && encontrado) {
						 
						 Persona c;
						 c = puntero.next();

						 if(c instanceof Cliente) {
							 
							 if(c.getNombre().equalsIgnoreCase(name)) {
								 System.out.println("");
								 System.out.println(c.toString());
								 System.out.println("//-------------------------//");
								 System.out.println("");
								 encontrado=false;
								 cliente=false;
							 }							 
						 }
					 }
					 
					 if(encontrado==true) {
						 System.out.println("No existe el cliente. Vuelve a intentarlo");
						 System.out.println("------------------------------------------");
					 }
					 
				}while(cliente);
				
				 break;
		
				 case "2":
					encontrado=true;
					Iterator <Persona> it= Gestion_personas.iterator();
			
					 if (Gestion_personas.size()==0) {
						 System.out.println("No hay personas.");
						 System.out.println("");
					 }
			
					 while(it.hasNext()) {
			
						 Persona p=it.next();
			
						 if(p instanceof Cliente) {
							 System.out.println("");
							 System.out.println(p.toString());
							 encontrado=false;
						 	}
					 }
			
					 if(encontrado==true) {
						 System.out.println("No existen clientes");
					 }
					 
				 break;
			}
	}
		
	protected void Pedidos() {
		ps=new Cliente();
		Cliente cl=new Cliente();
		String quiere, Fecha, precio = null, llevar;
		int i=0;
		double precio_gafas=0, precio_lentillas=0, resultado=0;
		boolean cliente=true, producto=true, fecha=true, gafas=true, lentillas=true, otro=true, Precio=true, correcto=true, control1=true, control=true;
		
		ArrayList<Producto> Productos_Cliente=new ArrayList<Producto>();
		
		do {
			
			System.out.println("Dime el DNI del cliente: ");
			DNI=es.recogerTextoSinEspacio();
			
				if (ps.validar(DNI)==true) {
					correcto=true;
					
				}else {
					correcto=false;
				}
			
			if (correcto==true) {
				
				if (Gestion_personas.size()==0) {
					cliente=false;
					
				}else {
					
					Iterator <Persona> it=Gestion_personas.iterator();
					control=true;
					i=0;
					
					while (it.hasNext() && control) {
						
						Persona p=it.next();
							
						if (p.getDNI().equals(DNI)) {
							
							if(p instanceof Cliente) {
								cl=(Cliente) p;
								cliente=false;
								control=false;
							}else {
								i++;
							}
								
						}else {
							i++;
							control=true;
						}													
					}
				}
				
			}else if (correcto==false) {
				System.out.println("El DNI es incorrecto");				
			}
			
			if(control==true) {
				System.out.println("El DNI de cliente no esta registrado");
			}
				
		}while(cliente);	
		
		
			
			if(Gestion_productos.size()==0) {
				System.out.println("No existen productos");
			}else {
				
				do {
					Iterator<Producto>it=Gestion_productos.iterator();			
					
					System.out.println("");
					System.out.println("------Lista de productos---");	
					while(it.hasNext()) {
							
						Producto pdo=it.next();
						
						System.out.println("");
						System.out.println(pdo.toString());
					}
					
					System.out.println("");
					System.out.println("Dime la ID del producto que quiere el cliente");
					ID=es.recogerTextoSinEspacio();
						
					Iterator<Producto>it1=Gestion_productos.iterator();
					control=true;
						
					while(it1.hasNext() && control) {
							
						Producto pdo=it1.next();
							
						if(pdo.getID().equals(ID)) {
							
							if(pdo instanceof Gafas) {
								Gafas gf=(Gafas) pdo;
								precio_gafas=pdo.getPrecio_venta();
								
								do {
									producto=true;
									System.out.println("¿Cuantos quieres llevarte?");
									llevar=es.recogerTextoSinEspacio();
									if(ps.comprobarNumero(llevar)) {					
										int numero=Integer.parseInt(llevar);
										
										if(numero<=0) {
											System.out.println("Debe ser mayor que 0");
										}else {
											int cantidad=pdo.getCantidad();
											System.out.println(cantidad);
											if(numero>cantidad) {
												System.out.println("No es posible llevarte mas de lo que tenemos");
											}else {										
												gf.setCantidad(cantidad-numero);
												Productos_Cliente.add(gf);
												pdo.setCantidad_comprada(numero);
												gafas=false;
												control=false;
												producto=false;
											}
										}
										
									}else {
										System.out.println("La cantidad debe ser un numero");
									}
								}while(producto);

							}else if(pdo instanceof Lentillas){
								Lentillas lt = (Lentillas) pdo;
								precio_lentillas=pdo.getPrecio_venta();
								do {
									producto=true;
									System.out.println("¿Cuantos quieres llevarte?");
									llevar=es.recogerTextoSinEspacio();
									if(ps.comprobarNumero(llevar)) {					
										int numero=Integer.parseInt(llevar);
										
										if(numero<=0) {
											System.out.println("Debe ser mayor que 0");
										}else {
											int cantidad=pdo.getCantidad();
											System.out.println(cantidad);
											if(numero>cantidad) {
												System.out.println("No es posible llevarte mas de lo que tenemos");
											}else {										
												lt.setCantidad(cantidad-numero);
												Productos_Cliente.add(lt);
												pdo.setCantidad_comprada(numero);
												lentillas=false;
												control=false;
												producto=false;
											}
										}
										
									}else {
										System.out.println("La cantidad debe ser un numero");
									}
								}while(producto);						
							}
						}
					}
					
					for (int j= 0; j < Gestion_personas.size(); j++) {
						if(Gestion_personas.get(j).getDNI().equals(DNI) && Gestion_personas.get(j).getTipo().equals("cliente")) {
							if(control==false && gafas==false) {
								resultado+=precio_gafas+((((Cliente) Gestion_personas.get(j)).getOjo_der()+((Cliente) Gestion_personas.get(j)).getOjo_izq())*5);
								producto=false;
							}else if (control==false && lentillas==false) {
								resultado+=precio_lentillas+((((Cliente) Gestion_personas.get(j)).getOjo_der()+((Cliente) Gestion_personas.get(j)).getOjo_izq())*5);
								producto=false;				
							}
						}
					}
					
					if(control==false) {
						boolean querer=true;
						do {					
						
							System.out.print("Si el cliente desea llevarse algun producto mas pulse 1 sino 2: ");
							quiere=es.recogerTextoSinEspacio();
							
							switch(quiere){
									
								case "1":
									producto=true;
									querer=false;
								break;
								
								case "2":
									producto=false;
									querer=false;
								break;
								
								default:
									System.out.println("Numero incorrecto");
							}
							
						}while(querer);
					}
					
				}while(producto);
					
				do {
						
					System.out.println("Dime la fecha de compra. Formato: dd/mm/YYYY");
					Fecha=es.recogerTextoSinEspacio();
						
					if(ps.comprobarFecha(Fecha)==true) {
						fecha=false;									
					}else {
						System.out.println("Fecha incorrecta");
						System.out.println("------------------");
					}
						
				}while(fecha);
				
				System.out.println("El precio es: "+resultado+"");
				precio=Double.toString(resultado);
				
				Pedidos pedido=new Pedidos(cl, Productos_Cliente, Fecha, precio);
				listaPedidos.add(pedido);
				
				System.out.println("");	
				System.out.println("Cliente: ");
				System.out.println("");
				System.out.println(cl);
				System.out.println("");
				System.out.println("Productos: ");
				System.out.println("");
				
				for (Producto p: Productos_Cliente) {
					System.out.println(p.toString());
					System.out.println("");
				}
				
				System.out.println("Fecha: "+Fecha);
				System.out.println("");
				System.out.println("Precio: "+precio);
				
			}
	}
	
	protected void mostrarPedidos() {
		Pedidos pedido=new Pedidos();
		
		System.out.println("--------------Resumen del Pedido------------");
		System.out.println(pedido.toString(listaPedidos));
	}
}

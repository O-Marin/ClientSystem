package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.github.omarin.PruebaModulo4SistemaDeClientes.menu.CreateFile;
import com.github.omarin.PruebaModulo4SistemaDeClientes.menu.ReadFile;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;

public class Menu{
	ClienteServicio clienteServicio;
	ArchivoServicio archivoServicio;
	ExportadorCsv exportarCSV;
	ExportadorTxt exportarTXT;
	
	
	String fileName = "Clientes";
	String fileName1 = "DBClientes.csv";
	static Scanner sc = new Scanner(System.in);
	
	public Menu() {
		
	}

	public void iniciarMenu() {
		clienteServicio = new ClienteServicio(null);
		
		//Mostrar el menu
		boolean salir = true;
		while(salir) {
			//opciones del menu, todavia no agrego validaciones.
			System.out.println("1. Listar Clientes");
			System.out.println("2. Agregar Cliente");
			System.out.println("3. Editar Cliente");
			System.out.println("4. Cargar Datos");
			System.out.println("5. Exportar Datos");
			System.out.println("6. Salir");
			System.out.println("Ingrese una opcion:");
			int userChoice = sc.nextInt();
			switch (userChoice) {
		case(1):
			//Listar Clientes
			if(clienteServicio.getListaClientes().isEmpty()) {
				System.out.println("La lista de clientes esta vacia.");
			}else {
				clienteServicio.listarClientes();
			}
			
			break;
		case(2):
			System.out.println("Ingresa rut del cliente");
			String rut = sc.next();
			System.out.println("Ingresa nombre del cliente");
			String nombre = sc.next();
			System.out.println("Ingresa apellido del cliente");
			String apellido = sc.next();
			System.out.println("Ingresa edad del cliente");
			String edad = sc.next();;
			//crear y agregar cliente
			clienteServicio.agregarCliente(rut,nombre,apellido,CategoriaEnum.valueOf("Activo"),edad);
			System.out.println("Cliente agregado con exito");
			break;
		case(3):
			System.out.println(clienteServicio.getListaClientes());
			editarCliente();
				break;
			
		case(4):
			importarDatos(clienteServicio.getListaClientes());
			
			break;
		case(5):
			/*exportar datos opciones txt y csv
			 * createFile.
			 * Considerar que debe usar la */
			
			System.out.println("-------------------Exportar Datos--------------------");
			System.out.println("Seleccione el formato a exportar");
			System.out.println("1.-Formato CSV");
			System.out.println("2.-Formato Txt");
			System.out.println();
			System.out.println("Ingrese opcion para Exportar:");
			System.out.println("----------------------------------------");
			userChoice = sc.nextInt();
			switch(userChoice) {
			case 1:
				exportarCSV = new ExportadorCsv();		
				exportarCSV.exportar(fileName1, clienteServicio.getListaClientes());
				System.out.println("Datos de clientes exportados correctamente en formato csv.");
				break;
			case 2:
				exportarTXT = new ExportadorTxt();
				exportarTXT.exportar(fileName, clienteServicio.getListaClientes());
				System.out.println("Datos de clientes exportados correctamente en formato txt.");
				break;
			}
			
			break;
			
		case(6):
			salir = terminarPrograma(salir);
			break;
			}
		}
		System.out.println("Adios, gracias por usar nuestros servicios");
		
		}
	
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.iniciarMenu();
	}

public void listarCliente(List<Cliente> listaClientes) {
	listaClientes.forEach(System.out::println);
}
public void agregarCliente(String rut, String nombre, String apellido, CategoriaEnum categoria, String edad) {	
	Cliente cliente = new Cliente(rut,nombre,apellido,categoria,edad);
	clienteServicio.getListaClientes().add(cliente);
	
}
	public void editarCliente() {
		
		System.out.println("-------------Editar Cliente-------------");
		System.out.println("Selecciona que desea hacer");
		System.out.println("1.-Cambiar el estado del Cliente");
		System.out.println("2.-Editar los datos ingresados del Cliente");
		System.out.println("Ingrese opcion:");
		System.out.println("----------------------------------------");
		int userChoice = sc.nextInt();
		switch(userChoice) {
		case(1):
			
			System.out.println("Ingrese el rut del cliente a editar: ");
			String rutIngresado = sc.next();
			
			
			for(Cliente tempCliente : clienteServicio.getListaClientes()) {
				String tempRun = tempCliente.getRut();
				if(tempRun.equals(rutIngresado)) {
					System.out.println("-------------Actualizando estado del Cliente-------------");
					System.out.println("El estado actual es: " + tempCliente.getCategoria());
					System.out.println("1.-Si desea cambiar el estado del Cliente");
					System.out.println("2.-Si desea mantener el estado del Cliente");
					System.out.println();
					System.out.println("Ingrese opcion:");
					System.out.println("----------------------------------------");
					userChoice = sc.nextInt();
					switch(userChoice) {
					case 1:
						if(tempCliente.getCategoria().toString() == "Activo") {
							tempCliente.setCategoria(CategoriaEnum.valueOf("Inactivo"));
						}else {
							tempCliente.setCategoria(CategoriaEnum.valueOf("Activo"));
						}
						
						break;
					case 2:
						System.out.println("Categoria del cliente no ha sufrido cambios");
						break;
						}
					} 	
				}	
			break;
		case(2):
			System.out.println("Ingrese el rut del cliente a editar: ");
			rutIngresado = sc.next();
			for(Cliente tempCliente : clienteServicio.getListaClientes()) {
				String tempRun = tempCliente.getRut();
				if(tempRun.equals(rutIngresado)) {
					System.out.println("----Actualizando datos del Cliente-----");
					System.out.println();
					System.out.println("1.-El RUN del Cliente es: " + tempCliente.getRut());
					System.out.println("2.-El Nombre del Cliente es: " + tempCliente.getNombre());
					System.out.println("3.-El Apellido del Cliente es: " + tempCliente.getApellido());
					System.out.println("4.-La edad del Cliente es: " + tempCliente.getEdad());
					System.out.println();
					System.out.println("Ingrese opcion a editar de los datos del cliente:");
					System.out.println("----------------------------------------");
					userChoice = sc.nextInt();
					switch(userChoice) {
					case 1:
						System.out.println("1.-Ingrese nuevo RUN del Cliente:");
						String nuevoRun = sc.next();
						tempCliente.setRut(nuevoRun);
						System.out.println("---------------------------------------");
						System.out.println("Datos cambiados con exito");
						break;
					case 2:
						System.out.println("1.-Ingrese nuevo nombre del Cliente:");
						String nuevoNombre = sc.next();
						tempCliente.setNombre(nuevoNombre);
						System.out.println("---------------------------------------");
						System.out.println("Datos cambiados con exito");
						break;
					case 3:
						System.out.println("1.-Ingrese nuevo apellido del Cliente:");
						String nuevoApellido = sc.next();
						tempCliente.setApellido(nuevoApellido);
						System.out.println("---------------------------------------");
						System.out.println("Datos cambiados con exito");
						break;
					case 4:
						System.out.println("1.-Ingrese nueva edad del Cliente:");
						String nuevaEdad = sc.next();
						tempCliente.setEdad(nuevaEdad);
						System.out.println("---------------------------------------");
						System.out.println("Datos cambiados con exito");
						break;
					}		
				}
			}		
			break;
		}		
			
	}
	public void importarDatos(List<Cliente> clienteDB) {
		archivoServicio = new ArchivoServicio();
		System.out.println();
		System.out.println("------------------Cargar Datos---------------------");
		ArrayList<Cliente> importacion = archivoServicio.cargarDatos(fileName);;
		clienteDB.addAll(importacion);
		System.out.println("---------------------------------------");
	}
	
	public static void exportarDatos() {
		
	}
	
	public boolean terminarPrograma(boolean salir) {
		System.out.println("Programa Terminado");	
		salir = false;		
		return salir;
	}

}

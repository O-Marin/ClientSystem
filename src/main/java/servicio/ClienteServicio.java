package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;
import vista.Menu;

public class ClienteServicio {
	List<Cliente> listaClientes;

	public ClienteServicio(List<Cliente> listaClientes) {
		this.listaClientes = new ArrayList<Cliente>() ;
	}
	
	public List<Cliente> getListaClientes(){
		return listaClientes;
	}
	public void listarClientes() {
		listaClientes.forEach(System.out::println);
	}

	public void setClientes(Cliente cliente) {
		this.listaClientes.add(cliente);
	}

public String agregarCliente(String rut, String nombre, String apellido, CategoriaEnum categoria, String edad) {	
		Cliente cliente = new Cliente(rut,nombre,apellido,categoria,edad);
		listaClientes.add(cliente);
		return("Cliente Agregado");
	}

public void editarCliente(String rut, String nombre, String apellido, CategoriaEnum categoria, String edad) {
	for(Cliente tempCliente : listaClientes) {
		String tempRun = tempCliente.getRut();
	}
	
}
	
	public static void main(String[] args) {
		ClienteServicio clienteServicio = new ClienteServicio(null);
		Cliente cliente = new Cliente(null, null, null, null, null);
		clienteServicio.setClientes(cliente);
		clienteServicio.listarClientes();
		System.out.println(clienteServicio.getListaClientes());
		clienteServicio.editarCliente(null, null, null, null, null);
		System.out.println(clienteServicio.getListaClientes().get(0).getRut());
	}
	
	
}

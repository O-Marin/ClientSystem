package servicio;

import java.util.List;

import modelo.Cliente;

public abstract class Exportador {
// Lo que no comprendo es cual es la diferencia de extender la clase o no hacerlo, siendo que teniendo las dos clases por separado, 
// Cada cual tiene su metodo implementado a su pinta de todas maneras, lo unico que cambia es la ruta que se entrega.
	public abstract void exportar(String fileName, List<Cliente> listaClientes);	
	
}

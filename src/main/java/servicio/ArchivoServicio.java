package servicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<Cliente>  cargarDatos(String fileName) {
		ArrayList<Cliente> clientesCargados = new ArrayList<Cliente>();
	
		try {
			File archivo = new File("src/main/java/archivos/"+fileName);
			FileWriter fw;
			BufferedWriter bw;
			FileReader fr;
			BufferedReader br;
			Scanner reader = new Scanner(archivo);
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				String[] hello = data.split(",");
					
				Cliente cliente = new Cliente(null,null,null,null,null);
				cliente.setRut(hello[0]);
				cliente.setNombre(hello[1]);
				cliente.setApellido(hello[2]);
				cliente.setCategoria(CategoriaEnum.valueOf(hello[3]));
				cliente.setEdad(hello[4]);
				clientesCargados.add(cliente);
			}
			reader.close();
			
			
			System.out.println("Datos cargados correctamente en la lista");
	}catch(IOException e) {
		System.out.println("Error");
		e.printStackTrace();
}
		return clientesCargados;
	}
	}

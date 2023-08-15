package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;

public class ExportadorCsv extends Exportador {
	public void exportar(String fileName, List<Cliente> listaClientes) {
		File archivo = new File("src/main/java/archivos/"+fileName);
		
		try {
			
			if (archivo.createNewFile()) {  
				BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
		        System.out.println("File created: " + archivo.getName());  
		        
		        for(Cliente tempCliente : listaClientes) {
		        	bw.write(tempCliente.getRut());
		        	bw.write(";");
		        	bw.write(tempCliente.getNombre());
		        	bw.write(";");
		        	bw.write(tempCliente.getApellido());
		        	bw.write(";");
		        	bw.write(tempCliente.getCategoria().toString());
		        	bw.write(";");
		        	bw.write(tempCliente.getEdad());
		        	bw.write("\n");
		        	
		        	
		        }

				bw.close();
		      } else {  
		        System.out.println("File already exists.");  

		      }  
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

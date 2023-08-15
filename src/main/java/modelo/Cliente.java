package modelo;

public class Cliente {
 private String rut;
 private String nombre;
 private String apellido;
 private CategoriaEnum categoria; 
 private String edad;

public Cliente(String rut, String nombre, String apellido, CategoriaEnum categoria, String edad) {
	super();
	this.rut = rut;
	this.nombre = nombre;
	this.apellido = apellido;
	this.categoria = categoria;
	this.edad = edad;
}

public String getRut() {
	return rut;
}
public void setRut(String rut) {
	this.rut = rut;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public CategoriaEnum getCategoria() {
	return categoria;
}
public void setCategoria(CategoriaEnum categoria) {
	this.categoria = categoria;
}
public String getEdad() {
	return edad;
}
public void setEdad(String edad) {
	this.edad = edad;
}


@Override
public String toString() {
	return "--------------------DATOS DEL CLIENTE--------------------------"
			
			+ "\nRun del cliente:" + rut + "\nNombre del cliente: " + nombre 
			+ "\nApellido del cliente: " + apellido + "\nEdad del Cliente: " + edad + "\nCategoria del Cliente: " + categoria
			+ "\n---------------------------------------------------------------\n";
}
 
 
 
}

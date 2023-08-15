package com.github.omarin.PruebaModulo4SistemaDeClientes;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

public class ClienteServicioTest {
	ClienteServicio clienteServicioTest = mock(ClienteServicio.class);
	
	@Test
	public void agregarClienteTest() {
		clienteServicioTest.agregarCliente("44", "Arturo", "bierto",CategoriaEnum.valueOf("Activo") , "72");
		when(clienteServicioTest.agregarCliente("44", "Arturo", "bierto",CategoriaEnum.valueOf("Activo") , "72")).thenReturn("OK");
		
		String agregarCliente = clienteServicioTest.agregarCliente("44", "Arturo", "bierto",CategoriaEnum.valueOf("Activo") , "72");
		assertEquals("OK", agregarCliente);
		
		verify(clienteServicioTest).agregarCliente("44", "Arturo", "bierto",CategoriaEnum.valueOf("Activo") , "72");
	}
	
	public void agregarClienteNullTest() {
		clienteServicioTest.agregarCliente(null, null, null, null, null);
		when(clienteServicioTest.agregarCliente(null, null, null, null, null)).thenThrow(new NullPointerException());
	}
}

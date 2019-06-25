package co.com.ceiba.dominio.modelo;

import org.junit.Test;

import co.com.ceiba.dominio.BasePrueba;

import co.com.ceiba.dominio.excepcion.ExcepcionArgumentoObligatorio;
import co.com.ceiba.dominio.excepcion.ExcepcionTipoVehiculo;

import co.com.ceiba.dominio.testdatabuilder.RegistroParqueoTestDataBuilder;


public class RegistroParqueoTest {
	@Test
	public void validarPlacaObligatoria() {
		//Arrange
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder();
		registroParqueoTestDataBuilder.conPlaca(null);
		//Act - Assert
		BasePrueba.assertThrows(()-> registroParqueoTestDataBuilder.build(), ExcepcionArgumentoObligatorio.class, "La placa es un dato obligaorio");
	}
	
	@Test
	public void validarTipoVehiculo() {
		//Arrange
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder();
		registroParqueoTestDataBuilder.elVehiculoEs("TRACTO");
		//Act - Assert
		BasePrueba.assertThrows(()-> registroParqueoTestDataBuilder.build(), ExcepcionTipoVehiculo.class, "El parqueadero solo admite carro y moto");
	}
	
		
}

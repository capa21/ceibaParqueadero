package co.com.ceiba.dominio.pruebasunitarias;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import co.com.ceiba.dominio.testdatabuilder.RegistroParqueoTestDataBuilder;
import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.dominio.modelo.TipoVehiculo;

public class RegistroParqueoTest {
	
	private RegistroParqueoTestDataBuilder registroParqueoBuilder;
	private RegistroParqueo registroParqueo;
	private static final String CILINDRAJE_MOTO = "500";
	private static final String CILINDRAJE_CARRO = "";
	private static final boolean REGISTRADO_EXITOSO = true;
	private static final Date FECHAENTRADA = Calendar.getInstance().getTime();
	private static final String PLACA_MOTO = "JCA-151";
	private static final String PLACA_CARRO = "LPP-102";
	
	/* VerificaQueSeHizoUnIngresoCorrectoParaUnTipoDeVehiculoMoto*/
	@Test
	public void registrarParqueoMoto() {
		// arrange
		this.registroParqueoBuilder = new RegistroParqueoTestDataBuilder().conPlaca(PLACA_MOTO)
				.elVehiculoEs(TipoVehiculo.MOTO).concilindraje(CILINDRAJE_MOTO).conEstado(REGISTRADO_EXITOSO)
				.conFechaEntrada(FECHAENTRADA);
		// act
		this.registroParqueo = this.registroParqueoBuilder.build();
		// assert
		assertNotNull(registroParqueo);
	}
	
	/* VerificaQueSeHizoUnIngresoCorrectoParaUnTipoDeVehiculoCarro*/
	@Test
	public void registrarParqueoCarro() {
		// arrange
		this.registroParqueoBuilder = new RegistroParqueoTestDataBuilder().conPlaca(PLACA_CARRO)
				.elVehiculoEs(TipoVehiculo.CARRO).concilindraje(CILINDRAJE_CARRO).conEstado(REGISTRADO_EXITOSO)
				.conFechaEntrada(FECHAENTRADA);
		// act
		this.registroParqueo = this.registroParqueoBuilder.build();
		// assert
		assertNotNull(registroParqueo);
	}

}

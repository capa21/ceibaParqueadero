package co.com.ceiba.dominio.pruebasunitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import co.com.ceiba.dominio.modelo.TipoVehiculo;
import co.com.ceiba.dominio.modelo.ValidadorArgumento;
import co.com.ceiba.dominio.excepcion.ExcepcionArgumentoObligatorio;
import co.com.ceiba.dominio.excepcion.ExcepcionTipoVehiculo;

public class ValidadorArgumentoTest {
	private static final String VACIO = "";
	private static final String PLACA_VACIA = "Este parqueadero solo admite carro y moto";
	private static final String TIPO_VEHICULO_VALIDO = "Este parqueadero solo admite carro y moto";
	
	@Test
	public void validadorArgumentoVacio() {
		try {
			// act
			ValidadorArgumento.validarObligatorio(VACIO, PLACA_VACIA);
		} catch (ExcepcionArgumentoObligatorio e) {
			// assert
			assertEquals(e.getMessage(), PLACA_VACIA);
		}
	}
	
	@Test
	public void validadorArgumentoNulo() {
		try {
			// act
			ValidadorArgumento.validarObligatorio(null, PLACA_VACIA);
			fail();
		} catch (ExcepcionArgumentoObligatorio e) {
			// assert
			assertEquals(e.getMessage(), PLACA_VACIA);
		}
	}
	
	@Test
	public void validadorArgumentoTipoVehiculoInvalido() {
		try {
			// act
			ValidadorArgumento.validarTipoVehiculo(TipoVehiculo.valueOf("MOTO"), TIPO_VEHICULO_VALIDO);
		} catch (ExcepcionTipoVehiculo e) {
			// assert
			assertEquals(e.getMessage(), TIPO_VEHICULO_VALIDO);
		}
	}
	
	
	
	

}

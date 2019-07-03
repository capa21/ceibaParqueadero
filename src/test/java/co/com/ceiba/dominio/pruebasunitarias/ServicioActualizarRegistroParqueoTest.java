package co.com.ceiba.dominio.pruebasunitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.dominio.testdatabuilder.RegistroParqueoTestDataBuilder;
import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.dominio.modelo.TipoVehiculo;
import co.com.ceiba.dominio.excepcion.ExcepcionVehiculoNoEstaEnElParqueadero;
import co.com.ceiba.dominio.puerto.repositorio.IRepositorioRegistroParqueo;
import co.com.ceiba.dominio.servicio.ServicioActualizarRegistroParqueo;

public class ServicioActualizarRegistroParqueoTest {
	
	private IRepositorioRegistroParqueo repositorioRegistroParqueo;
	private ServicioActualizarRegistroParqueo servicio;
	private RegistroParqueoTestDataBuilder registroParqueoBuilder;
	private RegistroParqueo registroParqueo;
	
	private static final String VEHICULO_NO_DENTRO = "Este vehiculo no se encuentra en el parqueadero";
	private static final String PLACA = "JCA-151";
	private static final String CILINDRAJE_EXTRA = "750";
	private static final String CILINDRAJE = "350";
	private static final int DIAS_PRUEBA_CARRO = 1;
	private static final int HORAS_PRUEBA_CARRO = 2;
	private static final int DIAS_PRUEBA_MOTO = 0;
	private static final int HORAS_PRUEBA_MOTO = 10;
	private static final float PRECIO_PRUEBA_MOTO = 4000;
	private static final float PRECIO_EXTRA_PRUEBA_MOTO = 6000;
	private static final float PRECIO_PRUEBA_CARRO = 11000;
	
	@Before
	public void setUp() {
		// arrange
		this.repositorioRegistroParqueo = mock(IRepositorioRegistroParqueo.class);
	}
	
	@Test
	public void build() {
		// act
		this.servicio = new ServicioActualizarRegistroParqueo(this.repositorioRegistroParqueo);
		// assert
		assertNotNull(this.repositorioRegistroParqueo);
		assertNotNull(this.servicio);
	}
	
	@Test
	public void vehiculoNoEstaEnParqueadero() {
		// arrange
		when(this.repositorioRegistroParqueo.vehiculoEstaEnElParqueadero(PLACA)).thenReturn(false);
		when(this.repositorioRegistroParqueo.salidaExitosa(this.registroParqueo)).thenReturn(false);
		
		this.servicio = new ServicioActualizarRegistroParqueo(this.repositorioRegistroParqueo);
		try {
			// act
			this.servicio.registrarSalidaVehiculo(PLACA);
			fail();
		} catch (ExcepcionVehiculoNoEstaEnElParqueadero e) {
			// assert
			assertEquals(e.getMessage(), VEHICULO_NO_DENTRO);
		}
	}
	
	@Test
	public void vehiculoEnParqueadero() {
		// arrange
		when(this.repositorioRegistroParqueo.vehiculoEstaEnElParqueadero(PLACA)).thenReturn(true);
		this.servicio = new ServicioActualizarRegistroParqueo(this.repositorioRegistroParqueo);
		try {
			// act
			this.servicio.registrarSalidaVehiculo(PLACA);
		} catch (ExcepcionVehiculoNoEstaEnElParqueadero e) {
		}
	}
	
	@Test
	public void registroSalidaMoto() {
		// arrange
		Calendar enEsteMomento = Calendar.getInstance();
		enEsteMomento.set(enEsteMomento.get(Calendar.YEAR), enEsteMomento.get(Calendar.MONTH),
				enEsteMomento.get(Calendar.DATE) - DIAS_PRUEBA_MOTO,
				enEsteMomento.get(Calendar.HOUR_OF_DAY) - HORAS_PRUEBA_MOTO, 0);
		
		Date fechaEntrada = enEsteMomento.getTime();
		
		this.registroParqueoBuilder = new RegistroParqueoTestDataBuilder().concilindraje(CILINDRAJE) 
				.conPlaca(PLACA).elVehiculoEs(TipoVehiculo.MOTO).conFechaEntrada(fechaEntrada);
		
		this.registroParqueo = this.registroParqueoBuilder.build();
		
		when(this.repositorioRegistroParqueo.registroDeVehiculo(PLACA)).thenReturn(this.registroParqueo);
		when(this.repositorioRegistroParqueo.salidaExitosa(registroParqueo)).thenReturn(true);
		
		this.servicio = new ServicioActualizarRegistroParqueo(this.repositorioRegistroParqueo);
		
		// act
		Float precio = this.servicio.registrarSalidaVehiculo(PLACA);
		boolean salidaExitosa = this.repositorioRegistroParqueo.salidaExitosa(registroParqueo);
		// assert
		assertEquals(PRECIO_PRUEBA_MOTO, precio, 0);
		assertEquals(true, salidaExitosa);
	}
	
	@Test
	public void registroSalidaMotoExtra() {
		// arrange
		Calendar enEsteMomento = Calendar.getInstance();
		enEsteMomento.set(enEsteMomento.get(Calendar.YEAR), enEsteMomento.get(Calendar.MONTH),
				enEsteMomento.get(Calendar.DATE) - DIAS_PRUEBA_MOTO,
				enEsteMomento.get(Calendar.HOUR_OF_DAY) - HORAS_PRUEBA_MOTO, 0);
		
		Date fechaEntrada = enEsteMomento.getTime();
		
		this.registroParqueoBuilder = new RegistroParqueoTestDataBuilder().concilindraje(CILINDRAJE_EXTRA) 
				.conPlaca(PLACA).elVehiculoEs(TipoVehiculo.MOTO).conFechaEntrada(fechaEntrada);
		
		this.registroParqueo = this.registroParqueoBuilder.build();
		
		when(this.repositorioRegistroParqueo.registroDeVehiculo(PLACA)).thenReturn(this.registroParqueo);
		when(this.repositorioRegistroParqueo.salidaExitosa(registroParqueo)).thenReturn(true);
		
		this.servicio = new ServicioActualizarRegistroParqueo(this.repositorioRegistroParqueo);
		
		// act
		Float precio = this.servicio.registrarSalidaVehiculo(PLACA);
		boolean salidaExitosa = this.repositorioRegistroParqueo.salidaExitosa(registroParqueo);
		// assert
		assertEquals(PRECIO_EXTRA_PRUEBA_MOTO, precio, 0);
		assertEquals(true, salidaExitosa);
	}
	
	@Test
	public void registroSalidaCarro() {
		// arrange
		Calendar enEsteMomento = Calendar.getInstance();
		enEsteMomento.set(enEsteMomento.get(Calendar.YEAR), enEsteMomento.get(Calendar.MONTH),
				enEsteMomento.get(Calendar.DATE) - DIAS_PRUEBA_CARRO,
				enEsteMomento.get(Calendar.HOUR_OF_DAY) - HORAS_PRUEBA_CARRO, 0);
		
		Date fechaEntrada = enEsteMomento.getTime();
		
		this.registroParqueoBuilder = new RegistroParqueoTestDataBuilder() 
				.conPlaca(PLACA).elVehiculoEs(TipoVehiculo.CARRO).conFechaEntrada(fechaEntrada);
		
		this.registroParqueo = this.registroParqueoBuilder.build();
		
		when(this.repositorioRegistroParqueo.registroDeVehiculo(PLACA)).thenReturn(this.registroParqueo);
		when(this.repositorioRegistroParqueo.salidaExitosa(registroParqueo)).thenReturn(true);
		
		this.servicio = new ServicioActualizarRegistroParqueo(this.repositorioRegistroParqueo);
		
		// act
		Float precio = this.servicio.registrarSalidaVehiculo(PLACA);
		boolean salidaExitosa = this.repositorioRegistroParqueo.salidaExitosa(registroParqueo);
		// assert
		assertEquals(PRECIO_PRUEBA_CARRO, precio, 0);
		assertEquals(true, salidaExitosa);
	}
	

}

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
import co.com.ceiba.dominio.excepcion.ExcepcionParqueaderoLleno;
import co.com.ceiba.dominio.excepcion.ExcepcionIngresoNoPermitido;
import co.com.ceiba.dominio.excepcion.ExcepcionVehiculoEstaEnElParqueadero;
import co.com.ceiba.dominio.puerto.repositorio.IRepositorioRegistroParqueo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarParqueo;

public class ServicioRegistrarParqueoTest {
	
	private IRepositorioRegistroParqueo repositorioRegistroParqueo;
	private ServicioRegistrarParqueo servicio;
	private RegistroParqueoTestDataBuilder registroParqueoBuilder;
	private RegistroParqueo registroParqueo;
	private Date hoy;
	
	private static final String CILINDRAJE = "300";
	private static final String PLACA = "URG-585";
	private static final String INGRESO_PLACA_NO_PERMITIDA = "ACJ-151";
	private static final String INGRESO_NO_PERMITIDO = "Solo puede ingresar domingo y lunes";
	private static final String VEHICULO_DENTRO = "Este vehiculo se encuentra dentro del parqueadero";
	private static final long MAXIMA_CAPACIDAD_DE_MOTOS = 10;
	private static final long MAXIMA_CAPACIDAD_DE_CARROS = 20;
	private static final String NO_HAY_CUPO_PARA_MOTOS = "Lo siento, no hay cupo para motos";
	private static final String NO_HAY_CUPO_PARA_CARROS = "Lo siento, no hay cupo para carros";
	
	@Before
	public void setUp() {
		// arrange
		this.repositorioRegistroParqueo = mock(IRepositorioRegistroParqueo.class);
		this.hoy = Calendar.getInstance().getTime();
	}
	
	@Test
	public void build() {
		// act
		this.servicio = new ServicioRegistrarParqueo(this.repositorioRegistroParqueo);
		// assert
		assertNotNull(this.repositorioRegistroParqueo);
		assertNotNull(this.servicio);
	}
	
	@Test
	public void registrarParqueoMoto() {
		// arrange
		this.registroParqueoBuilder  = new RegistroParqueoTestDataBuilder().concilindraje(CILINDRAJE).conPlaca(PLACA) 
				.elVehiculoEs(TipoVehiculo.MOTO).conFechaEntrada(hoy);
		
		this.registroParqueo= this.registroParqueoBuilder.build();
		
		this.registroParqueoBuilder  = new RegistroParqueoTestDataBuilder().concilindraje(CILINDRAJE).conPlaca(PLACA) 
				.elVehiculoEs(TipoVehiculo.MOTO).conFechaEntrada(hoy).conPrecio(0).conEstado(true);
		
		RegistroParqueo nuevoRegistroParqueo = this.registroParqueoBuilder.build();
		
		when(this.repositorioRegistroParqueo.registrarParqueo(this.registroParqueo)).thenReturn(nuevoRegistroParqueo);
		
		this.servicio = new ServicioRegistrarParqueo(this.repositorioRegistroParqueo);
		
		// act
		RegistroParqueo respuestaRegistroParqueo = this.servicio.registrarParqueo(this.registroParqueo);
		// assert
		assertEquals(respuestaRegistroParqueo, nuevoRegistroParqueo);
	}
	
	@Test
	public void registrarParqueoCarro() {
		// arrange
		this.registroParqueoBuilder  = new RegistroParqueoTestDataBuilder().conPlaca(PLACA) 
				.elVehiculoEs(TipoVehiculo.CARRO).conFechaEntrada(hoy);
		
		this.registroParqueo= this.registroParqueoBuilder.build();
		
		this.registroParqueoBuilder  = new RegistroParqueoTestDataBuilder().conPlaca(PLACA) 
				.elVehiculoEs(TipoVehiculo.CARRO).conFechaEntrada(hoy).conPrecio(0).conEstado(true);
		
		RegistroParqueo nuevoRegistroParqueo = this.registroParqueoBuilder.build();
		
		when(this.repositorioRegistroParqueo.registrarParqueo(this.registroParqueo)).thenReturn(nuevoRegistroParqueo);
		
		this.servicio = new ServicioRegistrarParqueo(this.repositorioRegistroParqueo);
		
		// act
		RegistroParqueo respuestaRegistroParqueo = this.servicio.registrarParqueo(this.registroParqueo);
		// assert
		assertEquals(respuestaRegistroParqueo, nuevoRegistroParqueo);
	}
	
	@Test
	public void vehiculoEnParqueadero() {
		// arrange
		this.registroParqueoBuilder  = new RegistroParqueoTestDataBuilder().conPlaca(PLACA) 
				.elVehiculoEs(TipoVehiculo.CARRO).conFechaEntrada(hoy);
		
		this.registroParqueo = this.registroParqueoBuilder.build();
		
		when(this.repositorioRegistroParqueo.vehiculoEstaEnElParqueadero(PLACA)).thenReturn(true);
		
		this.servicio = new ServicioRegistrarParqueo(this.repositorioRegistroParqueo);
		
		try {
			// act
			this.servicio.registrarParqueo(this.registroParqueo);
		} catch (ExcepcionVehiculoEstaEnElParqueadero e) {
			// assert
			assertEquals(e.getMessage(), VEHICULO_DENTRO);
		}
	}
	
	@Test
	public void vehiculoNoEstaEnParqueadero() {
		// arrange
		this.registroParqueoBuilder  = new RegistroParqueoTestDataBuilder().concilindraje(CILINDRAJE).conPlaca(PLACA) 
				.elVehiculoEs(TipoVehiculo.MOTO).conFechaEntrada(hoy);
		
		this.registroParqueo = this.registroParqueoBuilder.build();
		
		when(this.repositorioRegistroParqueo.vehiculoEstaEnElParqueadero(PLACA)).thenReturn(false);
		
		this.servicio = new ServicioRegistrarParqueo(this.repositorioRegistroParqueo);
		
		try {
			// act
			this.servicio.registrarParqueo(this.registroParqueo);
		} catch (ExcepcionVehiculoEstaEnElParqueadero e) {}
	}
	
	@Test
	public void validarRegistroExiste() {
		// arrange
		this.registroParqueoBuilder  = new RegistroParqueoTestDataBuilder().concilindraje(CILINDRAJE).conPlaca(PLACA) 
				.elVehiculoEs(TipoVehiculo.MOTO).conFechaEntrada(hoy);
		
		this.registroParqueo = this.registroParqueoBuilder.build();
		//act-assert
		when(this.repositorioRegistroParqueo.vehiculoEstaEnElParqueadero(PLACA)).thenReturn(true);
		assertEquals(this.repositorioRegistroParqueo.vehiculoEstaEnElParqueadero(PLACA), true);
	}
	
	@Test
	public void validarRegistroNoExiste() {
		// arrange
		this.registroParqueoBuilder  = new RegistroParqueoTestDataBuilder().concilindraje(CILINDRAJE).conPlaca(PLACA) 
				.elVehiculoEs(TipoVehiculo.MOTO).conFechaEntrada(hoy);
		
		this.registroParqueo = this.registroParqueoBuilder.build();
		//act-assert
		when(this.repositorioRegistroParqueo.vehiculoEstaEnElParqueadero(PLACA)).thenReturn(false);
		assertEquals(this.repositorioRegistroParqueo.vehiculoEstaEnElParqueadero(PLACA), false);
	}
	
	@Test
	public void validarCupoLlenoMotos() {
		// arrange
		this.registroParqueoBuilder  = new RegistroParqueoTestDataBuilder().concilindraje(CILINDRAJE).conPlaca(PLACA) 
				.elVehiculoEs(TipoVehiculo.MOTO).conFechaEntrada(hoy);
		this.registroParqueo = this.registroParqueoBuilder.build();
		
		when(this.repositorioRegistroParqueo.cantidadMotosEnElParqueadero()).thenReturn(MAXIMA_CAPACIDAD_DE_MOTOS);
		
		this.servicio = new ServicioRegistrarParqueo(this.repositorioRegistroParqueo);
		try {
			// act
			this.servicio.registrarParqueo(this.registroParqueo);
			fail();
		} catch (ExcepcionParqueaderoLleno e) {
			// assert
			assertEquals(e.getMessage(), NO_HAY_CUPO_PARA_MOTOS);
		}
	}
	
	@Test
	public void validarCupoLlenoCarros() {
		// arrange
		this.registroParqueoBuilder  = new RegistroParqueoTestDataBuilder().conPlaca(PLACA) 
				.elVehiculoEs(TipoVehiculo.CARRO).conFechaEntrada(hoy);
		this.registroParqueo = this.registroParqueoBuilder.build();
		
		when(this.repositorioRegistroParqueo.cantidadCarrosEnElParqueadero()).thenReturn(MAXIMA_CAPACIDAD_DE_CARROS);
		
		this.servicio = new ServicioRegistrarParqueo(this.repositorioRegistroParqueo);
		try {
			// act
			this.servicio.registrarParqueo(this.registroParqueo);
			fail();
		} catch (ExcepcionParqueaderoLleno e) {
			// assert
			assertEquals(e.getMessage(), NO_HAY_CUPO_PARA_CARROS);
		}
	}
	
	@Test
	public void validaeEntradaDeVehiculos() {
		// arrange
		Calendar enEsteMomento = Calendar.getInstance();
		enEsteMomento.set(2019, 5, 5);
		Date hoyAlterado = enEsteMomento.getTime();
		
		this.registroParqueoBuilder  = new RegistroParqueoTestDataBuilder().concilindraje(CILINDRAJE).conPlaca(INGRESO_PLACA_NO_PERMITIDA) 
				.elVehiculoEs(TipoVehiculo.MOTO).conFechaEntrada(hoyAlterado);
		this.registroParqueo = this.registroParqueoBuilder.build();
		
		this.servicio = new ServicioRegistrarParqueo(this.repositorioRegistroParqueo);
		
		try {
			// act
			this.servicio.registrarParqueo(this.registroParqueo);
			fail();
		} catch (ExcepcionIngresoNoPermitido e) {
			// assert
			assertEquals(e.getMessage(), INGRESO_NO_PERMITIDO);
		}

	}
	

}

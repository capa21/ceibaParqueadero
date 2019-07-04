package co.com.ceiba.insfraestructura.pintegracionTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.com.ceiba.AplicacionMock;
import co.com.ceiba.ParqueaderoApplication;
import co.com.ceiba.insfraestructura.pintegracion.testDatabuilder.ComandoRegistroParqueoDataBuilder;
import co.com.ceiba.aplicacion.comando.ComandoRegistroParqueo;
import co.com.ceiba.aplicacion.comun.ComandoRespuesta;
//import co.com.ceiba.dominio.excepcion.ExcepcionIngresoNoPermitido;
import co.com.ceiba.dominio.excepcion.ExcepcionVehiculoNoEstaEnElParqueadero;
import co.com.ceiba.dominio.modelo.TipoVehiculo;
import co.com.ceiba.infraestructura.error.Error;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AplicacionMock.class)
@SpringBootTest(classes = ParqueaderoApplication.class)
@AutoConfigureMockMvc
public class RegistroParqueoControladorTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mvc;
	private static final String URL_REGISTROSPARQUEO = "/registroVehiculos";
	private static final String PLACA_CARRO = "LPP-01";
	private static final String PLACA_CARRO_RETIRAR = "LPP-02";
	private static final String PLACA_MOTO = "JCA-01";
	private static final String PLACA_MOTO_RETIRAR = "JCA-02";
	private static final String PLACA_INGRESO_FALLIDO = "ARG-58p";
	private static final String CILINDRAJE = "400";
	private static final float PRECIO_CARRO = 1000;
	private static final float PRECIO_MOTO = 500;
	private static final String VEHICULO_NO_DENTRO = "Este vehiculo no se encuentra en el parqueadero";
	
	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void obtenerRegistrosParqueoActivos() throws Exception {
		this.mvc.perform(get(URL_REGISTROSPARQUEO).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
	
	@Test
	public void registroIngresoCarro() throws Exception {
		ComandoRegistroParqueoDataBuilder registroParqueoBuilder = new ComandoRegistroParqueoDataBuilder().conPlaca(PLACA_CARRO)
				.esTipoVehiculo(TipoVehiculo.CARRO);
		
		ComandoRegistroParqueo comandoRegistro = registroParqueoBuilder.build();
		
		JSONObject jsonComandoRegistroParqueo = new JSONObject(comandoRegistro);
		ComandoRespuesta<ComandoRegistroParqueo> comandoRespuesta = new ComandoRespuesta<>(comandoRegistro);
		JSONObject jsonRegistroParqueoComandoRespuesta = new JSONObject(comandoRespuesta);
		mvc.perform(post(URL_REGISTROSPARQUEO).content(jsonComandoRegistroParqueo.toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(jsonRegistroParqueoComandoRespuesta.toString()));
	}
	
	@Test
	public void registroIngresoMoto() throws Exception {
		ComandoRegistroParqueoDataBuilder registroParqueoBuilder = new ComandoRegistroParqueoDataBuilder().conPlaca(PLACA_MOTO)
				.esTipoVehiculo(TipoVehiculo.MOTO).conCilindraje(CILINDRAJE);
		
		ComandoRegistroParqueo comandoRegistro = registroParqueoBuilder.build();
		
		JSONObject jsonComandoRegistroParqueo = new JSONObject(comandoRegistro);
		ComandoRespuesta<ComandoRegistroParqueo> comandoRespuesta = new ComandoRespuesta<>(comandoRegistro);
		JSONObject jsonRegistroParqueoComandoRespuesta = new JSONObject(comandoRespuesta);
		mvc.perform(post(URL_REGISTROSPARQUEO).content(jsonComandoRegistroParqueo.toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(jsonRegistroParqueoComandoRespuesta.toString()));
	}
	
	@Test
	public void registroSalidaMoto() throws Exception {
		ComandoRegistroParqueoDataBuilder registroParqueoBuilder = new ComandoRegistroParqueoDataBuilder()
							.conPlaca(PLACA_MOTO_RETIRAR);
		
		ComandoRegistroParqueo comandoRegistro = registroParqueoBuilder.build();
		
		JSONObject jsonComandoRegistroParqueo = new JSONObject(comandoRegistro);
		ComandoRespuesta<Float> comandoRespuesta = new ComandoRespuesta<>(PRECIO_MOTO);
		JSONObject jsonRegistroParqueoComandoRespuesta = new JSONObject(comandoRespuesta);
		mvc.perform(put(URL_REGISTROSPARQUEO).content(jsonComandoRegistroParqueo.toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(jsonRegistroParqueoComandoRespuesta.toString()));
	}
	
	@Test
	public void registroSalidaCarro() throws Exception {
		ComandoRegistroParqueoDataBuilder registroParqueoBuilder = new ComandoRegistroParqueoDataBuilder()
							.conPlaca(PLACA_CARRO_RETIRAR);
		
		ComandoRegistroParqueo comandoRegistro = registroParqueoBuilder.build();
		
		JSONObject jsonComandoRegistroParqueo = new JSONObject(comandoRegistro);
		ComandoRespuesta<Float> comandoRespuesta = new ComandoRespuesta<>(PRECIO_CARRO);
		JSONObject jsonRegistroParqueoComandoRespuesta = new JSONObject(comandoRespuesta);
		mvc.perform(put(URL_REGISTROSPARQUEO).content(jsonComandoRegistroParqueo.toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(jsonRegistroParqueoComandoRespuesta.toString()));
	}
	
	
	@Test
	public void registroSalidaMotoExcepcionFallo() throws Exception {
		ComandoRegistroParqueoDataBuilder registroParqueoBuilder = new ComandoRegistroParqueoDataBuilder()
							.conPlaca(PLACA_INGRESO_FALLIDO).esTipoVehiculo(TipoVehiculo.MOTO).conCilindraje(CILINDRAJE);
		
		ComandoRegistroParqueo comandoRegistro = registroParqueoBuilder.build();
		
		JSONObject jsonComandoRegistroParqueo = new JSONObject(comandoRegistro);
		
		String nombreExcepcion = ExcepcionVehiculoNoEstaEnElParqueadero.class.getSimpleName();
		
		Error error = new Error(nombreExcepcion,VEHICULO_NO_DENTRO);
		
		JSONObject errorJsonRespuesta = new JSONObject(error);
				
		mvc.perform(put(URL_REGISTROSPARQUEO).content(jsonComandoRegistroParqueo.toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound()).andExpect(content().json(errorJsonRespuesta.toString()));
	}
	
	
	
	
	
}

package co.com.ceiba.infraestructura.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import co.com.ceiba.aplicacion.comando.manejador.ManejadorRegistrarParqueo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorActualizarRegistroParqueo;
import co.com.ceiba.aplicacion.comando.ComandoRegistroParqueo;
import co.com.ceiba.aplicacion.comun.ComandoRespuesta;
import co.com.ceiba.aplicacion.consulta.ManejadorCosultaRegistrosParqueoActivos;
import co.com.ceiba.aplicacion.consulta.ConsultaRegistrosParqueoActivos;


@RestController
@RequestMapping("/registroVehiculos")
@Api (tags = {"Controlador registro"})
public class RegistroParqueoControlador {
	
	private final ManejadorRegistrarParqueo manejadorRegistrarParqueo;
	private final ManejadorActualizarRegistroParqueo manejadorActualizarRegistroParqueo;
	private final ManejadorCosultaRegistrosParqueoActivos manejadorCosultaRegistrosParqueoActivos;
	
	@Autowired
	public RegistroParqueoControlador(ManejadorRegistrarParqueo manejadorRegistrarParqueo,
			ManejadorActualizarRegistroParqueo manejadorActualizarRegistroParqueo,
			ManejadorCosultaRegistrosParqueoActivos manejadorCosultaRegistrosParqueoActivos) {
		
		this.manejadorRegistrarParqueo = manejadorRegistrarParqueo;
		this.manejadorActualizarRegistroParqueo = manejadorActualizarRegistroParqueo;
		this.manejadorCosultaRegistrosParqueoActivos = manejadorCosultaRegistrosParqueoActivos;
	}
	
	@PostMapping
	@ApiOperation("Crear Registro")
	public ComandoRespuesta<ComandoRegistroParqueo> post(@RequestBody ComandoRegistroParqueo registroComando){
		return manejadorRegistrarParqueo.exec(registroComando);
	}
	
	@GetMapping
	@ApiOperation("Consultar Registros")
	public List<ConsultaRegistrosParqueoActivos> get() {
		return this.manejadorCosultaRegistrosParqueoActivos.exec();
	}
	
	@PutMapping()
	@ApiOperation("Actualizar Registro")
	public ComandoRespuesta<Float> put(@RequestBody ComandoRegistroParqueo registroComando) {
		return this.manejadorActualizarRegistroParqueo.exec(registroComando.getPlacaVehiculo());
	}
}

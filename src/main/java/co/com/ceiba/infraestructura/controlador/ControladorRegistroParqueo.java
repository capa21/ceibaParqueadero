package co.com.ceiba.infraestructura.controlador;

import java.util.Collection;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.aplicacion.comando.ComandoRegistroParqueo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorRegistrarParqueo;
import co.com.ceiba.aplicacion.consulta.manejador.ManejadorListarRegistros;
import co.com.ceiba.dominio.modelo.RegistroParqueo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/registroParqueo")
@Api(tags = { "Controlador registro"})
public class ControladorRegistroParqueo {
	private final ManejadorListarRegistros manejadorListarRegistros;
	private final ManejadorRegistrarParqueo manejadorRegistrarParqueo;
	
	public ControladorRegistroParqueo(ManejadorListarRegistros manejadorListarRegistros,ManejadorRegistrarParqueo manejadorRegistrarParqueo) {
		this.manejadorListarRegistros = manejadorListarRegistros;
		this.manejadorRegistrarParqueo = manejadorRegistrarParqueo;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation("listar")
	public Collection<RegistroParqueo> listar() {
		return this.manejadorListarRegistros.consultar();
	}
	
	@PostMapping
	@ApiOperation("registrar")
	public void crear(@RequestBody ComandoRegistroParqueo comandoUsuario) {
		this.manejadorRegistrarParqueo.registrar(comandoUsuario);
	}
	
	
	
}

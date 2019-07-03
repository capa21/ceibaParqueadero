package co.com.ceiba.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.ceiba.aplicacion.comando.ComandoRegistroParqueo;
import co.com.ceiba.aplicacion.comun.ComandoRespuesta;
import co.com.ceiba.aplicacion.comun.comandomanejadorrespuesta.IComandoManejadorRespuesta;
import co.com.ceiba.aplicacion.factory.RegistroParqueoFactory;
import co.com.ceiba.aplicacion.mapper.RegistroParqueoComandoMapper;
import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarParqueo;

@Component
public class ManejadorRegistrarParqueo implements IComandoManejadorRespuesta<ComandoRegistroParqueo,ComandoRespuesta<ComandoRegistroParqueo>> {
	
	private final RegistroParqueoFactory factory;
	private ServicioRegistrarParqueo servicioRegistrarParqueo;
	private static final RegistroParqueoComandoMapper mapper = RegistroParqueoComandoMapper.getInstancia();
	
	public ManejadorRegistrarParqueo(RegistroParqueoFactory factory,ServicioRegistrarParqueo servicioRegistrarParqueo) {
		this.factory= factory;
		this.servicioRegistrarParqueo = servicioRegistrarParqueo;
	}

	public ComandoRespuesta<ComandoRegistroParqueo> exec(ComandoRegistroParqueo command) {
		RegistroParqueo registroParqueo = this.factory.crear(command); 
		return new ComandoRespuesta<>(mapper.paraComando(this.servicioRegistrarParqueo.registrarParqueo(registroParqueo))) ;
	}

}

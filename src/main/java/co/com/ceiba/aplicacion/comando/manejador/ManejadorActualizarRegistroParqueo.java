package co.com.ceiba.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.ceiba.aplicacion.comun.ComandoRespuesta;
import co.com.ceiba.aplicacion.comun.comandomanejadorrespuesta.IComandoManejadorRespuesta;
import co.com.ceiba.dominio.servicio.ServicioActualizarRegistroParqueo;

@Component
public class ManejadorActualizarRegistroParqueo implements IComandoManejadorRespuesta<String, ComandoRespuesta<Float>> {
	private final ServicioActualizarRegistroParqueo servicioActualizarRegistroParqueo;

	public ManejadorActualizarRegistroParqueo(ServicioActualizarRegistroParqueo servicioActualizarRegistroParqueo) {
		this.servicioActualizarRegistroParqueo = servicioActualizarRegistroParqueo;
	}

	@Override
	public ComandoRespuesta<Float> exec(String placaVehiculo) {
		return new ComandoRespuesta<>(servicioActualizarRegistroParqueo.registrarSalidaVehiculo(placaVehiculo));
	}
	
	
	
	
	
}

package co.com.ceiba.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.ceiba.aplicacion.comando.ComandoRegistroParqueo;
import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.dominio.modelo.RegistroParqueo.TipoVehiculo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarParqueo;

@Component
public class ManejadorRegistrarParqueo {
	private TipoVehiculo tipoVehiculo;
	private ServicioRegistrarParqueo servicioRegistrarParqueo;
	
	public ManejadorRegistrarParqueo(ServicioRegistrarParqueo servicioRegistrarParqueo) {
		this.servicioRegistrarParqueo = servicioRegistrarParqueo;
	}
	
	public void registrar(ComandoRegistroParqueo comandoRegistroParqueo) {
		this.servicioRegistrarParqueo.registrar(new RegistroParqueo(comandoRegistroParqueo.getId(),tipoVehiculo,comandoRegistroParqueo.getPlacaVehiculo()));
	}

}

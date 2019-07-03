package co.com.ceiba.aplicacion.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.servicio.ServicioObtenerRegistrosParqueoActivos;

@Component
public class ManejadorCosultaRegistrosParqueoActivos {
	private final ServicioObtenerRegistrosParqueoActivos servicioObtenerRegistrosParqueoActivos;

	public ManejadorCosultaRegistrosParqueoActivos(ServicioObtenerRegistrosParqueoActivos servicioObtenerRegistrosParqueoActivos) {
		this.servicioObtenerRegistrosParqueoActivos = servicioObtenerRegistrosParqueoActivos;
	}

	public List<ConsultaRegistrosParqueoActivos> exec() {
		return this.servicioObtenerRegistrosParqueoActivos.obtenerRegistrosParqueoActivos();
	}

}

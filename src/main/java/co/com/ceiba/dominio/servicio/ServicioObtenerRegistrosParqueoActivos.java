package co.com.ceiba.dominio.servicio;

import java.util.List;

import co.com.ceiba.dominio.puerto.repositorio.IRepositorioRegistroParqueo;
import co.com.ceiba.aplicacion.consulta.ConsultaRegistrosParqueoActivos;

public class ServicioObtenerRegistrosParqueoActivos {
	private IRepositorioRegistroParqueo repositorioRegistroParqueo;
	
	public ServicioObtenerRegistrosParqueoActivos(IRepositorioRegistroParqueo repositorioRegistroParqueo) {
		this.repositorioRegistroParqueo = repositorioRegistroParqueo;
	}
	
	public List<ConsultaRegistrosParqueoActivos> obtenerRegistrosParqueoActivos() {
		return this.repositorioRegistroParqueo.obtenerRegistrosParqueoActivos();
	}
	
	
	
}

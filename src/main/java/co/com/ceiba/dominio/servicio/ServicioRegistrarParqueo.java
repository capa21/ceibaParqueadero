package co.com.ceiba.dominio.servicio;

import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.dominio.puerto.repositorio.IRepositorioRegistroParqueo;

public class ServicioRegistrarParqueo {
	
	private IRepositorioRegistroParqueo repositorioRegistroParqueo;
	
	public ServicioRegistrarParqueo(IRepositorioRegistroParqueo repositorioRegistroParqueo) {
		this.repositorioRegistroParqueo = repositorioRegistroParqueo;
	}
	
	public void registrar(RegistroParqueo registroParqueo) {
		this.repositorioRegistroParqueo.registrar(registroParqueo);
	}
}

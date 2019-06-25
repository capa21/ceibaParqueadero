package co.com.ceiba.dominio.servicio;

import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroParqueo;

public class ServicioRegistrarParqueo {
	
	private RepositorioRegistroParqueo repositorioRegistroParqueo;
	
	public ServicioRegistrarParqueo(RepositorioRegistroParqueo repositorioRegistroParqueo) {
		this.repositorioRegistroParqueo = repositorioRegistroParqueo;
	}
	
	public void registrar(RegistroParqueo registroParqueo) {
		this.repositorioRegistroParqueo.registrar(registroParqueo);
	}
}

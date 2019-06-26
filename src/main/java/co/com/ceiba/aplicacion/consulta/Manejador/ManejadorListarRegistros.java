package co.com.ceiba.aplicacion.consulta.manejador;

import java.util.Collection;

import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroParqueo;


@Component
public class ManejadorListarRegistros {
	private final RepositorioRegistroParqueo repositorioRegistroParqueo;
	
	public ManejadorListarRegistros(RepositorioRegistroParqueo daoRegistroParqueo) {
		this.repositorioRegistroParqueo = daoRegistroParqueo;
	}
	
	public Collection<RegistroParqueo> consultar(){
		return this.repositorioRegistroParqueo.listar();
	}
	
	
}

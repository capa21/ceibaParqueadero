package co.com.ceiba.aplicacion.consulta.manejador;

import java.util.Collection;

import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.dominio.puerto.repositorio.IRepositorioRegistroParqueo;


@Component
public class ManejadorListarRegistros {
	private final IRepositorioRegistroParqueo repositorioRegistroParqueo;
	
	public ManejadorListarRegistros(IRepositorioRegistroParqueo daoRegistroParqueo) {
		this.repositorioRegistroParqueo = daoRegistroParqueo;
	}
	
	public Collection<RegistroParqueo> consultar(){
		return this.repositorioRegistroParqueo.listar();
	}
	
	
}

package co.com.ceiba.dominio.puerto.repositorio;

import java.util.Collection;
import co.com.ceiba.dominio.modelo.RegistroParqueo;

public interface IRepositorioRegistroParqueo {
	
	Collection<RegistroParqueo> listar();
	void registrar (RegistroParqueo registroParqueo);
}

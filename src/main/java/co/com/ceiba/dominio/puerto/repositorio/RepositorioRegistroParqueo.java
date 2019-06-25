package co.com.ceiba.dominio.puerto.repositorio;

import java.util.Collection;
import co.com.ceiba.dominio.modelo.RegistroParqueo;

public interface RepositorioRegistroParqueo {
	
	Collection<RegistroParqueo> listar();
	void registrar (RegistroParqueo registroParqueo);
}

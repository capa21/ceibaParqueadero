package co.com.ceiba.infraestructura.adaptador.repositorio;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroParqueo;

@Repository
public class RepositorioRegistroParqueoEnMemoria implements RepositorioRegistroParqueo {
	private static ConcurrentHashMap<String, RegistroParqueo> registros;
	
	static {
		registros = new ConcurrentHashMap<>();
		registros.put(UUID.randomUUID().toString(), new RegistroParqueo(1,"CARRO","JCA 101"));
	}
	
	@Override
	public Collection<RegistroParqueo> listar(){
		return getRegistros();
	}
	
	@Override
	public void registrar(RegistroParqueo registroParqueo) {
		registros.put(UUID.randomUUID().toString(), registroParqueo);
	}

	private static Collection<RegistroParqueo> getRegistros() {
		return registros.values();
	}

}

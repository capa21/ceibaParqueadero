package co.com.ceiba.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.dominio.puerto.repositorio.IRepositorioRegistroParqueo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarParqueo;
import co.com.ceiba.dominio.servicio.ServicioObtenerRegistrosParqueoActivos;
import co.com.ceiba.dominio.servicio.ServicioActualizarRegistroParqueo;

@Configuration
public class ServicioBean {
	
	@Bean
	public ServicioRegistrarParqueo servicioCrearRegistro(IRepositorioRegistroParqueo repositorioRegistroParqueo) {
		return new ServicioRegistrarParqueo(repositorioRegistroParqueo);
	}
	
	@Bean
	public ServicioActualizarRegistroParqueo servicioActualizarRegistro(IRepositorioRegistroParqueo repositorioRegistroParqueo) {
		return new ServicioActualizarRegistroParqueo(repositorioRegistroParqueo);
	}
	
	@Bean
	public ServicioObtenerRegistrosParqueoActivos servicioListarRegistros(IRepositorioRegistroParqueo repositorioRegistroParqueo) {
		return new ServicioObtenerRegistrosParqueoActivos(repositorioRegistroParqueo);
	}
	
}

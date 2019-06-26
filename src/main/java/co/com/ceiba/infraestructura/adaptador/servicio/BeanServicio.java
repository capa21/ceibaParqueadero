package co.com.ceiba.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioRegistroParqueoEnMemoria;
import co.com.ceiba.dominio.servicio.ServicioRegistrarParqueo;

@Configuration
public class BeanServicio {
	
	@Bean
	public ServicioRegistrarParqueo servicioRegistrarParqueo() {
		return new ServicioRegistrarParqueo(new RepositorioRegistroParqueoEnMemoria());
	}

}

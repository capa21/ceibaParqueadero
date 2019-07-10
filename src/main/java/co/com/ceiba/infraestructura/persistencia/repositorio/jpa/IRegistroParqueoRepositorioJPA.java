package co.com.ceiba.infraestructura.persistencia.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.aplicacion.consulta.ConsultaRegistrosParqueoActivos;
import co.com.ceiba.infraestructura.persistencia.modelo.RegistroParqueoModelo;

public interface IRegistroParqueoRepositorioJPA extends CrudRepository<RegistroParqueoModelo,Long> {
	
	@Query("select new co.com.ceiba.aplicacion.consulta.ConsultaRegistrosParqueoActivos(r.id,r.placaVehiculo,r.fechaEntrada,r.tipoVehiculo) from RegistroParqueoModelo r where r.estado = true")
	List<ConsultaRegistrosParqueoActivos> registrosParqueoActivos();
	
	@Query("select r from RegistroParqueoModelo r where r.estado = true and r.placaVehiculo = :placaVehiculo")
	RegistroParqueoModelo buscarPorPlacaVehiculo(@Param("placaVehiculo") String placaVehiculo);
	
	@Query("select count(*) from RegistroParqueoModelo r where r.tipoVehiculo = 'MOTO' and r.estado = true")
	long contarMotosActivas();
	
	@Query("select count(*) from RegistroParqueoModelo r where r.tipoVehiculo = 'CARRO' and r.estado = true")
	long contarCarrosActivos();
}

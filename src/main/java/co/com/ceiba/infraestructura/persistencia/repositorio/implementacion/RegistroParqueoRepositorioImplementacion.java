package co.com.ceiba.infraestructura.persistencia.repositorio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.aplicacion.consulta.ConsultaRegistrosParqueoActivos;
import co.com.ceiba.dominio.excepcion.ExcepcionVehiculoNoEstaEnElParqueadero;
import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.dominio.puerto.repositorio.IRepositorioRegistroParqueo;
import co.com.ceiba.infraestructura.persistencia.modelo.RegistroParqueoModelo;
import co.com.ceiba.infraestructura.persistencia.mapper.RegistroParqueoMapper;
import co.com.ceiba.infraestructura.persistencia.repositorio.jpa.IRegistroParqueoRepositorioJPA;


@Component
public class RegistroParqueoRepositorioImplementacion implements IRepositorioRegistroParqueo {
	
	private static final String VEHICULO_NO_DENTRO = "Este vehiculo no se encuentra en el parqueadero";
	private static final RegistroParqueoMapper mapper = RegistroParqueoMapper.getInstance();
	
	@Autowired
	private IRegistroParqueoRepositorioJPA jpa;

	@Override
	public RegistroParqueo registrarParqueo(RegistroParqueo registro) {
		RegistroParqueoModelo modelo = mapper.haciaModelo(registro);
		return mapper.haciaDomino(jpa.save(modelo));
	}

	@Override
	public List<ConsultaRegistrosParqueoActivos> obtenerRegistrosParqueoActivos() {
		return jpa.registrosParqueoActivos();
	}

	@Override
	public boolean salidaExitosa(RegistroParqueo registro) {
		RegistroParqueoModelo modelo = mapper.haciaModelo(registro);
		return jpa.save(modelo) != null;
	}

	@Override
	public boolean vehiculoEstaEnElParqueadero(String placaVehiculo) {
		RegistroParqueoModelo modelo = jpa.buscarPorPlacaVehiculo(placaVehiculo);
		return modelo != null;
	}
	
	@Override
	public RegistroParqueo registroDeVehiculo(String placaVehiculo) {
		RegistroParqueoModelo modelo = jpa.buscarPorPlacaVehiculo(placaVehiculo);
		if(modelo == null) {
			throw new ExcepcionVehiculoNoEstaEnElParqueadero(VEHICULO_NO_DENTRO);
		}
		return mapper.haciaDomino(modelo);
	}

	@Override
	public long cantidadCarrosEnElParqueadero() {
		return jpa.contarCarrosActivos();
	}

	@Override
	public long cantidadMotosEnElParqueadero() {
		return jpa.contarMotosActivas();
	}

	@Override
	public RegistroParqueo registrarSalida(RegistroParqueo registro) {
		return this.registrarParqueo(registro);
	}
	
}

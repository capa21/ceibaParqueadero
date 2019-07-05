package co.com.ceiba.dominio.puerto.repositorio;

import java.util.List;
import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.aplicacion.consulta.ConsultaRegistrosParqueoActivos;

public interface IRepositorioRegistroParqueo {

	RegistroParqueo registrarParqueo(RegistroParqueo registroParqueo);
	
	public List<ConsultaRegistrosParqueoActivos> obtenerRegistrosParqueoActivos();
	
	public boolean salidaExitosa(RegistroParqueo registroParqueo);
	
	public boolean vehiculoEstaEnElParqueadero(String placaVehiculo);
	
	public RegistroParqueo registroDeVehiculo(String placaVehiculo);
	
	public long cantidadMotosEnElParqueadero();
	
	public long cantidadCarrosEnElParqueadero();
	
	public RegistroParqueo registrarSalida(RegistroParqueo registroParqueo);
	
}

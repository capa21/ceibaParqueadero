package co.com.ceiba.dominio.servicio;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.dominio.excepcion.ExcepcionIngresoNoPermitido;
import co.com.ceiba.dominio.excepcion.ExcepcionParqueaderoLleno;
import co.com.ceiba.dominio.excepcion.ExcepcionVehiculoEstaEnElParqueadero;
import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.dominio.modelo.TipoVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.IRepositorioRegistroParqueo;

public class ServicioRegistrarParqueo {
	
	private static final String MOTO = "MOTO";
	private static final String CARRO = "CARRO";

	private IRepositorioRegistroParqueo repositorioRegistroParqueo;
	
	private static final String INGRESO_NO_PERMITIDO = "Solo puede ingresar domingo y lunes";
	private static final String VEHICULO_DENTRO = "Este vehiculo se encuentra dentro del parqueadero";
	private static final String NO_HAY_CUPO_PARA_MOTOS = "Lo siento, no hay cupo para motos";
	private static final String NO_HAY_CUPO_PARA_CARROS = "Lo siento, no hay cupo para carros";
	
	private static final long CAPACIDAD_MAXIMA_MOTOS = 10;
	private static final long CAPACIDAD_MAXIMA_CARROS = 20;
	private static final String PRIMERA_LETRA_PLACA = "A";
	
	public ServicioRegistrarParqueo(IRepositorioRegistroParqueo repositorioRegistroParqueo) {
		this.repositorioRegistroParqueo = repositorioRegistroParqueo;
	}

	public RegistroParqueo registrarParqueo(RegistroParqueo registroParqueo) {
		this.validarVehiculoDentroDelParqueadero(registroParqueo.getPlacaVehiculo());
		this.validarParqueaderoLleno(registroParqueo.getTipoVehiculo());
		this.validarDiaValidoIngreso(registroParqueo.getPlacaVehiculo(),registroParqueo.getFechaEntrada());
				
		return this.repositorioRegistroParqueo.registrarParqueo(registroParqueo);
	}

	private void validarDiaValidoIngreso(String placaVehiculo, Date fechaEntrada) {
		Calendar fechaActual = Calendar.getInstance();
		
		fechaActual.setTimeInMillis(fechaEntrada.getTime());
		int diaFechaActual = fechaActual.get(Calendar.DAY_OF_WEEK);
		if(placaVehiculo.startsWith(PRIMERA_LETRA_PLACA) && diaFechaActual > Calendar.MONDAY){
			throw new ExcepcionIngresoNoPermitido(INGRESO_NO_PERMITIDO);
		}
	}

	private void validarParqueaderoLleno(TipoVehiculo tipoVehiculo) {
		if(tipoVehiculo.esTipo(MOTO) && this.repositorioRegistroParqueo.cantidadMotosEnElParqueadero() == CAPACIDAD_MAXIMA_MOTOS) {
			throw new ExcepcionParqueaderoLleno(NO_HAY_CUPO_PARA_MOTOS);
		}
		if(tipoVehiculo.esTipo(CARRO) && this.repositorioRegistroParqueo.cantidadCarrosEnElParqueadero() == CAPACIDAD_MAXIMA_CARROS) {
			throw new ExcepcionParqueaderoLleno(NO_HAY_CUPO_PARA_CARROS);
		}
	}

	private void validarVehiculoDentroDelParqueadero(String placaVehiculo) {
		if(this.repositorioRegistroParqueo.vehiculoEstaEnElParqueadero(placaVehiculo)) {
			throw new ExcepcionVehiculoEstaEnElParqueadero (VEHICULO_DENTRO);
		}
	}
}

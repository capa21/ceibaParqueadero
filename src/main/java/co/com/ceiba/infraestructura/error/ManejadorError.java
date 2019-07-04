package co.com.ceiba.infraestructura.error;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.ceiba.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.dominio.excepcion.ExcepcionArgumentoObligatorio;
import co.com.ceiba.dominio.excepcion.ExcepcionVehiculoNoEstaEnElParqueadero;
import co.com.ceiba.dominio.excepcion.ExcepcionVehiculoEstaEnElParqueadero;
import co.com.ceiba.dominio.excepcion.ExcepcionParqueaderoLleno;
import co.com.ceiba.dominio.excepcion.ExcepcionIngresoNoPermitido;

@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler {
	private static final Logger LOG = LoggerFactory.getLogger(ManejadorError.class);

	private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrio un error favor contactar al administrador.";
	
	private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

	public ManejadorError() {
		CODIGOS_ESTADO.put(ExcepcionTipoVehiculo.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		CODIGOS_ESTADO.put(ExcepcionArgumentoObligatorio.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		CODIGOS_ESTADO.put(ExcepcionIngresoNoPermitido.class.getSimpleName(), HttpStatus.NOT_ACCEPTABLE.value());
		CODIGOS_ESTADO.put(ExcepcionVehiculoEstaEnElParqueadero.class.getSimpleName(), HttpStatus.NOT_ACCEPTABLE.value());
		CODIGOS_ESTADO.put(ExcepcionVehiculoNoEstaEnElParqueadero.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
		CODIGOS_ESTADO.put(ExcepcionParqueaderoLleno.class.getSimpleName(), HttpStatus.FORBIDDEN.value());
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
		ResponseEntity<Error> resultado;

		String excepcionNombre = exception.getClass().getSimpleName();
		String mensaje = exception.getMessage();
		Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

		if (codigo != null) {
			Error error = new Error(excepcionNombre, mensaje);
			resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
		} else {
			LOG.error(excepcionNombre, exception);
			Error error = new Error(excepcionNombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
			resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resultado;
	}

}

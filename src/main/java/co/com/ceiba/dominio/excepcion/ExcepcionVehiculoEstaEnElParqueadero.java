package co.com.ceiba.dominio.excepcion;

public class ExcepcionVehiculoEstaEnElParqueadero extends RuntimeException {
		
	private static final long serialVersionUID = 1L;

	public ExcepcionVehiculoEstaEnElParqueadero(String mensaje) {
		super(mensaje);
	}
}

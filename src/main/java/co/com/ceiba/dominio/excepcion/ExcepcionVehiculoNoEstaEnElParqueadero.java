package co.com.ceiba.dominio.excepcion;

public class ExcepcionVehiculoNoEstaEnElParqueadero extends RuntimeException {
		
	private static final long serialVersionUID = 1L;

	public ExcepcionVehiculoNoEstaEnElParqueadero(String mensaje) {
		super(mensaje);
	}
}

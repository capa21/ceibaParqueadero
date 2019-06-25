package co.com.ceiba.dominio.excepcion;

public class ExcepcionTipoVehiculo extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ExcepcionTipoVehiculo(String mensaje) {
		super(mensaje);
	}

}

package co.com.ceiba.dominio.excepcion;

public class ExcepcionIngresoNoPermitido extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExcepcionIngresoNoPermitido(String mensaje) {
		super(mensaje);
	}
}

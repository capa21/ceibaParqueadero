package co.com.ceiba.dominio.excepcion;

public class ExcepcionParqueaderoLleno extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ExcepcionParqueaderoLleno(String mensaje) {
		super(mensaje);
	}
	
}

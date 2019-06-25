package co.com.ceiba.dominio.excepcion;

public class ExcepcionArgumentoObligatorio extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExcepcionArgumentoObligatorio(String mensaje) {
		super(mensaje);
	}

}

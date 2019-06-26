package co.com.ceiba.dominio.modelo;

import co.com.ceiba.dominio.excepcion.ExcepcionArgumentoObligatorio;
import co.com.ceiba.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.dominio.modelo.RegistroParqueo.TipoVehiculo;

public class ValidadorArgumento {
	private ValidadorArgumento() {}
	
	public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionArgumentoObligatorio(mensaje);
        }
    }
	
	public static void validarTipoVehiculo(Object valor, String mensaje) {
        if (!(valor instanceof TipoVehiculo)) {
            throw new ExcepcionTipoVehiculo(mensaje);
        }
    }
	

}

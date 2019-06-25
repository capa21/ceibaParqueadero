package co.com.ceiba.dominio.modelo;

import co.com.ceiba.dominio.excepcion.ExcepcionArgumentoObligatorio;
import co.com.ceiba.dominio.excepcion.ExcepcionTipoVehiculo;

public class ValidadorArgumento {
	private ValidadorArgumento() {}
	
	public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionArgumentoObligatorio(mensaje);
        }
    }
	
	public static void validarTipoVehiculo(Object valor, String mensaje) {
        if (valor != "MOTO" && valor != "CARRO" ) {
            throw new ExcepcionTipoVehiculo(mensaje);
        }
    }
	

}

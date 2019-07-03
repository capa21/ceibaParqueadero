package co.com.ceiba.dominio.modelo;

import co.com.ceiba.dominio.excepcion.ExcepcionArgumentoObligatorio;
import co.com.ceiba.dominio.excepcion.ExcepcionTipoVehiculo;

public class ValidadorArgumento {
	private ValidadorArgumento() {
	}

	public static void validarObligatorio(Object valor, String mensaje) {
		if (valor == null) {
			throw new ExcepcionArgumentoObligatorio(mensaje);
		}
	}

	public static void validarTipoVehiculo(TipoVehiculo tipoVehiculo, String mensaje) {
		if (!tipoVehiculo.esTipoValido()) {
			throw new ExcepcionTipoVehiculo(mensaje);
		}
	}

}

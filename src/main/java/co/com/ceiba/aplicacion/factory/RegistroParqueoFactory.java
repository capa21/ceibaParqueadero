package co.com.ceiba.aplicacion.factory;

import java.util.Calendar;

import co.com.ceiba.aplicacion.comando.ComandoRegistroParqueo;
import co.com.ceiba.dominio.modelo.RegistroParqueo;

import org.springframework.stereotype.Component;

@Component
public class RegistroParqueoFactory {
	public RegistroParqueo crear(ComandoRegistroParqueo comandoRegistroParqueo) {
		return new RegistroParqueo(comandoRegistroParqueo.getTipoVehiculo(),
				comandoRegistroParqueo.getPlacaVehiculo(),
				comandoRegistroParqueo.getCilindraje(),
				Calendar.getInstance().getTime()
			);
	}
}

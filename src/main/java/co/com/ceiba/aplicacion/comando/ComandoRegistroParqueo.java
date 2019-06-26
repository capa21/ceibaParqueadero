package co.com.ceiba.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ComandoRegistroParqueo {
	public enum TipoVehiculo{
		CARRO, MOTO
	}
	
	private int id;
	private String placaVehiculo;
	private TipoVehiculo tipoVehiculo;
}




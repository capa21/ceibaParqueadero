package co.com.ceiba.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import co.com.ceiba.dominio.modelo.TipoVehiculo; 


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ComandoRegistroParqueo {
	private Long id;
	private String placaVehiculo;
	private TipoVehiculo tipoVehiculo;
	private String cilindraje;
}

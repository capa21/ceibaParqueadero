package co.com.ceiba.insfraestructura.pintegracion.testDatabuilder;

import co.com.ceiba.aplicacion.comando.ComandoRegistroParqueo;
import co.com.ceiba.dominio.modelo.TipoVehiculo;

public class ComandoRegistroParqueoDataBuilder {
	
	private String placaVehiculo;
	private String cilindraje;
	private TipoVehiculo tipoVehiculo;

	public ComandoRegistroParqueoDataBuilder() {
	}

	public ComandoRegistroParqueoDataBuilder conPlaca(String placa) {
		this.placaVehiculo = placa;
		return this;
	}

	public ComandoRegistroParqueoDataBuilder conCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}

	public ComandoRegistroParqueoDataBuilder esTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}

	public ComandoRegistroParqueo build() {
		ComandoRegistroParqueo registro = new ComandoRegistroParqueo();
		registro.setTipoVehiculo(this.tipoVehiculo);
		registro.setPlacaVehiculo(this.placaVehiculo);
		registro.setCilindraje(this.cilindraje);
				
		return registro;
	}
}

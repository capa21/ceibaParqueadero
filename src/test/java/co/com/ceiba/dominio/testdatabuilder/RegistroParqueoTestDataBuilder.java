package co.com.ceiba.dominio.testdatabuilder;

import co.com.ceiba.dominio.modelo.RegistroParqueo;

public class RegistroParqueoTestDataBuilder {
	private Integer id;
    private String tipoVehiculo;
    private String placaVehiculo;
            
    public RegistroParqueoTestDataBuilder() {
    	this.id = 1;
    	this.tipoVehiculo = "CARRO";
    	this.placaVehiculo = "JCA 101";
    }
    
    public RegistroParqueo build() {
    	return new RegistroParqueo(id, tipoVehiculo,placaVehiculo);
    }

	public RegistroParqueoTestDataBuilder conPlaca(String placa) {
		this.placaVehiculo = placa;
		return this;
	}

	public RegistroParqueoTestDataBuilder elVehiculoEs(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
		
	}
}

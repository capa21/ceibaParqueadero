package co.com.ceiba.dominio.modelo;

public class RegistroParqueo {
	
	private static final String LA_PLACA_ES_UN_DATO_OBLIGATORIO = "La placa del vehículo es un dato obligaorio";
	private static final String TIPO_VEHICULO_VALIDO = "Este parqueadero solo adminte carro y moto";
		
	private Integer id;
    private String tipoVehiculo;
    private String placaVehiculo;
        
    public RegistroParqueo(Integer id, String tipoVehiculo, String placaVehiculo) {
    	ValidadorArgumento.validarObligatorio(placaVehiculo,LA_PLACA_ES_UN_DATO_OBLIGATORIO);
    	ValidadorArgumento.validarTipoVehiculo(tipoVehiculo, TIPO_VEHICULO_VALIDO);
		
    	this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.placaVehiculo = placaVehiculo;
	}
    
    
}

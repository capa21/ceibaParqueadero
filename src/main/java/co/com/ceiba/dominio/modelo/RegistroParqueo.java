package co.com.ceiba.dominio.modelo;

public class RegistroParqueo {
	
	public enum TipoVehiculo {
		CARRO,
		MOTO;
	}
	
	private static final String LA_PLACA_ES_UN_DATO_OBLIGATORIO = "La placa del vehiculo es un dato obligatorio";
	private static final String TIPO_VEHICULO_VALIDO = "Este parqueadero solo adminte carro y moto";
	
	private Integer id;
    private TipoVehiculo tipoVehiculo;
	//private String tipoVehiculo;
	
    private String placaVehiculo;
    
    public RegistroParqueo(Integer id, TipoVehiculo tipoVehiculo, String placaVehiculo) {
    	ValidadorArgumento.validarObligatorio(placaVehiculo,LA_PLACA_ES_UN_DATO_OBLIGATORIO);
    	ValidadorArgumento.validarTipoVehiculo(tipoVehiculo, TIPO_VEHICULO_VALIDO);
		
    	this.id = id;
		
    	this.tipoVehiculo = tipoVehiculo;
    	this.placaVehiculo = placaVehiculo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}
    
    
    
}

package co.com.ceiba.aplicacion.consulta;

import java.util.Date;

public class ConsultaRegistrosParqueoActivos {
	private Long id;
	private String placaVehiculo;
	private String fechaEntrada;
	private String tipoVehiculo;
	
	public ConsultaRegistrosParqueoActivos(Long id, String placaVehiculo,Date fechaEntrada,String tipoVehiculo) {
		this.id = id;
		this.placaVehiculo = placaVehiculo;
		this.fechaEntrada = String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM", fechaEntrada);
		this.tipoVehiculo = tipoVehiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	
	
}

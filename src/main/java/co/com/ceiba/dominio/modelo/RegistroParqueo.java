package co.com.ceiba.dominio.modelo;

import java.util.Date;

public class RegistroParqueo {

	private static final String LA_PLACA_ES_UN_DATO_OBLIGATORIO = "La placa del vehiculo es un dato obligatorio";
	private static final String LA_FECHA_ES_UN_DATO_OBLIGATORIO = "La fecha es un dato obligatorio";
	private static final String EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO = "El tipo de vehiculo es un dato obligatorio";
	private static final String EL_CILINDRAJE_ES_UN_DATO_OBLIGATORIO = "Para las motos el cilindraje es un dato obligatorio";
	private static final String TIPO_VEHICULO_VALIDO = "Este parqueadero solo admite carro y moto";
	
	private Long id;
	private TipoVehiculo tipoVehiculo;
	private String placaVehiculo;
	private Date fechaEntrada;
	private Date fechaSalida;
	private float precio;
	private boolean estado;
	private String cilindraje;

	public RegistroParqueo(TipoVehiculo tipoVehiculo,String placaVehiculo, String cilindraje,Date fechaEntrada) {
		ValidadorArgumento.validarObligatorio(placaVehiculo, LA_PLACA_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(fechaEntrada, LA_FECHA_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(tipoVehiculo, EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO);
		
		if(tipoVehiculo.esTipo("MOTO") ) {
			ValidadorArgumento.validarObligatorio(cilindraje, EL_CILINDRAJE_ES_UN_DATO_OBLIGATORIO);
		}
		
		ValidadorArgumento.validarTipoVehiculo(tipoVehiculo, TIPO_VEHICULO_VALIDO);

		this.tipoVehiculo = tipoVehiculo;
		this.placaVehiculo = placaVehiculo;
		this.cilindraje = cilindraje;
		this.fechaEntrada = fechaEntrada;
		this.estado = true;
	}
	
	public RegistroParqueo() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	

}

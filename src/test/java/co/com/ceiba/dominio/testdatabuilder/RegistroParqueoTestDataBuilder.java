package co.com.ceiba.dominio.testdatabuilder;

import java.util.Date;

import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.dominio.modelo.TipoVehiculo;

public class RegistroParqueoTestDataBuilder {

	private Long id;
	private TipoVehiculo tipoVehiculo;
	private String placaVehiculo;
	private Date fechaEntrada;
	private Date fechaSalida;
	private float precio;
	private boolean estado;
	private String cilindraje;

	public RegistroParqueoTestDataBuilder() {
	}

	public RegistroParqueoTestDataBuilder conPlaca(String placa) {
		this.placaVehiculo = placa;
		return this;
	}

	public RegistroParqueoTestDataBuilder elVehiculoEs(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}
	
	public RegistroParqueoTestDataBuilder conFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		return this;
	}
	
	public RegistroParqueoTestDataBuilder conFechaSalida(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		return this;
	}
	
	public RegistroParqueoTestDataBuilder conPrecio(float precio) {
		this.precio = precio;
		return this;
	}
	
	public RegistroParqueoTestDataBuilder conEstado(boolean estado) {
		this.estado = estado;
		return this;
	}
	
	public RegistroParqueoTestDataBuilder concilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
		
	public RegistroParqueo build(){
		RegistroParqueo registroParqueo = new RegistroParqueo();
		registroParqueo.setId(id);
		registroParqueo.setTipoVehiculo(tipoVehiculo);
		registroParqueo.setPlacaVehiculo(placaVehiculo);
		registroParqueo.setFechaEntrada(fechaEntrada);
		registroParqueo.setFechaSalida(fechaSalida);
		registroParqueo.setPrecio(precio);
		registroParqueo.setEstado(estado);
		registroParqueo.setCilindraje(cilindraje);
		
		return registroParqueo;
	}
}

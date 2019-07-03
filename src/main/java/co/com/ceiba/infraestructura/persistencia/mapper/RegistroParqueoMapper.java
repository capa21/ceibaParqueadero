package co.com.ceiba.infraestructura.persistencia.mapper;

import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.dominio.modelo.TipoVehiculo;
import co.com.ceiba.infraestructura.persistencia.modelo.RegistroParqueoModelo;

public final class RegistroParqueoMapper {
	private RegistroParqueoMapper() {
	}
	
	private static final RegistroParqueoMapper INSTANCIA = new RegistroParqueoMapper();
	
	public static RegistroParqueoMapper getInstance() {
		return INSTANCIA;
	}
	
	public RegistroParqueo haciaDomino(RegistroParqueoModelo registroParqueoModelo) {
		RegistroParqueo dominio = new RegistroParqueo();
		dominio.setCilindraje(registroParqueoModelo.getCilindraje());
		dominio.setFechaEntrada(registroParqueoModelo.getFechaEntrada());
		dominio.setFechaSalida(registroParqueoModelo.getFechaSalida());
		dominio.setId(registroParqueoModelo.getId());
		dominio.setPlacaVehiculo(registroParqueoModelo.getPlacaVehiculo());
		dominio.setPrecio(registroParqueoModelo.getPrecio());
		dominio.setEstado(registroParqueoModelo.isEstado());
		dominio.setTipoVehiculo(TipoVehiculo.valueOf(registroParqueoModelo.getTipoVehiculo()));
		
		return dominio;
	}
	
	public RegistroParqueoModelo haciaModelo(RegistroParqueo registroParqueo) {
		RegistroParqueoModelo modelo = new RegistroParqueoModelo();
		modelo.setCilindraje(registroParqueo.getCilindraje());
		modelo.setFechaEntrada(registroParqueo.getFechaEntrada());
		modelo.setFechaSalida(registroParqueo.getFechaSalida());
		modelo.setId(registroParqueo.getId());
		modelo.setPlacaVehiculo(registroParqueo.getPlacaVehiculo());
		modelo.setPrecio(registroParqueo.getPrecio());
		modelo.setEstado(registroParqueo.isEstado());
		modelo.setTipoVehiculo(registroParqueo.getTipoVehiculo().toString());
		return modelo;
		}
	
}

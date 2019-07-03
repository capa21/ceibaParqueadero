package co.com.ceiba.aplicacion.mapper;

import co.com.ceiba.aplicacion.comando.ComandoRegistroParqueo;
import co.com.ceiba.dominio.modelo.RegistroParqueo;

public final class RegistroParqueoComandoMapper {
	
	private static final RegistroParqueoComandoMapper INSTANCIA = new RegistroParqueoComandoMapper();
	
	private RegistroParqueoComandoMapper() {
	}
	
	public static RegistroParqueoComandoMapper getInstancia() {
		return INSTANCIA;
	}
	
	public ComandoRegistroParqueo paraComando(RegistroParqueo modelo) {
		ComandoRegistroParqueo dominio = new ComandoRegistroParqueo();
		dominio.setId(modelo.getId());
		dominio.setTipoVehiculo(modelo.getTipoVehiculo());
		dominio.setPlacaVehiculo(modelo.getPlacaVehiculo());
		dominio.setCilindraje(modelo.getCilindraje());
		
		
		
		return dominio;
	}

}

package co.com.ceiba.dominio.servicio;

import java.util.Calendar;
import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.modelo.ValidadorArgumento;
import co.com.ceiba.dominio.modelo.RegistroParqueo;
import co.com.ceiba.dominio.servicio.ServicioCobroParqueoCarro;
import co.com.ceiba.dominio.servicio.ServicioCobroParqueoMoto;
import co.com.ceiba.dominio.excepcion.ExcepcionVehiculoNoEstaEnElParqueadero;
import co.com.ceiba.dominio.puerto.repositorio.IRepositorioRegistroParqueo;

@Component
public class ServicioActualizarRegistroParqueo {
	
	private IRepositorioRegistroParqueo repositorioRegistroParqueo;
		
	private static final String VEHICULO_NO_DENTRO = "Este vehiculo no se encuentra en el parqueadero";
	private static final String PLACA_VACIA = "Se debe ingresar la placa para poder registrar la salida de un vehiculo";
		
	public ServicioActualizarRegistroParqueo(IRepositorioRegistroParqueo repositorioRegistroParqueo) {
		this.repositorioRegistroParqueo = repositorioRegistroParqueo;
	}
	
	public float registrarSalidaVehiculo(String placaVehiculo) {
		ValidadorArgumento.validarObligatorio(placaVehiculo, PLACA_VACIA);
		RegistroParqueo registroParqueo = this.validarRegistro(placaVehiculo);
		registroParqueo.setEstado(false);
		registroParqueo.setFechaSalida(Calendar.getInstance().getTime());
		registroParqueo.setPrecio(this.calcularCobroParqueo(registroParqueo));
		this.repositorioRegistroParqueo.registrarSalida(registroParqueo);
		return this.calcularCobroParqueo(registroParqueo);
	}

	private RegistroParqueo validarRegistro(String placaVehiculo) {
		RegistroParqueo registroParqueo = this.repositorioRegistroParqueo.registroDeVehiculo(placaVehiculo);
		if(registroParqueo == null) {
			throw new ExcepcionVehiculoNoEstaEnElParqueadero(VEHICULO_NO_DENTRO);
		}
		return registroParqueo;
	}
	
	public float calcularCobroParqueo(RegistroParqueo registroParqueo) {
		float valorACobrar = 0;
		if (registroParqueo.getTipoVehiculo().esTipo("MOTO")) {
			valorACobrar = new ServicioCobroParqueoMoto(registroParqueo).calcularCobroParqueo (registroParqueo);
		}
		if (registroParqueo.getTipoVehiculo().esTipo("CARRO")) {
			valorACobrar = new ServicioCobroParqueoCarro().calcularCobroParqueo(registroParqueo);
		}
		return valorACobrar;
	}
	
	
	
	
	
	
	
}

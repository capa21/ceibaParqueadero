package co.com.ceiba.dominio.servicio;

import java.util.concurrent.TimeUnit;

import co.com.ceiba.dominio.modelo.RegistroParqueo;

public abstract class ServicioCobroParqueo {

	private static final long HORAS_COBRO_POR_DIAS = 9;
	protected RegistroParqueo registroParqueo;
	
	public float calcularCobroParqueo(RegistroParqueo registroParqueo) {
		this.registroParqueo = registroParqueo;
		long tiempoParqueo = registroParqueo.getFechaSalida().getTime() - registroParqueo.getFechaEntrada().getTime();
		
		long numeroDiasACobrar = this.datosCobro(tiempoParqueo)[0];
		long numeroHorasACobrar = this.datosCobro(tiempoParqueo)[1];
		
		return this.calcularCobro(numeroDiasACobrar,numeroHorasACobrar);
	}

	private long[] datosCobro(long tiempoParqueo) {
		
		long[] datosCobro = new long[2];
		long minutos = TimeUnit.MILLISECONDS.toMinutes(tiempoParqueo);
		long tiempoParqueoHoras = this.numeroHoras(tiempoParqueo);
		long diasACobrar = (tiempoParqueoHoras / 24);
		long horasACobrar = (tiempoParqueoHoras - (diasACobrar* 24));
		
		if(minutos % 60 > 0) {
			horasACobrar++;
		}
		
		if (horasACobrar >= HORAS_COBRO_POR_DIAS) {
			diasACobrar ++;
			horasACobrar = 0;
		}
		
		if (horasACobrar == 0 && diasACobrar == 0) {
			horasACobrar = 1;
		}
		
		datosCobro[0] = diasACobrar;
		datosCobro[1] = horasACobrar;
		
		return datosCobro;
	}

	private long numeroHoras(long tiempoParqueo) {
		return TimeUnit.MILLISECONDS.toHours(tiempoParqueo);
	}

	protected abstract float calcularCobro(long numeroDiasACobrar, long numeroHorasACobrar);
	

}

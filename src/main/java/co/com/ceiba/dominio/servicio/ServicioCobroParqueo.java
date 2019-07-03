package co.com.ceiba.dominio.servicio;

import java.util.concurrent.TimeUnit;

import co.com.ceiba.dominio.modelo.RegistroParqueo;

public abstract class ServicioCobroParqueo {

	private static final long HORAS_COBRO_POR_DIAS = 9;
	protected RegistroParqueo registroParqueo;
	
	public float calcularCobroParqueo(RegistroParqueo registroParqueo) {
		this.registroParqueo = registroParqueo;
		long tiempoParqueo = registroParqueo.getFechaEntrada().getTime() - registroParqueo.getFechaSalida().getTime();
		
		long numeroDiasACobrar = this.numeroDiasACobrar(tiempoParqueo);
		long numeroHorasACobrar = this.numeroHorasACobrar(tiempoParqueo);
		
		return this.calcularCobro(numeroDiasACobrar,numeroHorasACobrar);
	}

	protected long numeroHorasACobrar(long tiempoParqueo) {
		long minutos = TimeUnit.MILLISECONDS.toMinutes(tiempoParqueo);
		long horasACobrar = this.numeroHoras(tiempoParqueo) - (this.numeroDias(tiempoParqueo)* 24);
		
		if(minutos % 60 > 0) {
			horasACobrar++;
		}
		
		if (horasACobrar >= HORAS_COBRO_POR_DIAS) {
			horasACobrar = 0;
		}
		
		if (horasACobrar == 0 && this.numeroDias(tiempoParqueo) == 0) {
			horasACobrar = 1;
		}
				
		return horasACobrar;
	}

	protected long numeroDiasACobrar(long tiempoParqueo) {
		long diasACobrar = this.numeroDias(tiempoParqueo);
		
		if (this.numeroHorasACobrar(tiempoParqueo) >= HORAS_COBRO_POR_DIAS) {
			diasACobrar++;
		}
				
		return diasACobrar;
	}

	private long numeroHoras(long tiempoParqueo) {
		return TimeUnit.MILLISECONDS.toHours(tiempoParqueo);
	}

	private long numeroDias(long tiempoParqueo) {
		return this.numeroHoras(tiempoParqueo) / 24 ;
	}

	protected abstract float calcularCobro(long numeroDiasACobrar, long numeroHorasACobrar);
	

}

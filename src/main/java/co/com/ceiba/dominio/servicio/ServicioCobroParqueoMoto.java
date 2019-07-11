package co.com.ceiba.dominio.servicio;

import co.com.ceiba.dominio.modelo.RegistroParqueo;

public class ServicioCobroParqueoMoto extends ServicioCobroParqueo {
	private RegistroParqueo registro;
	
	public ServicioCobroParqueoMoto(RegistroParqueo registroParqueo) {
		this.registro = registroParqueo;
	}

	private static final float PRECIO_HORA = 500;
	private static final float PRECIO_DIA = 4000;
	private static final float PRECIO_EXTRA = 2000;
	
	@Override
	protected float calcularCobro(long numeroDiasACobrar, long numeroHorasACobrar) {
		float valorACobrar = 0;
		int cilindraje = Integer.parseInt(this.registro.getCilindraje()) ;
		
		valorACobrar += numeroDiasACobrar * PRECIO_DIA;
		valorACobrar += numeroHorasACobrar * PRECIO_HORA;
		
		if(cilindraje > 500) {
			valorACobrar += PRECIO_EXTRA;
		}
				
		return valorACobrar;
	}

	
}

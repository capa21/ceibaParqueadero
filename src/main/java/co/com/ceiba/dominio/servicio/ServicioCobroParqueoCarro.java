package co.com.ceiba.dominio.servicio;

public class ServicioCobroParqueoCarro extends ServicioCobroParqueo {
	
	private static final float PRECIO_HORA = 1000;
	private static final float PRECIO_DIA = 8000;
		
	@Override
	protected float calcularCobro(long numeroDiasACobrar, long numeroHorasACobrar) {
		float valorACobrar = 0;
			
		valorACobrar += numeroDiasACobrar * PRECIO_DIA;
		valorACobrar += numeroHorasACobrar * PRECIO_HORA;
		
		return valorACobrar;
	}

	
}

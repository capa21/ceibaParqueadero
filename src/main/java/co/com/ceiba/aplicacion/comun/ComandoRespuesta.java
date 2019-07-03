package co.com.ceiba.aplicacion.comun;

public class ComandoRespuesta<T> {
	private T value;

	public ComandoRespuesta(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}

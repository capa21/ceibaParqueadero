package co.com.ceiba.dominio.modelo;

public enum TipoVehiculo {
	MOTO ("MOTO"),
    CARRO ("CARRO");
  
    private final String tipo;       

    private TipoVehiculo(String tipo) {
        this.tipo = tipo;
    }

    public boolean esTipo(String otroTipo) {
        return this.tipo.equals(otroTipo);
    }

    public String toString() {
       return this.tipo;
    }
    
    public boolean esTipoValido() {
		return (MOTO.toString().equals(this.tipo) || CARRO.toString().equals(this.tipo)); 
	}
}

package co.com.ceiba.aplicacion.comun.comandomanejadorrespuesta;

import org.springframework.transaction.annotation.Transactional;

public interface IComandoManejador<C> {
	@Transactional
	void exec (C command);

}

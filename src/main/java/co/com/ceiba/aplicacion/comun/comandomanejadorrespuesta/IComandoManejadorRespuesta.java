package co.com.ceiba.aplicacion.comun.comandomanejadorrespuesta;

import org.springframework.transaction.annotation.Transactional;

public interface IComandoManejadorRespuesta<C,R> {
	@Transactional
	R exec (C command);
}

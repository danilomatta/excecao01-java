package SECAO15_173_CRIANDO_EXCECOES_PERSONALIZADAS.model.exception;

public class DomainException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}

}

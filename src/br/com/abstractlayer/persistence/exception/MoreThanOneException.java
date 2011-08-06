package br.com.abstractlayer.persistence.exception;

/**
 * Exception que deve ser lancada quando uma consulta, que espera apenas
 * um elemento, retonar mais do que o esperado
 * 
 * @author Nelson
 *
 */
public class MoreThanOneException extends Exception {

	public MoreThanOneException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MoreThanOneException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MoreThanOneException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MoreThanOneException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

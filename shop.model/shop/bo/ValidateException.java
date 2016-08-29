package shop.bo;

public class ValidateException extends Exception {

	private static final long serialVersionUID = 1L;

	private String exceptionMessage;

	public ValidateException() {
		this.exceptionMessage = "Statement is not valid ";
	}

	public ValidateException(String message) {
		this.exceptionMessage = message;
	}

	@Override
	public String getMessage() {
		return exceptionMessage;
	}

	@Override
	public String toString() {
		return exceptionMessage;
	}

}

package custom_exception;

public class InvalidInputException extends Exception{
	public InvalidInputException(String errMsg) {
		super(errMsg);
	}
}
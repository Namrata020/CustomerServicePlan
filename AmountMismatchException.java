package custom_exception;

public class AmountMismatchException extends Exception{
	public AmountMismatchException(String errMsg) {
		super(errMsg);
	}
}




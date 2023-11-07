package custom_exception;

public class DuplicateCustomerException extends Exception{
		public DuplicateCustomerException(String errMsg) {
			super(errMsg);
		}
}


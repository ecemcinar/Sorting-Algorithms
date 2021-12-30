

public class InvalidSizeException extends ArithmeticException {
		
		public InvalidSizeException(String message) {
			super(message);
		}
		@Override
		public void printStackTrace() {
			System.out.println("Enter only 1000, 10000 or 100000!!!");
		}

}

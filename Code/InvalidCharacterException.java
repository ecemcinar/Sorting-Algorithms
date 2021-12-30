

public class InvalidCharacterException extends ArithmeticException {

	public InvalidCharacterException(String message) {
		super(message);
	}
	@Override
	public void printStackTrace() {
		System.out.println("Enter only 1,2,3 or 0!!");
	}
}

package adt_project3;
/**
 * Defines an exception of RunTimeException.
 * @author Richard A.Bravo
 * @version 1.0
 */
public class StackException extends RuntimeException {
	/**
	 * Constructs an object with specific message.
	 * @param message
	 */
	public StackException(String message){
		super(message);
	}
}

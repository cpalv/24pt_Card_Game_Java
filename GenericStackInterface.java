package adt_project3;
/**
 * A GenericStack that pushes and pops items.
 * @author Richard A. Bravo
 * @version 1.0
 */
public interface GenericStackInterface<E> {
	/**
	 * Returns the size of this GenericStack<E>.
	 * @return int
	 */
	public int getSize();
	
	/**
	 * Returns the generic object of the top of the GenericStack<E>.
	 * @return E
	 * @throws StackException
	 */
	public E peek() throws StackException;
	
	/**
	 * Puts a generic object into this GenericStack.
	 * @param Object
	 */
	public void push(E Object);
	
	/**
	 * Removes a generic object from this GenericStack.
	 * @return E
	 * @throws StackException
	 */
	public E pop() throws StackException;
	
	/**
	 * Returns true if this GenericStack is empty.
	 * @return boolean
	 */
	public boolean isEmpty();
		
}

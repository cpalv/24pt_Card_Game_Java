package adt_project3;
import java.util.ArrayList;
/**
 * A GenericStack that pushes and pops items.
 * @author Richard A. Bravo
 * @version 1.0
 */
public class GenericStack<E> implements GenericStackInterface<E> {
	/**
	 * An ArrayList<E> list of this GenericStack.
	 */
	private ArrayList<E> list; 
	/**
	 * The top of this GenericStack.
	 */
	private int top;
	/**
	 * The default constructor for this GenericStack
	 */
	public GenericStack(){
		this.list = new ArrayList<E>();
	}
	
	/**
	 * Returns the size of this GenericStack<E>.
	 * @return int A reference to the size of this GenericStack<E>.
	 */
	public int getSize(){
		return this.list.size();
	}
	
	/**
	 * Returns the generic object of the top of the GenericStack<E>.
	 * @throws StackException 
	 */
	public E peek() throws StackException{
		if(isEmpty() == true){
			throw new StackException("Error: The stack is currently empty!");
		}
		else{
			return this.list.get(this.list.size() -1);
		}
	}
	
	/**
	 * Puts a generic object into this GenericStack.
	 * @param Object
	 */
	public void push(E Object){
		this.list.add(Object);
		
	}
	/**
	 * Removes a generic object from this GenericStack.
	 */
	public E pop() throws StackException{
		if(isEmpty() == true){
			throw new StackException("Error: The stack is currently empty!");
		}
		else{
			return this.list.remove(this.list.size() - 1);
			
		}
	}
	
	/**
	 * Returns true if this GenericStack is empty.
	 * @return
	 */
	public boolean isEmpty(){
		return this.list.isEmpty();
	}

	
}

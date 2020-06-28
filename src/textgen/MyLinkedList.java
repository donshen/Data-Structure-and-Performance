//package textgen;
//
//import java.util.AbstractList;
//
//
///** A class that implements a doubly linked list
// * 
// * @author UC San Diego Intermediate Programming MOOC team
// *
// * @param <E> The type of the elements stored in the list
// */
//public class MyLinkedList<E> extends AbstractList<E> {
//	LLNode<E> head;
//	LLNode<E> tail;
//	int size;
//
//	/** Create a new empty LinkedList */
//	public MyLinkedList() {
//		// TODO: Implement this method
//		size = 0;
//		head = new LLNode<E> (null);
//		tail = new LLNode<E> (null);
//		head.next = tail;
//		tail.prev = head;
//	}
//
//	/**
//	 * Appends an element to the end of the list
//	 * @param element The element to add
//	 */
//	public boolean add(E element ) 
//	{
//		// TODO: Implement this method
//		if (element == null) {
//			throw new NullPointerException("Cannot store null pointers.");
//		}
//		LLNode<E> newNode = new LLNode<E> (element);
//		newNode.next = tail;
//		newNode.prev = tail.prev;
//		tail.prev.next = newNode;
//		tail.prev = newNode;
//		
//		size ++;
//		
//		
//		
//		
//	 
//	    
//	    return true;
//		
//
//	}
//
//	/** Get the element at position index 
//	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
//	public E get(int index) 
//	{
//		// TODO: Implement this method.
//		if (index < 0 || index >= size) {
//			throw new NullPointerException("Check the index you are getting.");
//		}
//		LLNode<E> node = head.next;
//		for (int i = 0; i <= index; i++ ) {
//			node = node.next;
//		}
//		return node.data;
//	}
//
//	/**
//	 * Add an element to the list at the specified index
//	 * @param The index where the element should be added
//	 * @param element The element to add
//	 */
//	public void add(int index, E element ) 
//	{
//		// TODO: Implement this method
//		if (element == null) {
//			throw new NullPointerException("Cannot store null pointers.");
//		}
//		if (index < 0 || index >= size) {
//			throw new NullPointerException("Check the index you are getting.");
//		}
//		LLNode<E> currNode = head;
//		LLNode<E> newNode = new LLNode<E> (element);
//		for (int i=0; i < index; i++) {
//			currNode = currNode.next;
//		}
//		newNode.prev = currNode;
//		newNode.next = currNode.next;
//		newNode.next.prev = newNode;
//		currNode.next = newNode;
//		
//		this.size ++;
//		
//		
//		
//		
//	}
//
//
//	/** Return the size of the list */
//	public int size() 
//	{
//		// TODO: Implement this method
//		return size;
//	}
//
//	/** Remove a node at the specified index and return its data element.
//	 * @param index The index of the element to remove
//	 * @return The data element removed
//	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
//	 * 
//	 */
//	public E remove(int index) 
//	{
//		// TODO: Implement this method
//		if (index < 0 || index >= size) {
//			throw new NullPointerException("Check the index you are getting.");
//		}
//		
//		LLNode<E> node = head.next;
//		for (int i = 0; i <= index; i ++) {
//			node = node.next;
//		}
//		E removedElement = node.data;
//		node.prev.next = node.next;
//		node.next.prev = node.prev;
//		node.prev = null;
//		node.next = null;
//
//		this.size --;
//		return removedElement;
//	}
//
//	/**
//	 * Set an index position in the list to a new element
//	 * @param index The index of the element to change
//	 * @param element The new element
//	 * @return The element that was replaced
//	 * @throws IndexOutOfBoundsException if the index is out of bounds.
//	 */
//	public E set(int index, E element) 
//	{
//		// TODO: Implement this method
//		if (element == null) {
//			throw new NullPointerException("Cannot store null pointers.");
//		}
//		if (index < 0 || index >= size) {
//			throw new NullPointerException("Check the index you are getting.");
//		}
//		LLNode<E> node = head.next;
//		for (int i = 0; i <= index; i ++) {
//			node = node.next;
//		}
//		
//		node.data = element;
//		
//		return element;
//	}   
//}
//
//class LLNode<E> 
//{
//	LLNode<E> prev;
//	LLNode<E> next;
//	E data;
//
//	// TODO: Add any other methods you think are useful here
//	// E.g. you might want to add another constructor
//
//	public LLNode(E e) 
//	{
//		this.data = e;
//		this.prev = null;
//		this.next = null;
//	}
//
//}

package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) 
	{
		if (element == null) {
			throw new NullPointerException();
		}
        LLNode<E> node = new LLNode<E>(element);
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        size++;
		return true;
	}
	
	public boolean addFront(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> n = new LLNode<E>(element);
		n.next = head.next;
		n.prev = n.next.prev;
		n.next.prev = n;
		head.next = n;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		return node.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if (element == null) {
			throw new NullPointerException();
		}
		if ((index < 0 || index >= size)&& size != 0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> prev = head;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		LLNode<E> node = new LLNode<E>(element);
	
		node.next = prev.next;
		prev.next = node;
		node.next.prev = node;
		node.prev = prev;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		node.prev.next = node.next;
		node.next.prev = node.prev;
		size --;
		return node.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		node.data = element;
		return element;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode()
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}


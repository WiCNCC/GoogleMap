/*
 * Node class for Double Linked Lab - CSC 230
 */

package gm;

//Zermina Ejaz N00831354

public class Node<E> {

	private E data;

	private Node<E> next;
	private Node<E> prev;


	// constructor that takes in parameters in this order:
	// data, next, prev

	public Node(E d, Node<E> n, Node<E> p)
	{
		data = d;
		next = n;
		prev = p;
	}

	// accessors and mutators that are necessary
	public E getData() {
		return data;
	}


	public void setData(E data) {
		this.data = data;
	}


	public Node<E> getNext() {
		return next;
	}


	public void setNext(Node<E> next) {
		this.next = next;
	}


	public Node<E> getPrev() {
		return prev;
	}


	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}


}
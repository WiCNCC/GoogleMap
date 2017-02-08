/*
 * DoublyLinkedQueue class for Double Linked Lab - CSC 230
 */

package gm;

//Zermina Ejaz N00831354


import java.util.NoSuchElementException;


// will have to slightly change declaration of this class to use Generics
public class DoublyLinkedQueue {


	// declare node references for front and rear below this comment
	protected Node<GoogleMarker> front, rear;

	// declare variable for size
	int size;
	
	private double latitudeCenter;
	private double longitudeCenter;

	//default constructor
	public DoublyLinkedQueue(){
		front = rear = null;
	}



	/* will need min. of three methods
		size(), enqueue which takes a parameter, and dequeue

		remember that the dequeue should throw an Exception if nothing in list
		can use NoSuchElementException
	 */

	public int size()
	{
		if(front == null)
			return 0;
		else
		{
			Node<GoogleMarker> current = front;
			while(current != null)
			{
				current = current.getNext();
				size++;
			}
			return size;
		}

	}
	public void enqueue(GoogleMarker item)
	{
		if(front == null)
			front = rear = new Node<GoogleMarker>(item, null, null);
		else
		{
			rear.setNext(new Node<GoogleMarker>(item, null, rear));
			rear = rear.getNext();
		}
		size++;
	}

	public GoogleMarker dequeue()
	{
		if(front == null)
			throw new NoSuchElementException("DoublyLinkedQueue");
		
		Node<GoogleMarker> temp = null;
		if(front.getNext() != null)
		{
			temp = front;
			front = front.getNext();
			front.setPrev(null);
			size--;
			return temp.getData();
		}

		else
		{
			temp = front;
			front = rear = null;
			size--;
			return temp.getData();
		}
	}
	
	
	public double getLatitudeCenter() {
		return latitudeCenter;
	}



	public void setLatitudeCenter(double latitudeCenter) {
		this.latitudeCenter = latitudeCenter;
	}



	public double getLongitudeCenter() {
		return longitudeCenter;
	}



	public void setLongitudeCenter(double longitudeCenter) {
		this.longitudeCenter = longitudeCenter;
	}



	public String search(String category)
	{
		Node<GoogleMarker> temp = front;
		GoogleMarker current;
		String str = "";
		double latitude = 0;
		double longitude = 0;
		int j = 0; //count of how many in that category
		
	/////////////

		
		while(temp != null)
		{
			current = (temp.getData());
			System.out.println(("Current" + current.toString()));
			System.out.println(("Current" + current.getCategory()));
			if((current.getCategory()).equals(category)){
				
				latitude += (current.getLatitude());
				longitude += (current.getLongitude());
				j++;
				str += current.toString();
				
			}
			latitudeCenter = latitude / j;
			longitudeCenter = longitude / j;
			//if(temp.getNext() == null)
			//	return str;
		
			temp = temp.getNext();
		}
		
		
System.out.println("latitudeCenter " + latitudeCenter);
System.out.println("longitudeCenter " + longitudeCenter);
		return str;
	
	}
}


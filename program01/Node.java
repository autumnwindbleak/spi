/**
 * Node use in mylist
 */
public class Node 
{
	/**
	 * global var
	 */
	Object element; //data
	
	/**
	 * global var
	 */
	
	Node next;  //pointer
	/**
	 *create the head of a linked list 
	 */
	public Node(Node nextval) 
	{
		this.next = nextval;
	}
	/**
	 * create a middle node
	 */
	public Node(Object obj, Node nextval) 
	{
		this.element = obj;
		this.next = nextval;
	}
    
	/**
	 * get next node
	 * @return
	 */
	
	public Node getNext() 
	{
		return this.next;
	}
	
	/**
	 * get the data
	 * @return
	 */
	
	public Object getElement() 
	{
		return this.element;
	}
    
	/**
	 * set next
	 */
	
	public void setNext(Node nextval) 
	{
		this.next = nextval;
	}

	/**
	 * set data
	 * @param obj
	 */
	
	public void setElement(Object obj) 
	{
		this.element = obj;
	}
	/**
	 * tostring
	 */
	public String toString() 
	{
		return this.element.toString();
	}
}
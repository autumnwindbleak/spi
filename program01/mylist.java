/**
 * a linked list
 */

public class mylist 
{
	/**
	 * global var
	 */
	Node head; //head
	/**
	 * global var
	 */
	Node current;//current node
	/**
	 * global var
	 */
	int size;//whole size
	/**
	* constructor
	*/
	public mylist()
	{
		this.head = current = new Node(null);
		this.size =0;
	}  
	/**
	* set current to the first node
	*/
	public void sethead()
	{
		current = head.next;  
	}
	/**
	* locate index
	*/
	public void index(int index) 
	{
		if(index <-1 || index > size -1)
		{
			System.out.println("wrong input");    
		}
		if(index == -1)
		{
			return;
		}
		current = head.next;
		int j=0;
		while(current != null&&j<index)
		{
			current = current.next;
			j++;
		}	      
	}
	  
	/**
	* delete a node
	*/  
	public void delete(int index) 
	{
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			System.out.println("can't delete(empty)");
		}
		if(index <0 ||index >size)
		{
			System.out.println("wrong input");  
		}
		index(index-1);
		current.setNext(current.next.next);
		size--;
	}
	/**
	* get index node
	*/
	public Object get(int index)
	{
		// TODO Auto-generated method stub
		if(index <-1 || index >size-1)
		{
			System.out.println("wrong input");  
		}
		index(index);  
		return current.getElement();
	}
	/**
	* insert a node
	*/
	public void insert(int index, Object obj)
	{
		// TODO Auto-generated method stub
		if(index <0 ||index >size)
		{
			System.out.println("wrong input");  
		}
		index(index-1);
		current.setNext(new Node(obj,current.next));
		size++;
	}
	  
	/**
	* get current
	*/
	public Object getcurrent() 
	{
		return current.getElement();
	}
	  
	/**
	* go to next
	*/  
	public void next()
	{
		current = current.next;
	}
	/**
	* if is empty
	*/
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return size==0;
	}
	/**
	* get size
	*/
	public int size() 
	{
		// TODO Auto-generated method stub
		return this.size;
	}
}

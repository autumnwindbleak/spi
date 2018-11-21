/**
 * This is my linked list class.
 *
 * @author Fred Brown 
 * @version 1.0
*/
class mylist
{
	/** doubles only */
	double hd ;
	/** pointer to the tail - we assume null marks end of list */
	mylist tl ;

	/**
	 * Create a new list cell.
	 *
	 * @param d The number to add.
	 * @param next The tail of the new list.
	 * return A new list.
	*/
	static mylist cons(double d,mylist next)
	{
		mylist r = new mylist() ;
		r.hd = d ;
		r.tl = next ;
		return r ;
	}
}

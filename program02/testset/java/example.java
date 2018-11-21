// the import statements should come before the
// javadoc comment for the class.
import java.util.* ;

/**
 * This is the code layout example class.
 *
 * @author Fred Brown
 * @version 1.0
*/
class example
{
	/**
	 * The constructors are items too.
	 * @param bob A string.
	*/
	public example(String bob)
	{
	}

	/**
	 * This is my main method.
	 * It just writes out something and includes unused code
	 * to demonstrate the layout of declarations and switch statements.
	 *
	 * @param args	the command line arguments passed by the shell.
	*/
	public static void main(String args[])
	{
		if ( 5 > 3 )		// this is an if true, but demonstrates white space around operators
		{
			System.out.println("something") ;
		} else
		{
			int a,b ;	// multiple declarations are OK if they are not initialised.
			int junk = 3 ;	// initialised declarations must be on separate lines.

			switch(junk)	// note indentation of the case labels and internal code.
			{
			case 1:	a = junk ;
				break ;
			case 45634:
				break ;
			default:
				b = junk ;
			}
		}
	}

	/**
	 * Calculates fibonacci.
	 *
	 * @param n We want the n'th fibonacci number.
	 * @return The answer we were looking for or 0.
	*/
	int fib(int n)
	{
		if ( n < 1 )		// if the answer may be undefined, we return 0.
		{
			return 0 ;
		} else
		{
			return fib(n - 1) + fib(n - 2) ;
		}
	}

	/**
	 * A package access member called bob.
	*/
	static int bob[] ;

	/**
	 * This is an example of a static initialiation block.
	 * This is an item too.
	*/
	static 
	{
		bob = new int[] {1,2,3} ;
		ArrayList al = new ArrayList() ;
	}
}

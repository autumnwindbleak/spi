import java.io.* ;
import reuseLibrary.tokens ;

/**
 * This is the program01 class.
 *
 * @author Fred Brown
 * @version 1.0
*/
class programXX
{
	/**
	 * Our main program
	 *
	 * @param args The command line arguments.
	 *
	*/
	public static void main(String args[])
	{
		try
		{
			// grab a stream tokenizer for standard input
			tokens.init() ;

			mylist nums = null ;
			int n = 0 ;
			double sumx = 0 ;

			while ( tokens.more() ) 
			{
				n++ ;
				double nval = tokens.number() ;
				sumx += nval ;
				nums = mylist.cons(nval,nums) ;
			}

			// we need at least 2 numbers
			if ( n < 2 )
			{
				throw new Exception("bad input") ;
			}

			// average ...
			double average = sumx / n ;

			// variance - sum square of differences from the average
			double variance = 0 ;
			while ( nums != null )
			{
				double diff = nums.hd - average ;
				variance += diff * diff ;
				nums = nums.tl ;
			}
			variance /= n - 1 ;

			// std deviation is sqrt of variance
			double stdev = Math.sqrt(variance) ;

			System.out.printf("Mean %.2f\n",average) ;
			System.out.printf("StdDev %.2f\n",stdev) ;

		} catch ( Throwable t )
		{
			System.out.println("OOPS!") ;
		}
	}
}

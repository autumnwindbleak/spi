package reuseLibrary ;

import java.io.* ;
/**
 * This is the program01 class.
 *
 * @author Fred Brown
 * @version 1.0
*/
public class tokens
{
	/** last token read */
	private static int t ;
	/** the StreamTokenizer object */
	private static StreamTokenizer st ;

	/**
	 * initialise tokens
	*/
	public static void init() throws Exception
	{
													// grab a stream tokenizer for standard input
		InputStreamReader isr = new InputStreamReader(System.in) ;
		st = new StreamTokenizer(isr) ;
		t = st.nextToken() ;						// read first token
	}

	/**
	 * is there another number in the input?
	*/
	public static boolean more() throws Exception
	{
		while ( t != StreamTokenizer.TT_EOF )
		{
			if ( t == StreamTokenizer.TT_NUMBER )	// return true if we found a number
			{
				return true ;
			}
			t = st.nextToken() ;
		}
		return false ;
	}

	/**
	 * return next number - the current token - then advance one token
	*/
	public static double number() throws Exception
	{
		double nval = st.nval ;
		t = st.nextToken() ;
		return nval ;
	}
}

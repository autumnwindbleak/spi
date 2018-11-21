package reuseLibrary;
import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * tokens that can read string and double
 */
public class tokens 
{
	/**
	 * global var
	 */
	public int nt = 0;
	/**
	 * global var
	 */
	public StreamTokenizer st;
	/**
	 * constructor
	 */
	public tokens()
	{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		try 
		{
			nt = st.nextToken();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("OOPS!");
			System.exit(0);
		}
	}
		
	/**
	 * identify if there is a next token 
	 */
	public boolean hasNext() 
	{
		if(nt != StreamTokenizer.TT_EOF)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * identify if there is a next token in double
	 */
	public boolean hasNextDouble() 
	{
		if(nt == StreamTokenizer.TT_NUMBER) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * get next input double token
	 */
	public double nextDouble()
	{
		
		return st.nval;
	}
	/**
	 * get next input string token
	 */
	public String nextString()
	{
		return st.sval;
	}

	/**
	 * go to next token
	 */
	public void nextToken()
	{
		try 
		{
			nt = st.nextToken();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("OOPS!");
			System.exit(0);
		}
	}

}

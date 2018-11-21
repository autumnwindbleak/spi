package reuseLibrary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * tokens that can read string and double
 */
public class tokens 
{
	/**
	 * global var
	 */
	Scanner input;
	/**
	 * constructor
	 * @param fname
	 */
	public tokens(String fname)
	{
		try 
		{
			input = new Scanner(new FileReader(fname));
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("OOPS!");
			System.exit(0);
		}
	}
	/**
	 * if there is a next
	 * @return
	 */
	public boolean hasNext()
	{
		return input.hasNext();
	}
	
	/**
	 * get next line
	 * @return 
	 */
	public String getNextLine()
	{
		return input.nextLine();
		
	}

}

import reuseLibrary.*;

/**
 * program02
 * @author ian
 *
 */

public class program02
{	
	/**
	 * store how many lines
	 */
	int lines = 0;
	/**
	 * store how many items
	 */
	int items = 0;
	/**
	 * calculate the lines and items
	 * @param t
	 */
	public void calculate(tokens t)
	{
		String s;
		lines = 0;
		items = 0;
		int count = -1;
		while(t.hasNext())
		{
			s = t.getNextLine();
			if(s.equals("/**"))
			{
				while(t.hasNext())
				{
					s = t.getNextLine();
					if(s.equals("*/"))
					{
						break;
					}
				}
			}
			if(s.equals("\t/**"))
			{
				while(t.hasNext())
				{
					s = t.getNextLine();
					if(s.equals("\t*/"))
					{
						break;
					}
				}
			}
			char[] c = s.toCharArray();
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] == '{')
				{
					if(count == -1)
					{
						count = 0;
					}
					lines++;
					count++;
				}
				if(c[i] == '}')
				{
					count--;
					if(count == 1)
					{
						items++;
					}
					lines++;
				}
				if(c[i] == ';' || c[i] == ',')
				{
					lines++;
				}
				if(c[i] == '/' && i < c.length-1)
				{
					if(c[i+1] == '/')
					{
						break;
					}
				}
			}
		}
	}
	
	/**
	 * get lines
	 * @return lines
	 */
	public int getlines()
	{
		return lines;
	}
	
	/**
	 * get items
	 * @return items
	 */
	public int getitems()
	{
		if(items == -1)
		{
			return 0;
		}
		else 
		{
			return items;
		}
	}
	
	/**
	 * get the tokenizer when read fname
	 * @param fname
	 * @return tokens
	 */
	public tokens readfile(String fname)
	{
		tokens t = new tokens(fname);
		if(!t.hasNext())
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
		return t;
	}
	
	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
		int[] linesstock = new int[args.length];
		int[] itemsstock = new int[args.length];
		int total = 0;
		program02 p = new program02();
		for(int i = 0; i < args.length; i++)
		{
			p.calculate(p.readfile(args[i]));
			linesstock[i] = p.getlines();
			itemsstock[i] = p.getitems();
			total += linesstock[i];
		};
		for(int i = 0; i < args.length; i++)
		{
			System.out.println("Class " + args[i].substring(0, args[i].length()-5) + ", items " + itemsstock[i] + ", size " + linesstock[i]);
		}
		System.out.println("Total Size: " + total);		
	}		
}

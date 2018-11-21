import java.util.ArrayList;
import reuseLibrary.*;
/**
 * program10
 * @author Ian
 *
 */
public class program10 
{
	/**
	 * store the text data
	 */
	ArrayList<String> data = new ArrayList<String>();
	
	/**
	 * store order
	 */
	int[] order;
	
	/**
	 * if the parameter has -r then it will change into true
	 */
	boolean R = false;
	
	/**
	 * if there is a parameter -t then this change into true
	 */
	boolean T = false;
	
	/**
	 * if there is a parameter -s then this will be true
	 */
	boolean S = false;
	
	/**
	 * if there is a parameter -k then this will be true 
	 */
	boolean K = false;
	
	/**
	 * store the field after -k
	 */
	int[][] field;
	
	/**
	 * if there is a char after -t then put it into split
	 */
	String split = "";
	
	
	
	/**
	 * print out the result
	 */
	public void print()
	{
		for(int i = 0; i < order.length; i++)
		{
			System.out.println(data.get(order[i]));
		}
	}
	
	/**
	 * sort strings and put order into order array
	 */
	public void sort()
	{
		quicksort(0,order.length-1);
	}
	
	
	/**
	 * quick sort
	 */
	public void quicksort(int left, int right)
	{
		if(left >= right)
		{
			return;
		}
		int l = left;
		int r = right;
		int p = right;
		int temp;
		while(l < r)
		{
			while(l < p && !compare(data.get(order[l]), data.get(order[p])))
			{
				l++;
			}
			if(compare(data.get(order[l]), data.get(order[p])))
			{
				temp = order[l];
				order[l] = order[p];
				order[p] = temp;
				p = l;
			}
			while(p < r && compare(data.get(order[r]),data.get(order[p])))
			{
				r--;
			}
			if(!compare(data.get(order[r]),data.get(order[p])))
			{
				temp = order[r];
				order[r] = order[p];
				order[p] = temp;
				p = r;
			}	
		}
		quicksort(left,p-1);
		quicksort(p+1,right);
	}
	
	/**
	 * read the input and put it into the data arraylist
	 */
	public void read()
	{
		tokens t = new tokens();
		while(t.hasNext())
		{
			data.add(t.getNextLine());
		}
		order = new int[data.size()];
		for(int i = 0; i < order.length; i++)
		{
			order[i] = i;
		}
	}
	
	/**
	 * compare which is larger/ if string a >= b
	 * @param a
	 * @param b
	 * @return if a >= b return true else return false
	 */
	public boolean compare(String a, String b)
	{
		if(!S)
		{
			if(a.compareTo(b) >= 0)
			{
				if(R)
				{
					return false;
				}
				return true;
			}
			else 
			{
				if(R)
				{
					return true;
				}
				return false;
			}
		}
		else
		{
			String tempa = "";
			String tempb = "";
			String[] tempsa,tempsb;
			for(int i = 0; i < field.length; i++)
			{
				tempsa = a.split(split);
				tempsb = b.split(split);
				for(int j = field[i][0]; j < field[i][1]; j++)
				{
					if(j < tempsa.length)
					{
						tempa += tempsa[j];
					}
					if(j < tempsb.length)
					{
						tempb += tempsb[j];
					}
				}
				if(tempa.compareTo(tempb) > 0)
				{
					if(R)
					{
						return false;
					}
					return true;
				}
				if(tempa.compareTo(tempb) < 0)
				{
					if(R)
					{
						return true;
					}
					return false;
				}
			}
			if(R)
			{
				return false;				
			}
			return true;
		}
	}
	
	
	/**
	 * identify the parameters
	 * @param args
	 */
	public void parameter(String[] args)
	{
		if(args.length == 0)
		{
			return;
		}
		ArrayList<Integer> start = new ArrayList<Integer>();
		ArrayList<Integer> end = new ArrayList<Integer>();
		int n_k = 0;
		String[] temp;
		for(int i = 0; i < args.length; i++)
		{
			switch(args[i].length())
			{
			case 1:
				if(i > 0)
				{
					if(args[i-1].equals("-t"))
					{
						split = args[i];
					}
				}
				break;
			case 2:
				if(args[i].equals("-r"))
				{
					R = true;
				}
				if(args[i].equals("-t"))
				{
					T = true;
				}
				if(args[i].equals("-s"))
				{
					S = true;
				}
				if(args[i].equals("-k"))
				{
					K = true;
					n_k++;
				}
				break;
			case 3:
				if(i > 0)
				{
					if(args[i-1].equals("-k"))
					{
						temp = args[i].split(",");
						start.add(Integer.parseInt(temp[0]) - 1);
						end.add(Integer.parseInt(temp[1]));
					}
				}
				break;
			}
		}
		if((S && T && K) != (S || T || K))
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
		if(n_k != start.size() || n_k != end.size())
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
		field = new int[n_k][2];
		for(int i = 0; i < n_k; i++)
		{
			field[i][0] = start.get(i);
			field[i][1] = end.get(i);
		}
	}
	
	
	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args)
	{
		program10 p10 = new program10();
		p10.parameter(args);
		p10.read();
		p10.sort();
		p10.print();
	}

}

import java.util.ArrayList;
import reuseLibrary.*;
/**
 * program09
 * @author Ian
 *
 */
public class program09 
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
		if(a.compareTo(b) >= 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
		
//		char[] ac = a.toCharArray();
//		char[] bc = b.toCharArray();
//		int n = ac.length;
//		if(n > bc.length)
//		{
//			n = bc.length;
//		}
//		for(int i = 0; i < n; i++)
//		{
//			if (ac[i] > bc[i])
//			{
//				return true;
//			}
//			if(ac[i] < bc[i])
//			{
//				return false;
//			}
//		}
//		return true;
	}
	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args)
	{
		program09 p9 = new program09();
		p9.read();
		p9.sort();
		p9.print();
	}

}

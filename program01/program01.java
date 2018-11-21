import reuseLibrary.tokens;

/**
 * main program
 */
public class program01 
{
	/**
	 * global var
	 */
	private mylist ml = new mylist();
	/**
	 * global var
	 */
	private double mean;
	
	/**
	 * caculate mean
	 */
	public void calculate_mean() 
	{
		double sum = (double) ml.get(0);
		for(int i = 0; i < ml.size()-1; i++)
		{
			ml.next();
			sum = sum + (double) ml.getcurrent();
		}
		mean = sum/ml.size();
	}
	
	/**
	 * caculate stddev and return it
	 * 
	 */
	public double get_StdDev() 
	{
		ml.sethead();
		double sum = ((double) ml.getcurrent() - mean) * ((double) ml.getcurrent() - mean);
		for(int i = 0; i < ml.size()-1; i++)
		{
			ml.next();
			sum = sum + ((double) ml.getcurrent() - mean) * ((double) ml.getcurrent() - mean);
		}
		return Math.sqrt(sum / (ml.size() - 1));
	}
	
	/**
	 * creat mylist
	 */
	public void creatmylist() 
	{	
		tokens t = new tokens();
		while(t.hasNext())
		{
			if(t.hasNextDouble())
			{
				ml.insert(0, t.nextDouble());
				t.nextToken();
			}
			else
			{
				t.nextToken();
			}
		}
	}
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) 
	{
		program01 p = new program01();
		p.creatmylist();
		if(p.ml.size() <= 1)
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
		p.calculate_mean();
		System.out.println("Mean " + String.format("%.2f", p.mean));
		System.out.println("StdDev " + String.format("%.2f", p.get_StdDev()));
	}
}

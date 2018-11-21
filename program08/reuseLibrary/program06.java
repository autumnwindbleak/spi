package reuseLibrary;

/**
 * program06
 * @author ian
 *
 */
public class program06 
{
	/**
	 * d is the try number
	 */
	double d = 0.5;
	
	/**
	 * E is the error that can stand. 
	 */
	double E = 0.00000000001;
	
	/**
	 * defaut x;
	 */
	double x = 1;
	
	/**
	 * import program05 to calculate the p;
	 */
	program05 cal_p = new program05();
	
	/**
	 * store dof
	 */
	double dof = -1;
	
	/**
	 * store p
	 */
	double p = -1;
	
	
	/**
	 * read dof and p from file
	 */
	public void read()
	{
		tokens t = new tokens();
		while(t.hasNext())
		{
			if(t.hasNextDouble())
			{
				if(p == -1)
				{
					if(t.nextDouble() < 0 || t.nextDouble() >= 0.5)
					{
						System.out.println("OOPS!");
						System.exit(0);
					}
					p = t.nextDouble();
				}
				else
				{
					if(t.nextDouble() < 1 || (int) t.nextDouble() != t.nextDouble())
					{
						System.out.println("OOPS!");
						System.exit(0);
					}
					dof = t.nextDouble();
					break;
				}
			}
			t.nextToken();
		}
		if(p == -1 || dof == -1)
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
		
	}
	/**
	 * 
	 * @param p expect p
	 * @param dof dof
	 * @return x
	 */
	public double calculate(double p, double dof)
	{
		this.p = p;
		this.dof = dof;
		calculate();
		return x;
	}
	/**
	 * calculate x
	 */
	public void calculate()
	{
		double c_p = 1;
		int flag = 1;
		while(Math.abs(c_p - p) > E)
		{
			if(c_p > p)
			{
				if(flag == -1)
				{
					d = d / 2;
				}
				x = x - d;
				cal_p.set(x, dof);
				c_p = cal_p.p();
				flag = 1;
			}
			else
			{
				if(flag == 1)
				{
					d = d / 2;
				}
				x = x + d;
				cal_p.set(x, dof);
				c_p = cal_p.p();
				flag = -1;
			}
		}
		
	}
	/**
	 * print out the result
	 */
	public void print()
	{
		System.out.println("x = " +String.format("%.5f", x));
	}
	
	
	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args)
	{
		program06 p = new program06();
		p.read();
		p.calculate();
		p.print();
	}

}

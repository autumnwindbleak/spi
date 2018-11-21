package reuseLibrary;
import reuseLibrary.*;
/**
 * program05
 * @author Ian
 *
 */
public class program05 
{
	/**
	 * numbers of segments 
	 */
	int seg_num = 100;
	/**
	 * the acceptable error
	 */
	double E = 0.00001;
	
	/**
	 * degree of freedom
	 */
	double dof = -1;
	
	/**
	 * the input x
	 */
	double x= -1;
	
	
	
	/**
	 * print out the result
	 * @param result
	 */
	public void print(double result)
	{
		System.out.print("p = " + String.format("%.5f", result));
	}
	
	
	/**
	 * calculate p value
	 * @return
	 */
	public double p()
	{
		double W;
		double temp = -1;
		double result = -1;
		do
		{
			seg_num = seg_num * 2;
			temp = result;
			W = x / seg_num;
			result = (W / 3) * (T_dis(0) + T_dis(x) + sum(true,seg_num,W) + sum(false,seg_num,W));
		}
		while(Math.abs(result - temp) > E);
		return result;
	}
	/**
	 * read the input and put into dof and x
	 */
	public void read()
	{
		tokens input = new tokens();
		int count = 0;
		while(input.hasNext() && count != 2)
		{
			if(input.hasNextDouble())
			{
				if(count == 0)
				{
					if(input.nextDouble() < 0)
					{
						System.out.println("OOPS!");
						System.exit(0);
					}
					else
					{
						x = input.nextDouble();
					}
				}
				if(count == 1)
				{
					if(input.nextDouble() != (int) input.nextDouble() || input.nextDouble() < 1)
					{
						System.out.println("OOPS!");
						System.exit(0);
					}
					else
					{
						dof = (int)input.nextDouble();
					}
				}
				count++;
			}
			input.nextToken();
		}
		if(dof == -1 || x == -1)
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
	}
	
	/**
	 * 
	 * @param flag : if calculate the odd then the flag is true else flag is false
	 * @param seg_num
	 * @param W
	 * @return
	 */
	public double sum(boolean flag, int seg_num, double W)
	{
		double sum = 0;
		if(flag)
		{
			for(int i = 1; i <= seg_num - 1; i ++)
			{
				if(i % 2 == 1)
				{
					sum += T_dis(i * W);
				}
			}
			return sum * 4;
		}
		else
		{
			for(int i = 2; i <= seg_num - 2; i++)
			{
				if(i % 2 == 0)
				{
					sum += T_dis(i * W);
				}
			}
			return sum * 2;
		}
	}
	
	
	/**
	 * T distribution method
	 * @param x
	 * @return
	 */
	public double T_dis(double x)
	{
		return gama((dof + 1) / 2) * Math.pow(1 + x * x / dof, 0 - (dof + 1) / 2) / (Math.sqrt(dof * Math.PI) * gama(dof / 2));
	}
	
	
	/**
	 * gama method
	 * @param x
	 * @return
	 */
	public double gama(double x)
	{
		if(x == 1)
		{
			return 1;
		}
		else
		{
			if(x == 0.5)
			{
				return Math.sqrt(Math.PI);
			}
			else
			{
				return (x - 1) * gama(x - 1);
			}
		}
	}
	
	/**
	 * if no read from system.in set x and dof
	 * @param x
	 * @param dof
	 */
	public void set(double x, double dof)
	{
		this.x = x;
		this.dof = dof;
		this.seg_num = 100;
	}
	
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) 
	{
		program05 p = new program05();
		p.read();
		p.print(p.p());
	}

}

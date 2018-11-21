package reuseLibrary;
import java.util.Vector;


/**
 * program03
 * @author ian
 *
 */

public class program03 
{
	/**
	 * store xk
	 */
	double xk;
	
	/**
	 * store x
	 */
	double[] x_array;
	
	/**
	 * store y
	 */
	double[] y_array;
	
	/**
	 * size
	 */
	double size;
	
	/**
	 * store result;
	 */
	double beta0 = 0;
	/**
	 * store result;
	 */
	double beta1 = 0;
	/**
	 * store result;
	 */
	double Rxy = 0;
	/**
	 * store result;
	 */
	double RSQ = 0;
	/**
	 * store result;
	 */
	double Yk = 0;
	
	
	/**
	 * print to the system.out
	 */
	public void print()
	{
		System.out.println("Beta0 = " + String.format("%.2f", beta0));
		System.out.println("Beta1 = " + String.format("%.2f", beta1));
		System.out.println("Rxy = " + String.format("%.4f", Rxy));
		System.out.println("RSQ = " + String.format("%.4f", RSQ));
		System.out.println("Yk = " + String.format("%.0f", Yk));
	}
	
	/**
	 * calculate the result
	 */
	public void calculate()
	{
		double x_avg = 0;
		double y_avg = 0;
		double x_sum = 0;
		double y_sum = 0;
		double xy_sum = 0;
		double x_s_sum = 0;
		double y_s_sum = 0;
		
		
		for(int i = 0; i < size; i++)
		{
			x_sum += x_array[i];
			y_sum += y_array[i];
			xy_sum += x_array[i] * y_array[i];
			x_s_sum += x_array[i] * x_array[i];
			y_s_sum += y_array[i] * y_array[i];
		}
		x_avg = x_sum / size;
		y_avg = y_sum / size;
		
		double temp;
		beta1 = xy_sum - size * x_avg * y_avg;
		temp = x_s_sum - size * x_avg * x_avg;
		if(temp == 0)
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
		beta1 = beta1 / temp;
		beta0 = y_avg - beta1 * x_avg;
		Yk = beta0 + beta1 * xk;
		Rxy = size * xy_sum - x_sum * y_sum;
		temp = Math.sqrt((size * x_s_sum - x_sum * x_sum) * ( size * y_s_sum - y_sum * y_sum));
		if(temp <= 0)
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
		Rxy = Rxy / temp;
		RSQ = Rxy * Rxy;
	}
	
	
	/**
	 * check the input and put it into stock
	 */
	public void checkandread()
	{
		Vector<Double> data = new Vector<Double>();
		double temp = 0.0;
		tokens t = new tokens();
		while(t.hasNext())
		{
			if(t.hasNextDouble())
			{
				temp = t.nextDouble();
				if(temp < 1)
				{
					System.out.println("OOPS!");
					System.exit(0);
				}
				data.add(temp);
				t.nextToken();
			}
			else
			{
				t.nextToken();
			}
		}
		if(data.size() % 2 == 0 || data.size() < 7)
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
		xk =(double) data.get(0);
		x_array = new double[(data.size() - 1) / 2];
		y_array = new double[(data.size() - 1) / 2];
		for(int i = 1; i < data.size(); i++)
		{
			if(i % 2 == 1)
			{
				x_array[i / 2] = (double) data.get(i);
			}
			else
			{
				y_array[i / 2 - 1] = (double) data.get(i);
			}
			
		}
		size = (data.size() - 1) / 2;
	}
	/**
	 * 
	 * @return xk
	 */
	public double getXk()
	{
		return xk;
	}
	
	/** 
	 * @return x_array
	 */
	public double[] getxarray()
	{
		return x_array;
	}
	/**
	 * @return y_array
	 */
	public double[] getyarray()
	{
		return y_array;
	}
	/**
	 * 
	 * @return Rxy
	 */
	public double getRxy()
	{
		return Rxy;
	}
	/**
	 * 
	 * @return RSQ
	 */
	public double getRSQ()
	{
		return RSQ;
	}
	/**
	 * 
	 * @return beta0
	 */
	public double getBeta0()
	{
		return beta0;
	}
	/**
	 * 
	 * @return beta1;
	 */
	public double getBeta1()
	{
		return beta1;
	}
	/**
	 * 
	 * @return Yk
	 */
	public double getYk()
	{
		return Yk;
	}
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args)
	{
		program03 p = new program03();
		p.checkandread();
		p.calculate();
		p.print();
	}
	
	

}

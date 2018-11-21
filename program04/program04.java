import java.util.ArrayList;

import reuseLibrary.*;

/**
 * program04
 * @author ian
 *
 */
public class program04
{
	/**
	 * to store the data
	 */
	ArrayList<Double> data = new ArrayList<Double>();
	/**
	 * store the result VS
	 */
	double VS;
	/**
	 * store the result S
	 */
	double S;
	/**
	 * store the result M
	 */
	double M;
	/**
	 * store the result L
	 */
	double L;
	/**
	 * store the resutl VL
	 */
	double VL;
	/**
	 * read the input
	 */
	public void read()
	{
		double temp;
		tokens input = new tokens();
		while(input.hasNext())
		{
			if(input.hasNextDouble())
			{
				temp = input.nextDouble();
				if(temp <= 0)
				{
					System.out.println("OOPS!");
					System.exit(0);
				}
				data.add(temp);
			}
			input.nextToken();
		}
		if(data.size() <= 1)
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
	}
	/**
	 * calculate the result
	 */
	public void calculate()
	{
		double sum = 0;
		for(int i = 0; i < data.size(); i++)
		{
			sum += Math.log(data.get(i));
		}
		double avg = sum / data.size();
		double var = 0;
		double temp;
		for(int i = 0; i < data.size(); i++)
		{
			temp = Math.log(data.get(i));
			var += (temp - avg) * (temp - avg);
		}
		var = var / (data.size() - 1);
		double dev = Math.sqrt(var);
		
		VS = Math.pow(Math.E, avg - 2 * dev);
		S = Math.pow(Math.E, avg - dev);
		M = Math.pow(Math.E, avg);
		L = Math.pow(Math.E, avg + dev);
		VL = Math.pow(Math.E, avg +2 * dev);	
	}
	/**
	 * output the result in format
	 */
	public void print()
	{
		System.out.println("VS: " + String.format("%.2f", VS));
		System.out.println("S: " + String.format("%.2f", S));
		System.out.println("M: " + String.format("%.2f", M));
		System.out.println("L: " + String.format("%.2f", L));
		System.out.println("VL: " + String.format("%.2f", VL));
	}
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String args[])
	{
		program04 p = new program04();
		p.read();
		p.calculate();
		p.print();
	}
	
}

import reuseLibrary.*;

/**
 * program07
 * @author ian
 *
 */
public class program07
{
	/**
	 * store Xk
	 */
	double Xk = 0;
	/**
	 * store Xi
	 */
	double[] x_array;
	/**
	 * store avg of x_array;
	 */
	double Xavg;
	/**
	 * store Yi
	 */
	double[] y_array;
	/**
	 * store Beta0;
	 */
	double beta0 = 0;
	/**
	 * store Beta1;
	 */
	double beta1 = 0;
	/**
	 * store Rxy;
	 */
	double Rxy = 0;
	/**
	 * store RSQ;
	 */
	double RSQ = 0;
	/**
	 * store Yk;
	 */
	double Yk = 0;
	/**
	 * store Tail
	 */
	double Tail = 0;
	/**
	 * store sigma;
	 */
	double sigma = 0;
	/**
	 * store range;
	 */
	double Range = 0;
	/**
	 * store UPI
	 */
	double UPI = 0;
	/**
	 * sotre LPI;
	 */
	double LPI = 0;
	
	/**
	 * calculate Xavg
	 */
	public void calculate_Xavg()
	{
		double sum = 0;
		for(int i = 0; i < x_array.length; i++)
		{
			sum += x_array[i];
		}
		Xavg = sum / x_array.length;
	}
	/**
	 * calculate sigma
	 * @return
	 */
	public double sigma()
	{
		double sum = 0;
		for(int i = 0; i < x_array.length; i++)
		{
			sum += (y_array[i] - beta0 - beta1 * x_array[i]) * (y_array[i] - beta0 - beta1 * x_array[i]); 
		}
		return Math.sqrt(sum / (x_array.length - 2));
	}
	/**
	 * calculate dev of x
	 * @return
	 */
	public double devx()
	{
		double sum = 0;
		for(int i = 0; i < x_array.length; i++)
		{
			sum += (x_array[i] - Xavg) * (x_array[i] - Xavg);
		}
		return sum;
	}
	/**
	 * main method
	 * @param args
	 */
	public void calculate()
	{
		double p = -1;
		double x = -1;
		double ex = -1;
		program03 p3 = new program03();
		program05 p5 = new program05();
		program06 p6 = new program06();
		p3.checkandread();
		p3.calculate();
		Xk = p3.getXk();
		x_array = p3.getxarray();
		calculate_Xavg();
		y_array = p3.getyarray();
		Rxy = p3.getRxy();
		RSQ = p3.getRSQ();
		beta0 = p3.getBeta0();
		beta1 = p3.getBeta1();
		Yk = p3.getYk();
		x = Math.abs(Rxy) * Math.sqrt(x_array.length - 2) / Math.sqrt(1 - Rxy * Rxy);
		if(x == -1 || x < 0)
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
		p5.set(x, x_array.length - 2);
		p = p5.p();
		if(p == -1 || p >= 0.5)
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
		Tail = 1 - 2 * p;
		ex = p6.calculate(0.35, x_array.length - 2);
		Range = ex * sigma() * Math.sqrt(1 + (1.0 / x_array.length) + (Xk - Xavg) * (Xk - Xavg) / devx());
		UPI = Yk + Range;
		LPI = Yk - Range;
	}
	/**
	 * print out the result in format
	 */
	public void print()
	{
		System.out.println("Rxy = " + String.format("%.4f", Rxy));
		System.out.println("RSQ = " + String.format("%.4f", RSQ));
		System.out.println("Tail = " + String.format("%.3e", Tail));
		System.out.println("Beta0 = " + String.format("%.2f", beta0));
		System.out.println("Beta1 = " + String.format("%.2f", beta1));
		System.out.println("Yk = " + String.format("%.0f", Yk));
		System.out.println("Range = " + String.format("%.0f", Range));
		System.out.println("UPI(70%) = " + String.format("%.0f", UPI));
		System.out.println("LPI(70%) = " + String.format("%.0f", LPI));
	}
	/**
	 * main method
	 * @param args
	 */
	public static void main(String args[])
	{
		program07 p = new program07();
		p.calculate();
		p.print();
	}
	
}

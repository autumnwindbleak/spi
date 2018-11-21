import java.util.ArrayList;

import reuseLibrary.*;
/**
 * program06
 * @author ian
 *
 */
public class program08 
{
	/**
	 * wk
	 */
	double Wk = -1;
	/**
	 * Xk
	 */
	double Xk = -1;
	/**
	 * Yk
	 */
	double Yk = -1;
	/**
	 * Zk
	 */
	double Zk = -1;
	/**
	 * program06 t function
	 */
	program06 p6 = new program06();
	
	/**
	 * store n;
	 */
	int n;
	/**
	 * store w
	 */
	ArrayList<Double> w = new ArrayList<Double>();
	/**
	 * store x
	 */
	ArrayList<Double> x = new ArrayList<Double>();
	/**
	 * store y
	 */
	ArrayList<Double> y = new ArrayList<Double>();
	/**
	 * store z
	 */
	ArrayList<Double> z = new ArrayList<Double>();
	/**
	 * beta0
	 */
	double beta0 = -1;
	/**
	 * beta1
	 */
	double beta1 = -1;
	/**
	 * beta2
	 */
	double beta2 = -1;
	/**
	 * beta3
	 */
	double beta3 = -1;
	/**
	 * range
	 */
	double range = -1;
	
	/**
	 * read data from input
	 */
	public void read()
	{
		tokens t = new tokens();
		int flag = -3;
		while(t.hasNext())
		{
			if(t.hasNextDouble())
			{
				if(t.nextDouble() < 0)
				{
					System.out.print("OOPS!");
					System.exit(0);
				}
				if(flag == -3)
				{
					Wk = t.nextDouble();
					flag++;
				}else
				if(flag == -2)
				{
					Xk = t.nextDouble();
					flag++;
				}else
				if(flag == -1)
				{
					Yk = t.nextDouble();
					flag++;
				}else
				if(flag == 0)
				{
					w.add(t.nextDouble());
					flag++;
				}else
				if(flag == 1)
				{
					x.add(t.nextDouble());
					flag++;
				}else
				if(flag == 2)
				{
					y.add(t.nextDouble());
					flag++;
				}else
				if(flag == 3)
				{
					z.add(t.nextDouble());
					flag = 0;
				}
			}
			t.nextToken();
		}
		n = w.size();
		if(n != x.size() || n != y.size() || n != z.size() || n <= 4)
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
		for(int i = 0; i < z.size(); i++)
		{
			if(z.get(i) < 1 || w.get(i) + x.get(i) + y.get(i) < 1)
			{
				System.out.println("OOPS!");
				System.exit(0);
			}
		}
	}
	/**
	 * calculate the result
	 */
	public void calculate()
	{
		double[][] a = new double[4][4];
		double[][] b = new double[4][1];
		double sum_w = 0;
		double sum_x = 0;
		double sum_y = 0;
		double sum_z = 0;
		double sum_w2 = 0;
		double sum_x2 = 0;
		double sum_y2 = 0;
		double sum_wx = 0;
		double sum_wy = 0;
		double sum_wz = 0;
		double sum_xy = 0;
		double sum_xz = 0;
		double sum_yz = 0;
		for(int i = 0; i < w.size(); i++)
		{
			sum_w += w.get(i);
			sum_x += x.get(i);
			sum_y += y.get(i);
			sum_z += z.get(i);
			sum_w2 += w.get(i) * w.get(i);
			sum_x2 += x.get(i) * x.get(i);
			sum_y2 += y.get(i) * y.get(i);
			sum_wx += w.get(i) * x.get(i);
			sum_wy += w.get(i) * y.get(i);
			sum_wz += w.get(i) * z.get(i);
			sum_xy += x.get(i) * y.get(i);
			sum_xz += x.get(i) * z.get(i);
			sum_yz += y.get(i) * z.get(i);
		}
		if(sum_w < 1 || sum_x < 1 || sum_y < 1 || sum_z < 1)
		{
			System.out.println("OOPS!");
			System.exit(0);
		}
		a[0][0] = n;
		a[0][1] = sum_w;
		a[0][2] = sum_x;
		a[0][3] = sum_y;
		b[0][0] = sum_z;
		a[1][0] = sum_w;
		a[1][1] = sum_w2;
		a[1][2] = sum_wx;
		a[1][3] = sum_wy;
		b[1][0] = sum_wz;
		a[2][0] = sum_x;
		a[2][1] = sum_wx;
		a[2][2] = sum_x2;
		a[2][3] = sum_xy;
		b[2][0] = sum_xz;
		a[3][0] = sum_y;
		a[3][1] = sum_wy;
		a[3][2] = sum_xy;
		a[3][3] = sum_y2;
		b[3][0] = sum_yz;
		matrix am = new matrix(a);
		matrix bm = new matrix(b);
		double[] result = am.solve(bm);
		beta0 = result[0];
		beta1 = result[1];
		beta2 = result[2];
		beta3 = result[3];
		Zk = beta0 + Wk * beta1 + Xk * beta2 + Yk * beta3;
		double sigma = 0;
		for(int i = 0; i < n; i++)
		{
			sigma += (z.get(i) - beta0 - beta1 * w.get(i) - beta2 * x.get(i) - beta3 * y.get(i)) * (z.get(i) - beta0 - beta1 * w.get(i) - beta2 * x.get(i) - beta3 * y.get(i));
		}
		sigma = sigma / (double)(n - 4);
		sigma = Math.sqrt(sigma);
		double Wavg = sum_w / (double)n;
		double Xavg = sum_x / (double)n;
		double Yavg = sum_y / (double)n;
		double sumxa = 0;
		double sumya = 0;
		double sumwa = 0;
		for(int i = 0; i < n; i++)
		{
			sumwa += (w.get(i) - Wavg) * (w.get(i) - Wavg);
			sumxa += (x.get(i) - Xavg) * (x.get(i) - Xavg);
			sumya += (y.get(i) - Yavg) * (y.get(i) - Yavg);
		}
		range = p6.calculate(0.35, n - 4) * sigma * Math.sqrt(1 + 1.0 / (double)n + (Wk - Wavg)* (Wk - Wavg) / sumwa +(Xk - Xavg) * (Xk - Xavg) / sumxa + (Yk - Yavg) * (Yk - Yavg) / sumya);
	}
	/**
	 * print out the result
	 */
	public void print()
	{
		System.out.println("Beta0 = " + String.format("%.4f", beta0));
		System.out.println("Beta1 = " + String.format("%.4f", beta1));
		System.out.println("Beta2 = " + String.format("%.4f", beta2));
		System.out.println("Beta3 = " + String.format("%.4f", beta3));
		System.out.println("Hours = " + String.format("%.1f", Zk));
		System.out.println("UPI(70%) = " + String.format("%.1f", (Zk + range)));
		System.out.println("LPI(70%) = " + String.format("%.1f", (Zk - range)));
	}
	
	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args)
	{
		program08 p8 = new program08();
		p8.read();
		p8.calculate();
		p8.print();
	}

}

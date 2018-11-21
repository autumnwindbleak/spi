
/**
 * solve matrix problem
 * @author ian
 *
 */
public class matrix 
{
	/**
	 * store matrix double[][]
	 */
	double[][] matrix;

	/**
	 * constructor with double array
	 * @param matrix
	 */
	matrix(double[][] matrix)
	{
		this.matrix = matrix;
		if(matrix.length == 0 && matrix.length < matrix[0].length)
		{
			System.out.println("matrix error");
			System.exit(0);
		}
	}
	
	/**
	 * constructor with matrix
	 * @param x
	 */
	matrix(matrix x)
	{
		this.matrix = x.getdoublematrix();
	}
	
	/**
	 * get the height of matrix
	 * @return height
	 */
	public int getheight()
	{
		return matrix.length;
	}
	
	/**
	 * get the width of matrix
	 * @return
	 */
	public int getwidth()
	{
		return matrix[0].length;
	}
	
	
	/**
	 * get the double array matrix
	 * @return whole matrix in double array
	 */
	public double[][] getdoublematrix()
	{
		return matrix;
	}
	/**
	 * get Matrix[i][j]
	 * @param i 
	 * @param j
	 * @return Matrix[i][j]
	 */
	public double getelement(int i, int j)
	{
		return matrix[i][j];
	}
	
	
	/**
	 * solve singular matrix
	 * @param b should be double[1][n]
	 * @return x matrix
	 */
	public double[] solve(matrix b)
	{
		double[] result = new double[b.getheight()];
		double[][] temp = getdoublematrix();
		for(int i = 0; i < result.length; i++)
		{
			result[i] = b.getelement(i, 0);
		}
		double div;
		for(int i = 0; i < temp.length-1; i++)
		{
			for(int j = i+1; j < temp.length; j++)
			{
				if(temp[j][i] == 0)
				{
					continue;
				}
				div = temp[j][i] / temp[i][i];
				for(int k = i; k < temp[j].length; k++)
				{
					temp[j][k] = temp[j][k] - temp[i][k] * div;	
				}
				result[j] = result[j] - result[i] * div;
			}
		}

		for(int i = result.length-1; i > 0 ; i--)
		{
			for(int j = i-1; j >=0; j--)
			{
				if(temp[j][i] == 0)
				{
					continue;
				}
				div = temp[j][i] / temp[i][i]; 
				temp[j][i] = temp[j][i] - temp[i][i] * div;
				result[j] = result[j] - result[i] * div;
			}
		}	
		for(int i = 0; i < result.length; i++)
		{
			div = temp[i][i];
			if(div == 0)
			{
				System.out.println("OOPS!");
				System.exit(0);
			}
			temp[i][i] = 1.0;
			result[i] = result[i] / div;			
		}
		return result;
	}

	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args)
	{
		double[][] a = {{1,1},{1,-1}};
		double[][] b = {{1},{2}};
		matrix am = new matrix(a);
		matrix bm = new matrix(b);
		double[] result = am.solve(bm);
		for(int i = 0; i < result.length; i++)
		{
			System.out.println(result[i]);
		}
	}
	
}

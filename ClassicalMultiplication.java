import java.util.Random;

public class ClassicalMultiplication {
	
	private int[][] a;

	public ClassicalMultiplication(int n) {
		Random rng = new Random();
		a = new int[n][n];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				a[i][j] = rng.nextInt(10) + 1;
				//System.out.printf("%-8d ", a[i][j]);
			}
			//System.out.println();
		}
		//System.out.println();
	}
	
	public int[][] multiplication(int[][] b) {
        int[][] c = new int[a.length][b[0].length];
		for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                for (int k = 0; k < a.length; k++)
                {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }
		return c;
	}
	
	public void print(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.printf("%-8d ", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public int[][] getMatrix() {
		return a;
	}
	
	public static void main(String[] args) {
		int n = 2048;
		ClassicalMultiplication matrix1 = new ClassicalMultiplication(n);
		ClassicalMultiplication matrix2 = new ClassicalMultiplication(n);
		double startTime = System.nanoTime();
		int[][] result = matrix1.multiplication(matrix2.getMatrix());
		double totalTime = (System.nanoTime() - startTime) / 1000000000;
		System.out.println(totalTime);
		//matrix1.print(result);
	}
}

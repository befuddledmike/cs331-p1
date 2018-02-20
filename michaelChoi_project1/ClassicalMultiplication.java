import java.util.Random;

public class ClassicalMultiplication {
	
	private int[][] a;

	public ClassicalMultiplication(int n) {	//constructor
		Random rng = new Random();	//random class for random numbers
		a = new int[n][n];	//instantiate a as n x n matrix
		for(int i = 0; i < a.length; i++) {	//fill in matrix with random numbers
			for(int j = 0; j < a[0].length; j++) {
				a[i][j] = rng.nextInt(n) + 1;
			}
		}
	}
	
	public int[][] multiplication(int[][] b) {	//multiplication method
        int[][] c = new int[a.length][b[0].length];	//c = product matrix with same size (n x n)
		for (int i = 0; i < a.length; i++) {	//0 to n for row
            for (int j = 0; j < a.length; j++) {	//0 to n for column
                for (int k = 0; k < a.length; k++) {	//go right or down the row/column
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];	//c[i][j] = sum of all the row entry * col entry
                }
            }
        }
		return c;	//return product matrix
	}
	
	public void print(int[][] matrix) {	//optional print method
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.printf("%-8d ", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {	//main method
		int n = 2048;	//size of row and column (n x n)
		ClassicalMultiplication matrix1 = new ClassicalMultiplication(n);	//first matrix
		ClassicalMultiplication matrix2 = new ClassicalMultiplication(n);	//second matrix
		System.out.println("Classical Multiplication:");
		double startTime = System.nanoTime();
		int[][] result = matrix1.multiplication(matrix2.a);	//product of matrix1 and matrix2
		double totalTime = (System.nanoTime() - startTime) / 1000000000;	//total time taken
		System.out.println("Total time taken: " + totalTime);
	}
}
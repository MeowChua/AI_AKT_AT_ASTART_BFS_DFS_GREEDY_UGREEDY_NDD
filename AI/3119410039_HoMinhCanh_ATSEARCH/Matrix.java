package ATSEARCH;
public class Matrix{
	
	public int matrix[][];
	
	static int row = 23;
	
	static int colum = 23;
	
	Matrix(){
		matrix = new int[row][colum];
	}
	
	public int[][] initialMatrix(int row, int colum, int value) {
		this.matrix[row][colum] = value;
		return this.matrix;
	}
	
	public void printMatrix() {
		for(int i = 0; i<Matrix.row; i++) {
			for(int j = 0; j<Matrix.colum; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
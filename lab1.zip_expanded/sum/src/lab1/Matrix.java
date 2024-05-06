package lab1;

/**
* <b>Title:</b> Lab 1:<br>
* <b>Filename:</b> Matrix.java<br>
* <b>Date Written:</b> September 13, 2023<br>
* <b>Due Date:</b> September 16, 2023<br>
* <p>
* <b>Description:</b><br>
* Manipulates Matrices through a variety of methods to include addition, subtraction
* and multiplication
* <p><b>Algorithm:</b></p>
* 
*@author Kevin Li
*/
public class Matrix {
	
	private double[][] matrix;
	
	public Matrix() {
		
		matrix = new double[][] {{0,0},{0,0}};
		
	}
	/**
	 * 
	 * @param m Two dimensional array used to assign every value in matrix
	 * 			to every value in m
	 * @throws RuntimeException Error signifying a two dimensional array is
	 * 							invalid for the purposes of creating a Matrix, e.g.
	 * 							every column does not have the same length
	 */
	public Matrix(double[][] m) throws RuntimeException{
		
		if (!isMatrix(m)) {
			throw new RuntimeException("InvalidMatrixException");
		}
		matrix = new double[m.length][m[0].length];
		for (int r = 0; r < m.length; r++) {
			for (int c = 0; c < m[r].length; c++) {
				matrix[r][c] = m[r][c]; 
			}
		}
	}
	public Matrix(int r, int c) {
		matrix = new double[r][c]; 
	}
	// returns number of rows in a matrix
	public int getRows() {
		return matrix.length;
	}
	// returns number of columns in a matrix
	public int getColumns() {
		return matrix[0].length;
	}
	/**
	 * 
	 * @param om 	other Matrix object for the purpose of comparing matrices
	 * @return		returns false if other matrix does not share the same number
	 * 				of rows and columns, and if values between the two matrices in 
	 * 				the same positions are not the same, returns true otherwise
	 */
	public boolean equals(Matrix om) {
		
		if (om.matrix.length != matrix.length || matrix[0].length != om.matrix[0].length) {
			return false;
		}
		for (int r = 0; r < om.matrix.length; r++) {
			for (int c = 0; c < om.matrix[r].length; c++) {
				if (this.matrix[r][c] != om.matrix[r][c]) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * 
	 * @param om	other matrix for the purpose of comparison 
	 * @return		returns false if other matrix does not have the same 
	 * 				column length for every column, or if every value in 
	 * 				om.matrix is 0.0, the marker of a default array,
	 * 				returns true otherwise
	 */
	public boolean isMatrix(double[][] om) {
		
		boolean notnull = false;
		
		for (int r = 0; r < om.length; r++) {
			for (int c = 0; c < om[0].length; c++) {
				if (om[r].length != om[0].length) {
					return false;
				}
				if (om[r][c] != 0.0) {
					notnull = true;
				}
			}
		}
		return notnull;
	}
	/**
	 * 
	 * @param om 	other matrix for the purpose of comparison 
	 * @return		returns true if both matrices share the same number of
	 * 				rows and columns, false otherwise
	 */
	private boolean sameDimensions(Matrix om) {
		
		if (this.isMatrix(matrix) && this.matrix.length == om.matrix.length && this.matrix[0].length == om.matrix[0].length) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * 
	 * @param om 	other Matrix object for the purpose of comparison 
	 * @return		returns new Matrix object with value in each index r,c 
	 * 				being that of the sum of the two matrices value at index r,c,
	 * 				returns null if matrices do not have the same dimensions
	 */
	public Matrix add(Matrix om) {
		
		double[][] newMatrix = new double[om.matrix.length][om.matrix[0].length];
		
		if (this.sameDimensions(om)) {						
			for (int r = 0; r < newMatrix.length; r++) {
				for (int c = 0; c < newMatrix[0].length; c++) {
					newMatrix[r][c] = this.matrix[r][c] + om.matrix[r][c]; 
				}
			}
		}
		else {
			return null;
		}
		
		return new Matrix(newMatrix);
	}
	/**
	 * 
	 * @param om 	other Matrix object for the purpose of comparison 
	 * @return		returns new Matrix object with value in each index r,c 
	 * 				being that of the difference of the two matrices value at index r,c,
	 * 				returns null if matrices do not have the same dimensions
	 */
	public Matrix subt(Matrix om) {
		
		double[][] newMatrix = new double[om.matrix.length][om.matrix[0].length];
		
		if (this.sameDimensions(om)) {
			for (int r = 0; r < newMatrix.length; r++) {
				for (int c = 0; c < newMatrix[0].length; c++) {
					newMatrix[r][c] = this.matrix[r][c] - om.matrix[r][c]; 
				}
			}
		}
		else {
			return null;
		}
		
		return new Matrix(newMatrix);
	}
	/**
	 * 
	 * @param om	other Matrix object for the purpose of comparison 
	 * @return		returns Matrix object with m rows and n columns for 
	 * 				the this.matrix dimension of m x p and om.matrix dimension 
	 * 				of p x n, the value of each index being that of the sums of the 
	 * 				products of this.matrix's rows and om.matrix's columns.
	 * 				returns null if this.matrix's columns are not equal to om.matrix's
	 * 				columns.
	 */
	public Matrix mult(Matrix om) {
		
		double[][] newMatrix = new double[matrix.length][om.matrix[0].length];
		
		if (this.getColumns() == om.getRows()) {	
			for (int r = 0; r < matrix.length; r++) {
				for (int c = 0; c < om.matrix[0].length; c++) {
					for (int k = 0; k < matrix[0].length; k++) {
					
						newMatrix[r][c] += matrix[r][k] * om.matrix[k][c];
					}
				}
			}
		}
		else {
			return null;
		}
		return new Matrix(newMatrix);
	}
	/**
	 * 
	 * @param s		integer scalar amount for the purpose of multiplication
	 * @return		returns new Matrix Object with identical dimensions, but with
	 * 				values equivalent to this.matrix's values * s.
	 */
	public Matrix scalarMult(int s) {
		
		double[][] newMatrix = new double[matrix.length][matrix[0].length];
							
			for (int r = 0; r < newMatrix.length; r++) {
				for (int c = 0; c < newMatrix[0].length; c++) {
					newMatrix[r][c] = this.matrix[r][c] * s; 
				}
			}
		return new Matrix(newMatrix);
	}
	/**
	 * 
	 * @return		returns new Matrix object with values transposed, or 
	 * 				having rows and columns reversed, likewise having the amount
	 * 				of rows and columns also reversed.
	 */
	public Matrix transpose() {
		
		double[][] newMatrix = new double[this.matrix[0].length][this.matrix.length];
		
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				newMatrix[c][r] = matrix[r][c];
					
			}
		}
		
		return new Matrix(newMatrix);
	}
	/**
	 * 			Overrides toString method, returning Matrix in
	 * 			an easy to read String format
	 */
	public String toString() {
		String matStr = new String();
		
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				
				if (c == 0) {
					matStr += "{";
				}
				
				if (c == matrix[0].length - 1) {
					matStr += matrix[r][c] + "} \n";
				}
				else {
					matStr += matrix[r][c] + "  ";
				}
			}
		}
		return matStr;
	}
	
	
	
	public static void main(String[] args) {
	}

}

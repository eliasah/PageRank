package datastructure;

public class Graph extends SparseMatrix {

	/**
	 * 
	 * @param n
	 * @param m
	 */
	public Graph(int n, int m) {
		super(n,m);
	}

	/**
	 * 
	 * @param matrix
	 * @param m
	 */
	public Graph(float[][] matrix, int m) {
		super(matrix, m);
	}
}

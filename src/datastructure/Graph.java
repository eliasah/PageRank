package datastructure;

public class Graph {

	int nodes;
	int links;
	SparseMatrix adjMatrix;

	/**
	 * 
	 * @param n
	 * @param m
	 */
	public Graph(int n, int m) {
		this.nodes = n;
		this.links = m;
		this.adjMatrix = new SparseMatrix(n, m);
	}

	/**
	 * 
	 * @param s
	 * @param n
	 * @param m
	 */
	public Graph(String s, int n, int m) {
		SparseMatrixReader r = new SparseMatrixReader(s, n, m);
		this.adjMatrix = r.getMatrix();
		this.nodes = n;
		this.links = m;
	}

	/**
	 * 
	 * @param matrix
	 * @param m
	 */
	public Graph(float[][] matrix, int m) {
		this.adjMatrix = new SparseMatrix(matrix, m);
		this.links = m;
		this.nodes = matrix.length;
	}

	/**
	 * @return the nodes
	 */
	public int getNodes() {
		return nodes;
	}

	/**
	 * @return the links
	 */
	public int getLinks() {
		return links;
	}

	/**
	 * @return the adjMatrix
	 */
	public SparseMatrix getAdjMatrix() {
		return adjMatrix;
	}

}

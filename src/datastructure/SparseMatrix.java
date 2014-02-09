package datastructure;

public class SparseMatrix {
	float[] C;
	int[] L;
	int[] I;
	int n;
	int m;

	/**
	 * SparseMatrix Constructor from a matrix representation of the graph
	 * 
	 * Complexity : O(n^2)
	 * 
	 * @param matrix
	 *            matrix representation of the graph
	 * @param m
	 *            number of non-null elements in the matrix
	 */
	public SparseMatrix(float[][] matrix, int m) {
		this.n = matrix.length;
		this.m = m;
		System.out.println("n = " + this.n);
		System.out.println("m = " + this.m);

		this.C = new float[m];
		this.L = new int[n + 1];
		this.I = new int[m];

		L[0] = 0; // default value to L
		int cpt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != 0) {
					C[cpt] = matrix[i][j];
					I[cpt] = j;
					cpt++;
				}
			}
			L[i + 1] = cpt;
		}

	}

	public SparseMatrix(int n, int m) {
		this.C = new float[m];
		this.L = new int[n + 1];
		this.I = new int[m];
		this.n = n;
		this.m = m;
	}

	public float[] getC() {
		return C;
	}

	public float getC(int index) {
		return C[index];
	}

	public int[] getI() {
		return I;
	}

	public int getI(int index) {
		return I[index];
	}

	public int[] getL() {
		return L;
	}

	public int getL(int index) {
		return L[index];
	}

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}

	/**
	 * 
	 * @param v
	 * @return
	 */
	public float[] MultiplyTransposeWithVector(float[] v) {
		float[] product = new float[n];
		// Initialise the product vector with 0
		for (int i = 0; i < n; i++) {
			product[i] = 0;
		}

		// compute the product
		for (int i = 0; i < n; i++) {
			for (int j = L[i]; j < L[i + 1]; j++) {
				// System.out.println("I[" + j + "] = " + I[j]);
				product[I[j]] += C[j] * v[i];
			}
		}
		// return product
		return product;

	}

	/**
	 * Return the matrix multiplication production with a vector v
	 * 
	 * @param v
	 *            integer vector
	 * @return
	 */
	public float[] MultiplyWithVector(float[] V) {
		float[] product = new float[n];

		// Initialise the product vector with 0
		for (int i = 0; i < n; i++) {
			product[i] = 0;
		}

		// compute the product
		for (int i = 0; i < n; i++) {
			for (int j = L[i]; j <= L[i + 1] - 1; j++) {
				product[i] += C[j] * V[I[j]];
			}
		}

		// return product
		return product;
	}

	public void printMatrix() {
		System.out.println(this.toString());
	}

	public void setC(float[] c) {
		C = c;
	}

	public void setC(int index, float v) {
		C[index] = v;
	}

	public void setI(int[] i) {
		I = i;
	}

	public void setL(int[] l) {
		L = l;
	}

	public void setM(int m) {
		this.m = m;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String toString() {
		String str = "";
		str += "\n" + "C = { ";
		for (float c : C)
			str += c + " ";
		str += "}\nL = { ";
		for (int l : L)
			str += l + " ";
		str += "}\nI = { ";
		for (int i : I)
			str += i + " ";
		str += "}\n";
		return str;
	}
}

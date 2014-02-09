package datastructure;

public class SparseMatrix {
	float[] C;
	int[] L;
	int[] I;
	int n;
	int m;

	public SparseMatrix(float[][] matrice, int m) {
		this.n = matrice.length;
		this.m = m;
		System.out.println("n = " + this.n);
		System.out.println("m = " + this.m);

		this.C = new float[m];
		this.L = new int[n + 1];
		this.I = new int[m];

		L[0] = 0;
		int cpt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < matrice[i].length; j++) {
				if (matrice[i][j] != 0) {
					C[cpt] = matrice[i][j];
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

	public float[] MultiplyTransposeWithVector(float[] v) {
		float[] product = new float[n];
		// Initialise the product vector with 0
		for (int i = 0; i < n; i++) {
			product[i] = 0;
		}

		// compute the product
		for (int i = 0; i < n; i++) {
			for (int j = L[i]; j < L[i + 1]; j++) {
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

	public float diff(SparseMatrix m2) {
		float result = 0;

		return result;
	}
}

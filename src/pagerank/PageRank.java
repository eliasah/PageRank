package pagerank;

// import java.text.DecimalFormat;
import java.util.Scanner;

import datastructure.SparseMatrix;

public class PageRank {

	private boolean verbose = false;
	private float[] pageRankVector;
	private float[] stochVector;
	private SparseMatrix matrix;
	private float epsilon = 0.01F;

	/**
	 * Initialize PageRank with matrix m
	 * 
	 * @param m
	 *            SparseMatrix
	 */
	public PageRank(SparseMatrix m) {
		int n = m.getN();
		this.stochVector = new float[n];
		for (int i = 0; i < stochVector.length; i++) {
			this.stochVector[i] = 1F / (float) n;
		}
		// stochVector[index] = 1;
		this.pageRankVector = new float[n];
		this.matrix = m;
	}

	/**
	 * Initialize PageRank with matrix m and a stochastic vector z
	 * 
	 * @param m
	 *            SparseMatrix
	 * @param z
	 *            Stochastic vector
	 */
	public PageRank(SparseMatrix m, float[] z) {
		this(m);
		this.stochVector = z;
	}

	/**
	 * Initialize PageRank with matrix m and stochastic vector z. Set epsilon
	 * value
	 * 
	 * @param m
	 *            SparseMatrix
	 * @param z
	 *            Stochastic vector
	 * @param ep
	 *            epsilon
	 */
	public PageRank(SparseMatrix m, float[] z, float ep) {
		this(m, z);
		this.epsilon = ep;
	}

	/**
	 * Initialize PageRank with matrix m and et epsilon value
	 * 
	 * @param m
	 *            SparseMatrix
	 * @param ep
	 *            epsilon
	 */
	public PageRank(SparseMatrix m, float ep) {
		this(m);
		this.epsilon = ep;
	}

	/**
	 * Cette fonction calcule la norme de la difference de deux vecteurs
	 * 
	 * @param v1
	 *            vector 1
	 * @param v2
	 *            vector 2
	 * @return
	 */
	public float norm(float[] v1, float[] v2) {
		int n = v1.length;
		float[] tmp = new float[n];
		float norm = 0F;
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = v1[i] - v2[i];
			norm += Math.pow(tmp[i], 2);
		}

		return (float) Math.sqrt(norm);
	}

	/**
	 * Cette fonction calcule le PageRank standard
	 */
	public void computePageRankStd() {
		pageRankVector = stochVector;
		float[] pageRankN;

		float delta = 1F + epsilon;
		int cpt = 0;
		while (delta >= epsilon) {
			if (verbose)
				System.out.println("\t" + this.PtoString(cpt));
			pageRankN = matrix.MultiplyTransposeWithVector(pageRankVector);
			delta = norm(pageRankN, pageRankVector);
			pageRankVector = pageRankN;
			cpt++;
		}
		if (verbose) {
			System.out.println("\t" + this.PtoString(cpt));
		}
	}

	/**
	 * les indices des sommets commencent par 0
	 * 
	 * @param node
	 *            starting node
	 * @param nbPas
	 *            number of pace
	 */
	public void computePageRank(int node, int nbPas) {
		pageRankVector = stochVector;
		int cpt = 0;
		if (verbose) {
			System.out.println("\t" + this.PtoString(cpt));
		}

		float delta = 1F + epsilon;
		float[] pageRankN;

		while (nbPas > 0) {

			pageRankN = matrix.MultiplyTransposeWithVector(pageRankVector);
			nbPas--;
			delta = norm(pageRankN, pageRankVector);

			pageRankVector = pageRankN;
			if (verbose) {
				System.out.println("\t" + this.PtoString(cpt + 1));
			}
			if (delta == 0) {
				System.out.println("\t=> P converge apres " + (cpt + 1)
						+ " pas.");
				if (verbose)
					System.out.println("\t" + this.PtoString(cpt + 1));

				break;
			}
			cpt++;
		}
	}

	/**
	 * Cette fonction calcule le PageRank a partir de zero
	 * 
	 * @param nbPas
	 *            number of pace
	 */
	public void computePageRankZero(int start, int nbPas) {
		computePageRank(start, nbPas);
	}

	/**
	 * helper for adding zap factor coeff to pageRank
	 * 
	 * @param f
	 *            zap factor
	 */
	private void addZap(float f) {
		for (int i = 0; i < pageRankVector.length; i++) {
			this.pageRankVector[i] += f;
		}
	}

	/**
	 * helper for multiplying zap factor coeff with pageRank
	 * 
	 * @param f
	 *            zap factor
	 */
	private void multZap(float f) {
		for (int i = 0; i < pageRankVector.length; i++) {
			this.pageRankVector[i] *= (1f - f);
		}
	}

	/**
	 * Computer PageRank considering a zap factor
	 * 
	 * @param node
	 *            starting node
	 * @param zap
	 *            zap factor
	 * @param nbPas
	 *            number of pace
	 */
	public void computePageRankWithZap(int node, float zap, int nbPas) {
		assert (zap >= 0.1F && zap <= 0.2F);
		pageRankVector = new float[matrix.getN()];
		pageRankVector[node] = 1;
		int n = matrix.getN();
		int cpt = 0;
		if (verbose) {
			System.out.println("\t" + this.PtoString(cpt));
		}
		while (nbPas > 0) {

			pageRankVector = matrix.MultiplyTransposeWithVector(pageRankVector);
			multZap(zap);
			addZap(zap / n);
			if (verbose) {
				System.out.println("\t" + this.PtoString(cpt));
			}
			nbPas--;
			cpt++;
		}
	}

	/**
	 * 
	 * @param j
	 *            step number
	 * @return PageRank vector in string format
	 */
	public String PtoString(int j) {
		// DecimalFormat df = new DecimalFormat();
		// df.setMinimumFractionDigits(5);
		String str = new String();
		str += "P(" + j + ")\t = ( ";
		for (float i : pageRankVector) {
			str += i + " ";
			// str += df.format(i) + " ";
		}

		return str + ")";
	}

	/**
	 * 
	 * @return PageRank Vector
	 */
	public float[] getPageRank() {
		return pageRankVector;
	}

	/**
	 * 
	 * @param index
	 *            node
	 * @return pagerank for given node
	 */
	public float getPageRank(int index) {
		return pageRankVector[index];
	}

	/**
	 * Set stochastic vector
	 * 
	 * @param v
	 *            stochastic vector
	 */
	public void setZ(float[] v) {
		this.stochVector = v;
	}

	/**
	 * Set verbose mode
	 * 
	 * @param bool
	 *            boolean
	 */
	public void setVerbose(boolean bool) {
		verbose = bool;
	}
}

package pagerank;

import datastructure.SparseMatrix;

public class PageRank {

	int start;
	float[] pageRankVector;
	float[] stochVector;
	SparseMatrix matrix;
	float epsilon = 0.01F;

	public PageRank(SparseMatrix m, int index) {
		int n = m.getN();
		this.stochVector = new float[n];
		// for (int i = 0; i < stochVector.length; i++) {
		// this.stochVector[i] = 1F / (float) n;
		// }
		stochVector[index] = 1;
		this.pageRankVector = new float[n];
		this.matrix = m;
		this.start = index;
	}

	// Cette fonction calcule la norme de la difference de deux vecteurs
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

	// Cette fonction calcule le PageRank standard
	public void computePageRankStd() {
		pageRankVector = stochVector;
		float[] pageRankN;

		float delta = 1F + epsilon;
		int cpt = 0;
		while (delta >= epsilon) {
			System.out.println(this.PtoString(cpt));
			pageRankN = matrix.MultiplyTransposeWithVector(pageRankVector);
			delta = norm(pageRankN, pageRankVector);
			pageRankVector = pageRankN;
			cpt++;
		}
		System.out.println(this.PtoString(cpt));

	}

	// les indices des sommets commencent par 0
	public void computePageRank(int node, int nbPas) {
		pageRankVector = new float[matrix.getN()];
		pageRankVector[node] = 1;
		while (nbPas > 0) {
			pageRankVector = matrix.MultiplyTransposeWithVector(pageRankVector);
			nbPas--;
		}
	}

	// Cette fonction calcule le PageRank a partir de zero
	public void computePageRankZero(int nbPas) {
		computePageRank(0, nbPas);
	}

	public String PtoString(int j) {
		String str = new String();
		str += "P(" + j + ") = ( ";
		for (float i : pageRankVector) {
			str += i + " ";
		}

		return str + ")";
	}

	public float[] getPageRank() {
		return pageRankVector;
	}
}

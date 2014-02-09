package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import datastructure.SparseMatrix;
import datastructure.SparseMatrixReader;

public class SparseMatrixTest {

	@Test
	public void testMultiplyWithVector() {
		System.out.print("> Testing MultiplyWithVector : ");
		float[] C = { 1F, 1F, 0.5F, 0.5F, 1F / 3F, 1F / 3F, 1F / 3F, 1F };
		int[] L = { 0, 1, 2, 4, 7, 8 };
		int[] I = { 2, 3, 0, 2, 0, 1, 4, 1 };

		SparseMatrix M = new SparseMatrix(5, 8);
		float[] v = { 10, 0, 3, -1, 5 };

		M.setC(C);
		M.setL(L);
		M.setI(I);

		float[] result = M.MultiplyWithVector(v);
		float[] expected = { 3, -1, (float) 6.5, 5, 0 };

		assertEquals(expected.length, result.length);

		for (int i = 0; i < result.length; i++) {
			assertTrue(expected[i] == result[i]);
		}
		System.out.println("Test success");
	}

	@Test
	public void testMultiplyTransposeWithVector() {
		System.out.print("> Testing MultiplyTransposeWithVector : ");
		float[] C = { 1F, 1F, 0.5F, 0.5F, 1F / 3F, 1F / 3F, 1F / 3F, 1F };
		int[] L = { 0, 1, 2, 4, 7, 8 };
		int[] I = { 2, 3, 0, 2, 0, 1, 4, 1 };

		SparseMatrix M = new SparseMatrix(5, 8);
		float[] v = { 10, 0, 3, -1, 5 };

		M.setC(C);
		M.setL(L);
		M.setI(I);

		float[] result = M.MultiplyTransposeWithVector(v);
		float[] expected = { 7F / 6F, 4F + 2F / 3F, 23F / 2F, 0, -1F / 3F };

		assertEquals(expected.length, result.length);

		for (int i = 0; i < result.length; i++) {
			// System.out.println(result[i]);
			assertTrue(expected[i] == result[i]);
		}
		System.out.println("Test success");

	}

	@Test
	public void testDummyExempleMultiplyTransposeWithVector() {
		System.out
				.print("> Testing DummyExempleMultiplyTransposeWithVector : ");
		SparseMatrixReader r = new SparseMatrixReader("data/exemple.data", 5, 8);
		SparseMatrix m = r.getMatrix();

		float[] v = { 10, 0, 3, -1, 5 };

		float[] result = m.MultiplyTransposeWithVector(v);
		float[] expected = { 7F / 6F, 4F + 2F / 3F, 23F / 2F, 0, -1F / 3F };

		assertEquals(expected.length, result.length);

		for (int i = 0; i < result.length; i++) {
			// System.out.println(result[i] + "\t" + expected[i]);
			assertTrue(expected[i] == result[i]);
		}
		System.out.println("Test Success");
	}

	@Test
	public void testDummyExemple() {
		System.out.println("> Testing SparseMatrixReader on exemple.data : ");
		SparseMatrixReader s = new SparseMatrixReader("data/exemple.data", 5, 8);
		SparseMatrix m = s.getMatrix();
		assertTrue(verifyLink(m));

	}

	@Test
	public void testP2PGnutella() {
		System.out.println("> Testing SparseMatrixReader on p2p-Gnutella04 : ");
		SparseMatrixReader s = new SparseMatrixReader(
				"data/p2p-Gnutella04.data", 10876, 39994);
		SparseMatrix m = s.getMatrix();
		assertTrue(verifyLink(m));

	}

	private boolean verifyLink(SparseMatrix m) {
		boolean verdict = false;
		System.out.print("\t1. Pick a random index from C : ");
		int i = (int) (Math.random() * ((m.getM())));
		System.out.println(+i + " (C[" + i + "] = " + m.getC(i) + ")");
		System.out.println("\t2. Compute link from L and I");
		int l_index = 0, tmp = 0;
		for (int j = 0; j <= m.getN(); j++) {
			if (i == 0) {
				break;
			}
			tmp = m.getL(j);
			if (tmp >= i) {
				break;
			}
			l_index = j + 1;
		}
		System.out.println("\t L[" + l_index + "] = " + m.getL(l_index));
		int i_index = i;
		System.out.println("\t I[" + i_index + "] = " + m.getI(i_index));

		// TODO 3. vérifier dans le fichier que l'arc existe bien.

		verdict = true;
		return verdict;
	}
}

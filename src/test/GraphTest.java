package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import datastructure.SparseMatrix;
import datastructure.GraphReader;

public class GraphTest {

	
	
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
		GraphReader r = new GraphReader("data/exemple1.data", 5, 8);
		SparseMatrix m = r.getGraph();

		float[] v = { 10, 0, 3, -1, 5 };

		float[] result = m.MultiplyTransposeWithVector(v);
		float[] expected = { 7F / 6F, 4F + 2F / 3F, 23F / 2F, 0, -1F / 3F };

		assertEquals(expected.length, result.length);

		for (int i = 0; i < result.length; i++) {
			assertTrue(expected[i] + " is different from " + result[i],
					expected[i] == result[i]);
		}
		System.out.println("Test Success");
	}

	@Test
	public void testDummyExemple() {
		System.out.print("> Testing on dummy exemple1.data : ");
		GraphReader s = new GraphReader("data/exemple1.data", 5, 8);
		SparseMatrix m = s.getGraph();
		assertTrue("test dummy example fail",
				verifyLink(m, "data/exemple1.data"));
		System.out.println("Test Success");

	}

	@Test
	public void testP2PGnutella() {
		System.out.print("> Testing SparseMatrixReader on p2p-Gnutella04 : ");
		GraphReader s = new GraphReader(
				"data/p2p-Gnutella04.data", 10876, 39994);
		SparseMatrix m = s.getGraph();
		assertTrue("test gnutella fail",
				verifyLink(m, "data/p2p-Gnutella04.data"));
		System.out.println("Test Success");
	}

	private boolean verifyLink(SparseMatrix m, String file) {
		boolean verdict = false;
		// System.out.print("\t1. Pick a random index from C : ");
		int i = (int) (Math.random() * ((m.getM())));
		// System.out.println(+i + " (C[" + i + "] = " + m.getC(i) + ")");
		// System.out.println("\t2. Compute link from L and I");
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
		// System.out.println("\t L[" + l_index + "] = " + m.getL(l_index));
		int i_index = i;
		// System.out.println("\t I[" + i_index + "] = " + m.getI(i_index));

		BufferedReader br = null;
		String sCurrentLine;
		int n1, n2;
		try {
			br = new BufferedReader(new FileReader(file));

			while ((sCurrentLine = br.readLine()) != null) {
				String[] tmp2 = sCurrentLine.split("\\s+");
				if (sCurrentLine.startsWith("#")) {
					continue;
				} else {
					n1 = Integer.parseInt(tmp2[0]);
					n2 = Integer.parseInt(tmp2[1]);
					if (n1 == m.getI(i_index) || n2 == l_index) {
						// System.out.println("n1 : " + n1 + " n2 : " + n2);
						verdict = true;
						break;
					}
				}
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return verdict;
	}
}

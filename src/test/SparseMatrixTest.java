package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import datastructure.SparseMatrix;

public class SparseMatrixTest {

	@Test
	public void testSparseMatrixFromArray() {
		float[][] m = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 0 },
				{ (float) 0.5, 0, (float) 1 / 2, 0, 0 },
				{ (float) 1 / 3, (float) 1 / 3, 0, 0, (float) 1 / 3 },
				{ 0, 1, 0, 0, 0 } };
		SparseMatrix sm = new SparseMatrix(m, 8);

		System.out.println(sm);
	}

	@Test
	public void testMultiplyWithVector() {
		float[] C = { 1, 1, (float) 0.5, (float) 0.5, (float) 1 / 3,
				(float) 1 / 3, (float) 1 / 3, 1 };
		int[] L = { 0, 1, 2, 4, 7, 8 };
		int[] I = { 2, 3, 0, 2, 0, 1, 4, 1 };

		SparseMatrix M = new SparseMatrix(5, 8);
		int[] v = { 10, 0, 3, -1, 5 };

		M.setC(C);
		M.setL(L);
		M.setI(I);

		float[] result = M.MultiplyWithVector(v);
		float[] expected = { 3, -1, (float) 6.5, 5, 0 };

		assertEquals(expected.length, result.length);

		for (int i = 0; i < result.length; i++) {
			assertTrue(expected[i] == result[i]);
		}

	}

	@Test
	public void testMultiplyTransposeWithVector() {
		float[] C = { 1 / 2, 1 / 3, 1 / 3, 1, 1, 1 / 2, 1, 1 / 3 };
		int[] L = { 0, 2, 4, 6, 7, 8 };
		int[] I = { 2, 3, 3, 4, 0, 2, 1, 3 };

		SparseMatrix M = new SparseMatrix(5, 8);
		int[] v = { 10, 0, 3, -1, 5 };

		M.setC(C);
		M.setL(L);
		M.setI(I);

		float[] result = M.MultiplyWithVector(v);
		float[] expected = { 0, 5, 10, 0, 0 };

		assertEquals(expected.length, result.length);

		for (int i = 0; i < result.length; i++) {
			assertTrue(expected[i] == result[i]);
		}

	}

}

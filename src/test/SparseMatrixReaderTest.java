package test;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure.SparseMatrixReader;

public class SparseMatrixReaderTest {

	@Test
	public void testDummyExemple() {
		SparseMatrixReader r = new SparseMatrixReader("data/exemple.data", 5, 8);
		// r.matrix.printMatrix();

		// System.out.println("########################");
	}

	@Test
	public void testP2PGnutella() {
		SparseMatrixReader s = new SparseMatrixReader(
				"data/p2p-Gnutella04.data", 10876, 39994);
		s.matrix.printMatrix();

		/*
		 * TODO 1. je prends par hasard un indice du tableau C 2. calculer gr�ce
		 * a L et I � quel arc �a correspond 3. v�rifier dans le fichier que
		 * l'arc existe bien.
		 */

	}

}

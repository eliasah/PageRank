package test;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure.SparseMatrixReader;

public class SparseMatrixReaderTest {

	@Test
	public void test() {
		SparseMatrixReader r = new SparseMatrixReader("data/exemple.data", 5,8);
		r.matrix.printMatrix();
		
		System.out.println("########################");
	}

}

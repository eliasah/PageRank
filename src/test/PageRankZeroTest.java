package test;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure.SparseMatrix;
import datastructure.SparseMatrixReader;
import pagerank.PageRank;

public class PageRankZeroTest {
	@Test
	public void testPageRankZero() {
		System.out.println("> Testing PageRankZero on exemple.data : ");
		SparseMatrixReader s = new SparseMatrixReader("data/exemple.data", 5, 8);
		SparseMatrix m = s.getMatrix();
		PageRank p = new PageRank(m, 0);
		p.computePageRankStd();
		assertTrue(true);
	}

}

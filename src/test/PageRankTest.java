package test;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure.SparseMatrix;
import datastructure.SparseMatrixReader;
import pagerank.PageRank;

public class PageRankTest {
	SparseMatrixReader s = new SparseMatrixReader("data/p2p-Gnutella04.data",
			10878, 39994);
	SparseMatrix m = s.getMatrix();

	@Test
	public void testPageRankZero() {
		System.out.println("> Testing PageRankZero on p2p-Gnutella04.data : ");

		PageRank p = new PageRank(m, 4);

		p.computePageRankZero(20);
		float res = p.getPageRank(0);

		System.out.println("PageRankZero : La probabilité d'être sur 0 est de "
				+ res);

		assertTrue(true);
	}

	@Test
	public void testPageRankStd() {
		System.out.println("> Testing PageRankStd on p2p-Gnutella04.data : ");
		PageRank p = new PageRank(m, 0.0001f);
		p.computePageRankStd();
		float res = p.getPageRank(4);

		System.out.println("PageRankStd : La probabilité d'être sur 4 est de "
				+ res);

		assertTrue(true);
	}

	@Test
	public void testPageRankWithPace() {
		System.out
				.println("> Testing PageRankWithPace on p2p-Gnutella04.data : ");
		PageRank p = new PageRank(m, 0);
		p.computePageRank(0, 100);

		float res = p.getPageRank(0);
		System.out
				.println("PageRank with pace 100 : La probabilité d'être sur 0 est de "
						+ res);
		assertTrue(true);

	}

}

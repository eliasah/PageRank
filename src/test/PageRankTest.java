package test;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure.SparseMatrix;
import datastructure.GraphReader;
import pagerank.PageRank;

public class PageRankTest {
	GraphReader s = new GraphReader("data/p2p-Gnutella05.data",
			8846, 31839);
	SparseMatrix m = s.getGraph();

	@Test
	public void testPageRankZero() {
		System.out.println("> Testing PageRankZero on p2p-Gnutella04.data : ");

		PageRank p = new PageRank(m, 0);
		p.setVerbose(true);
		p.computePageRankZero(1, 20);
		float res = p.getPageRank(0);

		System.out.println("PageRankZero : La probabilité d'être sur 0 est de "
				+ res);

		assertTrue(true);
	}

	@Test
	public void testPageRankStd() {
		System.out.println("> Testing PageRankStd on p2p-Gnutella04.data : ");
		PageRank p = new PageRank(m, 0.005f);
		// p.setVerbose(true);
		p.computePageRankStd();
		float res = p.getPageRank(0);

		System.out.println("PageRankStd : La probabilité d'être sur 0 est de "
				+ res);

		assertTrue(true);
	}

	@Test
	public void testPageRankWithPace() {
		System.out
				.println("> Testing PageRankWithPace on p2p-Gnutella04.data : ");
		PageRank p = new PageRank(m, 0);
		// p.setVerbose(true);
		p.computePageRank(0, 100);

		float res = p.getPageRank(0);
		System.out
				.println("PageRank with pace 100 : La probabilité d'être sur 0 est de "
						+ res);
		assertTrue(true);

	}
}

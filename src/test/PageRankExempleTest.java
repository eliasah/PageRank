package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pagerank.PageRank;
import datastructure.Graph;
import datastructure.GraphReader;

public class PageRankExempleTest {

	String file = "data/p2p-Gnutella09.data";
	int n = 8114;
	int m = 26013;
	GraphReader r = new GraphReader(file, n, m);
	Graph g = r.getGraph();
	PageRank p;

	@Test
	public void testPageRankStd() {
		p = new PageRank(g);
		// p.setVerbose(true);
		System.out.println("> Test PageRankStd on " + file);
		p.computePageRank(1000);
		assertTrue(true);
	}

	public void testPageRankZero() {
		for (int i = 0; i < n; i++) {
			p = new PageRank(g);
			// p.setVerbose(true);
			// System.out.println("> Test PageRankZero on " + file
			// + "a partir de " + i);
			p.computePageRankZero(i, 1000);
			assertTrue(true);
		}
	}

	@Test
	public void testPageRank() {
		p = new PageRank(g);
		// p.setVerbose(true);
		System.out.println("> Test PageRank on " + file);
		p.computePageRank(1000);
		assertTrue(true);
	}

	@Test
	public void testPageRankWithZapFactor() {
		p = new PageRank(g);
		// p.setVerbose(true);
		System.out.println("> Test PageRank with Zap Factor on " + file);
		p.computePageRankWithZap(0.11f, 10000);
		assertTrue(true);
	}
}

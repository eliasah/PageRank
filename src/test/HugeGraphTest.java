package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pagerank.PageRank;
import datastructure.Graph;
import datastructure.GraphReader;

public class HugeGraphTest {
	String file = "data/wiki-Talk.data";
	int n = 2394385;
	int m = 5021410;
	GraphReader r = new GraphReader(file, n, m);
	Graph g = r.getGraph();
	PageRank p;

	@Before
	public void setUp() {
		p = new PageRank(g);
		// p.setVerbose(true);
	}

	public void testHugeGraph() {
		System.out.println("> Test on " + file);
		p.computePageRank(200);
		assertTrue(true);
	}

	@Test
	public void testHugeGraphWithZap011() {
		System.out.println("> Test on " + file + " with Zap factor d = 0.11");
		p.computePageRankWithZap(0.11F, 200);
		assertTrue(true);
	}

	@Test
	public void testHugeGraphWithZap012() {
		System.out.println("> Test on " + file + " with Zap factor d = 0.12");
		p.computePageRankWithZap(0.13F, 200);
		assertTrue(true);
	}

	@Test
	public void testHugeGraphWithZap013() {
		System.out.println("> Test on " + file + " with Zap factor d = 0.13");
		p.computePageRankWithZap(0.13F, 200);
		assertTrue(true);
	}

	@Test
	public void testHugeGraphWithZap014() {
		System.out.println("> Test on " + file + " with Zap factor d = 0.14");
		p.computePageRankWithZap(0.14F, 200);
		assertTrue(true);
	}

	@Test
	public void testHugeGraphWithZap015() {
		System.out.println("> Test on " + file + " with Zap factor d = 0.15");
		p.computePageRankWithZap(0.15F, 200);
		assertTrue(true);
	}

	@Test
	public void testHugeGraphWithZap016() {
		System.out.println("> Test on " + file + " with Zap factor d = 0.16");
		p.computePageRankWithZap(0.16F, 200);
		assertTrue(true);
	}

	@Test
	public void testHugeGraphWithZap017() {
		System.out.println("> Test on " + file + " with Zap factor d = 0.17");
		p.computePageRankWithZap(0.17F, 200);
		assertTrue(true);
	}

	@Test
	public void testHugeGraphWithZap018() {
		System.out.println("> Test on " + file + " with Zap factor d = 0.18");
		p.computePageRankWithZap(0.18F, 200);
		assertTrue(true);
	}

	@Test
	public void testHugeGraphWithZap019() {
		System.out.println("> Test on " + file + " with Zap factor d = 0.19");
		p.computePageRankWithZap(0.19F, 200);
		assertTrue(true);
	}

}

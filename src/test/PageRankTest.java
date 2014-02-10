package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pagerank.PageRank;
import datastructure.Graph;
import datastructure.GraphReader;

public class PageRankTest {

	@Test
	public void testGraphWithWell1() {
		GraphReader r = new GraphReader("data/exemple2.data", 3, 3);
		Graph g = r.getGraph();

		System.out
				.println("> Testing PageRank on a graph with a well (exemple2)");
		PageRank p = new PageRank(g, 0.001f);
		// p.setVerbose(true);
		p.computePageRank(0, 1000);

		assertTrue(true);
	}

	@Test
	public void testGraphWithWell2() {
		GraphReader r = new GraphReader("data/exemple3.data", 3, 4);
		Graph g = r.getGraph();
		System.out
				.println("> Testing PageRank on a graph with a well (exemple3)");
		PageRank p = new PageRank(g, 0.00001f);
		// p.setVerbose(true);
		p.computePageRank(0, 1000);
		assertTrue(true);
	}

	@Test
	public void testGraphWithCircuit() {
		GraphReader r = new GraphReader("data/exemple4.data", 4, 5);
		Graph g = r.getGraph();

		System.out
				.println("> Testing PageRank on a graph with a well (exemple4)");
		PageRank p = new PageRank(g);
		// p.setVerbose(true);
		p.computePageRank(0, 1000);
		assertTrue(true);
	}

	@Test
	public void testDefaultGraph() {
		GraphReader r = new GraphReader("data/exemple5.data", 5, 8);
		Graph g = r.getGraph();

		System.out.println("> Testing PageRank on a default graph (exemple5)");
		PageRank p = new PageRank(g);
		// p.setVerbose(true);
		p.computePageRank(1, 1000);
		assertTrue(true);
	}

	@Test
	public void testSymetricGraph() {
		GraphReader r = new GraphReader("data/exemple6.data", 3, 6);
		Graph g = r.getGraph();

		System.out.println("> Testing PageRank on a symetric graph (exemple6)");
		PageRank p = new PageRank(g);
		// p.setVerbose(true);
		p.computePageRank(0, 1000);
		assertTrue(true);
	}

	@Test
	public void testGraphWithCycle() {
		GraphReader r = new GraphReader("data/exemple7.data", 3, 4);
		Graph g = r.getGraph();

		System.out
				.println("> Testing PageRank on a graph with cycle (exemple7)");
		PageRank p = new PageRank(g);
		p.setVerbose(true);
		p.computePageRank(0, 6);
		assertTrue(true);
	}

	@Test
	public void testStarGraph() {
		GraphReader r = new GraphReader("data/star.data", 5, 8);
		Graph g = r.getGraph();

		System.out.println("> Testing PageRank on a star graph (star.data)");
		PageRank p = new PageRank(g);
		p.setVerbose(true);
		p.computePageRank(0, 6);
		assertTrue(true);
	}

	@Test
	public void testPageRankZero() {
		GraphReader s = new GraphReader("data/p2p-Gnutella04.data", 10878,
				39994);
		Graph g = s.getGraph();

		System.out.println("> Testing PageRankZero on p2p-Gnutella04.data : ");

		PageRank p = new PageRank(g, 0);
		// p.setVerbose(true);
		p.computePageRankZero(1, 20);
		float res = p.getPageRank(0);

		System.out.println("PageRankZero : La probabilitŽ d'tre sur 0 est de "
				+ res);

		assertTrue(true);
	}

	@Test
	public void testPageRankStd() {
		GraphReader s = new GraphReader("data/p2p-Gnutella04.data", 10878,
				39994);
		Graph g = s.getGraph();
		System.out.println("> Testing PageRankStd on p2p-Gnutella04.data : ");
		PageRank p = new PageRank(g, 0.005f);
		// p.setVerbose(true);
		p.computePageRankStd();
		float res = p.getPageRank(0);

		System.out.println("PageRankStd : La probabilitŽ d'tre sur 0 est de "
				+ res);

		assertTrue(true);
	}

	@Test
	public void testPageRankWithPace() {
		GraphReader s = new GraphReader("data/p2p-Gnutella04.data", 10878,
				39994);
		Graph g = s.getGraph();
		System.out
				.println("> Testing PageRankWithPace on p2p-Gnutella04.data : ");
		PageRank p = new PageRank(g, 0);
		// p.setVerbose(true);
		p.computePageRank(0, 10000);

		float res = p.getPageRank(0);
		System.out
				.println("PageRank with pace 100 : La probabilitŽ d'tre sur 0 est de "
						+ res);
		assertTrue(true);

	}

	@Test
	public void testPageRankGnutella05() {
		GraphReader r = new GraphReader("data/p2p-Gnutella05.data", 8846, 31839);
		Graph g = r.getGraph();
		System.out
				.println("> Testing PageRank with pace on p2p-Gnutella05.data : ");
		PageRank p = new PageRank(g);
		// p.setVerbose(true);
		p.computePageRank(0, 10000);
		assertTrue(true);
	}

	@Test
	public void testPageRankGnutella06() {
		GraphReader r = new GraphReader("data/p2p-Gnutella06.data", 8717, 31525);
		Graph g = r.getGraph();
		System.out
				.println("> Testing PageRank with pace on p2p-Gnutella06.data : ");
		PageRank p = new PageRank(g);
		// p.setVerbose(true);
		p.computePageRank(0, 10000);
		assertTrue(true);
	}

	@Test
	public void testPageRankGnutella08() {
		GraphReader r = new GraphReader("data/p2p-Gnutella08.data", 6301, 20777);
		Graph g = r.getGraph();
		System.out
				.println("> Testing PageRank with pace on p2p-Gnutella08.data : ");
		PageRank p = new PageRank(g);
		// p.setVerbose(true);
		p.computePageRank(0, 10000);
		assertTrue(true);
	}

	@Test
	public void testPageRankGnutella09() {
		GraphReader r = new GraphReader("data/p2p-Gnutella09.data", 8114, 26013);
		Graph g = r.getGraph();
		System.out
				.println("> Testing PageRank with pace on p2p-Gnutella09.data : ");
		PageRank p = new PageRank(g);
		// p.setVerbose(true);
		p.computePageRank(0, 10000);
		assertTrue(true);
	}

	@Test
	public void testPageRankGnutella24() {
		GraphReader r = new GraphReader("data/p2p-Gnutella24.data", 26518,
				65369);
		Graph g = r.getGraph();
		System.out
				.println("> Testing PageRank with pace on p2p-Gnutella24.data : ");
		PageRank p = new PageRank(g);
		// p.setVerbose(true);
		p.computePageRank(0, 10000);
		assertTrue(true);
	}

	@Test
	public void testPageRankGnutella25() {
		GraphReader r = new GraphReader("data/p2p-Gnutella25.data", 22687,
				54705);
		Graph g = r.getGraph();
		System.out
				.println("> Testing PageRank with pace on p2p-Gnutella25.data : ");
		PageRank p = new PageRank(g);
		// p.setVerbose(true);
		p.computePageRank(0, 10000);
		assertTrue(true);
	}

	@Test
	public void testPageRankGnutella30() {
		GraphReader r = new GraphReader("data/p2p-Gnutella30.data", 36682,
				88328);
		Graph g = r.getGraph();
		System.out
				.println("> Testing PageRank with pace on p2p-Gnutella30.data : ");
		PageRank p = new PageRank(g);
		// p.setVerbose(true);
		p.computePageRank(0, 10000);
		assertTrue(true);
	}

	@Test
	public void testPageRankGnutella31() {
		GraphReader r = new GraphReader("data/p2p-Gnutella31.data", 62586,
				147892);
		Graph g = r.getGraph();
		System.out
				.println("> Testing PageRank with pace on p2p-Gnutella31.data : ");
		PageRank p = new PageRank(g);
		// p.setVerbose(true);
		p.computePageRank(0, 10000);
		assertTrue(true);
	}

}

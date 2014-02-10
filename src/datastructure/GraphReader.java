package datastructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphReader {

	private Graph g;
	private int m, n;
	private String file;

	public GraphReader(String f, int n, int m) {
		this.file = f;
		this.n = n;
		this.m = m;
		read();
	}

	private void read() {
		BufferedReader br = null;
		String sCurrentLine;
		int n1, n2, s = 0, i = 0, j = 0, deg = 0;

		this.g = new Graph(this.n, this.m);

		g.setL(0,0);

		try {
			br = new BufferedReader(new FileReader(file));

			while ((sCurrentLine = br.readLine()) != null) {
				String[] tmp = sCurrentLine.split("\\s+");
				if (sCurrentLine.startsWith("#")) {
					continue;
				} else {
					n1 = Integer.parseInt(tmp[0]);
					n2 = Integer.parseInt(tmp[1]);
					g.setI(j, n2);
					j++;
					if (s != n1 - 1) {
						s = n1 - 1;
						g.setL(i, j - 1);
						i++;
					}

				}
			}
			g.setL(n, j);

			j = 0;
			for (i = 0; i < g.getC().length; i++) {
				// if (j == matrix.L.length -1 ) break;
				while (i >= g.getL(j + 1))
					j++;

				deg = g.getL(j + 1) - g.getL(j);
				g.setC(i, (float) 1 / deg);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Graph getGraph() {
		return g;
	}
}

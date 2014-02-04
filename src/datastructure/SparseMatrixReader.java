package datastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import datastructure.SparseMatrix;

public class SparseMatrixReader {

	public SparseMatrix matrix;
	private int m, n;
	private String file;

	public SparseMatrixReader(String f, int n, int m) {
		this.file = f;
		this.n = n;
		this.m = m;
		read();
	}

	private void read() {
		BufferedReader br = null;
		String sCurrentLine;
		int n1, n2, s = 0, i = 0, j = 0, k = 0, deg = 0;

		this.matrix = new SparseMatrix(this.n, this.m);
		matrix.C = new float[m];
		matrix.L = new int[n + 1];
		matrix.I = new int[m];

		matrix.L[0] = 0;

		try {
			br = new BufferedReader(new FileReader(file));

			while ((sCurrentLine = br.readLine()) != null) {
				String[] tmp = sCurrentLine.split("\\s+");
				if (sCurrentLine.startsWith("#")) {
					continue;
				} else {
					n1 = Integer.parseInt(tmp[0]);
					n2 = Integer.parseInt(tmp[1]);
					matrix.I[j] = n2 - 1;
					j++;
					if (s != n1 - 1) {
						s = n1 - 1;
						matrix.L[i + 1] = j - 1;
						i++;
					}

				}
			}
			matrix.L[n] = j;
			j = 0;
			for (i = 0; i < matrix.C.length; i++) {
				// if (j == matrix.L.length -1 ) break;
				while (i >= matrix.L[j + 1])
					j++;

				deg = matrix.L[j + 1] - matrix.L[j];
				matrix.setC(i, (float) 1 / deg);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import datastructure.SparseMatrix;

/**
 * Class Reader is more like a helper to read text files and records it's
 * content into a string vector breaking on each end of line
 * 
 * @author Abou Haydar Elias - Université Paris Diderot
 * 
 */
public class Reader {

	// Content vector
	private SparseMatrix matrix;
	private int m, n;
	private ArrayList<Integer> vect;
	private String file;
	@SuppressWarnings("unused")
	private String workingdir;

	public Reader() {
		vect = new ArrayList<Integer>();
	}

	/**
	 * Constructor of Reader.
	 * 
	 * @param f
	 */
	public Reader(String f) {

		this.vect = new ArrayList<Integer>();
		this.file = f;
		this.workingdir = "";
		this.n = 0;
		this.m = 0;
	}

	private void computeDregrees() {

	}

	private void countEdgesAndNodes() {
		BufferedReader br = null;

		String sCurrentLine;
		int n1, n2;
		try {
			br = new BufferedReader(new FileReader(file));

			while ((sCurrentLine = br.readLine()) != null) {
				String[] tmp = sCurrentLine.split("\\s+");
				if (sCurrentLine.startsWith("#")) {
					// System.out.println("reading comment");
					continue;
				} else {
					this.m++;
					// System.out.println("reading line " + sCurrentLine);
					n1 = Integer.parseInt(tmp[0]);
					n2 = Integer.parseInt(tmp[1]);

					if (!this.vect.contains(n1))
						this.vect.add(n1);
					if (!this.vect.contains(n2))
						this.vect.add(n2);
				}
			}

			br.close();
		} catch (IOException e) {
			// System.err.println("File is a directory");
			e.printStackTrace();
		}
		this.n = vect.size();
		System.out.println("egdes = " + this.m);
		System.out.println("nodes = " + this.n);
	}

	/**
	 * Read file to parse
	 * 
	 */
	public void read() {
		countEdgesAndNodes();
		this.matrix = new SparseMatrix(this.n, this.m);
		// this.matrix.printMatrix();
	}

	/**
	 * Returns content of reader
	 * 
	 * @return vector of string used to record contents
	 */
	public ArrayList<Integer> getContent() {
		return vect;
	}

	@Override
	public String toString() {
		return "Reader [vect=" + vect + "]";
	}

	/**
	 * Read content of directory and record the ones containing the filter
	 * 
	 * @param s
	 *            filter
	 * @return list of files with name contains the string s
	 */
	public ArrayList<String> listFilesForFolder(String s) {
		ArrayList<String> res = new ArrayList<String>();
		File f = new File(file);
		workingdir = f.getName();
		for (final File fileEntry : f.listFiles()) {
			if (fileEntry.isDirectory()) {
				System.out.println(fileEntry + "directory skipped");
			} else {
				// System.out.println(fileEntry.getName());
				if (fileEntry.getName().contains(s))
					res.add(f.getName() + "/" + fileEntry.getName());
			}
		}
		// System.out.println(res.toString());
		return res;
	}

}

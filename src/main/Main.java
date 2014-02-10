package main;

import java.util.Scanner;

import pagerank.PageRank;
import datastructure.Graph;
import datastructure.GraphReader;

/**
 * @author Abou Haydar Elias <abouhaydar.elias@gmail.com> , Ben Hadj Ali
 *         <benelhadj-ali@hotmail.fr>
 * 
 */
public class Main {

	public static void main(String[] args) {

		int n, m, opt;
		float epsilon;
		String file;

		Scanner in = new Scanner(System.in);

		System.out.println("Entrer le nom d'un fichier de graphe en entrŽe :");
		file = in.nextLine();
		System.out.println("nom du fichier = " + file);

		System.out.println("Entrer le nombre de noeuds du graphe :");
		n = in.nextInt();

		System.out.println("Entrer le nombre de liens du graphe :");
		m = in.nextInt();

		System.out.println("Entrer la valeur d'epsilon :");
		epsilon = in.nextFloat();
		System.out.println("epsilon = " + epsilon);

		System.out.println("Selectionner le type de PageRank");
		System.out.println("1. PageRank Std");
		System.out.println("2. PageRank Zero");
		System.out.println("3. PageRank avec pas");
		System.out.println("4. PageRank avec facteur Zap");
		opt = in.nextInt();
		switch (opt) {
		case 1:
			pageRankStd(file, n, m, epsilon);
			break;
		case 2:
			pageRankZero(file, n, m, epsilon);
			break;
		case 3:
			pageRankZeroWithPace(file, n, m, epsilon);
			break;
		case 4:
			pageRankWithZapFactor(file, n, m, epsilon);
		case -1:
			System.exit(0);
		default:
			System.err
					.println("Il faut choisir un nombre entre 1 et 4 (-1 pour sortir)");
			System.exit(-1);
		}
		System.exit(1);
	}

	private static void pageRankStd(String file, int n, int m, float epsilon) {
		GraphReader s = new GraphReader(file, n, m);
		Graph g = s.getGraph();

		System.out.println("> PageRankStd on " + file + " : ");

		PageRank p = new PageRank(g, epsilon);
		p.setVerbose(true);
		p.computePageRankStd();
	}

	private static void pageRankZero(String file, int n, int m, float epsilon) {
		GraphReader s = new GraphReader(file, n, m);
		Graph g = s.getGraph();

		Scanner in = new Scanner(System.in);
		System.out.println("Entrer le numero de noeud de dŽpart :");
		int start = in.nextInt();
		System.out.println("Entrer le nombre de pas :");
		int nbPas = in.nextInt();

		System.out.println("> PageRankZero on " + file + " : ");
		PageRank p = new PageRank(g, epsilon);
		p.setVerbose(true);
		p.computePageRankZero(start, nbPas);

	}

	private static void pageRankZeroWithPace(String file, int n, int m,
			float epsilon) {
		GraphReader s = new GraphReader(file, n, m);
		Graph g = s.getGraph();

		Scanner in = new Scanner(System.in);
		System.out.println("Entrer le numero de noeud de dŽpart :");
		int start = in.nextInt();
		System.out.println("Entrer le nombre de pas :");
		int nbPas = in.nextInt();

		System.out.println("> PageRankZero on " + file + " : ");
		PageRank p = new PageRank(g, epsilon);
		p.setVerbose(true);
		p.computePageRank(start, nbPas);
	}

	private static void pageRankWithZapFactor(String file, int n, int m,
			float epsilon) {
		GraphReader s = new GraphReader(file, n, m);
		Graph g = s.getGraph();

		Scanner in = new Scanner(System.in);
		System.out.println("Entrer le numero de noeud de dŽpart :");
		int start = in.nextInt();
		System.out.println("Entrer le nombre de pas :");
		int nbPas = in.nextInt();
		System.out.println("Entrer le facteur Zap entre 0.1 et 0.2");
		float zap = in.nextFloat();

		System.out.println("> PageRankZero on " + file + " : ");
		PageRank p = new PageRank(g, epsilon);
		p.setVerbose(true);
		p.computePageRankWithZap(start, zap, nbPas);
	}
}

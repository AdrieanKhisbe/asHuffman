package tools;

import huffmanTree.AHA;

import java.io.IOException;
import java.io.PrintWriter;

public class Dot {

	// TODO Méthod pour générer automatiquement le dot si possible

	public static void generateArbreGraph(AHA arbre) throws IOException {
		generateArbreGraph("aha", arbre);
	}

	public static void generateArbreGraph(String filename, AHA arbre)
			throws IOException {

		System.out.println("Génération d'un fichier dot");
		generateDotFile(filename + ".dot", arbre);

		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec("which dot"); // Bonux: put up static
		
		try {
			pr.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		// test si peut lancer Dot
		if (pr.exitValue() == 0) {
			System.out.print("Génération du Graphe au format Png... ");
			pr = rt.exec("dot -o " + filename + ".png -Tpng " + filename
					+ ".dot");
			try {
				pr.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
			
			System.out.println("Done");

		} else {
			System.err.println("Le graphe ne peut etre générer, dot n'étant pas installé sur cette machine");
		}

		//
	}

	public static void generateDotFile(String filename, AHA arbre)
			throws IOException {
		PrintWriter pw = new PrintWriter(filename, "UTF-8");
		pw.print(arbre.toDot());
		pw.close();

	}

}

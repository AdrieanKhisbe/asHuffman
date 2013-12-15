package tools;

import huffmanTree.AHA;

import java.io.IOException;
import java.io.PrintWriter;

public class Dot {

	private static boolean dotProgram = false;

	// Establish whether dot is installed on the machine or not
	static {
		try {
			Runtime rt = Runtime.getRuntime();
			Process pr = rt.exec("which dot"); // Bonux: put up static

			pr.waitFor();
			dotProgram = (pr.exitValue() == 0);

			if (!dotProgram) {
				System.err
						.println("Les graphes ne pourront être générés, dot(graphviz) n'étant pas installé sur cette machine");
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (IOException e) {
			// causé par erreur du processus (windows.
			e.printStackTrace();
			System.err
					.println("Les graphes ne pourront être générés (not Unix OS)");
		}

	}

	
	public static void generateArbreGraph(AHA arbre) throws IOException {
		generateArbreGraph("aha", arbre);
	}

	public static void generateArbreGraph(String filename, AHA arbre)
			throws IOException {

		String dotname = filename + ".dot";

		System.out.println("Génération d'un fichier dot " + dotname);
		generateDotFile(dotname, arbre);

		// test si peut lancer Dot
		if (dotProgram) {
			System.out.print("Génération du Graphe au format Png... ");
			Process pr = Runtime.getRuntime().exec(
					"dot -o " + filename + ".png -Tpng " + dotname);
			try {
				pr.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}

			System.out.println("Done");

		}

	}

	public static void generateDotFile(String filename, AHA arbre)
			throws IOException {
		PrintWriter pw = new PrintWriter(filename, "UTF-8");
		pw.print(arbre.toDot());
		pw.close();

	}

}

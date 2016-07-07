import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Cours pour apprendre à lire un fichier, et à écrire dans un fichier.
 * 
 * @author Maxime BLAISE
 *
 */
public class EntreeSortie {

	/**
	 * Fichier à lire.
	 */
	public static String fichierEntree = "file/entree.txt";

	/**
	 * Fichier dans lequel on va écrire.
	 */
	public static String fichierSortie = "file/sortie.txt";

	/**
	 * Méthode principale, lance le cours d'apprentissage et un exercice.
	 * 
	 * @param args
	 *            Argument du programme (on en a pas ici)
	 */
	public static void main(String[] args) {
		// Lecture d'un fichier
		// lireLeFichier(fichierEntree);

		// Ecriture dans un fichier
		// ecrireDansUnFichier(fichierSortie, "Bonjour\nJe suis là.", false);

		// Ecrire progressive dans un fichier
		ecrireDansUnFichier(fichierSortie);
	}

	/**
	 * Méthode qui permet d'écrire progressivement dans un fichier.
	 * 
	 * @param nomDuFichier
	 *            Nom du fichier dans lequel on va écrire
	 */
	public static void ecrireDansUnFichier(String nomDuFichier) {
		Scanner sc = new Scanner(System.in);
		String message = "";
		do {
			System.out.print("Que souhaites-tu écrire dans le fichier ? => ");
			message = sc.nextLine();
			if (!message.trim().equalsIgnoreCase("exit")) {
				ecrireDansUnFichier(nomDuFichier, message + "\n", true);
			}
		} while (!message.equals("exit"));
		// On arrête d'écrire dans le fichier
		sc.close();
		System.out.println("*** OK, J'arrête d'écrire dans le fichier ***");
	}

	/**
	 * Méthode qui permet d'écrire dans le fichier de sortie.
	 * 
	 * @param nomDuFichier
	 *            Nom du fichier dans lequel on va écrire
	 * @param texte
	 *            Texte que l'on va écrire dans ce fichier
	 */
	public static void ecrireDansUnFichier(String nomDuFichier, String texte, boolean append) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(nomDuFichier, append));
			bw.append(texte);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Méthode qui permet de lire le fichier d'entrée, et d'afficher son contenu
	 * à l'écran.
	 * 
	 * @param nomDuFichier
	 *            Le nom du fichier que l'on souhaite lire.
	 */
	public static void lireLeFichier(String nomDuFichier) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(nomDuFichier));
			System.out.println("*** JE COMMENCE A LIRE ***");
			// Tant qu'on n'accède pas à la fin du document, on continue
			while (br.ready()) {
				// On récupère la ligne suivante du fichier
				String ligne = br.readLine();
				// On affiche cette ligne à l'écran
				System.out.println(ligne);
			}
			System.out.println("*** J'AI TERMINE DE LIRE ***");
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Oh non, je n'ai pas trouvé le fichier " + nomDuFichier);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

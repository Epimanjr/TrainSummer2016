import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
	 * Fichier d'entrée pour l'exercice
	 */
	public static String fichierEntreeExercice = "file/entree_exercice.txt";

	/**
	 * Fichier de sortie pour l'exercice
	 */
	public static String fichierSortieExercice = "file/sortie_exercice.txt";

	/**
	 * Fichier de sortie pour la correction
	 */
	public static String fichierCorrection = "file/correction.txt";

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
		// ecrireDansUnFichier(fichierSortie);

		exercice();
		correctionExercice();

		boolean juste = compareDeuxFichiers(fichierCorrection, fichierSortieExercice);
		String resultat = (juste) ? "Bravo, tu as réussi l'exercice ! " : "Oh non, tu n'as pas réussi :'(";
		System.out.println(resultat);
	}

	/**
	 * Le but de l'exercice est de lire le fichier 'fichierEntreeExercice'. Il
	 * contient quelques adresses mails mais très mal écrites ... l'objectif ici
	 * est de supprimer les espaces, les saut de lignes inutiles et tout mettre
	 * en minuscule. On souhaite avoir un nouveau fichier contenant les adresses
	 * mails mais en respectant l'objectif.
	 */
	public static void exercice() {
		// TODO Exercice sur les flux IO et chaîne de caractères
		
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
			// On récupère une saisie au clavier
			System.out.print("Que souhaites-tu écrire dans le fichier ? => ");
			message = sc.nextLine();
			// Si ce n'est pas exit, alors on écrit dans le fichier
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

	/**
	 * Méthode qui compare deux fichier.
	 * 
	 * @param fichier1
	 *            Nom du premier fichier
	 * @param fichier2
	 *            Nom du deuxième fichier
	 * @return Retourne vrai si les deux fichiers sont identiques (en termes de
	 *         contenu). Faux sinon.
	 */
	public static boolean compareDeuxFichiers(String fichier1, String fichier2) {
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		try {
			BufferedReader br1 = new BufferedReader(new FileReader(fichier1));
			while (br1.ready()) {
				list1.add(br1.readLine());
			}
			br1.close();

			BufferedReader br2 = new BufferedReader(new FileReader(fichier2));
			while (br2.ready()) {
				list2.add(br2.readLine());
			}
			br2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Si les deux listes ont une taille différente.
		if (list1.size() != list2.size()) {
			return false;
		}

		// On parcourt chaque ligne du fichier
		// Dès qu'on voit deux lignes différentes, alors on arrête
		for (int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}

		// Si on arrive ici, c'est que les deux fichiers sont identiques
		return true;
	}

	/**
	 * Correction de l'exercice, lit le fichier en entrée et génère le bon
	 * fichier en sortie.
	 */
	public static void correctionExercice() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fichierEntreeExercice));
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichierCorrection));

			while (br.ready()) {
				String line = br.readLine().trim().toLowerCase();
				if (!line.equals("")) {
					bw.append(line + "\n");
				}
			}

			bw.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

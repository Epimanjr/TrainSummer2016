import model.Personne;

/**
 * Rassemblement des différentes méthodes disponibles pour la manipulation des
 * chaînes de caractères (String).
 * 
 * @author Maxime BLAISE
 */
public class StringManipulation {

	/**
	 * Chaînes de caractères sur lesquelles on va s'entraîner.
	 */
	public static String chaineAManipuler = "Bonjour chérie";
	public static String chaineAvecEspaces = "  Salut  ";

	/**
	 * Méthode principale du programme. Elle est appelée quand on lance le
	 * programme.
	 * 
	 * @param args
	 *            Argument du programme (on en a pas ici)
	 */
	public static void main(String[] args) {
		// Petit cours
		cours();
		// Exercice
		System.out.println("Partie EXERCICE : ");
		System.out.println("------------------");
		String chainePourExercice = " Maxime Blaise  ";
		Personne personne = exercice(chainePourExercice);
		System.out.println("Personne générée  : " + personne);
		// Correction de l'exercice
		Personne correction = correction(chainePourExercice);
		System.out.println("Personne attendue : " + correction);
		boolean juste = correction.equals(personne);
		String resultat = (juste) ? "Bravo, tu as réussi l'exercice ! " : "Oh non, tu n'as pas réussi :'(";
		System.out.println(resultat);
	}

	/**
	 * Exercice : on a en paramètre une chaîne de caractères contenant le prénom
	 * et le nom. Le but est de distinguer le nom du prénom, et de créer une
	 * instance de l'objet Personne à partir du nom et du prénom.
	 */
	public static Personne exercice(String chainePourExercice) {
		// TODO Exercice sur les chaînes de caractères
		return null;
	}

	/**
	 * Quelques exemples de code pour manipuler des chaînes de caractères.
	 */
	public static void cours() {
		System.out.println("Partie COURS : ");
		System.out.println("---------------");

		// Avant toute manipulation, il faut créer un objet StringBuilder
		StringBuilder builder = new StringBuilder(chaineAManipuler);

		// Inversion de la chaîne
		System.out.println("Chaîne inversée : " + builder.reverse());

		// Grâce à cette invertion, on peut voir si c'est un palindrome
		if (builder.toString().equals(builder.reverse().toString())) {
			System.out.println(chaineAManipuler + " est un palindrome.");
		} else {
			System.out.println(chaineAManipuler + " n'est pas un palindrome.");
		}

		// Pour supprimer les espaces inutiles
		String chaineSansEspace = chaineAvecEspaces.trim();
		System.out.println("'" + chaineAvecEspaces + "' sans espace, ça donne '" + chaineSansEspace + "'");

		// Couper la chaîne en deux, par exemple avec l'espace
		String[] chaines = chaineAManipuler.split(" ");
		System.out.println("La chaîne '" + chaineAManipuler + "' coupé en deux avec l'espace, ça donne : ");
		System.out.println("\tChaîne 1 : " + chaines[0]);
		System.out.println("\tChaîne 2 : " + chaines[1]);

		// Savoir si la chaîne commence par ...
		boolean bBegin = chaineSansEspace.startsWith("Sa");
		System.out.println("La chaîne '" + chaineSansEspace + "' débute-t-elle par Sa ? " + bBegin);

		// Savoir si la chaîne se termine par ...
		boolean bEnd = chaineSansEspace.endsWith("lut");
		System.out.println("La chaîne '" + chaineSansEspace + "' se finit-elle par lut ? " + bEnd);

		// Transformation en majuscule
		String MAJUSCULE = chaineSansEspace.toUpperCase();
		System.out.println("En MAJUSCULE : " + MAJUSCULE);

		// Transformation en minuscule
		String minuscule = chaineSansEspace.toLowerCase();
		System.out.println("En minuscule : " + minuscule);
	}

	/**
	 * Correction de l'exercice.
	 * 
	 * @param chainePourExercice
	 *            La chaîne de caractère contenant les informations de la
	 *            personne (prénom et nom)
	 * @return Une instance de personne
	 */
	public static Personne correction(String chainePourExercice) {
		// On enlève les espaces autour de la chaîne
		String chaineSansEspace = chainePourExercice.trim();

		// On coupe la chaîne en deux, avec l'espace
		String[] split = chaineSansEspace.split(" ");

		// On récupère le prénom et le nom
		String prenom = split[0];
		String nom = split[1].toUpperCase();

		// Création d'une instance de Personne
		Personne p = new Personne(nom, prenom);
		return p;
	}
}

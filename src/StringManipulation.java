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
	 */
	public static void main(String[] args) {
		// Petit cours
		runTraining();
		// Exercice
		String chainePourExercice = " Maxime BLAISE  ";
		Personne personne = runExercise(chainePourExercice);
		System.out.println(personne);
	}

	/**
	 * Exercice : on a en paramètre une chaîne de caractères contenant le prénom
	 * et le nom. Le but est de distinguer le nom du prénom, et de créer une
	 * instance de l'objet Personne à partir du nom et du prénom.
	 */
	public static Personne runExercise(String chainePourExercice) {

		return null;
	}

	/**
	 * Quelques exemples de code pour manipuler des chaînes de caractères.
	 */
	public static void runTraining() {
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
		System.out.println("'" + chaineAvecEspaces
				+ "' sans espace, ça donne '" + chaineAvecEspaces.trim() + "'");

		// Couper la chaîne en deux, par exemple avec l'espace
		String[] chaines = chaineAManipuler.split(" ");
		System.out.println("Chaîne 1 : " + chaines[0]);
		System.out.println("Chaîne 2 : " + chaines[1]);
	}
}

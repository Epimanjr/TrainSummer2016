package model;

/**
 * Classe représentant une Personne (nom + prénom)
 * 
 * @author Maxime BLAISE
 *
 */
public class Personne {

	/**
	 * Nom de la personne.
	 */
	private String nom;

	/**
	 * Prénom de la personne.
	 */
	private String prenom;

	/**
	 * Construit une instance de personne à partir de son nom et de son prénom.
	 * 
	 * @param nom
	 *            Nom de la personne.
	 * @param prenom
	 *            Prénom de la personne.
	 */
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Je m'appelle " + prenom + " " + nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}

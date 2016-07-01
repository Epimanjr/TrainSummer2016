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
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
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

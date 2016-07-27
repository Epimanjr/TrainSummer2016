package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Unique classe qui permet de gérer les connections à la base de données.
 * 
 * @author Maxime BLAISE
 *
 */
public class Connector {

	/**
	 * Instance d'une connection. Initialement cette connection vaut "null",
	 * C'est-à-dire qu'aucune connection n'a été initialisée.
	 */
	private Connection connection;

	/**
	 * Nom de la base.
	 */
	private String baseName;

	/**
	 * Pseudo utilisé pour se connecter.
	 */
	private String login;

	/**
	 * Mot de passe associé.
	 */
	private String password;

	/**
	 * Unique instance de connector.
	 */
	private static Connector connector = new Connector();

	/**
	 * Constructeur privé pour éviter la création de Connector en dehors de
	 * cette classe.
	 */
	private Connector() {
		super();
	}

	/**
	 * Permet de récupérer l'unique instance de Connector en dehors de cette
	 * classe.
	 * 
	 * @return Connector
	 */
	public static Connector getConnector() {
		return connector;
	}

	/**
	 * Permet de récupérer une connection à une base de données. Si la
	 * connection a déjà été initialisée, alors on la récupère. Sinon, on créer
	 * une nouvelle connection, et on récupère celle-ci.
	 * 
	 * @return L'instance de la connection
	 */
	private Connection getConnection() {
		if (this.connection == null) {
			// Initialisation d'une nouvelle connection
			initConnection();
		}
		return this.connection;
	}

	/**
	 * Permet d'initialiser la connexion à la base de données.
	 */
	public void initConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/" + this.baseName, this.login,
					this.password);
		} catch (SQLException e) {
			System.err.println("Error: can't connect to database " + baseName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Permet d'effectuer des requêtes de sélections à la base de données.
	 * 
	 * @param sql
	 *            Requête SQL
	 * @return Résultats
	 * @throws SQLException
	 *             Exception si on arrive pas à effectuer la requête.
	 */
	public ResultSet select(String sql) throws SQLException {
		// Récupération de la connexion
		Connection connection = this.getConnection();
		if (connection != null) {
			// Connexion OK
			Statement statement = this.getConnection().createStatement();
			ResultSet results = statement.executeQuery(sql);
			return results;
		}
		return null;
	}

	/**
	 * Permet de renseigner les informations de connexion à la BDD.
	 * 
	 * @param baseName
	 *            Nom de la base.
	 * @param login
	 *            Pseudo utilisé pour se connecter.
	 * @param password
	 *            Mot de passe associé.
	 */
	public void setConnectionInformation(String baseName, String login, String password) {
		this.baseName = baseName;
		this.login = login;
		this.password = password;
	}
}

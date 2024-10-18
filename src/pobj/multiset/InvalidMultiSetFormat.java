package pobj.multiset;

/**
 * Classe d'exception spécifique aux erreurs de conversion d'un fichier texte en HashMultiSet
 */

public class InvalidMultiSetFormat extends Exception{
	private static final long serialVersionUID = 1L; // genéré auto

	/**
	 * Lève une exception et affiche le message d'erreur msg
	 * @param msg
	 */
	public InvalidMultiSetFormat(String msg) {
		super(msg);
	}
	
	/**
	 * Lève une exception en causée par cause et affiche le message d'erreur msg
	 * @param msg
	 * @param cause
	 */
	public InvalidMultiSetFormat(String msg, Throwable cause) {
		super(msg, cause);
	}
}

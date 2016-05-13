package exception;
/**
 * <b>CommandeException est l'exception lévé lors de l'execution du programme au cas ou </br>
 * l'utilisateur entre une commande non definie.</b>
 * @author kouyate,Cisse,Diallo,Melaine
 *
 */
public class CommandeException extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * Constructeur de CommandeException
	 * @param message
	 */
	public CommandeException(String message){
		super(message);
	}

}

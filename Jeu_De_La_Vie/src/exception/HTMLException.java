package exception;
/**
 * <b>HTMLException est l'exception lévé lors de la génération d'une page HTML.</b>
 * @author kouyate,Cisse,Diallo,Melaine
 *
 */
public class HTMLException extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * Constructeur de HTMLException
	 * @param message
	 * 
	 */
	public HTMLException(String message){
		super(message);
	}

}

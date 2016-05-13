package exception;
/**
 * <b>LectureException est l'exception lévé lors de la 
 * lecture d'un fichier au format lif.</b>
 * @author kouyate,Cisse,Diallo,Melaine
 *
 */
public class LectureException extends Exception{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur LectureException
	 * @param message
	 * 
	 */
	public LectureException(String message){
		System.out.println(this.getClass() + " : "+message);
	}

}

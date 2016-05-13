package structureDeDonnee;
import java.io.IOException;
import exception.LectureException;

import jeuDeLaVie.JeuDeLaVie;

/**
 * <b>PlateauInfini est la classe répresentant une structure de donnée du jeu de la vie </br>
 * dans un plateau infini.</b>
 * Elle hérite de la classe {@link PlateauFini}.
 * @see JeuDeLaVie
 * @author kouyate
 *
 */
public class PlateauInfini extends PlateauFini{
	/* (non-Javadoc)
	 * @see StructureDeDonnee.PlateauFini
	 */
	public PlateauInfini() {
		super();
	}
	/* (non-Javadoc)
	 * @see StructureDeDonnee.PlateauFini
	 */
	public PlateauInfini(String nomFichier) throws LectureException, IOException {
		super(nomFichier);
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see StructureDeDonnee.PlateauFini#is_Bordure(Cellule)
	 */
	public boolean is_Bordure(Cellule c){
		return false;
	}
	/* (non-Javadoc)
	 * @see StructureDeDonnee.PlateauFini#clear()
	 */
	public void clear(){}
}

package structureDeDonnee;
import java.io.IOException;

import exception.LectureException;

import interface_.Matrice;

/**
 * <b>StructureDeDonneeFactory est la classe de fabrique d'un plateau du jeu de la vie.</b>
 * Elle peut créer trois type de plateau :
 * <p>
 * <ul>
 * <li>Plateau Fini</li>
 * <li>Plateau infini</li>
 * <li>Plateau circulaire</li>
 * </ul>
 * </p>
 * @see PlateauFini
 * @see PlateauInfini
 * @see PlateauCirculaire
 *  @author kouyate
 */
public class StructureDeDonneeFactory {
	
	/**
	 * Constante répresentant un plateau infini.
	 * @see PlateauInfini
	 */
	public static final int PLATEAU_INFINI = 1;
	/**
	 * Constante répresentant un Plateau fini.
	 * @see PlateauFini
	 */
	public static final int PLATEAU_FINI = 2;
	/**
	 * Constante répresentant un circulaire.
	 * @see PlateauCirculaire
	 */
	public static final int PLATEAU_CIRCULAIRE = 3;
	/**
	 * Méthode de fabrique de structure de donnée (Plateau du jeu de la vie).
	 * @param typePlateau
	 * 				Un entier correspondant au type de plateau.
	 * @param nomFichier
	 * 				Un nom de fichier LIF(fichier comportant le jeu de la vie).
	 * @return	Un plateau(Structure de donnée) correspondant au type passé en paramètre.
	 * @throws LectureException 
	 * @throws IOException 
	 * @see Matrice
	 * @see PlateauFini
	 * @see PlateauInfini
	 * @see PlateauCirculaire
	 */
	public static Matrice getPlateau(int typePlateau,String nomFichier) throws LectureException, IOException{
		Matrice plateau = null;
		switch(typePlateau){
		
		case PLATEAU_FINI : 
			plateau = new PlateauFini(nomFichier);
			break;
		case PLATEAU_INFINI :
			plateau = new PlateauInfini(nomFichier);
			break;
		case PLATEAU_CIRCULAIRE :
			plateau = new PlateauCirculaire(nomFichier);
			break;
		default : 
			throw new IllegalArgumentException("Type de jeu Inconnu "+typePlateau);
		}
		return plateau;
	}
}

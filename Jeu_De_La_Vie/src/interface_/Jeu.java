package interface_;
import structureDeDonnee.PlateauCirculaire;
import structureDeDonnee.PlateauFini;
import structureDeDonnee.PlateauInfini;
/**
 * <b>Jeu est l'interface définissant un jeu de la vie.</b>
 * @author kouyate,Cisse,Diallo,Melaine
 *
 */
public interface Jeu {
	/**
	 * Calcule l'évolution suivante du jeu de la vie.</br>
	 * Elle est dépendante du plateau du jeu de la vie.({@link PlateauFini},{@link PlateauInfini},
	 * {@link PlateauCirculaire}).
	 * @see Matrice
	 * @see PlateauFini 
	 * @see PlateauInfini
	 * @see PlateauCirculaire
	 */
	public void evolutionSuivante();
}

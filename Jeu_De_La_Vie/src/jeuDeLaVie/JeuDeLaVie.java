package jeuDeLaVie;
import java.io.IOException;

import exception.LectureException;
import interface_.Jeu;
import interface_.Matrice;
import structureDeDonnee.PlateauCirculaire;
import structureDeDonnee.PlateauFini;
import structureDeDonnee.PlateauInfini;
/**
 * <b>JeuDeLaVie est la classe répresentant un jeu de la vie.</b>
 * Elle implemente l'interface Jeu.</br>
 * Elle est paramètré par une structure de donnée qui peut être : 
 * <p>
 * <ul>
 * <li>Un Plateau circulaire.</li>
 * <li>Un plateau fini. </li>
 * <li>Un plateau Infini.</li>
 * </ul>
 * </p>
 * @see Matrice
 * @see PlateauFini
 * @see PlateauInfini
 * @see PlateauCirculaire
 * @author kouyate
 *
 */
public class JeuDeLaVie implements Jeu {
	/**
	 * Plateau du jeu de la vie.
	 * @see Matrice
	 * @see PlateauFini
	 * @see PlateauInfini
	 * @see PlateauCirculaire
	 */
    private Matrice plateau;
    /**
     * Constructeur JeuDeLaVie.
     * @param structure
     * 				Une structure de donnée répresentant un plateau du jeu de la vie.
     * @see Matrice
	 * @see PlateauFini
	 * @see PlateauInfini
	 * @see PlateauCirculaire
     */
    public JeuDeLaVie(Matrice structure){
    	this.plateau = structure;
    }
    /**
     * Constructeur JeuDeLaVie.
     * @param nomFichier
     * 				Un nom de fichier LIF(fichier comportant le jeu de la vie).	
     * @param structure
     * 				Une structure de donnée répresentant un plateau du jeu de la vie.
     * @throws LectureException 
     * @throws IOException 
     * @see Matrice
	 * @see PlateauFini
	 * @see PlateauInfini
	 * @see PlateauCirculaire
     */
    public JeuDeLaVie(String nomFichier,Matrice structure) throws LectureException, IOException{
    	this.plateau = structure;
    	LectureJeuDeLaVie.LectureJeu(nomFichier, plateau);
    }
	@Override
	public void evolutionSuivante() {
		// TODO Auto-generated method stub
		this.plateau.evoluer();
	}
	
   /**
    * Getter de plateau
    * @return une Matrice
    * @see JeuDeLaVie#plateau
    */
	public Matrice getPlateau(){
		return plateau;
	}
	
	/**
	 * Setter de plateau
	 * @param p
	 * @see JeuDeLaVie#plateau
	 */
	public void setPlateau(Matrice p){
		plateau = p;
	}
}

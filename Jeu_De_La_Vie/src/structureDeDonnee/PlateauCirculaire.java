package structureDeDonnee;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import exception.LectureException;

import jeuDeLaVie.JeuDeLaVie;

/**
 * <b>PlateauCirculaire est la classe répresentant une structure de donnée du jeu de la vie </br>
 * dans un plateau circulaire(Monde circulaire).</b>
 * Elle hérite de la classe {@link PlateauFini}.
 * @see JeuDeLaVie
 * @author cissé adama dodo
 */
public class PlateauCirculaire extends PlateauFini {

	public PlateauCirculaire(String nomFichier) throws LectureException, IOException {
		super(nomFichier); 

		// TODO Auto-generated constructor stub
	}
	/**
	 * Cette methode permet de calculer la symetrie horizontale d'une cellule.
	 * @param cellule 
	 * @param increment 
	 * @return une cellule qui est sa symetrie horizontale c'est a dire sont voisin horizontalement (gauche ou droite)
	 */
	private Cellule SymetrieHorizontale(Cellule cellule,int increment){
		// on teste si on veux se deplacer a gauche (si l'increment = -1)
		if(increment < 0){
			// si la cellule est au bord gauche de la matrice alors on renvoie 
			// une nouvelle cellule qui est à l'opposé horizontalement
			if(cellule.getOrdonnee() == getMinOrdonnee()){
				return new Cellule(cellule.getAbscisse(), getMaxOrdonnee(), 1, false);
			}else{
			// sinon on renvoie une nouvelle cellule decaler increment fois à gauche 
				return new Cellule(cellule.getAbscisse(),cellule.getOrdonnee() + increment, 1 , false);
			}
		// sinon forcement on veux ce deplacer à droite (si l'increment = 1) 
		}else{
			// si la cellule est au bord droite de la matrice alors on renvoie 
			// une nouvelle cellule qui est à l'opposé horizontalement
			if(cellule.getOrdonnee() == getMaxOrdonnee()){
				return new Cellule(cellule.getAbscisse(), getMinAbscisse(), 1, false);
			}else{
			// sinon on renvoie une nouvelle cellule decaler increment fois à droite 
				return new Cellule(cellule.getAbscisse(), cellule.getOrdonnee() + increment, 1, false);
			}
		}	
	}

	/**
	 * <b> Cette methode permet de calculer la symetrie verticale d'une cellule </b>
	 * @param cellule
	 * @param increment
	 * @return une cellule qui est sa symetrie verticale c'est a dire sont voisin verticalement(haut ou bas) 
	 */
	private Cellule SymetrieVertivale(Cellule cellule,int increment){
		// on teste si on veux se deplacer vers le en haut (si l'increment = -1)
		if(increment < 0 ){
			// si la cellule est au bord en haut de la matrice alors on renvoie 
			// une nouvelle cellule qui est a l'opposé, verticalement 
			if(cellule.getAbscisse() == getMinAbscisse()){
				return new Cellule(getMaxAbscisse(), cellule.getOrdonnee(), 1, false);
			}else{
			// sinon on renvoie une nouvelle cellule decaler increment fois en haut 
				return new Cellule(cellule.getAbscisse() + increment,cellule.getOrdonnee(), 1 , false);
			}
			// sinon forcement on veux ce deplacer a le bas (si l'increment = 1) 
		}else{
			// si la cellule est au bord en bas de la matrice alors on renvoie 
			// une nouvelle cellule qui est a l'opposé ,horizontalement
			if(cellule.getAbscisse() == getMaxAbscisse()){
				return new Cellule(getMinAbscisse(), cellule.getOrdonnee(), 1, false);
			}else{
			// sinon on renvoie une nouvelle cellule decaler increment fois en bas
				return new Cellule(cellule.getAbscisse() + increment, cellule.getOrdonnee(), 1, false);
			}
		}	
	}

	/**
	 * <b> cette methode permet de calculer l'evolution au plateauCirculaire </b>
	 */
	@SuppressWarnings("unchecked")
	public void evoluer(){
		ArrayList<Cellule> liste1 =new ArrayList<Cellule>();
		Iterator<Cellule> c = getIterateurCellule();
		// on fait un decalage vers la droite 
		while(c.hasNext()){
			liste1.add(SymetrieHorizontale(c.next(), 1));
		}
		ArrayList<Cellule> liste2 = new ArrayList<Cellule>();
		Iterator<Cellule> c2 = getIterateurCellule();
		// on fait un decalage vers le bas 
		while(c2.hasNext()){
			liste2.add(SymetrieVertivale(c2.next(), 1));
		}
		ArrayList<Cellule> liste3 = new ArrayList<Cellule>();
		Iterator<Cellule> c3 = getIterateurCellule();
		// on fait un decalage vers le gauche 
		while(c3.hasNext()){
			liste3.add(SymetrieHorizontale(c3.next(), -1));
		}	
		// on fait un decalage vers le haut
		ArrayList<Cellule> liste4 = new ArrayList<Cellule>();
		Iterator<Cellule> c4 = getIterateurCellule();
		while(c4.hasNext()){
			liste4.add(SymetrieVertivale(c4.next(), -1));
		}
		
		ArrayList<Cellule> liste5 = new ArrayList<Cellule>();
		Iterator<Cellule> c5 = getIterateurCellule();
		// on fait un decalage vers haut droite (diagonale) 
		while(c5.hasNext()){
			liste5.add(SymetrieHorizontale(SymetrieVertivale(c5.next(), -1), 1));
		}
		ArrayList<Cellule> liste6 = new ArrayList<Cellule>();
		Iterator<Cellule> c6 = getIterateurCellule();
		// on fait un decalage vers haut gauche (diagonale) 
		while(c6.hasNext()){
			liste6.add(SymetrieHorizontale(SymetrieVertivale(c6.next(), -1), -1));
		}
		ArrayList<Cellule> liste7 = new ArrayList<Cellule>();
		Iterator<Cellule> c7 = getIterateurCellule();
		// on fait un decalage vers bas gauche (diagonale) 
		while(c7.hasNext()){
			liste7.add(SymetrieHorizontale(SymetrieVertivale(c7.next(), 1), 1));
		}

		ArrayList<Cellule> liste8 = new ArrayList<Cellule>();
		Iterator<Cellule> c8 = getIterateurCellule();
		// on fait un decalage vers bas droite (diagonale) 
		while(c8.hasNext()){
			liste8.add(SymetrieHorizontale(SymetrieVertivale(c8.next(), 1), -1));
		}
	
		 //on récupere l'ensemble des translations des cellules du plateau dans liste1
		liste1 = ajouterElement(liste1,liste2);
		liste1 = ajouterElement(liste1,liste3);
		liste1 = ajouterElement(liste1,liste4);
		liste1 = ajouterElement(liste1,liste5);
		liste1 = ajouterElement(liste1,liste6);
		liste1 = ajouterElement(liste1,liste7);
		liste1 = ajouterElement(liste1,liste8);
		liste1 = ajouterElement(liste1,(ArrayList<Cellule>) getCelluleVivante());	// cellule Vivante pas declarer d'abord 
		Collections.sort(liste1);
		calculerEvolution(liste1);

	}

}
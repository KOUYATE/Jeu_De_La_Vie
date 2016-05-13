/**
 * 
 */
package structureDeDonnee;
import interface_.Matrice;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import exception.LectureException;
import jeuDeLaVie.JeuDeLaVie;
import jeuDeLaVie.LectureJeuDeLaVie;

/**
 * <b>PlateauFini est la classe répresentant une structure de donnée du jeu de la vie <br/>
 * dans un plateau fini (monde fini).</b>
 * Elle implement l'interface {@link Matrice} et est caractérisée par : 
 * <p>
 * <ul>
 * <li>Une liste de cellule vivante.</li>
 * <li>Une liste de règle de vie des cellules.</li>
 * <li>une liste de règle de mort des cellules.</li>
 * <li>Quatre(4) entier définissant le minimum des abscisses, des ordonnée, le maximum des abscisses</br>
 * ,des ordonnées.</li>
 * </ul>
 * </p>
 * @see JeuDeLaVie
 * @author kouyate
 *
 */
public class PlateauFini implements Matrice {
	/**
	 * Liste de l'ensemble des cellules vivantes.
	 * @see Cellule
	 * @see interface_.Matrice#getCelluleVivante()
	 * @see Matrice#ajouterCellule(Cellule)
	 */
	private ArrayList<Cellule>celluleVivante;
	/**
	 * Liste de l'ensemble des règles de vie des cellules(condition pour q'une cellule morte naisse).
	 * @see Cellule
	 * @see interface_.Matrice#ajouterRegleVie(Integer)
	 * @see interface_.Matrice#getTailleRegleVie()
	 */
	private ArrayList<Integer>regleVie;
	/**
	 *  Liste de l'ensemble des règles de mort des cellules(condition pour q'une cellule vivante reste vivante).
	 *  @see Cellule
	 *  @see Matrice#ajouterRegleMort(Integer)
	 *  @see Matrice#getTailleRegleMort()
	 */
	private ArrayList<Integer>regleMort;
	/**
	 * L'entier définissant le minimum des abscisses des cellules vivantes.
	 * @see Cellule
	 * @see PlateauFini#getMinAbscisse()
	 * @see PlateauFini#setMinAbscisse(int)
	 */
	private int minAbscisse;
	/**
	 * L'entier définissant le minimun des ordonnées des cellules vivantes.
	 * @see Cellule
	 * @see PlateauFini#getMinOrdonnee()
	 * @see PlateauFini#setMinOrdonnee(int)
	 */
	private int minOrdonnee;
	/**
	 * L'entier définissant le maximum des abscisses des cellules vivantes.
	 * @see Cellule
	 * @see PlateauFini#getMaxAbscisse()
	 * @see PlateauFini#setMaxAbscisse(int)
	 */
	private int maxAbscisse;
	/**
	 * L'entier définissant le maximun des ordonnées des cellules vivantes.
	 * @see Cellule
	 * @see PlateauFini#getMaxOrdonnee()
	 * @see PlateauFini#setMaxOrdonnee(int)
	 */
	private int maxOrdonnee;
	/**
	 * 
	 */
	public PlateauFini(){
		this.celluleVivante = new ArrayList<Cellule>();
		this.regleVie = new ArrayList<Integer>();
		this.regleMort = new ArrayList<Integer>();
		this.maxAbscisse = this.maxOrdonnee = this.minOrdonnee = this.minAbscisse = 0;
	}
	/**
	 * Constructeur Grille.
	 * @param nomFichier 
	 * 				Le nom du fichier LIF.
	 * @throws LectureException 
	 * @throws IOException 
	 * @see Cellule
	 * @see PlateauFini#celluleVivante
	 * @see PlateauFini#regleVie
	 * @see PlateauFini#regleMort
	 * @see PlateauFini#maxAbscisse {@link PlateauFini#maxOrdonnee} {@link #minAbscisse} {@link #minOrdonnee}
	 */
	public PlateauFini(String nomFichier) throws LectureException, IOException{
		//initialisation des variables
		this.celluleVivante = new ArrayList<Cellule>();
		this.regleVie = new ArrayList<Integer>();
		this.regleMort = new ArrayList<Integer>();
		this.maxAbscisse = this.maxOrdonnee = this.minOrdonnee = this.minAbscisse = 0;
		LectureJeuDeLaVie.LectureJeu(nomFichier, this);
		update();
		clear();
	}
	
	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#ajouterCellule(structure.Cellule)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean ajouterCellule(Cellule cellule) {
			//teste l'effet de bord 
			if(is_Bordure(cellule)){
				return false;
			}
			return ((ArrayList<Cellule>) getCelluleVivante()).add(cellule);
	}

	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#ajouterRegleVie(java.lang.Integer)
	 */
	@Override
	public boolean ajouterRegleVie(Integer regle) {
		if(regleVie.contains(regle)){
			return false;
		}
		return regleVie.add(regle);
	}

	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#ajouterRegleMort(java.lang.Integer)
	 */
	@Override
	public boolean ajouterRegleMort(Integer regle) {
		if(regleMort.contains(regle)){
			return false;
		}
		return regleMort.add(regle);
	}
	/**
	 * Methode ajouterEelement
	 * @param l1 liste de cellule de vivante
	 * @param l2 liste de cellule de vivante
	 * @return une liste contenant  la concatenation dès deux liste passées en paramètre
	 */
	public ArrayList<Cellule> ajouterElement(ArrayList<Cellule> l1,ArrayList<Cellule>l2){
		Iterator<Cellule> iterateur = l2.iterator();
		while(iterateur.hasNext()){
			l1.add(iterateur.next());
		}
		return l1;
	}
	@Override
	public Matrice clone(){
			try {
				return (Matrice) super.clone();
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
			return this;
	}

	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#contains(structure.Cellule)
	 */
	@Override
	public boolean contains(Cellule cellule) {
		return  celluleVivante.contains(cellule);
	}

	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#containsRegleMort(java.lang.Integer)
	 */
	@Override
	public boolean containsRegleMort(Integer regle) {
		return regleMort.contains(regle);
	}

	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#containsRegleVie(java.lang.Integer)
	 */
	@Override
	public boolean containsRegleVie(Integer regle) {
		return regleVie.contains(regle);
	}

	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#estVide()
	 */
	@Override
	public boolean estVide() {
		return celluleVivante.isEmpty();
	}

	/**
	 * Methode evoluer permet de calculer l'évolution
	 * en utilisant la méthode translation;
	 */
	
	public void evoluer(){
		ArrayList<Cellule> liste1 = translation(-1,-1);
		ArrayList<Cellule> liste2 = translation(-1, 0);
		ArrayList<Cellule> liste3 = translation(-1, 1);
		ArrayList<Cellule> liste4 = translation( 0,-1);
		ArrayList<Cellule> liste5 = translation( 0, 1);
		ArrayList<Cellule> liste6 = translation(1, -1);
		ArrayList<Cellule> liste7 = translation(1, 0);
		ArrayList<Cellule> liste8 = translation(1, 1);
		liste1 = ajouterElement(liste1,liste2);
		liste1 = ajouterElement(liste1,liste3);
		liste1 = ajouterElement(liste1,liste4);
		liste1 = ajouterElement(liste1,liste5);
		liste1 = ajouterElement(liste1,liste6);
		liste1 = ajouterElement(liste1,liste7);
		liste1 = ajouterElement(liste1,liste8);
		liste1 = ajouterElement(liste1,celluleVivante);	
		Collections.sort(liste1);
		calculerEvolution(liste1);
	}
	
	
	/**
	 * Methode calculerEvolution permet  de faire l'évolution de la liste passée en paramètre
	 * @param liste1 une liste de cellule vivante
	 */
	public void calculerEvolution(ArrayList<Cellule>liste1){
		int i=0;
		Cellule cellule1 = new Cellule();
		Cellule cellule2 = new Cellule();
		ArrayList<Cellule> tmp = new ArrayList<Cellule>();
		/*
		 * on parcoure la liste passé en paramètre en comtant le nombre de
		 * voisin de chaque cellule et on calucule l'évolution suivante des 
		 * cellules par rapport au règle du plateau
		 */
		while(i<liste1.size()){
			 cellule1 = new Cellule(liste1.get(i).getAbscisse(),
					 liste1.get(i).getOrdonnee(),
					 liste1.get(i).getNombreVoisin(),
					 liste1.get(i).isStatus());
			 
			 while(i+1<liste1.size()
					 && cellule1.getAbscisse() == liste1.get(i+1).getAbscisse()
					 && cellule1.getOrdonnee() == liste1.get(i+1).getOrdonnee()){
				 	if(cellule1.getNombreVoisin()!=-1 && liste1.get(i+1).getNombreVoisin()!=-1){
				 		cellule2 = new Cellule(cellule1.getAbscisse(),cellule1.getOrdonnee(),
				 				cellule1.getNombreVoisin()+1,false);
				 		i++;
				 	}
				 	else if(cellule1.getNombreVoisin()==-1){
				 		cellule2 = new Cellule(cellule1.getAbscisse(),cellule1.getOrdonnee(),
				 				liste1.get(i+1).getNombreVoisin(),true);
				 		i++;
				 	} else {
				 		cellule2 = new Cellule(cellule1.getAbscisse(),cellule1.getOrdonnee(),
				 				cellule1.getNombreVoisin(),true);
				 		i++;
				 	}
				 	cellule1 = cellule2;	 	
			 }
			 i++;
			 tmp.add(cellule1);
			 
		}
		ArrayList<Cellule>tmp2 = new ArrayList<Cellule>();
		Iterator<Cellule> it = tmp.iterator();
		//calcul de l'evolution des cellules
		while(it.hasNext()){
			Cellule cell = it.next();
			if(cell.isStatus()){
				if(regleMort.contains(cell.getNombreVoisin())){
					tmp2.add(new Cellule(cell.getAbscisse(),cell.getOrdonnee(),-1,true));
				}
			} else {
				if(regleVie.contains(cell.getNombreVoisin())){
					tmp2.add(new Cellule(cell.getAbscisse(),cell.getOrdonnee(),-1,true));
				}
			}
		}
		setCelluleVivante(tmp2);
	}
	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#getCellule(int)
	 */
	@Override
	public Cellule getCellule(int i) {
		return celluleVivante.get(i);
	}
	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#getCelluleVivante()
	 */
	@Override
	public Object getCelluleVivante() {
		return celluleVivante;
	}

	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#getIterateurCellule()
	 */
	@Override
	public Iterator<Cellule> getIterateurCellule() {
		Iterator<Cellule> iterateur = celluleVivante.iterator();
		return iterateur;
	}

	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#getTailleCelluleVivante()
	 */
	@Override
	public int getTailleCelluleVivante() {
		
		return celluleVivante.size();
	}

	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#getTailleRegleVie()
	 */
	@Override
	public int getTailleRegleVie() {
		
		return regleVie.size();
	}

	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#getTailleRegleMort()
	 */
	@Override
	public int getTailleRegleMort() {
		
		return regleMort.size();
	}

	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#setCelluleVivante(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setCelluleVivante(Object celluleVivante) {
		this.celluleVivante = (ArrayList<Cellule>)celluleVivante;
	}

	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#supprimerCellule(structure.Cellule)
	 */
	@Override
	public boolean supprimerCellule(Cellule cellule) {
		
		return celluleVivante.remove(cellule);
	}

	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#trierCellule()
	 */
	@Override
	public void trierCellule() {
		Collections.sort(celluleVivante); 
	}
	/**
	 * Méthode translation permet de décaler une cellule de x lignes et y colonnes 
	 * @param x un entier
	 * @param y un entier
	 * @return  une liste de cellule dont toutes les cellules ont été deplassées de x lignes et y colonnes
	 */
	public ArrayList<Cellule> translation(int x, int y) {
		ArrayList<Cellule> tmp = new ArrayList<Cellule>();
		Iterator<Cellule> iterateur = getIterateurCellule();
		while(iterateur.hasNext()){
			Cellule cellule = iterateur.next();
			Cellule nouvelleCellule = new Cellule(cellule.getAbscisse()+x,
					cellule.getOrdonnee()+y,1,false);
					if(!this.is_Bordure(nouvelleCellule))
							tmp.add(nouvelleCellule);
		}
		return tmp;
	}
	
	/**
	 * Vérifie l'effet de bord d'une cellule .</b>
	 * @param c une cellule
	 * @return un boolean
	 * @see Cellule
	 */
	public boolean is_Bordure(Cellule c){
		return c.getOrdonnee()< getMinOrdonnee() ||
			   c.getOrdonnee() > getMaxOrdonnee()||
			   c.getAbscisse() > getMaxAbscisse()||
			   c.getAbscisse() < getMinAbscisse();
	}
	
	/**
	 * Met à jour les variables {@link #maxAbscisse},{@link #maxOrdonnee},{@link #minAbscisse}
	 * {@link #minOrdonnee}
	 * @see PlateauFini
	 */
	
	public void update(){
		Iterator<Cellule> iterateur = this.getIterateurCellule();
		while(iterateur.hasNext()){
			Cellule cellule = iterateur.next();
			if(cellule.getAbscisse()<minAbscisse)
				minAbscisse = cellule.getAbscisse();
			else if(cellule.getAbscisse()>maxAbscisse)
				maxAbscisse = cellule.getAbscisse();
			if(cellule.getOrdonnee()<minOrdonnee)
				minOrdonnee = cellule.getOrdonnee();
			else if(cellule.getOrdonnee()>maxOrdonnee)
				maxOrdonnee = cellule.getOrdonnee();
		}
		
	}
	
	/**
	 *<b> Cette permet d'effacer toutes les cellules qui sont en dehors de notre cadre car nous sommes dans
	 * un monde fini </b>
	 */
	public void clear(){
		setMinAbscisse(getMinAbscisse()- 2);
		setMinOrdonnee(getMinOrdonnee() -2);
		setMaxAbscisse(getMinAbscisse() + 33);
		setMaxOrdonnee(getMinOrdonnee() + 134);
		
		for(int i=0;i<getTailleCelluleVivante();i++){
			if(getCellule(i).getAbscisse() > getMaxAbscisse()){
				supprimerCellule(getCellule(i));
				i--;
			}
		}
		for(int i=0;i<getTailleCelluleVivante();i++){
			if(getCellule(i).getOrdonnee() > getMaxOrdonnee()){
				supprimerCellule(getCellule(i));
				i--;
			}
		}
	}
	/**
	 * Getter de minAbscisse.
	 * @return Le minimum des abscisses des cellules vivantes.
	 * @see Cellule
	 * @see PlateauFini#minAbscisse
	 */
	public int getMinAbscisse() {
		return minAbscisse;
	}
	/**
	 * Setter de minAbscisse.
	 * @param minAbscisse
	 * 			Un entier correspondant au minimum des abscisses des cellules vivantes.
	 * @see Cellule
	 * @see PlateauFini#minAbscisse
	 */
	public void setMinAbscisse(int minAbscisse) {
		this.minAbscisse = minAbscisse;
	}
	/**
	 * Getter de minOrdonnee.
	 * @return Le minimum des ordonnées des cellules vivantes.
	 * @see Cellule
	 * @see PlateauFini#minOrdonnee 
	 */
	public int getMinOrdonnee() {
		return minOrdonnee;
	}
	/**
	 * Setter de minOrdonnee.
	 * @param minOrdonnee
	 * 			Un entier correspondant au minimum des ordonnées des cellules vivantes.
	 * @see Cellule
	 * @see PlateauFini#minOrdonnee
	 */
	public void setMinOrdonnee(int minOrdonnee) {
		this.minOrdonnee = minOrdonnee;
	}
	/**
	 * Getter de maxAbscisse.
	 * @return Le maximum des abscisses des cellules vivantes.
	 * @see Cellule
	 * @see PlateauFini#maxAbscisse
	 */
	public int getMaxAbscisse() {
		return maxAbscisse;
	}
	/**
	 * Setter de maxAbscisse.
	 * @param maxAbscisse
	 * 			Un entier correspondant au maximum des abscisses des cellules vivantes.
	 * @see Cellule
	 * @see PlateauFini#maxAbscisse
	 */
	public void setMaxAbscisse(int maxAbscisse) {
		this.maxAbscisse = maxAbscisse;
	}
	/**
	 * Getter de maxOrdonnee.
	 * @return Le maximum des ordonnées des cellules vivantes.
	 * @see Cellule
	 * @see PlateauFini#maxOrdonnee
	 */
	public int getMaxOrdonnee() {
		return maxOrdonnee;
	}
	/**
	 * Setter de maxOrdonnee.
	 * @param maxOrdonnee
	 * 			Un entier correspondant au maximum des ordonnées des cellules vivantes.
	 * @see Cellule
	 * @see PlateauFini#maxOrdonnee
	 */
	public void setMaxOrdonnee(int maxOrdonnee) {
		this.maxOrdonnee = maxOrdonnee;
	}
	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#ajouterCellule(structure.Cellule)
	 */
	public  boolean add(Cellule cellule){
		return celluleVivante.add(cellule);
	}
	@Override
	public boolean removeAll() {
		// TODO Auto-generated method stub
		return false;
	}
}

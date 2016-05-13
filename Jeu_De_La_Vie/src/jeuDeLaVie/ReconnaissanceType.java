package jeuDeLaVie;
import structureDeDonnee.Cellule;
import jeuDeLaVie.*;
import structureDeDonnee.PlateauCirculaire;
import structureDeDonnee.PlateauFini;
import structureDeDonnee.PlateauInfini;
import interface_.Matrice;

/**
 * <b>ReconnaissanceType est la classe qui calcule le type d'évolution d'un jeu de la vie.</b>
 * Elle s'interesse à cinq (5) types d'évolution du jeu de la vie qui sont : </br>
 * <li>L'état mort.</li>
 * <li>La stabilité.</li>
 * <li>L'oscillation.<li>
 * <li>Vaisseau.<li>
 * <li>L'état inconnu</li>
 * <p>
 * Une ReconnaissanceType est caracterisée par : 
 * <ul>
 * <li>Deux configurations du jeu de la vie.</li>
 * <li>Un entier répresentant la période de l'évolution du jeu.</li>
 * <li>Un entier répresentant la taille de la queue de l'évolution du jeu.<li>
 * <li>Cinq Booléen indiquant le type d'evolution</li>
 * </ul>
 * </p>
 * @see JeuDeLaVie
 * @author kouyate
 */

@SuppressWarnings("unused")
public class ReconnaissanceType {
	/**
	 * Prémière configuration du jeu la vie.
	 * @see ReconnaissanceType#getConfiguration1()
	 * @see ReconnaissanceType#setConfiguration1(JeuDeLaVie)
	 * @see JeuDeLaVie
	 */
	private JeuDeLaVie configuration1;
	/**
	 * Deuxième configuration du jeu de la vie.
	 * @see ReconnaissanceType#getConfiguration2()
	 * @see ReconnaissanceType#setConfiguration2(JeuDeLaVie)
	 * @see JeuDeLaVie
	 */
	private JeuDeLaVie configuration2;
	/**
	 * Période de l'evolution du jeu.
	 * @see ReconnaissanceType#getPeriodeFinal()
	 * @see ReconnaissanceType#setPeriodeFinal(int)
	 * @see JeuDeLaVie
	 */
	protected int periodeFinal = 0;
	/**
	 * Taille de la queue.
	 * @see ReconnaissanceType#getTailleQueue()
	 * @see ReconnaissanceType#setTailleQueue(int)
	 * @see JeuDeLaVie
	 */
	private int tailleQueue=0;
	/**
	 * Indique un type d'évolution oscillant.</br>
	 * A l'étape de la création de l'objet elle est initialiser à Faux.
	 * @see ReconnaissanceType#setOscillation(boolean)
	 * @see ReconnaissanceType#isOscillation()
	 * @see JeuDeLaVie
	 */
	private boolean oscillation=false;
	/**
	 * Indique un type d'évolution stable.</br>
	 * A l'étape de la création de l'objet elle est initialiser à Faux.
	 * @see ReconnaissanceType#setStabilite(boolean)
	 * @see ReconnaissanceType#isStabilite()
	 * @see JeuDeLaVie
	 */
	private boolean stabilite=false;
	/**
	 * Indique un type d'évolution mort.</br>
	 * A l'étape de la création de l'objet elle est initialiser à Faux.
	 * @see ReconnaissanceType#setMort(boolean)
	 * @see ReconnaissanceType#isMort()
	 * @see JeuDeLaVie
	 */
	private boolean mort=false;
	/**
	 *  Indique un type d'évolution vaisseau.<br>
	 *  A l'étape de la création de l'objet elle est initialiser à Faux.
	 *  @see ReconnaissanceType#setVaisseau(boolean)
	 *  @see ReconnaissanceType#isVaisseau()
	 *  @see JeuDeLaVie
	 */
	private boolean vaisseau=false;
	/**
	 * Indique un type d'évolution inconnu.<br>
	 * A l'étape de la création de l'objet elle est initialiser à Vrai.
	 * @see ReconnaissanceType#setInconnu(boolean)
	 * @see ReconnaissanceType#isInconnu()
	 */
	private boolean inconnu=true;
	/**
	 * La configuration du jeu déplacée de 'lignes' lignes.
	 * 
	 */
	private int lignes = 0;
	/**
	 * La configuration du jeu déplacée de 'colonnes' colonnes.
	 */
	private int colonnes = 0;
	/**
	 * Constructeur ReconnaissanceType.
	 * @param temp
	 * 				Un entier correspondant au nombre d'evolution à effectuer.
	 * @param plateau
	 * 				Un plateau correspondant au type du jeu de la vie.
	 * @see JeuDeLaVie
	 * @see PlateauFini
	 * @see PlateauInfini
	 * @see PlateauCirculaire
	 */
	public ReconnaissanceType(int temp,Matrice plateau) {
		Matrice plateauClone = plateau.clone();
		configuration1 = new JeuDeLaVie(plateau);
		configuration2 = new JeuDeLaVie(plateauClone);
		//calculerTypeEvolution(temp);

	}
	/**
	 * Calcule le type d'évolution du jeu.</br>
	 * A la détection d'un type d'évolution elle affecte à chaque variable sa valeur adéquate selon le type trouvé.
	 * @param temp
	 * 				Un entier correspondant au nombre d'évolution à effectuer.
	 * @see JeuDeLaVie
	 * @see ReconnaissanceType#periodeFinal
	 * @see ReconnaissanceType#tailleQueue
	 * @see ReconnaissanceType#stabilite
	 * @see ReconnaissanceType#mort
	 * @see ReconnaissanceType#inconnu
	 * @see ReconnaissanceType#oscillation
	 * @see ReconnaissanceType#vaisseau
	 */
	public void calculerTypeEvolution(int temp){

		for(int i=1;i<=temp;i++){
			evoluerConfiguration();

			if(!inconnu){
				break;
			}
			setTailleQueue(i) ;
			if(estMort()){ //on teste si on a un type d'évolution mort 
				setInconnu(false);
				setMort(true);
			}
			if(estOscillation()){ //on teste si on a un type d'évolution oscillation 
				setInconnu(false);
				setOscillation(true);
				//Calcule de la période d'évolution.
				while(true){
					evoluerConfiguration();
					setPeriodeFinal(getPeriodeFinal()+1);
					if(estOscillation())
						break;
				}
				//on teste si on a un type d'évolution stable
				if(periodeFinal == 1){ 
					setStabilite(true);
				}
			}
			//on teste si on a un type d'évolution vaisseau 
			if(estVaisseau()){ 
				setInconnu(false);
				setVaisceau(true);
				if(!isOscillation())
					//Calcule de la periode	d'évolution	
					while(true){
						evoluerConfiguration();
						periodeFinal++;
						if(estVaisseau())
							break;
					}
			}
		}
	}
	/**
	 * Evolue la prémiere Configuration d'un pas et la seconde de deux pas.
	 * @see ReconnaissanceType#configuration1
	 * @see ReconnaissanceType#configuration2
	 * @see JeuDeLaVie
	 */
	public void evoluerConfiguration(){
		configuration1.evolutionSuivante(); 
		configuration2.evolutionSuivante(); 
		configuration2.evolutionSuivante();
	}
	/**
	 * Vérifie que le type d'évolution du jeu est oscillation.
	 * @return
	 * 			Un booléen indiquant si le type d'évolution est une oscillation.
	 * @see ReconnaissanceType#oscillation
	 * @see ReconnaissanceType#calculerTypeEvolution(int)
	 * @see JeuDeLaVie
	 */
	public boolean estOscillation(){
		//teste l'egalité du contenu des plateaux des deux configurations.
		return configuration1.getPlateau().getCelluleVivante().equals(
				configuration2.getPlateau().getCelluleVivante()) ;
	}
	/**
	 * Vérifie que le type d'évolution du jeu est mort.
	 * @return
	 * 			Un booléen indiquant si le type d'évolution est de type mort.
	 * @see ReconnaissanceType#mort
	 * @see ReconnaissanceType#calculerTypeEvolution(int)
	 * @see JeuDeLaVie
	 */
	public boolean estMort(){
		return configuration1.getPlateau().estVide();
	}
	/**
	 * Vérifie que le type d'évolution du jeu est Vaisseau.
	 * @return
	 * 			Un booléen indiquant si le type d'évolution est de type vaisseau.
	 * @see ReconnaissanceType#vaisseau
	 * @see ReconnaissanceType#calculerTypeEvolution(int)
	 * @see JeuDeLaVie
	 */
	public boolean estVaisseau(){
		if(estMort() || estOscillation())
			return true;
		// teste de l'égalité du nombre de cellule dans les deux configurations.
		if(configuration1.getPlateau().getTailleCelluleVivante() ==
				configuration2.getPlateau().getTailleCelluleVivante()){
			//recupération de la prémière cellule de la prémière configuration1
			Cellule p1 = configuration1.getPlateau().getCellule(0);
			//recupération de la prémière cellule de configuration
			Cellule p2 = configuration2.getPlateau().getCellule(0);
			//recupération du nombre de cellule vivante.
			int taille = configuration1.getPlateau().getTailleCelluleVivante();
			//calcule de la distance de référence 
			double distance = distance(p1, p2);
			/*
			 * la distance de référence est comparée à l'ensemble des autres distances 
			 * des cellules se trouvant à la même position dans les deux configurations.
			 * Si elle est ègal à tous les autres distances alors l'évolution est de type vaisseau.
			 */
			for(int i = 1;i<taille;i++){
				Cellule a = configuration1.getPlateau().getCellule(i);
				Cellule b = configuration2.getPlateau().getCellule(i);
				if(distance(a, b) !=distance){
					return false;
				}
			}
			//calcule du déplacement de la configuration vaisseau
			setLignes(Math.abs(Math.abs(p1.getAbscisse())-Math.abs(p2.getAbscisse())));
			setColonnes(Math.abs(Math.abs(p1.getOrdonnee())-Math.abs(p2.getOrdonnee())));
			return true;
		}
		return false;

	}
	/**
	 * Calcule la distance entre deux cellules.
	 * @param p1
	 * 			Une cellule du jeu de la vie.
	 * @param p2
	 * 			Une cellule du jeu de la vie.
	 * @return
	 * 			La distance entre les deux cellules passés en paramètre.
	 * @see Cellule
	 */
	public double distance(Cellule p1,Cellule p2){
		return (Math.sqrt((Math.pow(p1.getAbscisse() - p2.getAbscisse(), 2)) + (Math.pow(p1.getOrdonnee() - p2.getOrdonnee(), 2))));
	}

	/**
	 * Getter de configuration1.
	 * @return
	 * 			La prémière configuration de {@link ReconnaissanceType} 
	 * @see ReconnaissanceType#configuration1
	 */
	public JeuDeLaVie getConfiguration1() {
		return configuration1;
	}
	/**
	 * Setter de configuration1.
	 * @param configuration1
	 * 				Un jeu de la vie.
	 * @see ReconnaissanceType#configuration1
	 * @see JeuDeLaVie
	 */
	public void setConfiguration1(JeuDeLaVie configuration1) {
		this.configuration1 = configuration1;
	}

	/**
	 * Getter de configuration2.
	 * @return
	 * 			La prémière configuration de {@link ReconnaissanceType} 
	 * @see ReconnaissanceType#configuration2
	 */
	public JeuDeLaVie getConfiguration2() {
		return configuration2;
	}
	/**
	 * Setter de configuration2.
	 * @param configuration2
	 * 				Un jeu de la vie.
	 * @see ReconnaissanceType#configuration2
	 * @see JeuDeLaVie
	 */
	public void setConfiguration2(JeuDeLaVie configuration2) {
		this.configuration2 = configuration2;
	}
	/**
	 * Getter de periodeFinal.
	 * @return
	 * 			La période de l'évolution du jeu.
	 * @see ReconnaissanceType#periodeFinal
	 */
	public int getPeriodeFinal() {
		return periodeFinal;
	}
	/**
	 * Setter de periodeFinal.
	 * @param periodeFinal
	 * 				Un entier correspondant à la période.
	 * @see ReconnaissanceType#periodeFinal
	 */
	public void setPeriodeFinal(int periodeFinal) {
		this.periodeFinal = periodeFinal;
	}
	/**
	 * Getter de tailleQueue.
	 * @return
	 * 			La taille de la queue.
	 * @see ReconnaissanceType#tailleQueue
	 */
	public int getTailleQueue() {
		return tailleQueue;
	}
	/**
	 * Setter de tailleQueue.
	 * @param tailleQueue
	 * 				Un entier correspondant à la taille de la queue.
	 * @see ReconnaissanceType#tailleQueue
	 */
	public void setTailleQueue(int tailleQueue) {
		this.tailleQueue = tailleQueue;
	}
	/**
	 * Vérifie une oscillation.
	 * @return
	 * 			Un booléen indiquant une oscillation de l'évolution du jeu.
	 * @see ReconnaissanceType#calculerTypeEvolution(int)
	 * @see JeuDeLaVie
	 */
	public boolean isOscillation() {
		return oscillation;
	}
	/**
	 * Setter de oscillaton.
	 * @param oscillation
	 * 				Un booléen.
	 * @see ReconnaissanceType#oscillation
	 */
	public void setOscillation(boolean oscillation) {
		this.oscillation = oscillation;
	}
	/**
	 * Vérifie une stabilité.
	 * @return
	 * 			Un booléen.
	 * @see ReconnaissanceType#stabilite
	 */
	public boolean isStabilite() {
		return stabilite;
	}
	/**
	 * Setter de stabilité
	 * @param stabilite
	 * 			Un booléen.
	 * @see ReconnaissanceType#stabilite
	 */
	public void setStabilite(boolean stabilite) {
		this.stabilite = stabilite;
	}
	/**
	 * Vérifie un état mort.
	 * @return
	 * 			Un booléen.
	 * @see ReconnaissanceType#mort
	 */
	public boolean isMort() {
		return mort;
	}
	/**
	 * Setter de mort.
	 * @param mort
	 * 			Un booléen.
	 * @see ReconnaissanceType#mort
	 */
	public void setMort(boolean mort) {
		this.mort = mort;
	}
	/**
	 * Setter de vaisseau.
	 * @param vaisceau
	 * 			Un booléen.
	 * @see ReconnaissanceType#vaisseau
	 */
	public void setVaisceau(boolean vaisceau) {
		this.vaisseau = vaisceau;
	}
	/**
	 * Vérifie un type inconnu.
	 * @return
	 * 			Un booléen.
	 * @see ReconnaissanceType#inconnu
	 */
	public boolean isInconnu() {
		return inconnu;
	}
	/**
	 * Setter de inconnu.
	 * @param inconnu
	 * 			Un booléen.
	 * @see ReconnaissanceType#inconnu
	 */
	public void setInconnu(boolean inconnu) {
		this.inconnu = inconnu;
	}
	/**
	 * Getter vaisseau
	 * @return Un boolean
	 @see ReconnaissanceType#vaisseau
	 */
	public boolean isVaisseau() {
		return vaisseau;
	}
	/**
	 * Setter vaisseau.
	 * @param vaisseau 
	 * 				Un booléen 
	 * @see ReconnaissanceType#vaisseau
	 */
	public void setVaisseau(boolean vaisseau) {
		this.vaisseau = vaisseau;
	}
	/**
	 * Getter lignes
	 * @return lignes Le déplacement suivant la ligne de l'évolution du jeu
	 * @see ReconnaissanceType#lignes
	 */
	public int getLignes() {
		return lignes;
	}
	/**
	 * Setter lignes. 
	 * @param lignes
	 * 				Le déplacement suivant la ligne de l'évolution du jeu.
	 * @see ReconnaissanceType#lignes
	 */
	public void setLignes(int lignes) {
		this.lignes = lignes;
	}

	/**
	 * Getter  colonnes
	 * @return colonnes Le déplacement suivant la colonne de l'évolution du jeu.
	 * @see ReconnaissanceType#colonnes
	 */
	public int getColonnes() {
		return colonnes;
	}

	/**
	 * Setter colonnes
	 * @param colonnes 
	 * 				Le déplacement suivant la ligne de l'évolution du jeu
	 * @see ReconnaissanceType#colonnes
	 */
	public void setColonnes(int colonnes) {
		this.colonnes = colonnes; 
	}

	/**
	 * Methode toString  de ReconnaissanceType
	 * @return un String
	 */
	public String toString(){
		if(isInconnu())
			return  "Type inconnu";
		else if(isMort())
			return  "Type d'évolution : \n- Mort.\n- Stable.\n- Oscillation.\n- Vaisseau \n" +
			"Période : "+periodeFinal+" \nTaille de la queue : "+tailleQueue+"\nDéplacement (ligne,colonne) = ("+
			getLignes()+","+getColonnes()+")";
		else if(isStabilite())
			return  "Type d'évolution : \n- Stable.\n- Oscillation.\n- Vaisseau. \n" +
			"Période : "+periodeFinal+" \nTaille de la queue : "+tailleQueue+"\nDéplacement (ligne,colonne) = ("+
			getLignes()+","+getColonnes()+")";
		else if(isOscillation())
			return  "Type d'évolution : \n- Oscillation.\n- Vaisseau. \n" +
			"Période : "+periodeFinal+" \nTaille de la queue : "+tailleQueue+"\nDéplacement (ligne,colonne) = ("+
			getLignes()+","+getColonnes()+")";
		else
			return  "Type d'évolution : \n- Vaisseau  \n" +
			"Période : "+periodeFinal+" \nTaille de la queue : "+tailleQueue+"\nDéplacement (ligne,colonne) = ("+
			getLignes()+","+getColonnes()+")";
	}


}

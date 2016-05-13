package structureDeDonnee;
/**
 * <b>Cellule est la classe représentant une cellule du jeu de la vie.</br>
 * Elle implemente l'interface Comparable sur les cellules.</b>
 * <p>
 * Une cellule vivante  est caracterisée par sa position,son nombre de voisin vivant </br>
 * et son status (vivante ou morte): 
 * <ul>
 * <li>Un abscisse</li>
 * <li>Un ordonnée</li>
 * <li>Un entier correspondant à son nombre de voisin</li>
 * <li>Un booléen correspondant à son status</li>
 * </ul>
 * </p>
 * @author kouyate
 * 
 */
public class Cellule implements Comparable<Cellule>{
	/**
	 * Abscisse de la cellule vivante.
	 * @see Cellule#getAbscisse()
	 * @see Cellule#setAbscisse(int)
	 */
	private int abscisse;
	/**
	 * Ordonnée de la cellule vivante.
	 * @see Cellule#getOrdonnee()
	 * @see Cellule#setOrdonnee(int)
	 */
	private int ordonnee;
	/**
	 * Nombre de voisin vivant de la cellule.
	 * @see Cellule#getNombreVoisin()
	 * @see Cellule#setNombreVoisin(int) 
	 */
	private int nombreVoisin;
	/**
	 * Status de la cellule (vivante ou morte)
	 * @see Cellule#isStatus()
	 * @see Cellule#setStatus(boolean)
	 */
	private boolean status;
	/**
	 * Constructeur Cellule.
	 * @see Cellule
	 */
	public Cellule(){
		this.abscisse = 0;
		this.ordonnee = 0;
		this.nombreVoisin = -1;
		status = false;
		
	}
	/**
	 * Constructeur Cellule.
	 * 
	 * @param abs
	 * 			L'abscisse de la cellule vivante.
	 * @param ord
	 * 			L'ordonnée de la cellule vivante.
	 * @see Cellule#abscisse
	 * @see Cellule#ordonnee
	 */
	public Cellule(int abs,int ord,int n,boolean s){
		this.abscisse = abs;
		this.ordonnee = ord;
		this.nombreVoisin = n;
		this.status = s;
	}
	/**
	 * Methode de comparaison des cellules vivante.</br>
	 * Elle fait la comparaison suivant l'abscisse(ligne) et ensuite l'ordonnée(colonne).
	 * @param o 
	 * 			La cellule vivante à comparé avec l'objet à plan (this).
	 * @return Un entier(1,-1,0) correspondant au resultat de la comparaison.
	 */
	@Override
	public int compareTo(Cellule o) {
		if(this.getAbscisse()>o.getAbscisse())
			return 1;
		else if(this.getAbscisse()==o.getAbscisse()){
			if(this.getOrdonnee()>o.getOrdonnee())
				return 1;
			else if(this.getOrdonnee()<o.getOrdonnee())
				return -1;
			else return 0;
		}
		return -1;
	}
    /**
     * Methode toString.
     * @return L'abscisse et l'ordonnée sous forme de chaine de caractère.
     * @see Cellule#abscisse
     * @see Cellule#ordonnee
     * @see Cellule
     */
	
	@Override
	public String toString() {
		return "Cellule [abscisse=" + abscisse + ", ordonnee=" + ordonnee
				+ ", nombreVoisin=" + nombreVoisin + ", status=" + status + "]";
	}
	/**
	 * Methode hashCode.
	 * @return Un entier correspondant à la hashCode générée.
	 * @see Cellule
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + abscisse;
		result = prime * result + ordonnee;
		return result;
	}
	/**
	 * Méthode equals.
	 * @return Vrai ou Faux selon le teste d'égalité des deux objets.
	 * @see Cellule
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cellule other = (Cellule) obj;
		if (abscisse != other.abscisse)
			return false;
		if (ordonnee != other.ordonnee)
			return false;
		return true;
	}
	/**
	 * Getter de l'abscisse de la cellule vivante. 
	 * @return L'abscisse de la cellule vivante.
	 * @see Cellule#abscisse
	 */
	public int getAbscisse() {
		return abscisse;
	}
	/**
	 * Setter de l'abscisse de la cellule vivante.
	 * @param x
	 * 			L'abscisse de la cellule vivante.
	 * @see Cellule#abscisse
	 */
	public void setAbscisse(int x) {
		this.abscisse = x;
	}
    /**
     * Getter de l'ordonnée de la cellule vivante.
     * @return L'ordonnée de la cellule vivante.
     * @see Cellule#ordonnee
     */
	public int getOrdonnee() {
		return ordonnee;
	}
	/**
	 * Setter de l'ordonnée de la cellule vivante.
	 * @param ordonnee 
	 * 			L'ordonnée de la cellule vivante.
	 * @see Cellule#ordonnee
	 */
	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}
	/**
	 * Getter du nombre de voisin vivant de la cellule.
	 * @return Un entier coorrespondant au nombre de voisin vivant de la cellule.
	 * @see Cellule
	 */
	public int getNombreVoisin() {
		return nombreVoisin;
	}
	/**
	 * Setter du nombre du nombre de voisin vivant de la cellule.
	 * @param nombreVoisin
	 * 				Nombre de voisin de la cellule.
	 */
	public void setNombreVoisin(int nombreVoisin) {
		this.nombreVoisin = nombreVoisin;
	}
	/**
	 * Getter du status de la cellule .
	 * @return Le status de la cellule 
	 * @see Cellule
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * Setter du status de la cellule.
	 * @param status
	 * 				Status de la cellule.
	 * @see Cellule
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

}

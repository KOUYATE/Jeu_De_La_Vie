package testStructureDeDonnee;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import structureDeDonnee.Cellule;
import structureDeDonnee.PlateauFini;

public class PlateauFiniTest {
	protected PlateauFini plateau ;

	@Before
	public void setUp() throws Exception {
		plateau = new PlateauFini();
		plateau = new PlateauFini("Dossier_Teste/teste.LIF");
		
	}

	@After
	public void tearDown() throws Exception {
	}
/*
 * Permet de tester  le constructeur de notre PlateauFini
 */
	@Test public void testPlateauFini(){
		//teste des attributs de la classe à la construction de l'objet
		plateau=new PlateauFini();
		assertEquals(plateau.getTailleCelluleVivante(),0);
		assertEquals(plateau.getTailleRegleMort(),0);
		assertEquals(plateau.getTailleRegleVie(),0);
		assertTrue(plateau.getMaxAbscisse()==plateau.getMaxOrdonnee()
					&& plateau.getMinAbscisse()==plateau.getMinOrdonnee()
					&& plateau.getMinOrdonnee()==0);
	}
	
	/*
	 * Nous permet de savoir si notre methode ajouterCellule marche
	 */
	@Test
	public void testAjouterCellule() {
		Cellule c1 = new Cellule(1,1,-1,true);
		plateau.ajouterCellule(c1);
		//teste que la cellule n'a pas été ajouter dans la liste des cellules vivantes
		//à cause de l'effet de bord .
		assertTrue(plateau.contains(c1));
	}

	/*
	 * Nous permet de savoir si notre méthode ajouterRegleVie fonctionnne
	 */
	@Test
	public void testAjouterRegleVie() {
		plateau.ajouterRegleVie(3);
		assertTrue(plateau.containsRegleVie(3));
	}

	/*
	 * Nous permet de savoir si notre méthode ajouterregleMort fonctionne
	 */
	@Test
	public void testAjouterRegleMort() {
		plateau.ajouterRegleMort(2);
		plateau.ajouterRegleMort(3);
		assertTrue(plateau.containsRegleMort(2));
		assertTrue(plateau.containsRegleMort(3));

	}
	

	@Test
	public void testAjouterElement() {
		ArrayList<Cellule> l1 = new ArrayList<Cellule>();
		ArrayList<Cellule> l2 = new ArrayList<Cellule>();
		Cellule c1 = new Cellule(0,0,-1,true);
		Cellule c2 = new Cellule(0,1,-1,true);
		l1.add(c1);
		l2.add(c2);
		ArrayList<Cellule> somme = plateau.ajouterElement(l1, l2);
		//on teste si la liste somme contient l'ensemble des élements de l1 et l2
		assertEquals(somme.size(),2);
		assertTrue(somme.contains(c1));
		assertTrue(somme.contains(c2));
	}

	/*
	 * Permet de tester notre méthode close
	 */
	@Test
	public void testClone() {
		assertNotSame(plateau.clone(),plateau);
	}
	/*
	 * Nous permet de savoir si notre méthode contains  fait son boulo
	 */

	@Test
	public void testContains() {
		assertTrue(plateau.contains(new Cellule(0, 0, 3, false)));
	}

	/*
	 * Permet de tester la méthode containsRegleMort
	 */
	@Test
	public void testContainsRegleMort() {
		assertTrue(plateau.containsRegleMort(2));
		assertTrue(plateau.containsRegleMort(3));
	}

	/*
	 * Permet de tester la méthode containsRegleVie
	 */
	@Test
	public void testContainsRegleVie() {
		//les règles du jeu sont vides d'ou la méthode contains doit rétourner false
		assertTrue(plateau.containsRegleMort(3));
	}
/*
 * Nous permet de savoir que notre méthode estVide marche
 */
	@Test
	public void testEstVide() {
		assertFalse(plateau.estVide());;
	}
/*
 * Permet de savoir que la methode evoluer fait ce qu'on attend d'elle
 */
	@Test
	public void testEvoluer() {
		plateau.evoluer();
		assertFalse(plateau.estVide());
		
	}

/*
 * Nous permet de savoir si effectivement la méthode getcellule retourne bien une cellule
 */
	@Test
	public void testGetCellule() {
		Cellule c=new Cellule(0, 0, -1, true);
		assertEquals(plateau.getCellule(0), c);
	}
/*
 * Nous permet de savoir si effectivement la méthode getcelluleVivante retourne bien l'ensemble des cellules vivantes
 */
	@Test
	public void testGetCelluleVivante() {
		Iterator<Cellule> it=plateau.getIterateurCellule();
		int i=0;
		while(it.hasNext()){
			assertTrue(plateau.getCellule(i).equals(it.next()));
			i++;
		}
		assertEquals(plateau.getTailleCelluleVivante(),i);
	}
	

	@SuppressWarnings("unchecked")
	@Test
	/*
	 * permet de savoir si la méthode getIterateurCellule fait bien son travail retournée un iterator sur les cellules
	 */
	public void testGetIterateurCellule() {
		assertNotSame(plateau.getIterateurCellule(),((ArrayList<Cellule>)(plateau.getCelluleVivante())).iterator());
	}
/*
 * permet de savoir la taille de la liste des cellules vivantes 
 */
	@Test
	public void testGetTailleCelluleVivante() {
		assertEquals(plateau.getTailleCelluleVivante(),3);
	}
/*
 * Nous permet de savoir la taille de la liste de regle vie
 */
	@Test
	public void testGetTailleRegleVie() {
		assertEquals(plateau.getTailleRegleVie(),1);
	}
/*
 * Nous permet de savoir la taille de la liste de regle mort
 */
	@Test
	public void testGetTailleRegleMort() {
		assertEquals(plateau.getTailleRegleMort(),2);
	}
/*
 * permet de savoir si la méthode supprimerCellule fonctionne
 */
	@Test
	public void testSupprimerCellule() {
		Cellule c=new Cellule(0, 0, -1, true);
		assertTrue(plateau.supprimerCellule(c));
	}
/*
 * Permet de savoir si la lise de cellules vivantes est trée
 */
	@Test
	public void testTrierCellule() {
		plateau.trierCellule();
		assertEquals(plateau.getTailleCelluleVivante(),3);
		//teste si les cellules sont triés
		assertEquals(plateau.getCellule(0).compareTo(plateau.getCellule(1)),-1);
		assertEquals(plateau.getCellule(1).compareTo(plateau.getCellule(2)),-1);
	}

}

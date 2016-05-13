package testJeuDeLaVie;
import static org.junit.Assert.*;
import java.io.IOException;
import jeuDeLaVie.LectureJeuDeLaVie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import exception.LectureException;
import structureDeDonnee.Cellule;
import structureDeDonnee.PlateauInfini;

public class LectureJeuDeLaVieTest {
	LectureJeuDeLaVie lecture;
	protected PlateauInfini plateau;
	@Before
	public void setUp() throws Exception {
		//initialisation d'une nouvelle matrice
		plateau = new PlateauInfini();			
	}

	@After
	public void tearDown() throws Exception {
	}
	/*
	 * Fonction qui teste si le jeu a bien été initialiser 
	 * a partir d'un fichier Au depart notre fichier contient 4 cellules 
	 *
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testLectureJeu() throws LectureException, IOException {
		lecture.LectureJeu("Dossier_Teste/teste_jeu.LIF", plateau);
		//teste si le fichier contient bien quatre cellule
		assertEquals(plateau.getTailleCelluleVivante(), 4);	
		//teste si la cellule en position 0 0 a bien été enregistré
		assertTrue(plateau.contains(new Cellule(0,0,-1,true)));	
		//teste si la cellule en position 0 1 a bien été enregistré
		assertTrue(plateau.contains(new Cellule(0,1,-1,true)));	
		//teste si la cellule en position 1 0 a bien été enregistré
		assertTrue(plateau.contains(new Cellule(1,0,-1,true)));	
		//teste si la cellule en position 1 1 a bien été enregistré
		assertTrue(plateau.contains(new Cellule(1,1,-1,true)));		
		plateau = new PlateauInfini();
		lecture.LectureJeu("Dossier_Teste/teste.LIF",plateau);
		try{
			//teste sur les exceptions au cas ou le fichier est introuvable	
			lecture.LectureJeu("fichier", plateau);					 
			fail("une exception doit être lever");			
		}catch(LectureException e){
			//teste que l'exception a étét bien lever
			assertTrue(true);										
		}
	}

	@SuppressWarnings("static-access")
	@Test
	public void testAjouterRegle() {
		String ligne = "#R 3/23";
		//ajout des regles du jeu 
		lecture.ajouterRegle(ligne, plateau);	
		
		//teste si la taille de la règle de mort est bien 2 vu qui qu'il doit contenir 2 et 3
		assertEquals(plateau.getTailleRegleMort(),2);		
		
		//teste si la taille de la règle de vie est bien 1 vu qu'il doit contenir 3 		
		assertEquals(plateau.getTailleRegleVie(),1);
		
		//verification que règle de mort contient bien 3
		assertTrue(plateau.containsRegleMort(3));	
		
		//verification que règle de mort contient bien 2 aussi
		assertTrue(plateau.containsRegleMort(2));		
		
		//verification que règle de vie contient 3
		assertTrue(plateau.containsRegleVie(3));					

	}

}

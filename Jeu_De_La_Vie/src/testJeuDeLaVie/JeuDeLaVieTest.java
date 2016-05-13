package testJeuDeLaVie;
import static org.junit.Assert.*;
import java.io.IOException;

import interface_.Matrice;
import jeuDeLaVie.JeuDeLaVie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exception.LectureException;
import structureDeDonnee.Cellule;
import structureDeDonnee.PlateauFini;
import structureDeDonnee.PlateauInfini;
public class JeuDeLaVieTest {
protected JeuDeLaVie  jeu;

	@Before
	public void setUp() throws Exception {
		PlateauInfini plateau=new PlateauInfini();
		plateau.ajouterCellule(new Cellule(0, 1, -1, true));
		jeu=new JeuDeLaVie(new PlateauInfini() );
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testJeuDeLaVieMatrice() {
		//teste du constructeur jeu de la vie.
		assertEquals(jeu.getPlateau().getClass(),PlateauInfini.class);
	}
	
@Test 
public void testJeuDeLaVie() throws LectureException, IOException{
	//teste du constructeur qui prend un nom de fichier en paramètre.
	Matrice matrice= new PlateauFini();
	jeu=new JeuDeLaVie("Dossier_Teste/teste_jeu2.LIF", matrice);
	assertEquals(jeu.getPlateau().getClass(), PlateauFini.class);
	
}
	
	@Test
	public void testEvolutionSuivante() {
		//teste de l'evolution du jeu
		jeu.evolutionSuivante();
	 assertTrue (jeu.getPlateau().estVide());
	 }

	@Test
	public void testGetPlateau() {
		assertEquals(jeu.getPlateau().getClass(),PlateauInfini.class);
	}

	@Test
	public void testSetPlateau() {
	jeu.setPlateau(new  PlateauFini());
	assertTrue(jeu.getPlateau().getClass().equals( PlateauFini.class));
	}

}

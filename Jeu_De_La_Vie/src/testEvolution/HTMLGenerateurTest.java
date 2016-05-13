package testEvolution;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import jeuDeLaVie.HTMLGenerateur;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import structureDeDonnee.StructureDeDonneeFactory;
import exception.HTMLException;
import exception.LectureException;

public class HTMLGenerateurTest {
	protected HTMLGenerateur generateur;
	@Before
	public void setUp() throws Exception {
		int temps = 10;
		String nomPage = "Teste";
		generateur = new HTMLGenerateur("Dossier_Teste",temps,
				StructureDeDonneeFactory.PLATEAU_INFINI,nomPage);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHTMLGenerateur() {
		//teste des attributs de la classe HTMLGenerateur
		assertEquals(generateur.getTypePlateau(),StructureDeDonneeFactory.PLATEAU_INFINI);
		assertEquals(generateur.getBalise(),"");
		assertEquals(generateur.getDossier(),"Dossier_Teste");
		assertEquals(generateur.getTemps(),10);
		
	}

	@Test
	public void testAnalyser() throws HTMLException, LectureException, IOException {
		int temps = 10;
		//teste avec un dossier comportant des fichiers au format lif
		String s = generateur.analyser("Dossier_Teste", temps);
		assertNotNull(s);
		//teste avec un dossier ne comportant aucun fichier au format lif
		try{
		 s = generateur.analyser("Dossier_Teste/Dossier_Vide", temps);
		 fail("Une exception doit être lévée");
		}catch(HTMLException e){
			
		}
		try{
			 s = generateur.analyser("FauxChemin", temps);
			 fail("Une exception doit être lévée");
		}catch(HTMLException e){
			
		}
		
	}

	@Test
	public void testGenerer() throws HTMLException, LectureException, IOException {
		String nomPage = "Teste";
		generateur.generer(nomPage);
		File page = new File(nomPage+".html");
		assertTrue(page.isFile());
	}


}

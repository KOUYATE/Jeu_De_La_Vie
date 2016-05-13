package testJeuDeLaVie;

import static org.junit.Assert.*;
import jeuDeLaVie.JeuDeLaVie;
import jeuDeLaVie.Simulation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import structureDeDonnee.Cellule;
import structureDeDonnee.PlateauFini;
import structureDeDonnee.PlateauInfini;

public class SimulationTest {
	Simulation simule;
	@Before
	public void setUp() throws Exception {
		PlateauInfini plateau = new PlateauInfini();
		plateau.add(new Cellule(0,0,-1,true));
		plateau.add(new Cellule(0,1,-1,true));
		plateau.add(new Cellule(0,2,-1,true));
		JeuDeLaVie jeu = new JeuDeLaVie(plateau);
		simule = new Simulation(3, jeu);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimulation() {
		//teste du constructeur de la classe simulation
		assertEquals(simule.getJeu().getPlateau().getClass(),PlateauInfini.class);
		assertEquals(simule.getDureeSimulation(),3);
	}

	@Test
	public void testSimuler() throws InterruptedException {

		simule.simuler();
	}

	@Test
	public void testGetJeu() {
		assertEquals(simule.getJeu().getPlateau().getClass(),PlateauInfini.class);
	}

	@Test
	public void testSetJeu() {
		JeuDeLaVie jeu = new JeuDeLaVie(new PlateauFini());
		simule.setJeu(jeu);
		assertEquals(simule.getJeu().getPlateau().getClass(),PlateauFini.class);
		
		
	}

	@Test
	public void testGetDureeSimulation() {
		assertEquals(3, simule.getDureeSimulation());
	}

	@Test
	public void testSetDureeSimulation() {
		simule.setDureeSimulation(2);
		assertEquals(simule.getDureeSimulation(),2);
	}

}

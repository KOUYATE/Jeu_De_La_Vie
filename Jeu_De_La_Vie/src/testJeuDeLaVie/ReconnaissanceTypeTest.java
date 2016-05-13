package testJeuDeLaVie;

import static org.junit.Assert.*;
import jeuDeLaVie.JeuDeLaVie;
import jeuDeLaVie.ReconnaissanceType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import structureDeDonnee.Cellule;
import structureDeDonnee.PlateauInfini;


public class ReconnaissanceTypeTest {
	protected ReconnaissanceType type;
	@Before
	public void setUp() throws Exception {
		//initialisation de l'objet reconnaissanceType 

		PlateauInfini plateau = new PlateauInfini();
		plateau.ajouterCellule(new Cellule(0,0,-1,true));
		plateau.ajouterCellule(new Cellule(0,1,-1,true));
		plateau.ajouterCellule(new Cellule(0,2,-1,true));
		plateau.ajouterRegleMort(3);
		plateau.ajouterRegleMort(2);
		plateau.ajouterRegleVie(3);
		type = new ReconnaissanceType(10, plateau);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReconnaissanceType() {
		assertTrue(type.isInconnu());
		assertFalse(type.isOscillation());
		assertFalse(type.isStabilite());
		assertFalse(type.isVaisseau());
		assertFalse(type.isMort());
	}

	@Test
	public void testCalculerTypeEvolution() {
		type.calculerTypeEvolution(10);
		PlateauInfini plateau = new PlateauInfini();
		plateau.ajouterCellule(new Cellule(0,0,-1,true));
		type = new ReconnaissanceType(10,plateau);
		type.calculerTypeEvolution(10);
		
		PlateauInfini plateau2 = new PlateauInfini();
		
		plateau2.ajouterRegleMort(3);
		plateau2.ajouterRegleMort(2);
		plateau2.ajouterRegleVie(3);
		
		plateau2.ajouterCellule(new Cellule(0, 1, -1, true));
		plateau2.ajouterCellule(new Cellule(1, 2, -1, true));
		plateau2.ajouterCellule(new Cellule(2, 0, -1, true));
		plateau2.ajouterCellule(new Cellule(2, 1, -1, true));
		plateau2.ajouterCellule(new Cellule(2, 2, -1, true));
		
		
		
		ReconnaissanceType type2 =new ReconnaissanceType(100, plateau2);
		type2.calculerTypeEvolution(10);
		
		assertTrue(type2.isVaisseau());
		assertFalse(type2.isMort());
		assertFalse(type2.isStabilite());
		assertFalse(type2.isOscillation());
		assertFalse(type2.isInconnu());
		
		PlateauInfini plateau3  = new PlateauInfini();
		plateau3.ajouterRegleMort(3);
		plateau3.ajouterRegleMort(2);
		plateau3.ajouterRegleVie(3);
		plateau3.ajouterCellule(new Cellule(0, 1, -1, true));
		plateau3.ajouterCellule(new Cellule(0, 2, -1, true));
		plateau3.ajouterCellule(new Cellule(0, 3, -1, true));
		plateau3.ajouterCellule(new Cellule(0, 4, -1, true));
		plateau3.ajouterCellule(new Cellule(0, 5, -1, true));
		
		ReconnaissanceType type3 = new ReconnaissanceType(2, plateau3);
		type3.calculerTypeEvolution(3);
		assertTrue(type3.isInconnu());
		
	}

	@Test
	public void testEvoluerConfiguration() {
		type.evoluerConfiguration();
		assertFalse(type.getConfiguration1().getPlateau().getCelluleVivante().equals(
					type.getConfiguration2().getPlateau().getCelluleVivante()));
		
	}

	@Test
	public void testEstOscillation() {

		assertTrue(type.estOscillation());
	}

	@Test
	public void testEstMort() {
		type = new ReconnaissanceType(10, new PlateauInfini());
		assertTrue(type.estMort());
	}

	@Test
	public void testEstVaisseau() {
		assertTrue(type.estVaisseau());
		
	}

	@Test
	public void testDistance() {
		@SuppressWarnings("unused")
		double b = type.distance(new Cellule(1,1,-1,true), new Cellule(1,1,-1,true));
		
	}

	@Test
	public void testGetConfiguration1() {
		assertEquals(type.getConfiguration1().getClass(),JeuDeLaVie.class);
	}

	@Test
	public void testSetConfiguration1() {
		JeuDeLaVie j = new JeuDeLaVie(new PlateauInfini());
		type.setConfiguration1(null);
		assertNull(type.getConfiguration1());
		type.setConfiguration1(j);
		assertNotNull(type.getConfiguration1());
		
	}
	@Test
	public void testGetConfiguration2() {
		assertEquals(type.getConfiguration2().getClass(),JeuDeLaVie.class);
	}

	@Test
	public void testSetConfiguration2() {
		JeuDeLaVie j = new JeuDeLaVie(new PlateauInfini());
		type.setConfiguration2(null);
		assertNull(type.getConfiguration2());
		type.setConfiguration2(j);
		assertNotNull(type.getConfiguration2());
	}

	@Test
	public void testGetPeriodeFinal() {
		assertEquals(type.getPeriodeFinal(),0);
	}

	@Test
	public void testSetPeriodeFinal() {
		type.setPeriodeFinal(1);
		assertEquals(type.getPeriodeFinal(),1);
	}

	@Test
	public void testGetTailleQueue() {
		assertEquals(type.getTailleQueue(),0);
	}

	@Test
	public void testSetTailleQueue() {
		assertEquals(type.getTailleQueue(),0);
	}

	@Test
	public void testIsOscillation() {
		type.setOscillation(true);
		assertTrue(type.isOscillation());
	}

	@Test
	public void testSetOscillation() {
		type.setOscillation(true);
		assertTrue(type.isOscillation());
	}

	@Test
	public void testIsStabilite() {
		type.setStabilite(true);
		assertTrue(type.isStabilite());
	}

	@Test
	public void testSetStabilite() {
		type.setStabilite(true);
		assertTrue(type.isStabilite());
	}

	@Test
	public void testIsMort() {
		type.setMort(true);
		assertTrue(type.isMort());
	}

	@Test
	public void testSetMort() {
		type.setMort(true);
		assertTrue(type.isMort());
	}

	@Test
	public void testIsVaisseau() {
		type.setVaisseau(true);
		assertTrue(type.isVaisseau());
	}

	@Test
	public void testSetVaisceau() {
		type.setVaisseau(true);
		assertTrue(type.isVaisseau());
	}

	@Test
	public void testIsInconnu() {
		type.setInconnu(true);
		assertTrue(type.isInconnu());
	}

	

	@Test
	public void testToString() {
		String s="Type inconnu";
		assertTrue(type.toString().equals(s));
		type.setInconnu(false);
		type.setMort(true);
		s="Type d'évolution : \n- Mort.\n- Stable.\n- Oscillation.\n- Vaisseau \n" +
				"Période : "+0+" \nTaille de la queue : "+0+"\nDéplacement (ligne,colonne) = ("+
				0+","+0+")";
		assertTrue(type.toString().equals(s));
		type.setMort(false);
		type.setStabilite(true);
		s = "Type d'évolution : \n- Stable.\n- Oscillation.\n- Vaisseau. \n" +
				"Période : "+0+" \nTaille de la queue : "+0+"\nDéplacement (ligne,colonne) = ("+
				0+","+0+")";
		assertTrue(type.toString().equals(s));
		type.setStabilite(false);
		type.setOscillation(true);
		s = "Type d'évolution : \n- Oscillation.\n- Vaisseau. \n" +
				"Période : "+0+" \nTaille de la queue : "+0+"\nDéplacement (ligne,colonne) = ("+
				0+","+0+")";
		assertTrue(type.toString().equals(s));
		type.setOscillation(false);
		type.setVaisseau(true);
		s = "Type d'évolution : \n- Vaisseau  \n" +
				"Période : "+0+" \nTaille de la queue : "+0+"\nDéplacement (ligne,colonne) = ("+
				0+","+0+")";
		assertTrue(type.toString().equals(s));
		
	}

}

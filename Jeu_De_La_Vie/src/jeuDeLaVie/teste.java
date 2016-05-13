package jeuDeLaVie;
import java.io.IOException;
import exception.HTMLException;
import exception.LectureException;
import structureDeDonnee.PlateauCirculaire;
import interface_.Matrice;

public class teste {
public static void main(String []args) throws HTMLException, LectureException, IOException{
	Matrice plateau = new PlateauCirculaire("Dossier_Teste/ADDER.lif");
	@SuppressWarnings("unused")
	JeuDeLaVie jeu = new JeuDeLaVie(plateau);
	@SuppressWarnings("unused")
	HTMLGenerateur html = new HTMLGenerateur("Dossier_Teste", 1000, 2, "ess");
}

}

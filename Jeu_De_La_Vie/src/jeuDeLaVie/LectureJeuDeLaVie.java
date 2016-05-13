package jeuDeLaVie;

import interface_.Matrice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import exception.LectureException;
import structureDeDonnee.Cellule;
import structureDeDonnee.PlateauCirculaire;
import structureDeDonnee.PlateauFini;
import structureDeDonnee.PlateauInfini;

/**
 * <b>LectureJeuDeLaVie est la classe permettant d'initialiser un plateau du jeu de la vie</br>
 * à partir d'un fichier au format LIF.</b>
 * @see JeuDeLaVie
 * @author Cissé,Diallo,Kouyate,Melaine
 *
 */

public class LectureJeuDeLaVie {
	/**
	 * Initialise le plateau du jeu (Structure de donnée) à partir d'un fichier au format LIF.
	 * @param nomFichier
	 * 				Un nom de fichier LIF(fichier comportant le jeu de la vie).
	 * @param plateau
	 * 				Une structure de donnée répresentant un plateau du jeu de la vie.
	 * @throws LectureException 
	 * 				Lève une exception si le nom de fichier passer en paramètre n'existe pas.
	 * @throws IOException 
	 * @see Matrice
	 * @see PlateauFini
	 * @see PlateauInfini
	 * @see PlateauCirculaire
	 * 
	 */
	public static void LectureJeu(String nomFichier,Matrice plateau) throws LectureException, IOException{
		BufferedReader reader = null;
		File fichier=new File(nomFichier);
		/*
		 * on initialise les coordonnées abscisse et ordonnée des cellules à 0
		 * au début de la lecture du fichier.
		 */
		int abscisse=0;
		int ordonnee=0;
		String line = null; 
		//Scanner pour lire les entiers du fichier
		Scanner scanner  = null;
		//teste que le fichier existe et qu'il est au format LIF
		if( fichier.isFile() && fichier.getAbsolutePath().endsWith(".lif")
				|| fichier.isFile() && fichier.getAbsolutePath().endsWith(".LIF")){
			//initialisation du reader pour lire le fichier 
			reader = new BufferedReader(new FileReader(fichier));
			
				while((line = reader.readLine())!=null){
					/*
					 * teste si la ligne courante est un bloque,récupere les deux entiers 
					 * du bloque et met à jour la valeur du coordonnée abscisse et ordonnee.
					 */
					if(line.matches("^#P[\\s0-9-]+")){
						line = line.replaceAll("[^0-9\\s-]", "");
						scanner = new Scanner(line);
						abscisse = scanner.nextInt();
						ordonnee = scanner.nextInt();
						
					} 
					/*
					 * teste si la ligne courante du fichier est une règle, ajoute ces règles 
					 * au plateau du jeu.
					 */
					else if (line.matches("^#R[\\s0-9]+/[0-9]+$")){

						ajouterRegle(line,plateau);

					} 
					/*
					 * teste si la ligne courante du fichier est une chaine de cellule vivante, ajoute les cellules
					 * vivantes dans l'ensemble des cellules vivantes du plateau du jeu.
					 */
					else if (line.matches("^[.*]+")){

						int i = 0;
						int tmp=ordonnee;
						while(i<line.length()){
							if(line.charAt(i)=='*'){
								plateau.add(new Cellule(abscisse,ordonnee,-1,true));
							}
							ordonnee++;
							i++;
						}
						abscisse++;
						ordonnee=tmp;

					} 
					/*
					 * teste si la ligne courante du fichier definie une règle normal du jeu de la vie,
					 * ajoute les règles normales au plateau du jeu de la vie.
					 */
					else if (line.matches("^#N$")){

						plateau.ajouterRegleVie(3);
						plateau.ajouterRegleMort(2);
						plateau.ajouterRegleMort(3);
					}
				}
			//on trie l'ensemble des cellules vivantes du plateau
			plateau.trierCellule();
		} else {
			throw new LectureException(nomFichier + " = n'existe pas ou le format est incorrecte ");
		}
		/*
		 * si les règles du jeu n'ont pas été renseigner dans le fichier on ajoute
		 * les règles normales du jeu de la vie.
		 */
		if(plateau.getTailleRegleMort()==0){
			plateau.ajouterRegleMort(2);
			plateau.ajouterRegleMort(3);
		}
		if(plateau.getTailleRegleVie()==0){
			plateau.ajouterRegleVie(3);
		}
	}
	
	/**
	 * Ajoute les règles dans un plateau donner en paramètre </b>
	 * à partir d'une chaine de caractère passé en paramètre. 
	 * @param line
	 * 				Une chaine de caractère.
	 * @param plateau
	 * 				Un plateau du jeu de la vie dans le quel les règles sont ajoutés.
	 * @see JeuDeLaVie
	 * 				
	 */
	public static void ajouterRegle(String line, Matrice plateau){
		//on remplace tous les caractères sauf les règles séparer par un /
		line = line.replaceAll("[^0-9/]", "");
		//on récupere les règles dans un stringTokenizer
		StringTokenizer regle = new StringTokenizer(line,"/");
		if(regle.countTokens()==2){
			String k = regle.nextToken();
			int i=0;
			//on ajoute les règle de vie des cellules 
			while(i<=k.length()-1){
				plateau.ajouterRegleVie(Integer.parseInt(k.charAt(i)+""));
				i++;
			}
			k = regle.nextToken();
			i=0;
			//on ajoute les règles de mort des cellules vivantes
			while(i<=k.length()-1){
				plateau.ajouterRegleMort(Integer.parseInt(k.charAt(i)+""));
				i++;
			}
		}
	}
}
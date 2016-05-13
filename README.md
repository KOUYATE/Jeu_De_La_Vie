# Jeu de la vie
Ce projet est un jeu « Jeu de la vie » réalisé en JAVA. <br>Il met en œuvre plusieurs design Pattern comme le Pattern Factory ou Créateur pour la création du plateau de jeu, le Pattern Singleton pour l’instance du jeu de la vie…<br>
Ce programme met un accent particulier sur les structures de données utilisés, le temps d’exécution  et la performance des algorithmes de calcul mis en œuvre dans le jeu. Les tests unitaires pour valider les fonctionnalités du jeu font aussi partie intégrante de ce projet.
<h1>Fonctionnalités : </h1>
<li>Initialiser le plateau de jeu avec des fichier au format LIF</li>
<li>Simulation du jeu de la vie en console </li> 
<li>Simuler le jeu de la vie  à une durée déterminer</li> 
<li>Plusieurs plateau de jeu intégrer (jeu de la vie en monde infini, monde fini, monde circulaire)</li>
<li>Calculer le type d’évolution du jeu avec ses caractéristiques</li>
<li>Générer des rapports au format HTML pour tous les jeux contenu dans un dossier</li>
<h2>Commandes : </h2>
JEU DE LA VIE : OPTIONS ET COMMANDES DU PROGRAMME

Afficher les noms et prénoms des concepteurs du jeu :<br>&emsp;&emsp;
	java -jar JeuDeLaVie.jar -name

Afficher la liste des options du programme :<br>&emsp;&emsp;
	java -jar JeuDeLaVie.jar -h

Exécuter une simulation du jeu d'une durée d :<br>&emsp;&emsp;	java -jar JeuDeLaVie.jar -s d fichier.lif

Calculer le type d'évolution du jeu avec ses caracteristiques <br>&emsp;&emsp;
max répresente la durée maximal pour déduire les résultats du calcule :<br>&emsp;&emsp;
	java -jar JeuDeLaVie.jar -c max fichier.lif

Calculer le type d'évolution de tous les jeux contenus dans le dossier passé <br>&emsp;&emsp;
en paramètre et affiche les résultats sous forme d'un fichier HTML :<br>&emsp;&emsp;
	java -jar JeuDeLaVie.jar -w max dossier

Pour les même actions dans un Plateau Fini ou Circulaire : <br>&emsp;&emsp;
Taper la commande correspodant à votre action parmis les commandes çi-dessu suivi du type de plateau :<br>&emsp;&emsp;
	1 = Plateau Infini
	2 = Plateau Fini
	3 = Plateau Circulaire

Exemple = Pour éffectuer une simulation du jeu dans un plateau fini d'une durée de 10s <br>&emsp;&emsp;
	java -jar JeuDeLaVie.jar -s 10 fichier.lif 2

/* Benjamin Jedrocha & Kevin Leblanc */

#include<graph.h>
#include<stdio.h>
void delw(){ /* Procedure efface ecran */
        ChargerImageFond("./background/background.jpg"); /* background du menu */
}
/* Affiche les choix Rejouer ou Quitter */
void displayReplay(int k){
	char tabk[100];

	InitialiserGraphique();
	CreerFenetre(0,0,240,320);
	delw();
	
	EcrireTexte(70,30,"Bravo !",2); 
	EcrireTexte(15,50,"Vous avez termine en :", 1);

	sprintf(tabk,"%09d",k);
	EcrireTexte(80,88,tabk,1);
	
	ChargerImage("./img/bluebutton.png",45,127,0,0,150,45);
  EcrireTexte(54,160,"Rejouer ?",2);
	
	ChargerImage("./img/bluebutton.png",45,207,0,0,150,45);
  EcrireTexte(55,240,"Quitter ?",2);
}

/* Affiche les choix des différents puzzles */
void puzzles(){

  EcrireTexte(5,60,"Choisir un puzzle",2);

  EcrireTexte(100,115,"LOUP",1);
  ChargerImage("./img/minLoup.png",35,120,0,0,185,100);

  EcrireTexte(68,275,"MARMOTTE", 1);
  ChargerImage("./img/minMarmotte.png",62,280,0,0,119,100);

  EcrireTexte(70,435,"PAPILLON", 1);
  ChargerImage("./img/minPapillon.png",45,440,0,0,153,100);

  EcrireTexte(15,585,"Retour (esc)", 1);

}

/* Affiche le choix des colonnes/lignes */
void lines(void){

        EcrireTexte(295,60,"Colonnes",2);
        EcrireTexte(400,77,"(rouge)",1);
        EcrireTexte(350,90,"x",2);
        EcrireTexte(310,120,"Lignes",2);
        EcrireTexte(410,120,"(vert)",1);

        ChargerImage("./img/3.png",240,140,0,0,100,100);
        ChargerImage("./img/4.png",240,280,0,0,100,100);
        ChargerImage("./img/5.png",240,420,0,0,100,100);
        ChargerImage("./img/6.png",360,140,0,0,100,100);
        ChargerImage("./img/7.png",360,280,0,0,100,100);
        ChargerImage("./img/8.png",360,420,0,0,100,100);
}

/* Affiche le menu d'aide */
void help(void){
        
        EcrireTexte(175,61,"Aide :",2);
        
        EcrireTexte(40,100,"Le taquin est un jeu solitaire en forme",1);
        EcrireTexte(40,125,"de damier.",1);
        EcrireTexte(40,150,"Il est compose entre 8 et 63 petites images",1);
        EcrireTexte(40,175,"qui glissent dans un cadre prevu pour 9 a 64",1);
        EcrireTexte(40,200,"images.",1);
        EcrireTexte(40,225,"Il consiste a reconstituer l'image originale a",1);
        EcrireTexte(40,250,"partir d'une configuration initiale quelconque.",1);

        EcrireTexte(40,300,"Pour vous deplacer dans les menus utilisez :",1);
        
				EcrireTexte(55,325,"<Fleches Directionnelles>",1);
        ChargerImage("./help/img/arrow.png",280,305,0,0,100,67);
        
				EcrireTexte(55,395,"Entrer pour confirmer la selection",1);
        ChargerImage("./help/img/enter.png",365,370,0,0,61,88);    
        
				EcrireTexte(55,455,"Esc pour Annuler/Quitter",1);
        ChargerImage("./help/img/esc.png",290,430,0,0,40,40);      
        
				EcrireTexte(55,500,"Ou bien utilisez la souris.",1);

        EcrireTexte(40,550,"Amusez-vous bien !",1);

        EcrireTexte(15,585,"Retour (esc)",1);
}

/* Affiche le menu */
void menu(void){

  EcrireTexte(175,60,"Taquin !",2);
	
  ChargerImage("./img/bluebutton.png",58,115,0,0,150,45);
  EcrireTexte(83,150,"Jouer ?",2);
	
  ChargerImage("./img/bluebutton.png",58,190,0,0,150,45); 
  EcrireTexte(85,225,"Fermer", 2);
  
  ChargerImage("./img/bluebutton.png",58,265,0,0,150,45);
  EcrireTexte(83,300,"Regles", 2);
  
  EcrireTexte(21,380,"Utiliser les touches directionnelles, ou la souris,",1);
  EcrireTexte(21,400,"pour vous deplacer.",1);
  EcrireTexte(21,420,"Appuyer sur Entree ou cliquer pour valider.", 1);

}

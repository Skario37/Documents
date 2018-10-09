/* Benjamin Jedrocha & Kevin Leblanc */

#include<stdio.h>
#include<graph.h>
#include<stdlib.h>
#include "jeu.h"
#include "menu.h"

int main(void){
	/* Initialisation des variables */
	char tabSelect[3]; /* 
			      tabSelect[1] = 'n img'
			      tabSelect[2] = 'n colonnes'
			      tabSelect[3] = 'n lignes'
						*/
	int sel = -1, k;
	/* Fin initialisation des variables */
	
	Menu:	

	/* Initialisation du graph */
	InitialiserGraphique();
		
	/* Creation de la fenetre et appel des fonctions menu() et menuPuzzle */
	CreerFenetre(0,0,480,640);
	
	/* Debut du programme boucle sans fin */
	while(1){
  	/* Premier menu */
		delw(); /* Nettoie l'écran en positionnant l'image de fond par dessus */
		menu();	/* Affiche les choix : Jouer, Quitter, Regles */ 
		sel = carrerouge(0); /* Selection du choix, argument indique dans quel menu on se trouve */ 
	
		if(sel == 0){ /* Choix Jouer */
			
			sel = -1; /* Valeur par defaut */	
			while(1){
				/* Second menu */	
				delw();		
				puzzles(); /* Affichage des puzzles */
				tabSelect[0] = carrerouge(1); /* Selection du puzzle, argument indique dans quel menu on se trouve */ 

				if(tabSelect[0] == 6){ /* Si 'esc' est presse retour au menu precedant */
					break;
				}else if(tabSelect[0] >= 0 && tabSelect[0] <= 2){
					while(1){
						/* Troisieme menu (selection colonne) */
						lines(); /* Affichage des choix de lignes/colonnes */	
						tabSelect[1] = carrerouge(2); /* Selection du nombre de colonnes*/

						if(tabSelect[1] == 6){ /* Si 'esc' est presse retour a la selection du puzzle */
							break;
						}else if(tabSelect[1] >= 0 && tabSelect[1] <= 5){
							while(1){
								/*Troisieme menu (selection ligne) */
								tabSelect[2] = carrerouge(3); /* Selection du nombre de lignes */

								if(tabSelect[2] == 6){

									break;
								}else if(tabSelect[2] >= 0 && tabSelect[2] <= 5){
									FermerGraphique();
									k = jeu(tabSelect[0], tabSelect[1], tabSelect[2]); /* Le jeu se lance */
									FermerGraphique();
									displayReplay(k); /* Demande si l'utilisateur souhaite rejouer ou quitter */
									sel = carrerouge(4);	
									if(sel == 1){ /* Quitte le programme */
										goto End;
									}else if(sel == 0){
										FermerGraphique();
										goto Menu;
									}
								}
							}
						}
					}		
				}
			}	
		}else if(sel == 1){ /* Si Close est choisit */
  		break; 	/* Quitte le programme */
		}else if(sel == 2){ /*Si Help est choisit */
			delw();
			help(); /* Affiche l'aide */

			
			do{


				if(SourisCliquee()){
					if(_X >= 13 && _X <= 93 && _Y >= 563 && _Y <= 588){  
						sel = 1;
					}
				}else if(ToucheEnAttente()){
					sel = Touche();
					switch(sel){
						case XK_Escape: 
							sel = 1;
							break;
						default:sel=0;
					}
				}
	 			/* Si 'esc' est presse retour au menu precedant */
			}while(sel != 1);
		}
	}
	End:
	FermerGraphique();
	return EXIT_SUCCESS;
}

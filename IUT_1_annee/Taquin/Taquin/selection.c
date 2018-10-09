/* Jedrocha Benjamin et Leblanc Kevin */
#include<graph.h>
#include "deplamenu.h"

#define CYCLE 10000L


/* Cette fonction prepare les donnees et l'affichage necessaires pour selectionner les differents choix du menu */
char carrerouge(char cmenu){
	int i;
	unsigned long suivant;
	couleur r;
	couleur b;
	couleur n;

	Table t; /* Variable t de type Table */
	t.cmenu = cmenu;
	t.z = 0; /* Par defaut */
	t.a = 0;

	r=CouleurParComposante(255,0,0); /* Couleur de selection */
 	b=CouleurParComposante(0,0,255); /* Couleur pour la deselection */
	n = 0; /* Couleur d'origine noir */

	ChoisirCouleurDessin(b);
	/* Definit tous les parametres pour l'affichage de la selection */
	if(t.cmenu == 0){
		t.x=58;
		t.y=115;
		t.xx=149;
		t.yy=44;
		t.dec=75;
	}else if(t.cmenu == 1){
		t.x=20;
		t.y=95;
		t.xx=200;
		t.yy=135;
		t.dec=160;
	}else if(t.cmenu == 4){
			t.x = 45;
			t.y = 127;
			t.xx = 149;
			t.yy = 44;
			t.dec = 80;
			r=CouleurParComposante(255,0,0);
			for(i=0; i<2; i++){
				DessinerRectangle(t.x, t.y + i*t.dec, t.xx, t.yy);
			}
	}else if(t.cmenu == 2 || t.cmenu == 3){
		t.x=235;
		t.y=135;
		t.xx=110;
		t.yy=110;
		t.dec=140;
			
		if(t.cmenu == 3){
     			t.x -= 2;
     			t.y -= 2;
     			t.xx += 4;
    			t.yy += 4;
		 	r=CouleurParComposante(0,255,0);
		}

		/* Cree les rectangles de deselection de la deuxieme colonne */ 
		for(i=0;i<3;i++){
			DessinerRectangle(t.x + 120, t.y + i * t.dec, t.xx, t.yy);
		
		}
	}

	/*La boucle ci-dessous sert a creer les rectangles bleues pour savoir qu'est ce que l'on peut selectionner avec les fleches directionnelles*/
	if(t.cmenu != 4){
		for(i=1; i<3; i++){ 
			DessinerRectangle(t.x, t.y + i*t.dec, t.xx, t.yy);
		}
	}

		/* Indique quel rectangle est selectionne par defaut */
	ChoisirCouleurDessin(r);
	DessinerRectangle(t.x, t.y, t.xx, t.yy);
	
	suivant = Microsecondes() + CYCLE;

	do{
		if(Microsecondes() > suivant){	
			suivant = Microsecondes() + CYCLE;
			if(ToucheEnAttente()){ /* Si une touche est pressee */
	
				t.a = Touche(); 
				ChoisirCouleurDessin(b);
				DessinerRectangle(t.x, t.y, t.xx, t.yy); /* Rectangle de deselection */	
				selclavier(&t); /* deplacement dans le menu au clavier */

			}else{
				SourisPosition();
				ChoisirCouleurDessin(b);
				DessinerRectangle(t.x, t.y, t.xx, t.yy);
				t.a = 1;
				selsouris(&t); /* deplacement dans le menu a la souris */
				if(!SourisCliquee()){
					t.a = 0;
				}
			}
			
			ChoisirCouleurDessin(r); /* Couleur du cadre de selection */
			DessinerRectangle(t.x, t.y, t.xx, t.yy); /* Taille du rectangle */
		}
	
  	}while(t.a != 1); /* Verifie si 'a' correspond aux touches 'Entrer', 'esc', ou un clic de la souris */
	
  ChoisirCouleurDessin(n); /* On remet par defaut la couleur */
  return t.z;
}


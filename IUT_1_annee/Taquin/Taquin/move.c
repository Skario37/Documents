/* Jedrocha Benjamin & Leblanc Kevin */

#include<graph.h>
#include<stdio.h>

/* Affiche le compteur */
void displayCompteur(int x, int y, int k){
	char tabk[100];
	sprintf(tabk, "%09d", k); /* Convertit k en chaine de caractere tabk */
	
  ChoisirCouleurDessin(CouleurParComposante(255,255,255));
  RemplirRectangle(x+10,y/2 - 30 - TailleSupPolice(1), TailleChaineEcran(tabk,1), TailleSupPolice(1)+TailleInfPolice(1)); /* Nettoie l'ancien nombre */

	ChoisirCouleurDessin(0); /* Noir */
	EcrireTexte(x+7,y/2 - 50,"Compteur",1);
  EcrireTexte(x+10, y/2 -30,tabk,1);	
	
}

/* Deplacement des tuiles au clavier */
int clavier(int a, int b, int x, int y, int e, int f, int *tab, char nomimg[100], int k){
	int posx, posy, ok, i, j;

	/* Determine la position en x et la position en y de la tuile blanche */
  for(i=0; i<b; i++){
  	for(j=0; j<a;j++){
     	if(tab[i*a + j]==0){
       	posx=j;
        posy=i;
        goto OUT; /* Sortie prematuree de la boucle */
      }
    }
  }
  OUT:
	ok = 1;
  while(ok){
		i=0;
    j=0;
		/* Calcul chaque permutation */
    switch(Touche()){
    	case XK_Left : /* Tuile de droite permute avec la tuile blanche */
        if(posx!=a-1){
        	tab[posx+posy*a]=tab[posx+1+posy*a];
          tab[posx+1+posy*a]=0;
          j=1;
          k+=1;
          RemplirRectangle(x+100+(posx+j)*f+5*posx+5*a/2+5, (posy+i)*e+5*posy+(5*b+10)/2, f, e);
          ChargerImage(nomimg, x+100+(posx)*f+posx*5+5*a/2, (posy)*e+5*posy+(5*b+10)/2, ((tab[posx+posy*a])%a)*f,((tab[posx+posy*a])/a)*e, f, e);
          ok = 0;
        }
        break;
      case XK_Down : /* Tuile du haut permute avec la tuile blanche */
       	if(posy!=0){
         	tab[posx+posy*a]=tab[posx+(posy-1)*a];
          tab[posx+(posy-1)*a]=0;
          i=-1;
			  	k+=1;
				  RemplirRectangle(x+100+(posx+j)*f+5*posx+5*a/2, (posy+i)*e+5*posy+(5*b+10)/2-5, f, e);
          ChargerImage(nomimg, x+100+(posx)*f+posx*5+5*a/2, (posy)*e+5*posy+(5*b+10)/2, ((tab[posx+posy*a])%a)*f,((tab[posx+posy*a])/a)*e, f, e);
          ok = 0;
        }
        break;
      case XK_Right : /* Tuile de gauche permute avec la tuile blanche */
        if (posx!=0){ 
      	  tab[posx+posy*a]=tab[posx-1+posy*a];
          tab[posx-1+posy*a]=0;
          j=-1;
          k+=1;
          RemplirRectangle(x+100+(posx+j)*f+5*posx+5*a/2-5, (posy+i)*e+5*posy+(5*b+10)/2, f, e);
          ChargerImage(nomimg, x+100+(posx)*f+posx*5+5*a/2, (posy)*e+5*posy+(5*b+10)/2, ((tab[posx+posy*a])%a)*f,((tab[posx+posy*a])/a)*e, f, e);
          ok = 0;
        }
        break;
			case XK_Up : /* Tuile du bas permute avec la tuile blanche */
        if(posy!=b-1){
        	tab[posx+posy*a]=tab[posx+(posy+1)*a];
          tab[posx+(posy+1)*a]=0;
          i=1;
          k+=1;
          RemplirRectangle(x+100+(posx+j)*f+5*posx+5*a/2, (posy+i)*e+5*posy+(5*b+10)/2+5, f, e);
          ChargerImage(nomimg, x+100+(posx)*f+posx*5+5*a/2, (posy)*e+5*posy+(5*b+10)/2, ((tab[posx+posy*a])%a)*f,((tab[posx+posy*a])/a)*e, f, e);
          ok = 0;
        }
        break;
		}
	}
	return k;
}

/* Deplacement des tuiles avec la souris */
int souris(int a, int b, int x, int y, int e, int f, int* tab, char nomimg[100], int k){
	int posx, posy, i, j;
		/* Determine la position en x et la position en y de la tuile blanche */
		for(i=0; i<b; i++){
    	for(j=0; j<a;j++){
       	if(tab[i*a + j]==0){
         	posx=j;
          posy=i;
          goto OUT; /* On sort prematurement de la boucle */
        }
      }
    }
    OUT:
	/* Calculs de la position de la souris pour les deplacments */
	if(_X >= x+100+posx*f+5*posx+5*a/2 && _X <= x+100+posx*f+5*posx+5*a/2+f && _Y >= posy*e+5*posy+(5*b+10)/2+e && _Y <= posy*e+5*posy+(5*b+10)/2+2*e){ /* Tuile du BAS */
		if(posy!=b-1){
    	tab[posx+posy*a]=tab[posx+(posy+1)*a];
      tab[posx+(posy+1)*a]=0;
      i=1;
      k+=1;
      RemplirRectangle(x+100+(posx+j)*f+5*posx+5*a/2-posx*f, (posy+i)*e+5*posy+(5*b+10)/2+5, f, e);
      ChargerImage(nomimg, x+100+(posx)*f+posx*5+5*a/2, (posy)*e+5*posy+(5*b+10)/2, ((tab[posx+posy*a])%a)*f,((tab[posx+posy*a])/a)*e, f, e);
		}
	}

	if(_X >= x+100+posx*f+5*posx+5*a/2+f && _X <= x+100+posx*f+5*posx+5*a/2+2*f && _Y >= posy*e+5*posy+(5*b+10)/2 && _Y <=posy*e+5*posy+(5*b+10)/2+e){ /* Tuile de DROITE */ 
		if(posx!=a-1){
    	tab[posx+posy*a]=tab[posx+1+posy*a];
      tab[posx+1+posy*a]=0;
      j=1;
      k+=1;
      RemplirRectangle(x+100+(posx+j)*f+5*posx+5*a/2+5, (posy+i)*e+5*posy+(5*b+10)/2-posy*e, f, e);
      ChargerImage(nomimg, x+100+(posx)*f+posx*5+5*a/2, (posy)*e+5*posy+(5*b+10)/2, ((tab[posx+posy*a])%a)*f,((tab[posx+posy*a])/a)*e, f, e);
		}
	}

	if(_X >= x+100+posx*f+5*posx+5*a/2 && _X <= x+100+posx*f+5*posx+5*a/2+f && _Y >= posy*e+5*posy+(5*b+10)/2-e && _Y <= posy*e+5*posy+(5*b+10)/2){ /* Tuile du HAUT */
		if(posy!=0){ 
	                tab[posx+posy*a]=tab[posx+(posy-1)*a]; 
                        tab[posx+(posy-1)*a]=0; 
                        i=-1; 
                        k+=1; 
                        RemplirRectangle(x+100+(posx+j)*f+5*posx+5*a/2-posx*f, (posy+i)*e+5*posy+(5*b+10)/2-5, f, e); 
                        ChargerImage(nomimg, x+100+(posx)*f+posx*5+5*a/2, (posy)*e+5*posy+(5*b+10)/2, ((tab[posx+posy*a])%a)*f,((tab[posx+posy*a])/a)*e, f, e); 
                }
	}

	if(_X >= x+100+posx*f+5*posx+5*a/2-f && _X <= x+100+posx*f+5*posx+5*a/2 && _Y >= posy*e+5*posy+(5*b+10)/2 && _Y <= posy*e+5*posy+(5*b+10)/2+e){ /* Tuile de GAUCHE */
		if (posx!=0){
                	tab[posx+posy*a]=tab[posx-1+posy*a];
                        tab[posx-1+posy*a]=0;
                        j=-1;
                        k+=1;
                        RemplirRectangle(x+100+(posx+j)*f+5*posx+5*a/2-5, (posy+i)*e+5*posy+(5*b+10)/2-posy*e, f, e);
                        ChargerImage(nomimg, x+100+(posx)*f+posx*5+5*a/2, (posy)*e+5*posy+(5*b+10)/2, ((tab[posx+posy*a])%a)*f,((tab[posx+posy*a])/a)*e, f, e);
		}
	}
	return k;
}
			



/* Jedrocha Benjamin & Leblanc Kevin */

#include<graph.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>

#include "move.h"

#define CYCLE 10000L

int verification(int a, int b, int x, int y, int *tab){ /* Verifie si toutes les tuiles sont à la position initiale */
	int i, j;
  int l = 0;
  for(i = 0; i < b; i++){
  	for(j = 0; j < a; j++){
    	if(tab[i*a+j] == i*a+j){
      	l++;
      }
    }
  }
  if(l==a*b){ 
		return 0;
  }
  return 1;
}

/* Melange les tuiles d'image */
int melange(int x,int y, int a, int b, int f, int e, char nomimg[100]){
  int nb_permutations, i, j, m, tmp, parite, k=0, kv=1;
	unsigned long suivant;
	int* tab = (int*) malloc (a*b*sizeof(int));
	int* tmp_tab = (int*) malloc (a*b*sizeof(int));
	
	srand(time(NULL));
  do{
  	for(i=0; i<b; i++){
    	for(j=0; j<a; j++){
      	tab[i*a+j]=i*a+j;
      }
  }
  	nb_permutations = 0;
  	/* Generation aleatoire */
  	for ( i=0 ; i<a*b ; i++ ){
  		m = i + (rand() % (a*b-i));
    	tmp = tab[i];
    	tab[i] = tab[m];
    	tab[m] = tmp;
  	}
		/* Cherche la position de la tuile blanche (parite) */
  	for ( i=0; tab[i] != 0; i++ ){
  		parite = (a - 1) + (b - 1) - ((i / a) + (i % a));
  	}

  	/* Copie du tableau pour compter les permutations */

  	memcpy(tmp_tab, tab, a*b*sizeof *tab);

  	if (i < a*b - 1){
  		tmp = tmp_tab[a*b - 1];
    	tmp_tab[a*b - 1] = tmp_tab[i];
    	tmp_tab[i] = tmp;
    	nb_permutations++;
  	}
		for(i=a*b-1;i>0;i--){
  		if(tmp_tab[i-1]<i){
    		for(j=i-1;j>=0;j--){
    			if(tmp_tab[j]==i){
    				tmp = tmp_tab[j];
      			tmp_tab[j]=tmp_tab[i-1];
      			tmp_tab[i-1]=tmp;
      			nb_permutations++;
    			}
      	}
   		}
 		}
  }while (!(nb_permutations%2)^(parite%2));


  /* AFFICHAGE TUILES */
  for(i=0; i<b; i++){
  	for(j=0; j<a; j++){
    	if(tab[j+i*a]!=0){
      	ChargerImage(nomimg, x+100+j*f+5*a/2+j*5, i*e+(5*b+10)/2+i*5, ((tab[j+i*a])%a)*f,((tab[j+i*a])/a)*e, f, e);
      }else{
				ChoisirCouleurDessin(CouleurParComposante(255,255,255));
				RemplirRectangle(x+100+j*f+5*a/2+j*5, i*e+(5*b+10)/2+i*5,f,e);
			}
    }
  }

	while(verification(a, b, x, y, tab)){ /* Tant que toutes les tuiles ne sont pas a la position initiale */
		if(Microsecondes() > suivant){
			suivant = Microsecondes() + CYCLE;
			
			if(k!=kv){
				displayCompteur(x, y, k); /* Affichage du compteur */
				ChoisirCouleurDessin(CouleurParNom("white"));
			}
			kv = k;	
			if(ToucheEnAttente()){
				k = clavier(a, b, x, y, e, f, tab, nomimg, k); /* Deplacement au clavier */
			}else if(SourisCliquee()){
				k = souris(a, b, x, y, e, f, tab, nomimg, k); /* Deplacement a la souris */
			}
		}
	}	
	free(tab);
	free(tmp_tab);
	return k;
}

int jeu(char m, int a, int b){
	int x, y, k;
	int e, f;
	char img[100];
	InitialiserGraphique();

	a += 3;
	b += 3;
		
	if(m==0){
		x=752;
		y=448;
		strcpy(img,"./puzzles/Loup.png");
	}else if(m==1){
		x=720;
		y=607;
		strcpy(img,"./puzzles/Marmotte.png");
	}else{
		x=880;
		y=576;
		strcpy(img,"./puzzles/Papillon.png");
	}

	f = x/a;
	e = y/b;

	CreerFenetre(0, 0, x*2 + a*5 + 110, y + b*10);
	ChargerImageFond("./background/background.png");
	ChargerImage(img, 5, 5*b, 0, 0, x, y); /* Affiche l'image d'origine */

	k = melange(x, y, a, b, f, e, img); /* Lance le melange des tuiles */
	
	return k;
}


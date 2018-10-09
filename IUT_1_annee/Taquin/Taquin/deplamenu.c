/* Jedrocha Benjamin & Leblanc Kevin */

#include<graph.h>
#include "deplamenu.h"

/*Cette fonction sert a selectionner au clavier dans les menus*/
void selclavier(Table *t){
	
	switch(t->a){
		case XK_Up : /*  Verification touche directionnelle haut */
			if(t->cmenu != 4){
				if(t->z != 0 && t->z != 3){
					t->y -= t->dec;
					t->z -= 1;
				}else{
		        		t->y += t->dec * 2;
					t->z += 2;
				}
			}else{
				if(t->z == 0){
					t->y += t->dec;
					t->z += 1;
				}else{
					t->y -= t->dec;
					t->z -= 1;
				}
			}
			break;
		case XK_Down : /* Verification touche directionnelle bas */
			if(t->cmenu != 4){
				if(t->z != 2 && t->z != 5){
					t->y += t->dec;
					t->z += 1;
				}else{
					t->y -= t->dec * 2;
					t->z -= 2;
				}
			}else{
				if(t->z == 1){
                                        t->y -= t->dec;
                                        t->z -= 1;
                                }else{
                                        t->y += t->dec;
                                        t->z += 1;
                                }
			}
			break;

		case XK_Right : /* Verification touche directionnelle droite */
			if(t->cmenu >= 2 && t->cmenu != 4){
				if(t->z < 3){
					t->x += 120;
					t->z += 3;
				}else{
					t->x -= 120;
					t->z -= 3;
				}
			}
			break;
		case XK_Left : /* Verification touche directionnelle gauche */
			if(t->cmenu >= 2 && t->cmenu != 4){
				if(t->z > 2){
					t->x -= 120;
		 			t->z -= 3;
				}else{
					t->x += 120;
					t->z += 3;
				}
			}
			break;		
		case XK_Escape : /*  Verification touche 'esc' */ 
			t->z = 6; /* Valeur de retour */
			t->a = 1;
			break;
		case XK_Return :
			t->a = 1;
			break;
		default : /* Ignore les touches non definies */
			t->a = 0;
			break;
	}
}

void selsouris(Table *t){	
	
	if(t->cmenu == 0){	
		if(_X >= t->x && _X <= t->x + t->xx){ 
		  if(_Y >= 115 && _Y <= 150){ /* Zone premier choix 'Jouer ?'*/
			  	t->y = 115;
				t->z = 0;
		  }else if(_Y >= 190 && _Y <= 235){ /* Zone second choix 'Fermer' */
		   	t->y = 190;
				t->z = 1;
		  }else if(_Y >= 265 && _Y <= 310){ /* Zone troisieme choix 'Regles' */
		   	t->y = 265;
				t->z = 2;
		  }else{
			t->a = 0;
		  }
		}else{
			t->a = 0; 
		}
	}else if(t->cmenu >= 1){

		if(t->cmenu == 1){
			if(_X >= t->x && _X <= t->x + t->xx){ 
				if(_Y >= 95 && _Y <= 220){
					t->y = 95;
					t->z = 0;
				}else if(_Y >= 255 && _Y <= 390){
					t->y = 255;
					t->z = 1;
				}else if(_Y >= 415 && _Y <= 550){
					t->y= 415;
					t->z = 2;
				}else{
					t->a = 0;
				}
			}else{
				t->a = 0;
			}
		}
		
		if(t->cmenu == 4){
			if(_X >= 45 && _X <= 195){
				if(_Y >= 127 && _Y <= 172){
					t->y = 127;
					t->z = 0;
				}else if(_Y >= 207 && _Y <= 252){
					t->y = 207;
					t->z = 1;
				}
			}
		}	
		if(t->cmenu >= 2 && t->cmenu != 4){
			if(_X >= 240 && _X <= 340){ /* premiere colonne */
	
				if(_Y >= 140 && _Y <= 240){ /* [3] */
					t->y = 135;
					t->z = 0;
				
				}else if(_Y >= 280 && _Y <= 380){ /* [5] */
					t->y = 275;
					t->z = 1;
		
				}else if(_Y >= 420 && _Y <= 520){ /* [7] */
					t->y = 415;
					t->z = 2;
				}else{
					t->a = 0;
				}
			if(t->a != 0){
				t->x = 235;
			}

		}else if(_X >= 360 && _X <= 460){ /* seconde colonne */ 

			if(_Y >= 140 && _Y <= 240){ /* [4] */
				t->y = 135;
				t->z = 3;

      			}else if(_Y >= 280 && _Y <= 380){ /* [6] */
				t->y = 275;
				t->z = 4;

      			}else if(_Y >= 420 && _Y <= 520){ /* [8] */
				t->y = 415;
				t->z = 5;
      			}else{
				t->a = 0;
			} 
			if(t->a != 0){	
				t->x = 355;
			}

		}else{
			t->a = 0;
		}
	}
	
	if(t->a == 1 && t->cmenu == 3){
		t->x -= 2;
		t->y -= 2;
	}
	if(_X >= 15 && _X <= 95 && _Y >= 565 && _Y <= 590){
			t->z = 6;
			t->a = 1;
	}	
	}
}

/* jedrocha benjamin & Leblanc Kevin */
#ifndef MENUDEPLA_H
#define MENUDEPLA_H


typedef struct Table Table;
struct Table{
  char cmenu;
	int a; 
	char z;                   
  unsigned int dec;
  unsigned int x;
  unsigned int y;                  
  unsigned int xx;                 
  unsigned int yy;                                  
};       

void selclavier(Table *t);
void selsouris(Table *t);

#endif


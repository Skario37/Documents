# Jedrocha Benjamin & Leblanc Kevin 
# CHAPITRE 1 : BUT FINAL

but : Taquin


# CHAPITRE 2 : VARIABLES

OFILES = move.o \
				 jeu.o \
				 deplamenu.o \
				 selection.o \
				 menu.o \
				 main.o

CC = gcc

CFLAGS = -Wall -ansi -pedantic -g

# CHAPITRE 3 : DEPENDANCES (REGLES IMPLICITES)

deplamenu.o : deplamenu.h selection.h

jeu.o : move.h

selection.o : selection.h deplamenu.h 

main.o : menu.h jeu.h

#CHAPITRE 4 : DEPENDANCES AVEC COMMANDES

Taquin : $(OFILES)
	$(CC) $(CFLAGS) -o Taquin $(OFILES) -lgraph

#CHAPITRE 5 : NETTOYAGE DES FICHIERS GENERES

clean :
	-rm -f $(OFILES) Taquin
graph.h :
	-lgraph Taquin
#CHAPITRE 6 : BUTS FACTICES

.PHONY : but clean
	

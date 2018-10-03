/**
* Cette classe est utilisee pour generer la grille
*
* @author Leblanc Kevin et Bullou Julien
*/


import java.util.Random;

public class Generation {
        /**
        * Empty constructor
        */
	public Generation(){}

        /**
        * Genere la grille d'une nouvelle partie
        * Renvoit la grille
        *
        * @param numberOfMines Nombre de mines a placer
        * @param Column Longueur de la grille
        * @param Line Largeur de la grille
        *
        * @return la grille
        */
	public static CreateLabel[][] Generate(int numberOfMines, int Column, int Line){
		CreateLabel[][] tabGrid = new CreateLabel[Column][Line];		
		Random Rand = new Random();
		int randColumn;
		int randLine;
		int minesPlaced = 0;

                for(int i = 0; i < Column; i++){
                	for(int j = 0; j < Line; j++){
                		tabGrid[i][j] = new CreateLabel(i, j, Column, Line);
                	}
                }
        
                // Place les bombes dans la grille
                while (minesPlaced < numberOfMines) {
                	randColumn = Rand.nextInt(Column);
                	randLine = Rand.nextInt(Line);
                	if(!tabGrid[randColumn][randLine].getIsMine()){
                		tabGrid[randColumn][randLine].setIsMine(true);
                		minesPlaced++;
                	}
                }

        
                for(int i = 0; i < Column; i++){
                	for(int j = 0; j < Line; j++){
                		
                		tabGrid[i][j].countMines(tabGrid); // Compte le nombre de bombe autour de chaque case
                	}
                }

                return tabGrid;

        }

        /**
        * Genere la grille a partir d'un fichier
        *
        * @return la grill
        */
	public static CreateLabel[][] Loading(){ 
                // Charge la sauvegarde
	        SaveGame save = new SaveGame();
                save.openReadSave();
                CreateLabel[][] tabGrid = null;
                int Column = save.getColumn();
                int Line = save.getLine();
                int numberOfMines = save.getNumberOfMine();


                tabGrid = new CreateLabel[Column][Line];

                
                for (int i = 0; i < Column; i++) {
                        for (int j = 0; j < Line; j++) {
                                boolean isMine = save.getIsMine();
                                int State = save.getState();
                                tabGrid[i][j] = new CreateLabel(i, j, Column, Line);
                                tabGrid[i][j].setState(State);
                                tabGrid[i][j].setIsMine(isMine);
                        }       
                }

                for (int i = 0; i < Column; i++) {
                        for (int j = 0; j < Line; j++) {
                                tabGrid[i][j].countMines(tabGrid);  // Compte le nombre de bombe autour de chaque case
                        }
                }
                save.closeReadSave();
                return tabGrid;
        }
}
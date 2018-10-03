/**
* Cette classe est utilisee pour creer le plateau
* @author Leblanc Kevin et Bullou Julien
*/

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

public class Grid extends JPanel {

	private CreateLabel[][] tabGrid;

	/**
	* Constructeur
	*
	* @param cellTab Grille generee
	* @param Column Longueur de la grille
	* @param Line Largeur de la grille
	* @param Width Taille en x de l'ecran
	* @param Height Taille en y de l'ecran
	*/
	public Grid(CreateLabel[][] cellTab, int Column, int Line, int Width, int Height){
		super();

		Random Rand = new Random();
		int randColumn;
		int randLine;
		int minesPlaced = 0;
		
		this.setBounds(0, 0, Width, Height);

		GridLayout Layout = new GridLayout(Line, Column);
		Layout.setHgap(1);
        Layout.setVgap(1);
		this.setLayout(Layout);
		

		// Crée la grille
		this.tabGrid = new CreateLabel[Column][Line];		

        for(int i = 0; i < Column; i++){
        	for(int j = 0; j < Line; j++){
        		this.tabGrid[i][j] = new CreateLabel(i, j, Column, Line);
        
	        	this.tabGrid[i][j].setIsMine(cellTab[i][j].getIsMine());
	        	this.tabGrid[i][j].setNeighborMine(cellTab[i][j].getNeighborMine());
	   			this.tabGrid[i][j].setState(cellTab[i][j].getState());
	        	this.tabGrid[i][j].setOpaque(true);
	        	this.tabGrid[i][j].setBackground(new Color(0, 76, 153));

        		this.add(tabGrid[i][j]);
        	}
        }
        
        for(int i = 0; i < Column; i++){
        	for(int j = 0; j < Line; j++){
        		this.tabGrid[i][j].countMines(tabGrid); // Compte le nombre de bombe autour de chaque case
        		this.tabGrid[i][j].setHorizontalAlignment(SwingConstants.CENTER);
        		if(this.tabGrid[i][j].getState() == 3){
 					WithoutMine.numberOfCellsWithoutMine -= 1;
					if(this.tabGrid[i][j].getNeighborMine() > 0){
						this.tabGrid[i][j].setBackground(new Color(96, 96, 96));
						this.tabGrid[i][j].setText("<html><h1><font color='d7df23'>" + this.tabGrid[i][j].getNeighborMine() + "</font></h1></html>");
					} else {
						this.tabGrid[i][j].setBackground(new Color(128, 128, 128));
					}
				} else if (this.tabGrid[i][j].getState() == 1) {
					WithoutMine.numberOfFlags += 1;
					this.tabGrid[i][j].setText("<html><h1><font color='ec008c'>&#9733;</font></h1></html>");
				} else if (this.tabGrid[i][j].getState() == 2) {
					this.tabGrid[i][j].setText("<html><h1><font color='ec008c'>?</font></h1></html>");
				}
        	}
        }

        
	}
}
/**
* Cette classe est utilisee pour creer les cases du demineur
* @author Leblanc Kevin et Bullou Julien
*/


import javax.swing.JLabel;

public class CreateLabel extends JLabel{

	private int Column;
	private int Line;
	private int initialColumn;
	private int initialLine;
	private int State; // 0 Normal, 1 Drapeau, 2 Soupçons, 3 révélée
	private int neighborMine;
	private CreateLabel Neighbor;
	private boolean isMine;
	private CreateLabel[][] finalGrid;

	/**
	* Renvoit la colonne de la case
	*
	* @return colonne de la case
	*/
	public int getColumn(){
		return this.Column;
	}

	/**
	* Renvoit la ligne de la case
	*
	* @return ligne de la case
	*/
	public int getLine(){
		return this.Line;
	}

	/**
	* Renvoit la longueur de la grille
	*
	* @return longueur de la grille
	*/
	public int getInitialColumn(){
		return this.initialColumn;
	}

	/**
	* Renvoit la largeur de la case
	*
	* @return largeur de la case
	*/
	public int getInitialLine(){
		return this.initialLine;
	}

	/**
	* Parametre l'etat de la case
	*
	* @rparam p Etat de la case
	*/
	public void setState(int p){
		this.State = p;
	}

	/**
	* Renvoit l'etat de la case
	*
	* @return etat de la case
	*/
	public int getState(){
		return this.State;
	}

	/**
	* Parametre le nombre de mines adjacentes a la case
	*
	* @param nombre de mines adjacentes a la case
	*/
	public void setNeighborMine(int p){
		this.neighborMine = p;
	}

	/**
	* Renvoit le nombre de mines adjacentes a la case
	*
	* @return nombre de mines adjacentes a la case
	*/
	public int getNeighborMine(){
		return this.neighborMine;
	}

	/**
	* Parametre si la case est une mine
	*
	* @param est une mine ou non
	*/
	public void setIsMine(boolean p){
		this.isMine = p;
	}

	/**
	* Renvoit si la case est une mine
	*
	* @param est une mine ou non
	*/
	public boolean getIsMine(){
		return this.isMine;
	}

	/**
	* Compte le nombre de mines adjacentes
	*
	* @param tabGrid case 
	*/
	public void countMines(CreateLabel[][] tabGrid){
		this.finalGrid = tabGrid;
		if(!this.isMine){
			this.neighborMine = 0;
			for(int i = -1; i <= 1; i++){
				for (int j = -1; j <= 1; j++) {
					int iPos = this.Column + i;
					int jPos = this.Line + j;
					if (iPos > -1 && iPos < this.initialColumn && jPos > -1 && jPos < this.initialLine) {
						this.Neighbor = tabGrid[iPos][jPos];
						if(this.Neighbor.isMine){
							this.neighborMine++;
						}
					}
				}
			}
		}
	}

	/**
	* Renvoit la grille complete
	*
	* @return grille complete
	*/
	public CreateLabel[][] getFinalGrid(){
		return this.finalGrid;
	}

	/**
	* Renvoit les voisins de la case
	*
	* @return voisins de la case
	*/
	public CreateLabel getNeighbor(){
		return this.Neighbor;
	}

	/**
	* Parametre l'etat de la case a 3 (revelee)
	*/
	public void RevealCase(){
		this.State = 3;
	}

	/**
	* Constructeur
	*
	* @param i Longueur de la grille
	* @param j Largeur de la grille
	* @param x Colonne de la case
	* @param y Ligne de la case
	*/
	public CreateLabel(int i, int j, int x, int y){
			this.Column = i;
			this.Line = j;
			this.initialColumn = x;
			this.initialLine = y;	
			this.State = 0;
			this.neighborMine = 0;
			this.Neighbor = null;
			this.isMine = false;
			this.addMouseListener(new LabelEvents());
	}
}
import javax.swing.JOptionPane;

/**
* Cette classe est utilisee pour definir certaines variables
* @author Leblanc Kevin et Bullou Julien
*/

public class WithoutMine {

	public static int numberOfCellsWithoutMine;
	public static boolean gridClickable;
	public static int numberOfFlags;
	public static int numberOfMine;

	/**
	* Constructeur
	*
	* @param p Nombre de cases sans mine
	* @param q Nombre de mines dans la grille
	*/ 
	public WithoutMine(int p, int q){
		numberOfCellsWithoutMine = p;
		numberOfMine = q;
		numberOfFlags = 0;
		gridClickable =true;
	}

	/**
	* Affiche le message "gagné" ou "perdu"
	*/ 
	public void affFinish(String p){
		JOptionPane.showMessageDialog(GameStart.gameFrame, p);
	}

}
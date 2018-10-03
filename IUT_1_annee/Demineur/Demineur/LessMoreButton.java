/**
* Cette classe est utilisee pour creer les boutons "+" ou "-" des choix de colonnes, lignes et pourcentage
* @author Leblanc Kevin et Bullou Julien
*/

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class LessMoreButton extends JButton{
	/**
	* Constructeur
	*
	* @param titleButton Titre du bouton
	* @param startWindow Ecran titre
	* @param currentFrame Fenetre actuelle
	* @param label JLabelFor
	* @param x Nombre choisit
	* @param state Etat du bouton (0 = colonne, 1 = ligne, 2 = pourcentage)
	* @param param "+" ou "-" booleen (true = +, false = -)
	*/
	public LessMoreButton(String titleButton, JFrame startWindow, JFrame currentFrame, JLabel label, int x, int state, boolean param) {
		super(titleButton); // Titre du bouton		

		this.setBackground(new Color(0, 76, 153)); //Couleur par defaut du bouton
		this.setForeground(Color.WHITE); // Couleur par defaut de la police du bouton

		this.addMouseListener(new LessMoreButtonEvents(startWindow, currentFrame, this, label, x, state, param)); // Evenements du bouton
		
	}
}
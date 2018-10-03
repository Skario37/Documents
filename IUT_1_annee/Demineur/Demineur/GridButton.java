/**
* Cette classe est utilisee pour creer les boutons de choix de grille predefinies
* @author Leblanc Kevin et Bullou Julien
*/

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GridButton extends JButton {



	/**
	* Constructeur
	*
	* @param titleButton Nom du bouton actuel
	* @param startWindow Ecran titre
	* @param currentFrame Fenetre actuelle
	* @param width Taille en x de l'ecran
	* @param height Taille en y de l'eran
	* @param x Longueur de la grille
	* @param y Largeur de la grille
	* @param z Pourcentage de mines
	*/
	public GridButton(String titleButton, JFrame startWindow, JFrame currentFrame, int width, int height, int x, int y, float z) {
		super(titleButton); // Titre du bouton		

		this.setBackground(new Color(0, 76, 153)); //Couleur par defaut du bouton
		this.setForeground(Color.WHITE); // Couleur par defaut de la police du bouton

		this.addMouseListener(new GridButtonEvents(startWindow, currentFrame, this, width, height, x, y, z)); // Evenements du bouton
		
	}
}
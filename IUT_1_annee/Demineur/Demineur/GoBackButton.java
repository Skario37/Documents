/**
* Cette classe est utilisee pour creer le bouton de retour
* @author Leblanc Kevin et Bullou Julien
*/

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GoBackButton extends JButton {

	/**
	* Aligne le bouton
	* @param titleButton Nom du bouton
	* @param oldFrame Ancienne fenêtre
	* @param currentFrame Fenêtre actuelle
	* @param width Taille de l'ecran en x
	* @param height Taille de l'ecran en y
	* @param putNumber Nombre de boutons à placer
	* @param position Position du bouton 
	*/

	public GoBackButton (String titleButton, JFrame oldFrame, JFrame currentFrame, int width, int height, int putNumber, int position) { // putNumber = nombre de boutons, position = determine l'endroit ou se place le bouton par rapport aux autres
		super(titleButton);

		// Placement du bouton
		int widthButton = (int) (width * 0.15f);
		int heightButton =  (int) (height * 0.06f);
		int x = width / (putNumber + 1) * position - widthButton / 2;
		int y = (int) (height * 0.80f);
		int fontsize = width / 80;

		this.setBounds(x, y, widthButton, heightButton); // Position et taille du bouton 
		this.setFont(new Font(Font.DIALOG, Font.ITALIC, fontsize)); // Police du bouton
		this.setBackground(new Color(0, 76, 153)); //Couleur par defaut du bouton
		this.setForeground(Color.WHITE); // Couleur par defaut de la police du bouton
		
		y += heightButton / 2; // Pour placer le selecteur
		this.addMouseListener(new BackEvents(oldFrame, currentFrame, this, width, height, x, y)); // Evenements du bouton

	}

}
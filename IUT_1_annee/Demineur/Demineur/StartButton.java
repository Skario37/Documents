/**
* Cette classe est utilisee pour creet les boutons de l'ecran titre
* @author Leblanc Kevin et Bullou Julien
*/

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StartButton extends JButton {
	
	private int fontsize;

	/**
	* Constructeur
	*
	* @param titleButton Nom du bouton actuel
	* @param currentFrame Fenetre actuelle
	* @param width Taille de l'ecran en x
	* @param height Taille de l'ecran en y
	* @param shift Décalage entre les boutons
	* @param clickable Bouton cliquable ou non
	*/
	public StartButton(String titleButton, JFrame currentFrame, int width, int height, float shift, boolean clickable) {
		super(titleButton); // Titre du bouton		

		// Placement du bouton
		int x = (int) (width * (0.075f + shift));
		int y = (int) (height * 0.80f);
		int widthButton = (int) (width * 0.15f);
		int heightButton =  (int) (height * 0.06f);

		this.setBounds( x, y, widthButton, heightButton); // Position et taille du bouton

		this.fontsize = width / 80;

		this.setFont(new Font(Font.DIALOG, Font.ITALIC, this.fontsize)); // Police du bouton
		this.setBackground(new Color(0, 76, 153)); //Couleur par defaut du bouton
		this.setForeground(Color.WHITE); // Couleur par defaut de la police du bouton
		
		y += heightButton / 2; // Pour placer le selecteur
		if(clickable) this.addMouseListener(new ButtonEvents(currentFrame, this, width, height, x, y)); // Evenements du bouton
		
	}
}


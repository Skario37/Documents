/**
* Cette classe est utilisee pour creer le bouton du choix de la grille personalisee
* @author Leblanc Kevin et Bullou Julien
*/
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;

public class PersoButton extends JButton{
	/**
	* Constructeur
	*
	* @param titleButton Titre du bouton
	* @param startWindow Ecran titre
	* @param currentFrame Fenetre actuelle
	* @param panel JPanel actuel
	* @param nextPanel JPanel a montrer (setVisible(true))
	* @param width Taille en x de l'ecran
	* @param height Taille en y de l'ecran
	*/
	public PersoButton(String titleButton, JFrame startWindow, JFrame currentFrame, JPanel panel, JPanel nextPanel, int width, int height) {
		super(titleButton); // Titre du bouton		

		this.setBackground(new Color(0, 76, 153)); //Couleur par defaut du bouton
		this.setForeground(Color.WHITE); // Couleur par defaut de la police du bouton

		this.addMouseListener(new PersoButtonEvents(startWindow, currentFrame, panel, nextPanel, this, width, height)); // Evenements du bouton
		
	}
}
/**
* Cette classe est utilisee pour definir les evenements souris du bouton du choix de la grille personalisee
* @author Leblanc Kevin et Bullou Julien
*/

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

public class PersoButtonEvents implements MouseListener {
	

	private JFrame firstWindow;
	private JFrame currentWindow;
	private JPanel currentPanel;
	private JPanel thisPanel;
	private JButton currentButton;
	private int width;
	private int height;
	
	/**
	* Constructeur
	*
	* @param titleButton Titre du bouton
	* @param window Ecran titre
	* @param currentFrame Fenetre actuelle
	* @param panel JPanel actuel
	* @param nextPanel JPanel a montrer (setVisible(true))
	* @param button Bouton actuel
	* @param widthWindow Taille en x de l'ecran
	* @param heightWindow Taille en y de l'ecran
	*/
	public PersoButtonEvents(JFrame startWindow, JFrame window, JPanel panel, JPanel nextPanel, JButton button, int widthWindow, int heightWindow){	
		this.firstWindow = startWindow;
		this.currentWindow = window;
		this.currentPanel = panel;
		this.thisPanel = nextPanel;
		this.currentButton = button;
		this.width = widthWindow;
		this.height = heightWindow;
	}

   	@Override
	public void mouseClicked(MouseEvent e) {
		int buttonDown = e.getButton();

	    if (buttonDown == MouseEvent.BUTTON1) {

	    	this.currentPanel.setVisible(false);
	    	this.thisPanel.setVisible(true);
	    	

			
	    } else if(buttonDown == MouseEvent.BUTTON2) {
	           // Bouton du MILIEU enfoncé
	    } else if(buttonDown == MouseEvent.BUTTON3) {
	           // Bouton DROIT enfoncé
	    }
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		currentButton.setBackground(new Color(51, 255, 255)); // Change la couleur du bouton selectionne
		currentButton.setForeground(Color.BLACK); // Change la couleur de la police du bouton selectionne
	}

	@Override
	public void mouseExited(MouseEvent e) {
		currentButton.setBackground(new Color(0, 76, 153)); // Retablit la couleur par defaut du bouton
		currentButton.setForeground(Color.WHITE); // Retablit la couleur de la police par defaut du bouton 
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}


}
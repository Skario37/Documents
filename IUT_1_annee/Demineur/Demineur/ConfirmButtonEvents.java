/**
* Cette classe est utilisee pour definir les evenements souris du bouton de confirmation 
* @author Kévin LEBLANC
*/

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

public class ConfirmButtonEvents implements MouseListener {

	private JFrame firstWindow;
	private JFrame currentWindow;
	private JButton currentButton;
	private int widthWindow;
	private int heightWindow;
	
	/**
	* Constructeur
	* @param startWindow Fenetre de l'ecran titre
	* @param window Fenetre actuelle
	* @param button Bouton actuel
	* @param width Taille en x de la fenetre
	* @param height Taille en y de la fenetre
	*/

	public ConfirmButtonEvents(JFrame startWindow, JFrame window, JButton button, int width, int height){	
		this.firstWindow = startWindow;
		this.currentWindow = window;
		this.currentButton = button;
		this.widthWindow = width;
		this.heightWindow = height;
	}

   	@Override
	public void mouseClicked(MouseEvent e) {
		int buttonDown = e.getButton();

	    if (buttonDown == MouseEvent.BUTTON1) {
	    	
	    	this.currentWindow.dispose();
			int mines = (int) (LessMoreButtonEvents.colonne * LessMoreButtonEvents.ligne * (LessMoreButtonEvents.pourcentage / 100.0f));
			JFrame game = new GameStart(this.firstWindow, this.widthWindow, this.heightWindow, LessMoreButtonEvents.colonne, LessMoreButtonEvents.ligne, mines);
			game.setVisible(true);
			
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
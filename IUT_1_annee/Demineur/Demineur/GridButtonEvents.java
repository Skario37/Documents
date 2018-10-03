/**
* Cette classe est utilisee pour definir les evenement souris des boutons des choix de grilles predefinies
* @author Leblanc Kevin et Bullou Julien
*/

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;


public class GridButtonEvents implements MouseListener {
	

	private JFrame firstWindow;
	private JFrame currentWindow;
	private JPanel currentPanel;
	private JButton currentButton;
	private int width;
	private int height;
	private int column;
	private int line;
	private float percent;
	
	
	/**
	* Constructeur
	*
	* @param startWindow Ecran titre
	* @param window Fenetre actuelle
	* @param button Bouton actuel
	* @param widthWindow Taille en x de l'ecran
	* @param heightWindow Taille en y de l'eran
	* @param x Longueur de la grille
	* @param y Largeur de la grille
	* @param z Pourcentage de mines
	*/
	public GridButtonEvents(JFrame startWindow, JFrame window, JButton button, int widthWindow, int heightWindow, int x, int y, float z){	
		this.firstWindow = startWindow;
		this.currentWindow = window;
		this.currentButton = button;
		this.width = widthWindow;
		this.height = heightWindow;
		this.column = x;
		this.line = y;
		this.percent = z;
	}

   	@Override
	public void mouseClicked(MouseEvent e) {
		int buttonDown = e.getButton();

	    if (buttonDown == MouseEvent.BUTTON1) {

	    	if (this.column >= 4 && this.column <= 30 && this.line >= 4 && this.line <= 30) {
	    		
	    		this.currentWindow.dispose();
			    int numberOfMines = (int) (this.column * this.line * this.percent);
				JFrame game = new GameStart(this.firstWindow, this.width, this.height, this.column, this.line, numberOfMines);
				game.setVisible(true);

	    	}
			
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
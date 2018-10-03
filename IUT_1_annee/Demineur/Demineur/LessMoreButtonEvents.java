/**
* Cette classe est utilisee pour definir les evenements souris des boutons "+" ou "-" des choix de colonnes, lignes et pourcentage
* @author Leblanc Kevin et Bullou Julien
*/

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;


public class LessMoreButtonEvents implements MouseListener {
	

	public static int colonne;
	public static int ligne;
	public static int pourcentage;

	private JFrame firstWindow;
	private JFrame currentWindow;
	private JButton currentButton;
	private JLabel currentLabel;
	private int etat;
	private boolean lessOrMore;
	
	/**
	* Constructeur
	*
	* @param startWindow Ecran titre
	* @param window Fenetre actuelle
	* @param label JLabelFor
	* @param x Nombre choisit
	* @param state Etat du bouton (0 = colonne, 1 = ligne, 2 = pourcentage)
	* @param param "+" ou "-" booleen (true = +, false = -)
	*/
	public LessMoreButtonEvents(JFrame startWindow, JFrame window, JButton button, JLabel label, int x, int state, boolean param){	
		this.firstWindow = startWindow;
		this.currentWindow = window;
		this.currentButton = button;
		this.currentLabel = label;
		this.etat = state;
		this.lessOrMore = param;

		if(state == 0) {
			colonne = x;
		} else if(state == 1) {
			ligne = x;
		} else if(state == 2) {
			pourcentage = x;
		}

	}

   	@Override
	public void mouseClicked(MouseEvent e) {
		int buttonDown = e.getButton();

	    if (buttonDown == MouseEvent.BUTTON1) {

	    	if(this.etat == 0) {
				if (lessOrMore) {
		    		if(colonne < 30) {
		    			colonne += 1;
		    		}
		    	} else {
		    		if(colonne > 4) {
		    			colonne -= 1;
		    		}
		    	}
		    	this.currentLabel.setText("<html><h1><font color='000000'>" + colonne + "</font></h1></html>");
			} else if(this.etat == 1) {
				if (lessOrMore) {
		    		if(ligne < 30) {
		    			ligne += 1;
		    		}
		    	} else {
		    		if(ligne > 4) {
		    			ligne -= 1;
		    		}
		    	}
		    	this.currentLabel.setText("<html><h1><font color='000000'>" + ligne + "</font></h1></html>");
			} else if(this.etat == 2) {
				if (lessOrMore) {
		    		if(pourcentage < 75) {
		    			pourcentage += 1;
		    		}
		    	} else {
		    		if(pourcentage > 10) {
		    			pourcentage -= 1;
		    		}
		    	}
		    	this.currentLabel.setText("<html><h1><font color='000000'>" + pourcentage + "</font></h1></html>");
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
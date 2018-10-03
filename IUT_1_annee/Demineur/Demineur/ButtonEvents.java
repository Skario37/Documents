/**
* Cette classe est utilisee pour definir les evenements souris des boutons de l'écran titre
* @author Leblanc Kevin et Bullou Julien
*/
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonEvents implements MouseListener {
	
	private JButton button;
	private JFrame window;
	private ImageIcon selected;
	private JLabel selectContainer;
	private int widthWindow; 
	private int heightWindow;
	private int xx; // Taille x selecteur
	private int yy; // Taille y selecteur
	
	/**
	* Image lors de la selection
	*/

	public void getImageSelector () {
		// Selectionne le selecteur en fonction de la taille d'ecran
		if(widthWindow == 768) {
			this.selected = new ImageIcon("img/select_768.png");
			this.xx = 31;
			this.yy = 31; 
		} else if(widthWindow == 1024) {
			this.selected = new ImageIcon("img/select_1024.png");
			this.xx = 41;
			this.yy = 41; 
		} else if(widthWindow == 1280) {
			this.selected = new ImageIcon("img/select_1280.png");
			this.xx = 51;
			this.yy = 52; 
		} else if(widthWindow == 1366) {
			this.selected = new ImageIcon("img/select_1366.png");
			this.xx = 55;
			this.yy = 56; 
		} else if(widthWindow == 1440) {
			this.selected = new ImageIcon("img/select_1440.png");
			this.xx = 57;
			this.yy = 58; 
		} else if(widthWindow == 1600) {
			this.selected = new ImageIcon("img/select_1600.png");
			this.xx = 64;
			this.yy = 65; 
		} else if(widthWindow == 1920) {
			this.selected = new ImageIcon("img/select_1920.png");
			this.xx = 76;
			this.yy = 77;
		}
	}

	/**
	* Constructeur
	*
	* @param currentFrame Fenêtre actuelle
	* @param startButton Bouton actuel
	* @param width Taille de l'écran en x
	* @param height Taille de l'écran en y
	* @param x Position en x du selecteur
	* @param y Position en y du selecteur
	*/

	public ButtonEvents(JFrame currentFrame, JButton startButton, int width, int height, int x, int y){	
		this.button = startButton;
		this.window = currentFrame;
		this.widthWindow = width;
		this.heightWindow = height;

		this.getImageSelector();

		// Parametre le selectContainer
		this.selectContainer = new JLabel(this.selected); // Cree le selecteur du container
		this.selectContainer.setVisible(false); // Selecteur invisible par defaut
		this.selectContainer.setBounds(x, y, xx, yy); // Position et taille du selectContainer pas joli
		
		this.window.add(this.selectContainer);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int buttonDown = e.getButton();
 
	    if (buttonDown == MouseEvent.BUTTON1) { // Boutton GAUCHE enfoncé
	        String titleButton = this.button.getText();
			if(titleButton.equals("Rejouer")){
				JFrame playWindow = new GameStart(this.window, this.widthWindow, this.heightWindow);
				playWindow.setVisible(true);
			}

			if(titleButton.equals("Nouvelle Partie")){
				JFrame newGame = new NewGame(this.window, this.widthWindow, this.heightWindow);
				newGame.setVisible(true);
			}

			if(titleButton.equals("Options")){
				JFrame optionsWindow = new OptionsWindow(this.window, this.widthWindow, this.heightWindow);
				optionsWindow.setVisible(true);
			}

			if(titleButton.equals("Aide")){
				JFrame helpWindow = new HelpWindow(this.window, this.widthWindow, this.heightWindow);
				helpWindow.setVisible(true);
			}

			if(titleButton.equals("Quitter")){
				System.exit(0);
			}
	    } else if(buttonDown == MouseEvent.BUTTON2) {
	           // Bouton du MILIEU enfoncé
	    } else if(buttonDown == MouseEvent.BUTTON3) {
	           // Bouton DROIT enfoncé
	    }
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Parametre le visuel du bouton 
		this.selectContainer.setVisible(true); // Affiche le selecteur sur le bouton selectionne
		button.setBackground(new Color(51, 255, 255)); // Change la couleur du bouton selectionne
		button.setForeground(new Color(0, 0, 0)); // Change la couleur de la police du bouton selectionne
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Parametre le visuel du bouton
		this.selectContainer.setVisible(false); // Enleve le selecteur
		button.setBackground(new Color(0, 76, 153)); // Retablit la couleur par defaut du bouton
		button.setForeground(new Color(255, 255, 255)); // Retablit la couleur de la police par defaut du bouton
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
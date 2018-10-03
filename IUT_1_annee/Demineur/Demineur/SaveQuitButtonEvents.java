/**
* Cette classe est utilisee pour ajouter les evenements souris du bouton de sauvegarde et quitter le systeme
* @author Leblanc Kevin et Bullou Julien
*/
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
* Fichier qui permet d'ajouter des évenements au bouton de sauvegarde
*/

public class SaveQuitButtonEvents implements MouseListener {
	private JFrame currentWindow;
	private JButton currentButton;
	private Component[] compo;
	private ImageIcon selected;
	private JLabel selectContainer;
	private int widthWindow;
	private int heightWindow;
	private int xx; // Taille x selecteur
	private int yy; // Taille y selecteur
	private int xWidth;
	private int yHeight;
	
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
	* @param button Bouton actuel
	* @param component CreateLabel actuel
	* @param width Taille de l'écran en x
	* @param height Taille de l'écran en y
	* @param x Position en x du selecteur
	* @param y Position en y du selecteur
	*/
	public SaveQuitButtonEvents(JFrame currentFrame, JButton button, Component[] component, int width, int height, int x, int y){	
		this.currentWindow = currentFrame;
		this.currentButton = button;
		this.widthWindow = width;
		this.heightWindow = height;
		this.compo = component;

		this.getImageSelector();

		// Parametre la selectContainer
		this.selectContainer = new JLabel(this.selected); // Cree le selecteur du container
		this.selectContainer.setVisible(false); // Selecteur invisible par defaut
		this.selectContainer.setBounds(x, y, xx, yy); // Position et taille du selectContainer pas joli
		
		this.currentWindow.add(this.selectContainer);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int buttonDown = e.getButton();
 
	    if (buttonDown == MouseEvent.BUTTON1) { // Boutton de GAUCHE enfoncé
	    	SaveGame save = new SaveGame();
	    	save.openWriteSave();
	    	CreateLabel label = (CreateLabel) this.compo[0];
	    	save.writeColumn(label.getInitialColumn());
	    	save.writeLine(label.getInitialLine());
	    	save.writeNumberOfMine(WithoutMine.numberOfMine);
	    	
		    for(int i=0; i< this.compo.length; i++)
		    {

		        label = (CreateLabel) this.compo[i];
		        save.writeIsMine(label.getIsMine());
		        save.writeState(label.getState());

		    }
		    save.closeWriteSave();

			Config config = new Config();
			config.setWidth(this.widthWindow);
			config.setHeight(this.heightWindow);
			config.setSave(true);
			config.setConfig(); // On lance l'ecriture dans le fichier userconfig.txt

			System.exit(0); //Quitte le systeme proprement

	    } else if(buttonDown == MouseEvent.BUTTON2) {
	           // Bouton du MILIEU enfoncé
	    } else if(buttonDown == MouseEvent.BUTTON3) {
	           // Bouton DROIT enfoncé
	    }
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.selectContainer.setVisible(true); // Affiche le selecteur sur le bouton selectionne
		currentButton.setBackground(new Color(51, 255, 255)); // Change la couleur du bouton selectionne
		currentButton.setForeground(Color.BLACK); // Change la couleur de la police du bouton selectionne
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.selectContainer.setVisible(false); // Enleve le selecteur
		currentButton.setBackground(new Color(0, 76, 153)); // Retablit la couleur par defaut du bouton
		currentButton.setForeground(Color.WHITE); // Retablit la couleur de la police par defaut du bouton 
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
/**
* Cette classe est utilisee pour donner un fond d'écran aux fenetres
* @author Leblanc Kevin et Bullou Julien
*/

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JComponent;


public class Background extends JComponent {

	private Image background;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();

	/**
	* Constructeur
	*
	* @param width Taille de la fenêtre en x
	* @param height Taille de la fenêtre en y 
	*/

	public Background(int width, int height){
		// Selectionne le background selon la taille de la fenetre
		if(width == 768) {	
			this.background = this.toolkit.getImage("img/background_768x1024.png");
		} else if (width == 1024) {
			this.background = this.toolkit.getImage("img/background_1024x768.png");
		} else if (width == 1280) {
			if (height == 800) {
				this.background = this.toolkit.getImage("img/background_1280x800.png");
			} else if (height == 1024) {
				this.background = this.toolkit.getImage("img/background_1280x1024.png");
			}
		} else if (width == 1366) {
			this.background = this.toolkit.getImage("img/background_1366x768.png");
		} else if (width == 1440) {
			this.background = this.toolkit.getImage("img/background_1440x900.png");
		} else if (width == 1600) {
			if (height == 900) {
				this.background = this.toolkit.getImage("img/background_1600x900.png");
			} else if (height == 1050) {
				this.background = this.toolkit.getImage("img/background_1600x1050.png");
			}
		} else if (width == 1920) {
			this.background = this.toolkit.getImage("img/background_1920x1080.png");
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.background, 0, 0, this);
	}
}
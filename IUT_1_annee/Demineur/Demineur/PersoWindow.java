/**
* @author Kévin LEBLANC
*/

import javax.swing.*;
import java.awt.*;

public class PersoWindow extends JFrame {

	public PersoWindow (JFrame oldWindow, int width, int height) {
		super("Nouvelle partie");
		  // Configure la fenetre
    	
    	oldWindow.setVisible(false); // Cache la fenetre des menus

		  // Configure la fenetre
    	this.setSize(width, height); // Taille de la fenetre
    	this.setResizable(false); 
    	this.setLayout(null);
    	this.setContentPane(new Background(width, height)); // Applique l'image de fond sur cette JFrame
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            
      int xBorder = (int) (width * 0.3f)/5; // Bordure en x pour les JPanel
      int yBorder =  (int) (height * 0.3f); // Bordure en y pour les JPanel

      	

      // Paramètre le layout
      GridLayout grid = new GridLayout(1,2);
      grid.setHgap(yBorder / 4);
      grid.setVgap(xBorder / 2);
      
      // Paramètre le containeur
      JPanel Container = new JPanel();
      Container.setLayout(grid);
      Container.setBounds(xBorder / 2, yBorder / 10, width - xBorder, height - yBorder);
      Container.setOpaque(false); // Desactive l'opacite
        

      
      	


      // Bouton retour 
		  JButton goBack = new GoBackButton("Retour", oldWindow, this, width, height, 2, 1); // 2 boutons a placer, ce bouton se placera en premier
    	
      // Bouton commencer
      //JButton start = new StartGameButton("Commencer", this, width, height, x, y, 2, 2); // 2 boutons a placer, ce bouton se placera en second


      this.add(goBack);
      //this.add(start);
      this.add(Container);
	}
}
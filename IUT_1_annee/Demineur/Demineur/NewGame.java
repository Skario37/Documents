/**
* Cette classe est utilisee pour creer la fenetre de jeu 
* @author Leblanc Kevin et Bullou Julien
*/

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class NewGame extends JFrame {

    /**
    * Constructeur
    *
    * @param startWindow Ecran titre
    * @param width Taille en x de l'ecran
    * @param height Taille en y de l'ecran
    */
	public NewGame (JFrame startWindow, int width, int height) {
		super("Nouvelle partie");
			// Configure la fenetre
    	
    	startWindow.setVisible(false); // Cache la fenetre des menus

		  // Configure la fenetre
    	this.setSize(width, height); // Taille de la fenetre
    	this.setResizable(false); 
    	this.setLayout(null);
    	this.setContentPane(new Background(width, height)); // Applique l'image de fond sur cette JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
                            
        int xBorder = (int) (width * 0.3f)/5; // Bordure en x pour les JPanel
        int yBorder =  (int) (height * 0.3f); // Bordure en y pour les JPanel
        int persoColumn = 30;
        int persoLine = 30;
        int persoPercent = 50;
      	

      	// Paramètre le layout
      	GridLayout grid = new GridLayout(2,1);
      	grid.setHgap(yBorder / 4);
        grid.setVgap(xBorder / 2);

      	// Parametre le Container
        JPanel Container = new JPanel();
        Container.setLayout(grid);
        Container.setBounds(xBorder / 2, yBorder / 10, width - xBorder, height - yBorder);
        Container.setOpaque(false); // Desactive l'opacite

        // Parametre le persoContainer
        JPanel persoContainer = new JPanel();
        persoContainer.setLayout(new GridLayout(3, 2));
        persoContainer.setBounds(xBorder / 2, yBorder / 10, width - xBorder, height - yBorder);
        persoContainer.setOpaque(false); // Desactive l'opacite
        persoContainer.setVisible(true);

        // Boutons choix grille predefinie
        JButton x8y8 = new GridButton("<html><h1>8 x 8</h1></html>", startWindow, this, width, height, 8, 8, 0.2f);
      	JButton x16y16 = new GridButton("<html><h1>16 x 16</h1></html>", startWindow, this, width, height, 16, 16, 0.2f);
      	JButton x30y30 = new GridButton("<html><h1>30 x 30</h1></html>", startWindow, this, width, height, 30, 30, 0.2f);
      	JButton Perso = new PersoButton("<html><h1>Personnalisée</h1></html>", startWindow, this, Container, persoContainer, width, height);

      	Container.add(x8y8);
      	Container.add(x16y16);
      	Container.add(x30y30);
      	Container.add(Perso);


        // Bouton grille perso
        JLabel  columnButtonLabel = new JLabel("<html><h1><font color='000000'>" + persoColumn + "</font></h1></html>");
        JButton plusColumnButton = new LessMoreButton("<html><h1>+</h1></html>", startWindow, this, columnButtonLabel, persoColumn, 0, true);
        JButton lessColumnButton = new LessMoreButton("<html><h1>-</h1></html>", startWindow, this, columnButtonLabel, persoColumn, 0, false);

        JLabel  lineButtonLabel = new JLabel("<html><h1><font color='000000'>" + persoLine + "</font></h1></html>");
        JButton plusLineButton = new LessMoreButton("<html><h1>+</h1></html>", startWindow, this, lineButtonLabel, persoLine, 1, true);
        JButton lessLineButton = new LessMoreButton("<html><h1>-</h1></html>", startWindow, this, lineButtonLabel, persoLine, 1, false);

        JLabel  percentButtonLabel = new JLabel("<html><h1><font color='000000'>" + persoPercent + "</font></h1></html>");
        JButton plusPercentButton = new LessMoreButton("<html><h1>+</h1></html>", startWindow, this, percentButtonLabel, persoPercent, 2, true);
        JButton lessPercentButton = new LessMoreButton("<html><h1>-</h1></html>", startWindow, this, percentButtonLabel, persoPercent, 2, false);

        persoContainer.add(new JLabel("<html><h1><font color='000000'>Colonne :</font></h1></html>"));
        persoContainer.add(columnButtonLabel);
        persoContainer.add(plusColumnButton);
        persoContainer.add(lessColumnButton);

        persoContainer.add(new JLabel("<html><h1><font color='000000'>Lignes :</font></h1></html>"));
        persoContainer.add(lineButtonLabel);
        persoContainer.add(plusLineButton);
        persoContainer.add(lessLineButton);

        persoContainer.add(new JLabel("<html><h1><font color='000000'>Pourcentage de mines :</font></h1></html>"));
        persoContainer.add(percentButtonLabel);
        persoContainer.add(plusPercentButton);
        persoContainer.add(lessPercentButton);

        // Bouton confirmer pour le choix perso
        JButton confirm = new ConfirmButton("Confirmer", startWindow, this, width, height, 2, 2);

        persoContainer.setVisible(false);

        // Bouton retour 
		    JButton goBack = new GoBackButton("Retour", startWindow, this, width, height, 2, 1); // 1 bouton a placer, ce bouton se placera en premier
    	
        this.add(confirm);
        this.add(goBack);
        this.add(Container);
        this.add(persoContainer);
	}
}
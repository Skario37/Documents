/**
* Cette classe est utilisee pour creer la fenetre d'aide
* @author Leblanc Kevin et Bullou Julien
*/

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridLayout;

public class HelpWindow extends JFrame {

    /**
    * Crée l'écran d'aide
    * @param startWindow Ancienne fenêtre
    * @param width Taille en x de la fenêtre
    * @param height Taille en y de la fenêtre
    */
	public HelpWindow (JFrame startWindow, int width, int height) {
    	super("Aide");
    	
    	startWindow.setVisible(false); // Cache la fenetre des menus

		// Configure la fenetre d'aide
    	this.setSize(width, height); // Taille de la fenetre
    	this.setResizable(false); 
    	this.setLayout(null);
    	this.setContentPane(new Background(width, height)); // Applique l'image de fond sur cette JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            
        int xBorder = (int) (width * 0.3f)/5; // Bordure en x pour les JPanel
        int yBorder =  (int) (height * 0.3f); // Bordure en y pour les JPanel

        // Ajout d'un panel en tant que "filtre" transparent pour écrire
        JPanel filter = new JPanel();
        filter.setBackground(new Color(206, 216, 246, 126)); // Fond bleu ciel semi-transparent
        filter.setBounds(0, yBorder / 10, width, height - yBorder);

        JLabel But = new JLabel();
        JLabel How = new JLabel();
        But.setText("<html><h1><font color=#0A0A2A>But du jeu :</font></h1><br /><font color=#0A0A2A size='4'>Le démineur est un jeu de réflexion dont le but est de localiser des mines cachées dans une grille avec pour seule indication le nombre de mines dans les zones adjacentes.<br />La partie est gagnée lorsque toutes les cases vides sont révélées.<br />La partie est perdue lorsqu'une mine explose.</font></html>");
        How.setText("<html><h1><font color=#0A0A2A>Comment jouer :</font></h1><br /><font color=#0A0A2A size='4'>Faire un clic gauche pour révéler une case.<br />Chaque case révélée indique le nombre de mine à proximité.<br />Vous pouvez marquer une case d'une étoile lorsque la case semble minée ou d'un ? pour un soupçon grâce à un clic droit.<br />Le compteur en haut à gauche indique le nombre de mines qu'il reste à trouver.</font></html>");
        
        // Parametre le Container
        JPanel Container = new JPanel();
        Container.setLayout(new GridLayout(2,1));
        Container.setBounds(xBorder / 2, yBorder / 10, width - xBorder, height - yBorder);
        Container.setOpaque(false); // Desactive l'opacite 
        
        Container.add(But);
        Container.add(How);

        

        // Bouton retour 
		JButton goBack = new GoBackButton("Retour", startWindow, this, width, height, 1, 1); // 1 bouton a placer, ce bouton se placera en premier
    	
        this.add(goBack);
        this.add(Container);
        this.add(filter);
    }
}
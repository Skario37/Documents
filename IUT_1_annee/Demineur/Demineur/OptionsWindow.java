/**
* Cette classe est utilisee pour creer la fenetre des options 
* Note : Pour l'instant il n'existe qu'une seule option qui est le choix de la résolution.
*        Cependant il est tout à fait possible d'en rajouter comme par exemple le choix d'un thème de couleurs...
* @author Leblanc Kevin et Bullou Julien
*/

import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.Color;


public class OptionsWindow extends JFrame {

    /**
    * Crée l'écran d'options
    * @param startWindow Ancienne fenêtre
    * @param width Taille en x de la fenêtre
    * @param height Taille en y de la fenêtre
    */
	public OptionsWindow (JFrame startWindow, int width, int height) {
    	super("Options");

    	startWindow.setVisible(false); // Cache la fenetre des menus

		// Configure la fenetre d'options
    	this.setSize(width, height); // Taille de la fenetre
    	this.setResizable(false); 
    	this.setLayout(null);
    	this.setContentPane(new Background(width, height)); // Applique l'image de fond sur cette JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	int xBorder = (int) (width * 0.3f)/5; // Bordure en x pour les JPanel
        int yBorder =  (int) (height * 0.3f); // Bordure en y pour les JPanel

        //Ajout d'un panel en tant que "filtre" transparent 
        JPanel filter = new JPanel();
        filter.setBackground(new Color(206, 216, 246, 126)); // Fond bleu ciel semi-transparent
        filter.setBounds(0, yBorder / 10, width, height - yBorder);

        // Configure la JComboBox du choix de la resolution
    	JLabel Resolution = new JLabel("Résolution :");
    	String[] elements =  new String[]{"768x1024","1024x768","1280x800","1280x1024","1366x768","1440x900","1600x900","1600x1050","1920x1080"};
    	JComboBox<String> ChooseResolution = new JComboBox<String>(elements);
        if(width == 768){
            ChooseResolution.setSelectedItem("768x1024");
        } else if (width == 1024){
            ChooseResolution.setSelectedItem("1024x768");
        } else if (width == 1280) {
            if (height == 800) {
                ChooseResolution.setSelectedItem("1280x800");
            } else if (height == 1024) {
                ChooseResolution.setSelectedItem("1280x1024");
            }
        } else if (width == 1366) {
            ChooseResolution.setSelectedItem("1366x768");
        } else if (width == 1440) {
            ChooseResolution.setSelectedItem("1440x900");
        } else if (width == 1600) {
            if (height == 900) {
                ChooseResolution.setSelectedItem("1600x900");
            } else if (height == 1050) {
                ChooseResolution.setSelectedItem("1600x1050");
            }
        } else if (width == 1920) {
            ChooseResolution.setSelectedItem("1920x1080");
        }

        
    	JPanel Container = new JPanel();
    	SpringLayout layout = new SpringLayout();
    	
    	// On place Resolution
    	layout.putConstraint(SpringLayout.WEST, Resolution, 0, SpringLayout.WEST, Container);
    	layout.putConstraint(SpringLayout.NORTH, Resolution, yBorder / 10, SpringLayout.NORTH, Container);
    	
    	// On place ChooseResolution
    	layout.putConstraint(SpringLayout.WEST, ChooseResolution, 50, SpringLayout.WEST, Resolution);
		layout.putConstraint(SpringLayout.NORTH, ChooseResolution, 5, SpringLayout.SOUTH, Resolution);

        // Parametre le Container
    	Container.setLayout(layout);
    	Container.setBounds(xBorder / 2, yBorder / 10, width - xBorder, height - yBorder);
    	Container.setOpaque(false);

    	Container.add(Resolution);
    	Container.add(ChooseResolution);

    	// Bouton pour sauvegarder les changements de parametres
    	JButton sauver = new SaveOptionsButton("Sauver", this, width, height, 2, 1, ChooseResolution); // 2 boutons a placer, ce bouton se placera en premier

    	// Bouton retour (ignore tous les changements)
    	JButton goBack = new GoBackButton("Annuler", startWindow, this, width, height, 2, 2); // 2 boutons a placer, ce bouton se placera en second
    	
    	this.add(Container);
    	this.add(sauver);
        this.add(goBack);
        this.add(filter);
	}
}
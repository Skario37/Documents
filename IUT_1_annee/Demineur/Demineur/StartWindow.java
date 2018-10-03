/**
* Cette classe est utilisee pour cree le menu d'ecran titre du demineur
* @author Leblanc Kevin et Bullou Julien
*/

import javax.swing.JFrame;
import javax.swing.JButton;

public class StartWindow extends JFrame {

	private int width; // Taille en x de la fenetre
	private int height; // Taille en y de la fenetre
	private boolean clickable; // Si une sauvegarde existe l'utilisateur peut reprendre une partie sauvegardee

	/**
	* Constructeur
	*/
	public StartWindow () {
		super("Minesweeper by Bullou and Leblanc"); // Titre de la fenetre

		Config config =  new Config();
		// Recupere la configuration
		config.Config();

		// Recupere la taille definie par l'utilisateur (1280x720 par defaut)
		this.width = config.getWidth();
		this.height = config.getHeight();

  		// Configure la fenetre
		this.setSize(width, height); // Donne la taille de la fenetre
  		this.setResizable(false); // Ne peut pas redimmensionner la fenetre (c'est de la triche)
		this.setLayout(null); // Enleve le layout de base

		this.setContentPane(new Background(width, height)); // Applique l'image de fond sur cette JFrame

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme entierement le programme


		// Recupere la variable qui indique si une sauvegarde existe ou non
		this.clickable = config.getSave();
		
		// Crée le bouton pour jouer
		JButton play = new StartButton("Rejouer", this, this.width, this.height, 0.0f, clickable); // Seul bouton qui dépend d'une sauvegarde
		this.add(play);

		// Crée le bouton pour commencer une nouvelle partie
		JButton newGame = new StartButton("Nouvelle Partie", this, this.width, this.height, 0.175f, true);
		this.add(newGame);

		// Crée le bouton pour modifier les paramètres
		JButton option = new StartButton("Options", this, this.width, this.height, 0.35f, true);
		this.add(option);

		// Crée le bouton pour afficher l'aide
		JButton help = new StartButton("Aide", this, this.width, this.height, 0.525f, true);
		this.add(help);

		// Crée le bouton pour quitter le jeu
		JButton leave = new StartButton("Quitter", this, this.width, this.height, 0.7f, true);
		this.add(leave);

	}
}


/**
* Cette classe est utilisee pour commencer le jeu (dependemment si on commence une nouvelle partie ou si on charge une partie sauvegardee)
* @author Leblanc Kevin et Bullou Julien
*/

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

public class GameStart extends JFrame {

    public static JFrame gameFrame;
    public static WithoutMine finishing;
    public static JLabel affProgress;

    /**
    * Constructeur nouvelle partie
    *
    * @param startWindow Ecran titre
    * @param width Taille en x de l'ecran
    * @param height Taille en y de l'ecran
    * @param Column Longueur de la grille
    * @param Line Largeur de la grille
    * @param numberOfMines Nombre de mines a placer dans la grille
    */
	public GameStart(JFrame startWindow, int width, int height, int Column, int Line, int numberOfMines){
		super("Démineur");
        finishing = new WithoutMine(Column * Line - numberOfMines, numberOfMines);

		// Configure la fenetre
    	this.setSize(width, height); // Taille de la fenetre
    	this.setResizable(false); 
    	this.setLayout(null);
    	this.setContentPane(new Background(width, height)); // Applique l'image de fond sur cette JFrame
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	

    	int xBorder = (int) (width * 0.3f)/5; // Bordure en x pour le container
        int yBorder =  (int) (height * 0.3f); // Bordure en y pour le container
        int caseNumber = Column * Line; // Nombre de case dans la grille
        
        // Parametre le Container
        JPanel Container = new JPanel();
        Container.setLayout(null);
        Container.setBounds(xBorder / 2, yBorder / 10, width - xBorder, height - yBorder / 2);
        Container.setOpaque(false); // Desactive l'opacite


        //Créé la grille
        JPanel Grille = new Grid(Generation.Generate(numberOfMines, Column, Line), Column, Line, height - yBorder / 2, height - yBorder / 2);
        Component[] component = Grille.getComponents();

        affProgress = new JLabel();
        affProgress.setBackground(new Color(0, 76, 153));
        affProgress.setText("<html><h1><font color='000000'>" + (numberOfMines - WithoutMine.numberOfFlags) + "</font></h1></html>");
        affProgress.setBounds(width - xBorder, yBorder, 50, 50);
        affProgress.setOpaque(true);

        // Créé bouton sauvegarde
        JButton saveQuit = new SaveQuitButton("Sauver et quitter", this, component, width, height, 10, 10);

        // Bouton retour 
        JButton goBack = new GoBackButton("Quitter", startWindow, this, width, height, 10, 10); // 1 bouton a placer, ce bouton se placera en premier

        Container.add(Grille);

        this.add(goBack);
        this.add(saveQuit);
        this.add(Container);
        this.add(affProgress);
        this.addWindowListener(new CloseWindow(this, component, width, height)); // Nouveaux evenements de la JFrame
        gameFrame = this;

	}

    /**
    * Constructeur partie sauvegardee
    *
    * @param startWindow Ecran tire
    * @param width Taille en x de l'ecran
    * @param height Taille en y de l'ecran
    */
    public GameStart(JFrame startWindow, int width, int height){
        super("Démineur");

        startWindow.setVisible(false);
        // Recupere les parametres pour creer la grille
        SaveGame save = new SaveGame();
        save.openReadSave();
        int Column = save.getColumn();
        int Line = save.getLine();
        int numberOfMines = save.getNumberOfMine();
        save.closeReadSave();

        finishing = new WithoutMine(Column * Line - numberOfMines, numberOfMines);

        // Configure la fenetre
        this.setSize(width, height); // Taille de la fenetre
        this.setResizable(false); 
        this.setLayout(null);
        this.setContentPane(new Background(width, height)); // Applique l'image de fond sur cette JFrame
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        

        int xBorder = (int) (width * 0.3f)/5; // Bordure en x pour le container
        int yBorder =  (int) (height * 0.3f); // Bordure en y pour le container
        int caseNumber = Column * Line; // Nombre de case dans la grille
        
        // Parametre le Container
        JPanel Container = new JPanel();
        Container.setLayout(null);
        Container.setBounds(xBorder / 2, yBorder / 10, width - xBorder, height - yBorder / 2);
        Container.setOpaque(false); // Desactive l'opacite


        //Créé la grille
        JPanel Grille = new Grid(Generation.Loading(), Column, Line, height - yBorder / 2, height - yBorder / 2);
        Component[] component = Grille.getComponents();

        affProgress = new JLabel();
        affProgress.setBackground(new Color(0, 76, 153));
        affProgress.setText("<html><h1><font color='000000'>" + (numberOfMines - WithoutMine.numberOfFlags) + "</font></h1></html>");
        affProgress.setBounds(width - xBorder, yBorder, 50, 50);
        affProgress.setOpaque(true);

        // Créé bouton sauvegarde
        JButton saveQuit = new SaveQuitButton("Sauver et quitter", this, component, width, height, 10, 10);

        // Bouton retour 
        JButton goBack = new GoBackButton("Quitter", startWindow, this, width, height, 10, 10); // 1 bouton a placer, ce bouton se placera en premier

        Container.add(Grille);

        this.add(goBack);
        this.add(saveQuit);
        this.add(Container);
        this.add(affProgress);
        this.addWindowListener(new CloseWindow(this, component, width, height)); // Nouveaux evenements de la JFrame
        gameFrame = this;
    }

}
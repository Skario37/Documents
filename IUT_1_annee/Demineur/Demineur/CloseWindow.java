/**
* Cette classe est utilisee pour ajouter un nouvel evenement a la fermeture de la fenetre du jeu
* @author Leblanc Kevin et Bullou Julien
*/

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Component;

public class CloseWindow implements WindowListener {

    private Component[] compo;
    private JFrame currentWindow;
    private int widthWindow;
    private int heightWindow;

	/**
	* Constructeur
    *
	* @param window Fenetre actuelle
	* @param component Composent actuel
    * @param width Taille en x de la fenetre
    * @param height Taille en y de la fenetre
	*/

	public CloseWindow (JFrame window, Component[] component, int width, int height) {
        this.currentWindow = window;
        this.compo = component;
        this.widthWindow = width;
        this.heightWindow = height;
    }


    @Override
    public void windowClosing(WindowEvent e) {
    	int choice = JOptionPane.showConfirmDialog(this.currentWindow, "Souhaitez-vous sauvegarder et quitter ?");
	    if(choice == JOptionPane.OK_OPTION){
            // Sauvegarde la grille du demineur /!\ ecrase ancien fichier
        	SaveGame save = new SaveGame();
            save.openWriteSave();
            CreateLabel label = (CreateLabel) this.compo[0];
            save.writeColumn(label.getInitialColumn());
            save.writeLine(label.getInitialLine());
            save.writeNumberOfMine(label.getInitialColumn() * label.getInitialLine() - WithoutMine.numberOfCellsWithoutMine);
 
            for(int i=0; i< this.compo.length; i++)
            {

                label = (CreateLabel) this.compo[i];
                save.writeIsMine(label.getIsMine());
                save.writeState(label.getState());

            }
            save.closeWriteSave();

            // Parametre la valeur de sauvegarde a vrai
            Config config = new Config();
            config.setWidth(this.widthWindow);
            config.setHeight(this.heightWindow);
            config.setSave(true);
            config.setConfig(); // On lance l'ecriture dans le fichier userconfig.txt

            System.exit(0); // Quitte le system proprement
	    }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

}
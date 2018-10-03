/**
* Cette classe est utilisee pour ecrire les preferences utilisateur dans le fichier userconfig.txt
* @author Leblanc Kevin et Bullou Julien
*/

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.NullPointerException;
import java.lang.StringIndexOutOfBoundsException;


public class Config {

	private String widthkey = "width=";
	private String heightkey = "height=";
	private String savekey = "save=";
	private String namefile = "userconfig.txt"; /* Fichier contenant les configurations */
	private String tmp; 
	private int width; 
	private int height;
	private FileInputStream inFile = null; 
	private FileWriter outFile = null;
	private DataInputStream flux = null;
	private int ligne; // Lignes du fichier userconfig.txt
	private boolean save; // True si au moins une sauvegarde existe, False si aucune sauvegarde existe

	/**
	* Renvoit la taille en x de l'ecran de l'utilisateur
	* 
	* @return la taille en x de l'ecran
	*/
	public int getWidth () {
		return this.width;
	}

	/**
	* Renvoit la taille en y de l'ecran de l'utilisateur
	*
	* @return la taille en y de l'ecran
	*/
	public int getHeight () {
		return this.height;
	}

	/**
	* Renvoit si une sauvegarde existe ou non 
	*
	* @return valeur sauvegarde (true/false)
	*/
	public boolean getSave () {
		return this.save;
	}

	/**
	* Paramètre la preference la taille en x de l'écran
	* @param p Preference de la taille en x de l'écran
	*/
	public void setWidth(int p) {
		this.width = p;
	}

	/**
	* Paramètre la preference de la taille en y de l'écran
	* @param p Preference de la taille en y de l'écran
	*/
	public void setHeight(int p) {
		this.height = p;
	}

	/**
	* Paramètre si une sauvegarde existe ou non
	* @param p Sauvegarde existe ou non
	*/
	public void setSave(boolean p) {
		this.save = p;
	}

	/**
	* Ecris les preferences dans le fichier de configuration
	*/
	public int setConfig(){
		String[] tab = {this.widthkey + this.width, this.heightkey + this.height, this.savekey + this.save};
		try {
			this.outFile = new FileWriter(this.namefile);
			try {
				for(int i = 0; i < tab.length; i++){ 
					outFile.write(tab[i] + "\n");
				}

			} catch (IOException e) {
				System.err.println("Bad write : " + this.namefile);
				return -1;
			}

			try {
					this.outFile.close();
				} catch (IOException e) {
					System.err.println("Bad file close : " + this.namefile);
					return 1;
				}

		} catch (IOException e) {
			System.err.println("Cannot open file : " + this.namefile);
			return 1;
		}

		return 0;
	}

	/**
	* Applique la taille actuelle de l'ecran de l'utilisateur si la lecture du fichier de configuration a echouee
	*/
	public void SizeDefault () {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.width = (int) screenSize.getWidth();
		this.height = (int) screenSize.getHeight();
	}


	/**
	* Parametre les preferences dans le fichier de configuration
	*/
	public void Config () {
		try {
			this.inFile = new FileInputStream(this.namefile);
			this.flux = new DataInputStream(this.inFile);
			try {
				while((this.tmp = this.flux.readLine()) != null){ // Deprecated api
					try {
						ligne++;
						if(ligne == 1) {
							if(this.tmp.substring(0, 6).equals(this.widthkey)){
								this.tmp = this.tmp.replace(this.widthkey, "");
								this.width = Integer.parseInt(this.tmp);	
							}
						} else if (ligne == 2) {
							if(this.tmp.substring(0, 7).equals(this.heightkey)){
								this.tmp = this.tmp.replace(this.heightkey, "");
								this.height = Integer.parseInt(this.tmp);				
							}
						} else if (ligne == 3) {
							if(this.tmp.substring(0,5).equals(this.savekey)){
								this.tmp = this.tmp.replace(this.savekey, "");
								this.save = Boolean.valueOf(tmp);
							}
						}
					} catch (StringIndexOutOfBoundsException e) {
						System.err.println("Incorrect line  '" + ligne + "' : " + this.namefile);	
						this.SizeDefault();	
					}
				}
				try {
					this.flux.close();
				} catch (IOException e) {
					System.err.println("Bad file close : " + this.namefile);
					this.SizeDefault();
				}

			} catch (IOException e) {
				System.err.println("Cannot read file : " + this.namefile);
				this.SizeDefault();	
			}
		} catch (FileNotFoundException e) {
			System.err.println("Cannot open file : " + this.namefile);
			this.SizeDefault();	
		}
	}
}
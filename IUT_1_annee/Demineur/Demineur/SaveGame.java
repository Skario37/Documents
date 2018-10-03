/**
* Cette classe est utilisee pour lire / ecrire des donnees dans le fichier de sauvegarde
* @author Kévin LEBLANC
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.NullPointerException;
import java.lang.StringIndexOutOfBoundsException;

public class SaveGame {

	private String namefile = "save.dat"; /* Fichier contenant les configurations */
	private File file;
	private boolean isSaved;
	private FileOutputStream outFile = null;
	private FileInputStream inFile = null; 
	private DataOutputStream outFlux = null;
	private DataInputStream inFlux = null;

	
	/**
	* Renvoit la longueur de la grille
	*
	* @return longueur grille
	*/
	public int getColumn() {
		try {
			return this.inFlux.readInt();
		} catch (IOException e) {
			System.err.println("Erreur lors de la lecture de la longueur de la grille");
			return -1;
		}
	}

	/**
	* Renvoit la largeur de la grille
	*
	* @return largeur grille
	*/
	public int getLine() {
		try {
			return this.inFlux.readInt();
		} catch(IOException e) {
			System.err.println("Erreur lors de la lecture de la hauteur de la grille");
			return -1;
		}
	}

	/**
	* Renvoit le nombre de mine dans la grille
	*
	* @return nombre de mine
	*/
	public int getNumberOfMine(){
		try {
			return this.inFlux.readInt();
		} catch (IOException e) {
			System.err.println("Erreur lors de la lecture du nombre de bombes");
			return -1;
		}
	}

	/**
	* Renvoit si la case est une mine
	*
	* @return est une mine (true/false)
	*/
	public boolean getIsMine() {
		try{
			return this.inFlux.readBoolean();
		}
		catch (IOException e) {
			System.err.println("Erreur lors de la lecture d'une case minee ou non");
			return false;
		}
	}

	/**
	* Renvoit l'etat de la case 
	*
	* @return etat de la case
	*/
	public int getState() {
		try {
			return this.inFlux.readInt();
		} catch (IOException e) {
			System.err.println("Erreur lors de la lecture de l'etat d'une case");
			return -1;
		}
	}

	
	

	/**
	* Ecrit longueur de la grille
	*
	* @param p Longueur de la grille
	*/
	public void writeColumn(int p){
		try {
			this.outFlux.writeInt(p);
		} catch(IOException e) {
			System.err.println("Erreur lors de l'ecriture de la hauteur de la grille");
		}
	}

	/**
	* Ecrit la largeur de la grille
	*
	* @param p Largeur de la grille
	*/
	public void writeLine(int p){
		try {
			this.outFlux.writeInt(p);
		} catch(IOException e) {
			System.err.println("Erreur lors de l'ecriture de la longueur de la grille");
		}
	}

	/**
	* Ecrit le nombre de mine  
	*
	* @param p nombre de mine
	*/
	public void writeNumberOfMine(int p){
		try {
			this.outFlux.writeInt(p);
		} catch(IOException e) {
			System.err.println("Erreur lors de l'ecriture du nombre de bombes");
		}
	}

	/**
	* Ecrit si la case est une mine
	*
	* @param p Est une mine (true/false)
	*/
	public void writeIsMine(boolean p){
		try {
			this.outFlux.writeBoolean(p);
		} catch(IOException e) {
			System.err.println("Erreur lors de l'ecriture d'une case minee ou non");
		}
	}

	/**
	* Ecrit l'etat de la case 
	*
	* @param p Etat de la case
	*/
	public void writeState(int p){
		try {
			this.outFlux.writeInt(p);
		} catch(IOException e) {
			System.err.println("Erreur lors de l'ecriture de l'etat d'une case");
		}
	}

	
	/**
	* Ouvre le fichier en lecture
	*/
	public void openReadSave () {
		try {
			this.inFile = new FileInputStream(this.namefile);
			this.inFlux = new DataInputStream(this.inFile);
			
		} catch (IOException e) {
			System.err.println("Cannot open file : " + this.namefile);
		}
	}

	/**
	* Ouvre le fichier en ecriture
	*/
	public void openWriteSave(){
		try {
			this.outFile = new FileOutputStream(this.namefile);
			this.outFlux = new DataOutputStream(this.outFile);
			
		} catch (IOException e) {
			System.err.println("Cannot open file : " + this.namefile);
		}
	}

	/**
	* Ferme le fichier en lecture
	*/
	public void closeReadSave () {
		try {
			this.inFile.close();
			this.inFlux.close();
			this.inFile = null;
			this.inFlux = null;
		} catch(IOException e) {
			System.err.println("Erreur lors de la fermeture des fichiers");
		}
	}

	/**
	* Ferme le fichier en ecriture
	*/
	public void closeWriteSave(){
		try {
			this.outFile.close();
			this.outFlux.close();
			this.outFile = null;
			this.outFlux = null;
		} catch(IOException e) {
			System.err.println("Erreur lors de la fermeture des fichiers");
		}
	}

	/**
	* Constructeur
	*/
	public SaveGame(){
		this.file = new File(namefile);
		this.isSaved = file.exists();
		try {
			this.file.createNewFile();
		} catch (IOException e) {}
	}
}
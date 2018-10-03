/**
* Cette classe est utilisee pour definir les evenements souris des cases du demineur
* @author Leblanc Kevin et Bullou Julien
*/

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class LabelEvents implements MouseListener {

	private CreateLabel[][] tabGrid;
    private CreateLabel Component;
    private CreateLabel Neighbor;
    private String flag = "<html><h1><font color='ec008c'>&#9733;</font></h1></html>";
    private String suspicion = "<html><h1><font color='ec008c'>?</font></h1></html>";
    private String beforeText = "<html><h1><font color='d7df23'>";
    private String afterText = "</font></h1></html>";
    private String bomb = "<html><h1><font color='000000'>&#9760</font></h1></html>";
    private int State;

    /**
    * Constructeur
    */
	public LabelEvents(){
        this.State = 0;
    }

	@Override
    public void mouseClicked(MouseEvent e) {
        // Enregistre quel bouton de la souris est enfoncé.
        
        int buttonDown = e.getButton();
        this.Component = (CreateLabel) e.getComponent();
        this.tabGrid = this.Component.getFinalGrid();

        if (WithoutMine.gridClickable) {
           
            if (buttonDown == MouseEvent.BUTTON1 && this.Component.getState() == 0 && WithoutMine.numberOfCellsWithoutMine != 0) {
                   // Bouton GAUCHE enfoncé
                	if (this.Component.getIsMine()) {
                		for(int i = 0; i < this.Component.getInitialColumn(); i++){
                			for (int j = 0; j < this.Component.getInitialLine(); j++) {
                				
                				if(this.tabGrid[i][j].getIsMine()){
                					this.tabGrid[i][j].RevealCase();
                                    this.tabGrid[i][j].setBackground(Color.RED);
                                    this.tabGrid[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                                    if(i == this.Component.getColumn() && j == this.Component.getLine()){
                                        this.tabGrid[i][j].setText("<html><h1><font color='000000'>X</font></h1></html>");

                                    } else {
                                        this.tabGrid[i][j].setText(this.bomb);
                                    }
                                    
                					WithoutMine.gridClickable = false;

                				}

                			}
                		}

                        GameStart.finishing.affFinish("Vous avez perdu ! Dommage contemplez bien votre défaite !");

                	} else {
                		if(this.Component.getState() != 3){
                            this.State = 3;
                			Reveal(this.Component.getColumn(), this.Component.getLine());
                		}
                		if(WithoutMine.numberOfCellsWithoutMine == 0){
                			WithoutMine.gridClickable = false;
                            GameStart.finishing.affFinish("Vous avez gagnez! Profitez de votre magnifique victoire !");
                		}
                	}


            } else if(buttonDown == MouseEvent.BUTTON2) {
                   // Bouton du MILIEU enfoncé
            } else if(buttonDown == MouseEvent.BUTTON3) {
                   // Bouton DROIT enfoncé
                    this.Component.setHorizontalAlignment(SwingConstants.CENTER);
                    if(this.Component.getState() == 0) {
                        WithoutMine.numberOfFlags += 1;
                        this.Component.setText(this.flag); // Drapeau
                        this.State = 1;
                        this.Component.setState(this.State);
                        
                    } else if(this.Component.getState() == 1){
                        WithoutMine.numberOfFlags -= 1;
                       	this.Component.setText(this.suspicion); // Soupçon
                        this.State = 2;
                        this.Component.setState(this.State);
                        
                    } else if(this.Component.getState() == 2){
                        this.Component.setText(""); // Case normale
                        this.State = 0;
                        this.Component.setState(this.State);
                    }
                    
            }

            GameStart.affProgress.setText("<html><h1><font color='000000'>" + (WithoutMine.numberOfMine - WithoutMine.numberOfFlags) + "</font></h1></html>");

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e){

    }

    @Override
    public void mousePressed(MouseEvent e){

    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    public void Reveal(int Column, int Line){
        if (this.tabGrid[Column][Line].getState() == 1) {
            WithoutMine.numberOfFlags -= 1;
        }
    	this.tabGrid[Column][Line].RevealCase();
    	WithoutMine.numberOfCellsWithoutMine--;
    	if (this.tabGrid[Column][Line].getNeighborMine() == 0) {
    		this.tabGrid[Column][Line].setBackground(new Color(128, 128, 128));
            this.tabGrid[Column][Line].setText("");
    		FillCase(Column, Line);
    	} else {
    		this.tabGrid[Column][Line].setBackground(new Color(96, 96, 96));
	    	String Text = Integer.toString(this.tabGrid[Column][Line].getNeighborMine());
            this.tabGrid[Column][Line].setHorizontalAlignment(SwingConstants.CENTER);
	    	this.tabGrid[Column][Line].setText(this.beforeText + Text + this.afterText);
    	}
    	
    }

    public void FillCase(int Column, int Line){
    	for (int i = -1; i <= 1; i++) {
    		for (int j = -1; j <= 1; j++) {
    			int iPos = Column + i;
    			int jPos = Line + j;
    			if(iPos > -1 && iPos < this.tabGrid[Column][Line].getInitialColumn() && jPos > -1 && jPos < this.tabGrid[Column][Line].getInitialLine()){
    				CreateLabel caseNeighbor = this.tabGrid[iPos][jPos];
    				boolean Mined = caseNeighbor.getIsMine();
    				if (!Mined && caseNeighbor.getState() == 0) {
    					Reveal(iPos, jPos);
    				}
    			}
    		}
    	}
    }

}

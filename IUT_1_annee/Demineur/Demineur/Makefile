JC = javac 
JRUN = java
MAIN = Demineur
.SUFFIXES: .java .class 
.java.class: 
	$(JC) $(JFLAGS) $*.java 

CLASSES = \
	BackEvents.java \
	BackGround.java \
	ButtonEvents.java \
	CloseWindow.java \
	Config.java \
	ConfirmButton.java \
	ConfirmButtonEvents.java \
	CreateLabel.java \
	GameStart.java \
	Generation.java \
	GoBackButton.java \
	Grid.java \
	GridButton.java \
	GridButtonEvents.java \
	HelpWindow.java \
	LabelEvents.java \
	LessMoreButton.java \
	LessMoreButtonEvents.java \
	NewGame.java \
	OptionsWindow.java \
	PersoButton.java \
	PersoButtonEvents.java \
	SaveGame.java \
	SaveOptionsButton.java \
	SaveOptionsEvents.java \
	SaveQuitButton.java \
	SaveQuitButtonEvents.java \
	StartButton.java \
	StartWindow.java \
	WithoutMine.java \
	Demineur.java
	

default : 
	Demineur.class: StartWindow.class 
	$(JC) Demineur.java 

	StartWindow.class: Config.class Background.class StartButton.class 
	$(JC) StartWindow.java

	Config.class: 
	$(JC) Config.java

	Background.class:
	$(JC) Background.java

	StartButton.class: ButtonEvents.class
	$(JC) StartButton.java

	ButtonEvents.class:	GameStart.class NewGame.class OptionsWindow.class HelpWindow.class
	$(JC) ButtonEvents.java

	GameStart.class: WithoutMine.class Background.class Grid.class Generation.class SaveQuitButton.class GoBackButton.class CloseWindow.class SaveGame.class
	$(JC) GameStart.java

	WithoutMine.class: 
	$(JC) WithoutMine.java

	Grid.class: CreateLabel.class 
	$(JC) Grid.java

	CreateLabel.class: LabelEvents.class
	$(JC) CreateLabel.java

	LabelEvents.class: 
	$(JC) Reveal.java

	Generation.class: CreateLabel.class SaveGame.class
	$(JC) Generation.java

	SaveGame.class:
	$(JC) SaveGame.java

	SaveQuitButton.class: SaveQuitButtonEvents.class
	$(JC) SaveQuitButton.java

	SaveQuitButtonEvents.class: SaveGame.class
	$(JC) SaveQuitButtonEvents.java

	GoBackButton.class: BackEvents.class
	$(JC) GoBackButton.java

	BackEvents.class: 
	$(JC) BackEvents.java

	CloseWindow.class: SaveGame.class Config.class
	$(JC) CloseWindow.java

	NewGame.class: Background.class GridButton.class PersoButton.class LessMoreButton.class ConfirmButton.class GoBackButton.class
	$(JC) NewGame.java

	GridButton.class: GridButtonEvents.class
	$(JC) GridButton.java

	GridButtonEvents.class: GameStart.class
	$(JC) GridButtonEvents.java

	PersoButton.class: PersoButtonEvents.class
	$(JC) PersoButton.java

	PersoButtonEvents.class: 
	$(JC) PersoButtonEvents.java

	LessMoreButton.class: LessMoreButtonEvents.class
	$(JC) LessMoreButton.java

	LessMoreButtonEvents.class:
	$(JC) LessMoreButtonEvents.java

	ConfirmButton.class: ConfirmButtonEvents.class
	$(JC) ConfirmButton.java

	ConfirmButtonEvents.class: GameStart.class
	$(JC) ConfirmButtonEvents.java

	OptionsWindow.class: BackGround.class SaveOptionsButton.class GoBackButton.class
	$(JC) OptionsWindow.java

	SaveOptionsButton.class: SaveOptionsEvents.class 
	$(JC) SaveOptionsButton.java

	SaveOptionsEvents.class: Config.class 
	$(JC) SaveOptionsEvents.java

	HelpWindow.class: Background.class GoBackButton.class
	$(JC) HelpWindow.java
	
test: $(MAIN).class
	$(JRUN) $(MAIN)

clean :
	-rm -f *.class 

.PHONY : but clean
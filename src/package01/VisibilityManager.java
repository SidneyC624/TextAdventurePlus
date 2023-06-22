package package01;

public class VisibilityManager {
	UI ui;
	
	public VisibilityManager(UI ui) {
		this.ui = ui;
	}
	
	public void showTitleScreen() {
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		
		ui.playerPanel.setVisible(false);
		ui.mainTextPanel.setVisible(false);
		ui.choicePanel.setVisible(false);
	}
	
	public void titleToTown() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		
		ui.playerPanel.setVisible(true);
		ui.mainTextPanel.setVisible(true);
		ui.choicePanel.setVisible(true);
	}
}

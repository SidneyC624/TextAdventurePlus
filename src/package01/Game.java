package package01;
import java.awt.event.*;

public class Game {
	ChoiceHandler cHandler = new ChoiceHandler();
	UI ui = new UI();
	VisibilityManager vm = new VisibilityManager(ui);
	Story story = new Story(this, ui, vm);
	
	public static void main(String[] args) {
		new Game();

	}
	
	public Game() {
		ui.createUI(cHandler);
		story.defaultSetup();
		vm.showTitleScreen();
		
	}
	
	public class ChoiceHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String yourChoice = e.getActionCommand();
			
			switch(yourChoice) {
			case "start": vm.titleToTown(); break;
			case "c1": break;
			case "c2": break;
			case "c3": break;
			case "c4": break;
			}
			
		}
		
	}

}

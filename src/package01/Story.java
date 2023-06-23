package package01;

import java.util.Random;

import package02.Monster_Gandalf;
import package02.Monster_Goblin;
import package02.SuperMonster;
import package02.Weapon_Knife;
import package02.Weapon_LongSword;

public class Story {
	Game game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
	SuperMonster monster;
	Random random = new Random();
	int silverRing = 0;
	
	public Story(Game game, UI ui, VisibilityManager vm) {
		this.game = game;
		this.ui = ui;
		this.vm = vm;
	}
	
	public void defaultSetup() {
		player.hp = 10;
		ui.hpLabelNumber.setText(String.valueOf(player.hp));
		
		player.currentWeapon = new Weapon_Knife();
		ui.weaponLabelName.setText(player.currentWeapon.name);
	}
	
	public void selectPosition(String nextPosition) {
		
		switch(nextPosition) {
		case "townGate": townGate(); break;
		case "talkGuard": talkGuard(); break;
		case "attackGuard": attackGuard(); break;
		case "crossRoad": crossRoad(); break;
		case "north": north(); break;
		case "east": east(); break;
		case "west": west(); break;
		case "fight": fight(); break;
		case "playerAttack": playerAttack(); break;
		case "monsterAttack": monsterAttack(); break;
		case "win": win(); break;
		case "lose": lose(); break;
		case "toTitle": toTitle(); break;
		}
	}
	
	public void townGate() {
		ui.mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you."
				+ "\nWhat do you do?");
		ui.choice1.setText("Talk to the guard");
		ui.choice2.setText("Attack the guard");
		ui.choice3.setText("Leave");
		ui.choice4.setText("");
		
		game.nextPosition1 = "talkGuard";
		game.nextPosition2 = "attackGuard";
		game.nextPosition3 = "crossRoad";
		game.nextPosition4 = "";
	}
	
	public void talkGuard() {
		if(silverRing== 0) {
			ui.mainTextArea.setText("Guard: Hello stranger. I have never seen your face. "
					+ "\nI'm sorry but I cannot let a stranger enter our town");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "townGate";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if(silverRing == 1) {
			ending();
		}
	}
	
	public void attackGuard() {
		ui.mainTextArea.setText("Guard: Hey don't be stupid! \nThe guard fought back and hit you hard"
				+ "\n(You receive 3 damage)");
		player.hp -= 3;
		ui.hpLabelNumber.setText(String.valueOf(player.hp));
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "townGate";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void crossRoad() {
		ui.mainTextArea.setText("You are at a crossroad. \nIf you go south, you will go back to the town");
		ui.choice1.setText("Go north");
		ui.choice2.setText("Go east ");
		ui.choice3.setText("Go south");
		ui.choice4.setText("Go west");
		
		game.nextPosition1 = "north";
		game.nextPosition2 = "east";
		game.nextPosition3 = "townGate";
		game.nextPosition4 = "west";
	}
	
	public void north() {
		ui.mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. "
				+ "\n(Your HP is recovered by 2)");
		player.hp += 2;
		ui.hpLabelNumber.setText(String.valueOf(player.hp));
		ui.choice1.setText("Go south");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "crossRoad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void east() {
		ui.mainTextArea.setText("You walked into a forest and found a long sword!"
				+ "\n\n(You obtained a long sword)");
		player.currentWeapon = new Weapon_LongSword();
		ui.weaponLabelName.setText(player.currentWeapon.name);
		ui.choice1.setText("Go west");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "crossRoad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void west() {
		int i = random.nextInt(100) + 1; //1 to 100
		if(i <= 90) {
			monster = new Monster_Goblin();
		}
		else {
			monster = new Monster_Gandalf();
		}
	
		ui.mainTextArea.setText("You encounter a " + monster.name + "!");
		ui.choice1.setText("Fight");
		ui.choice2.setText("Run");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "fight";
		game.nextPosition2 = "crossRoad";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void fight() {
		ui.mainTextArea.setText("Monster HP: " + monster.hp + "\n\nWhat do you do?");
		ui.choice1.setText("Attack");
		ui.choice2.setText("Run");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "playerAttack";
		game.nextPosition2 = "crossRoad";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void playerAttack() {
		int playerDamage = random.nextInt(player.currentWeapon.damage);
		monster.hp -= playerDamage;
		
		ui.mainTextArea.setText("You attacked the " + monster.name + " and dealt " + playerDamage + " damage!");
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		if(monster.hp > 0) {
			game.nextPosition1 = "monsterAttack";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if(monster.hp < 1) {
			game.nextPosition1 = "win";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void monsterAttack() {
		int monsterDamage = random.nextInt(monster.damage);
		player.hp -= monsterDamage;
		ui.hpLabelNumber.setText(String.valueOf(player.hp));
		
		ui.mainTextArea.setText(monster.attackMessage + "\nIt dealt " + monsterDamage + " damage to you");
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		if(player.hp > 0) {
			game.nextPosition1 = "fight";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if(player.hp < 1) {
			game.nextPosition1 = "lose";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void win() {
		ui.mainTextArea.setText("You defeated the goblin! \nThe goblin dropped a ring! "
				+ "\n(You obtained a Silver Ring)");
		silverRing = 1;
		
		ui.choice1.setText("Go east");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "crossRoad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void lose() {
		ui.mainTextArea.setText("You are dead! \n\n<GAME OVER>");
		silverRing = 1;
		
		ui.choice1.setText("To the title screen");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "toTitle";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void ending() {
		ui.mainTextArea.setText("Guard: Oh you killed the goblin!? \nYou are a true hero! \n\n<THE END>");
		
		ui.choice1.setVisible(false);
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
	}
	
	public void toTitle() {
		defaultSetup();
		vm.showTitleScreen();
	}
}

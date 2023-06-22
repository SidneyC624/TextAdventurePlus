package package01;

import package02.Weapon_Knife;

public class Story {
	Game game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
	
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
}

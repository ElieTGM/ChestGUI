package me.elietgm.chestgui;

import org.bukkit.plugin.java.JavaPlugin;

public class ChestCore extends JavaPlugin {

	private static ChestCore instance;

	public static ChestCore getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
	}

}

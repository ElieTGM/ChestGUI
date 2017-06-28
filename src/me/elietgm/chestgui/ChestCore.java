package me.elietgm.chestgui;

import org.bukkit.plugin.java.JavaPlugin;

import me.elietgm.chestgui.api.ItemCreator;
import me.elietgm.chestgui.api.SkullCreator;

public class ChestCore extends JavaPlugin {

	private static ChestCore instance;
	public static ChestCore getInstance() { return instance; }
	
	public static ItemCreator getItemCreator() {return new ItemCreator(); }
	public static SkullCreator getSkullCreator() {return new SkullCreator(); }
	
	@Override
	public void onEnable() {
		instance = this;		
	}
	
}

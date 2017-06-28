package me.elietgm.chestgui;

import org.bukkit.plugin.java.JavaPlugin;

import me.elietgm.chestgui.api.ItemCreator;
import me.elietgm.chestgui.api.SkullCreator;

public class ChestCore extends JavaPlugin {

	//4e879827186621dab1f4e52e9d3936e3bd7eb824//
	
	private static ChestCore instance;
	public static ChestCore getInstance() { return instance; }
	
	public static ItemCreator getItemCreator() {return new ItemCreator(); }
	public static SkullCreator getSkullCreator() {return new SkullCreator(); }
	
	@Override
	public void onEnable() {
		instance = this;		
	}
	
}

package me.elietgm.chestgui.api;

import org.bukkit.inventory.ItemStack;

public abstract class GUICallback {

	public static enum CallbackType {
		INIT,
		CLICK,
		CLOSE,
	}
	
	public abstract void firstCall(ChestGUI gui, CallbackType callback, ItemStack item);
	
	public abstract void secondCall(ChestGUI gui); //More descriptive names?
}

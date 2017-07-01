package me.elietgm.chestgui.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import me.elietgm.chestgui.ChestCore;

public class ChestGUI implements Listener {

	public String playerName;
	public Inventory inventory; // Try to use descriptive names!
	public GUICallback guiCallback;
	public boolean aC;
	private boolean iO; // Lets make this field private cause its not
						// configurable!

	public ChestGUI iN;

	public ChestGUI(Player player, int size, String title, boolean allowClick, GUICallback callback) {
		playerName = player.getName(); // Not need to store the Player object!
		this.inventory = Bukkit.createInventory(null, size, title);
		this.guiCallback = callback;
		this.aC = allowClick;
		this.iO = true;
		this.iN = this;

		guiCallback.firstCall(this, GUICallback.CallbackType.INIT, null);

		player.openInventory(inventory);

		ChestCore.getInstance().getServer().getPluginManager().registerEvents(this, ChestCore.getInstance());

		new BukkitRunnable() {
			public void run() {
				if (iO) {
					guiCallback.secondCall(iN);
				} else {
					this.cancel();
				}
			}
		}.runTaskTimer(ChestCore.getInstance(), 10L, 20L);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (event.getWhoClicked().getName().equals(playerName)) { // Always
																	// compare
																	// String
																	// with
																	// equals
			try {
				if (!aC)
					event.setCancelled(true);

				guiCallback.firstCall(this, GUICallback.CallbackType.CLICK, event.getCurrentItem());
			} catch (Exception e) {
				// Nope
			}
		}
	}

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {
		if (event.getPlayer().getName().equals(playerName)) {
			HandlerList.unregisterAll(this);

			guiCallback.firstCall(this, GUICallback.CallbackType.CLOSE, null);
		}
	}
}

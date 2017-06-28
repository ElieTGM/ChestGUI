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

	public Player p;
	public Inventory i;
	public GUICallback c;
	public boolean aC;
	public boolean iO;
	
	public ChestGUI iN;
	
	public ChestGUI(Player player, int size, String title, boolean allowClick, GUICallback callback) {
		this.p = player;
		this.i = Bukkit.createInventory(null, size, title);
		this.c = callback;
		this.aC = allowClick;
		this.iO = true;
		this.iN = this;
		
		c.callback(this, GUICallback.CallbackType.INIT, null);
		
		p.openInventory(i);
		
		ChestCore.getInstance().getServer().getPluginManager().registerEvents(this, ChestCore.getInstance());
		
		new BukkitRunnable() {
			public void run() {
				new BukkitRunnable() {
					public void run() {
						if(iO) {
							c.onSecond(iN);
						} else {
							this.cancel();
						}
					}
				}.runTaskTimer(ChestCore.getInstance(), 0, 20L);
			}
		}.runTaskLater(ChestCore.getInstance(), 10L);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if(event.getWhoClicked().getName() == p.getName()) {
			try {
				if(!aC) {
					event.setCancelled(true);
				}
				
				c.callback(this, GUICallback.CallbackType.CLICK, event.getCurrentItem());
			} catch (Exception e) {
				//Nope
			}
		}
	}
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {
		if(event.getPlayer().getName() == p.getName()) {
			HandlerList.unregisterAll(this);
			
			c.callback(this, GUICallback.CallbackType.CLOSE, null);
		}
	}
}

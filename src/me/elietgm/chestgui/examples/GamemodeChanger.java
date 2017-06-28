package me.elietgm.chestgui.examples;

import java.util.Arrays;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.elietgm.chestgui.ChestCore;
import me.elietgm.chestgui.api.ChestGUI;
import me.elietgm.chestgui.api.GUICallback;
import me.elietgm.chestgui.utils.Colorizer;

public class GamemodeChanger {
	
	/**
	 * Let's first create a static method to open our GUI, it can be done with static too.
	 * The param we're using is the player to open the gui for.
	 */

	public static void open(Player player) {
		
		/**
		 * As seen in the documentation, let's first initiate ChestGUI and the callback.
		 * 
		 * We're currently creating a gui, that will open for player (player), with 27 slots,
		 * and name 'GameMode Manager', where players aren't allowed to take items out of the
		 * gui (thus the boolean false).
		 */
		
		new ChestGUI(player, 27, "GameMode Manager", false, new GUICallback() {

			@Override
			public void callback(ChestGUI gui, CallbackType callback, ItemStack item) {
				
				/**
				 * Now let's check if the callback is INIT (stall); if it is, let's set the
				 * items.
				 */
				if(callback == CallbackType.INIT) {
					
					/**
					 * You can also add fancy if statements too! Take a look at this one,
					 * we'll check if the player's gamemode is creative; and put a redstone
					 * block instead of emerald in gui when he wants to change, and vice-versa.
					 * 
					 * We'll be going from Survival -> Creative -> Adventure
					 */
					
					if(player.getGameMode() == GameMode.CREATIVE) {
						
						/**
						 * We're gonna create an emerald block, named survival mode. It'll be emerald
						 * since the player's gamemode is Creative, and not Survival.
						 */
						gui.i.setItem(11, ChestCore.getItemCreator().createItem(Material.EMERALD_BLOCK,
								1, 0, "&aSurvival Mode",
								Arrays.asList("&7Switch to survival mode by clicking here!")));
						
						/**
						 * Now here's the trick, we've created this as a Redstone Block, because the
						 * player's gamemode is ALREADY creative, he won't change from Creative to
						 * Creative.
						 */
						gui.i.setItem(13, ChestCore.getItemCreator().createItem(Material.REDSTONE_BLOCK,
								1, 0, "&cCreative Mode",
								Arrays.asList("&7You cannot switch to Creative Mode...")));
						
						/**
						 * We're gonna create an emerald block, named adventure mode. It'll be emerald
						 * since the player's gamemode is Creative, and not Adventure.
						 */
						gui.i.setItem(15, ChestCore.getItemCreator().createItem(Material.EMERALD_BLOCK,
								1, 0, "&aAdventure Mode",
								Arrays.asList("&7Switch to adventure mode by clicking here!")));
					
					}
					
					if(player.getGameMode() == GameMode.SURVIVAL) {
						
						/**
						 * We're gonna create a redstone block, named survival mode. It'll be redstone
						 * since the player's gamemode is Survival, and he won't change from Survival
						 * to Survival.
						 */
						gui.i.setItem(11, ChestCore.getItemCreator().createItem(Material.REDSTONE_BLOCK,
								1, 0, "&cSurvival Mode",
								Arrays.asList("&7You cannot switch to Survival Mode...")));
						
						/**
						 * We're gonna create an emerald block, named Creative mode. It'll be emerald
						 * since the player's gamemode is Survival, and not Creative.
						 */
						gui.i.setItem(13, ChestCore.getItemCreator().createItem(Material.EMERALD_BLOCK,
								1, 0, "&aCreative Mode",
								Arrays.asList("&7Switch to Creative Mode by clicking here!")));
						
						/**
						 * We're gonna create an emerald block, named adventure mode. It'll be emerald
						 * since the player's gamemode is Survival, and not Adventure.
						 */
						gui.i.setItem(15, ChestCore.getItemCreator().createItem(Material.EMERALD_BLOCK,
								1, 0, "&aAdventure Mode",
								Arrays.asList("&7Switch to adventure mode by clicking here!")));
					
					}
					
					if(player.getGameMode() == GameMode.ADVENTURE) {
						
						/**
						 * We're gonna create an emerald block, named survival mode. It'll be emerald
						 * since the player's gamemode is Adventure, and not Survival.
						 */
						gui.i.setItem(11, ChestCore.getItemCreator().createItem(Material.EMERALD_BLOCK,
								1, 0, "&aSurvival Mode",
								Arrays.asList("&7Switch to survival mode by clicking here!")));
						
						/**
						 * We're gonna create an emerald block, named Creative mode. It'll be emerald
						 * since the player's gamemode is Adventure, and not Creative.
						 */
						gui.i.setItem(13, ChestCore.getItemCreator().createItem(Material.EMERALD_BLOCK,
								1, 0, "&aCreative Mode",
								Arrays.asList("&7Switch to Creative Mode by clicking here!")));
						
						/**
						 * We're gonna create a redstone block, named adventure mode. It'll be redstone
						 * since the player's gamemode is Adventure, and he won't change from Adventure
						 * to Adventure.
						 */
						gui.i.setItem(15, ChestCore.getItemCreator().createItem(Material.REDSTONE_BLOCK,
								1, 0, "&cAdventure Mode",
								Arrays.asList("&7You cannot switch to Adventure Mode...")));
					
					}
					
				}
				
				/**
				 * Now we're gonna check if the player clicks an item, we do something about it. For 
				 * that, we're gonna call the CLICK callback type.
				 */
				
				if(callback == CallbackType.CLICK) {
					
					/**
					 * There's actually two methods to approach gamemode changes now. Since they are
					 * basically the same stripped names (Adventure Mode, Creative Mode, Survival Mode)
					 * we can either strip the names and check for gamemodes then run the code, or don't
					 * strip at all, and check the names based on color values. We're gonna use the 
					 * second method, as it is more complicated and as the first method is already
					 * documentated in the Wiki section!
					 */
					
					/**
					 * Let's first get the item name with color values.
					 */
					String itemName = item.getItemMeta().getDisplayName();
					
					/**
					 * Let's check if the clicked item has the name with color code "&cSurvival Mode",
					 * if you remember correctly, players aren't allowed to change to the same gamemode
					 * they're in.
					 */
					if(itemName.equalsIgnoreCase(Colorizer.color("&cSurvival Mode"))) {
						
						/**
						 * Let's close the inventory and send the player a message.
						 */
						player.closeInventory();
						player.sendMessage(Colorizer.color("&a[GUI-Test] &cYou can't change from gamemode"
								+ "to the same gamemode you have right now!"));
						
					}
					
					/**
					 * Let's now check if the item has the name with color code "&aSurvival Mode",
					 * if you remember correctly, players can change to this gamemode since it isn't the
					 * gamemode they currently have.
					 */
					
					if(itemName.equalsIgnoreCase(Colorizer.color("&aSurvival Mode"))) {
						
						/**
						 * Let's close the inventory and send the player a message and change his
						 * gamemode.
						 */
						
						player.closeInventory();
						player.sendMessage(Colorizer.color("&a[GUI-Test] &aYour gamemode has been succesfully"
								+ "changed to survival!"));
						
						player.setGameMode(GameMode.SURVIVAL);
					}
					
					/**
					 * The rest is the same thing, you get the idea.
					 */
					
				}
				
			}

			@Override
			public void onSecond(ChestGUI gui) {

			}
			
		});
		
	}
}

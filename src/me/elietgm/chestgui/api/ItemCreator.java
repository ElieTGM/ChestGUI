package me.elietgm.chestgui.api;

import java.util.List;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;

import me.elietgm.chestgui.utils.Colorizer;

public class ItemCreator {

	public ItemStack createItem(Material type, int amount, int data, String name, List<String> lore) {
		ItemStack item = new ItemStack(type, 1, (short) data);
		ItemMeta meta = item.getItemMeta();
		
		item.setAmount(amount);
		
		meta.setDisplayName(Colorizer.color(name));
		meta.setLore(Colorizer.colorList(lore));
		
		item.setItemMeta(meta);
		
		return item;
	}
	
	public ItemStack createItemPotion(Material type, int amount, int data, String name, List<String> lore) {
		ItemStack item = new ItemStack(type, 1, (short) data);
		PotionMeta meta = (PotionMeta) item.getItemMeta();
		
		meta.clearCustomEffects();
		
		item.setAmount(amount);
		
		meta.setDisplayName(Colorizer.color(name));
		meta.setLore(Colorizer.colorList(lore));
		
		item.setItemMeta(meta);
		
		return item;
	}
	
	public ItemStack createItem(Material type, int amount, int data, String name) {
		ItemStack item = new ItemStack(type, 1, (short) data);
		ItemMeta meta = item.getItemMeta();
		
		item.setAmount(amount);
		
		meta.setDisplayName(Colorizer.color(name));
		
		item.setItemMeta(meta);
		
		return item;
	}
	
	public ItemStack createArmour(Material type, int amount, Color color, String name) {
		ItemStack item = new ItemStack(type, 1, (short) 0);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		
		item.setAmount(amount);
		
		meta.setDisplayName(Colorizer.color(name));
		
		meta.setColor(color);
		
		item.setItemMeta(meta);
		
		return item;
	}
	
	public ItemStack createArmour(Material type, int amount, Color color, String name, List<String> lore) {
		ItemStack item = new ItemStack(type, 1, (short) 0);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		
		item.setAmount(amount);
		
		meta.setDisplayName(Colorizer.color(name));
		
		meta.setLore(Colorizer.colorList(lore));
		
		meta.setColor(color);
		
		item.setItemMeta(meta);
		
		return item;
	}
}

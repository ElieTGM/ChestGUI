package me.elietgm.chestgui.api;

import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;

import me.elietgm.chestgui.utils.Colorizer;

public class ItemCreatorBeta {

	private Material type = Material.GRASS; // Default values!
	private int amount = 1; // Default values!
	private int data = 0; // Default values!
	private String name;
	private String owner; // Support for skulls!? Yes too!
	private List<String> lore;
	private List<PotionEffect> effects; // Also support for effects!?
	private Color color;

	public ItemCreatorBeta(Material mat) {
		type = mat;
	}

	public ItemCreatorBeta withType(Material newType) {
		type = newType;
		return this;
	}

	public ItemCreatorBeta withName(String newName) { // Can be named
														// setCustomName!
		name = newName;
		return this;
	}

	public ItemCreatorBeta withAmount(int newAmount) {
		amount = newAmount;
		return this;
	}

	public ItemCreatorBeta withData(int newData) {
		data = newData;
		return this;
	}

	public ItemCreatorBeta withLore(List<String> newLore) {
		lore = newLore;
		return this;
	}

	public ItemCreatorBeta withEffects(List<PotionEffect> newEffects) {
		effects = newEffects;
		return this;
	}

	public ItemCreatorBeta withOwner(String newOwner) {
		owner = newOwner;
		return this;
	}

	public ItemCreatorBeta withColor(Color newColor) {
		color = newColor;
		return this;
	}

	public ItemStack build() {
		ItemStack item = new ItemStack(type, amount, (short) data);
		ItemMeta im = item.getItemMeta();

		if (effects != null && !effects.isEmpty())
			if (im instanceof PotionMeta) {
				((PotionMeta) im).clearCustomEffects();
				effects.forEach(e -> ((PotionMeta) im).addCustomEffect(e, true));
			}

		if (owner != null && !owner.isEmpty())
			if (im instanceof SkullMeta)
				((SkullMeta) im).setOwner(owner);

		if (color != null)
			if (im instanceof LeatherArmorMeta)
				((LeatherArmorMeta) im).setColor(color);

		if (name != null && !name.isEmpty())
			im.setDisplayName(Colorizer.color(name)); // Color just in case!

		if (lore != null && !lore.isEmpty())
			im.setLore(Colorizer.colorList(lore)); // Color just in case!

		item.setItemMeta(im);

		return item;

	}

}

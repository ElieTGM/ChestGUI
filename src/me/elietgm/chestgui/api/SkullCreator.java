package me.elietgm.chestgui.api;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.elietgm.chestgui.utils.Colorizer;

public class SkullCreator {

	public ItemStack createSkull(String owner, int amount, String name, List<String> lore) {
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta meta = (SkullMeta) item.getItemMeta();

		item.setAmount(amount);

		meta.setOwner(owner);

		meta.setDisplayName(Colorizer.color(name));
		meta.setLore(Colorizer.colorList(lore));

		item.setItemMeta(meta);

		return item;
	}

	public ItemStack createSkull(String owner, int amount, String name) {
		return createSkull(owner, amount, name, new ArrayList<>());
	}
}

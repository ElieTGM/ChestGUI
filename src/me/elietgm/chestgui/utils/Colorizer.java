package me.elietgm.chestgui.utils;

import java.util.List;
import java.util.stream.Collectors;

import net.md_5.bungee.api.ChatColor;

public class Colorizer {

	public static String color(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public static List<String> colorList(List<String> l) {
		return l.stream().map(Colorizer::color).collect(Collectors.toList());
	}

	public static String uncolor(String message) {
		return ChatColor.stripColor(message);
	}

	public static List<String> uncolorList(List<String> l) {
		return l.stream().map(Colorizer::uncolor).collect(Collectors.toList());
	}

}

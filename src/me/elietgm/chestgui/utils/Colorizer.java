package me.elietgm.chestgui.utils;

import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

public class Colorizer {

	public static String color(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	
	public static List<String> colorList(List<String> msg) {
		List<String> newmsg = new ArrayList<String>();

		for (String s : msg) {
			newmsg.add(color(s));
		}

		return newmsg;
	}
	
}

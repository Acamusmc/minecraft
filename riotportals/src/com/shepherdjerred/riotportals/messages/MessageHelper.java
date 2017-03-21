package com.shepherdjerred.riotportals.messages;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

import com.shepherdjerred.riotportals.Main;
import com.shepherdjerred.riotportals.config.FileManager;

public class MessageHelper {
	
	public static String colorString(String input) {

		return ChatColor.translateAlternateColorCodes('&', input);

	}

	public static String colorConfigString(String input) {

		return ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString(input));

	}

	public static List<String> colorConfigListStrings(String input) {

		List<String> output = new ArrayList<>();

		for (String s : Main.getInstance().getConfig().getStringList(input)) {

			output.add(ChatColor.translateAlternateColorCodes('&', s));

		}

		return output;

	}

	public static String colorMessagesString(String input) {

		return ChatColor.translateAlternateColorCodes('&', FileManager.getInstance().messages.getString(input));

	}

	public static List<String> colorMessagesListStrings(String input) {

		List<String> output = new ArrayList<>();

		for (String s : FileManager.getInstance().messages.getStringList(input)) {

			output.add(ChatColor.translateAlternateColorCodes('&', s));

		}

		return output;

	}

	public static String getMessagePrefix() {

		return colorMessagesString("prefix");

	}

}

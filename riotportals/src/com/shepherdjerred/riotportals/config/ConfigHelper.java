
package com.shepherdjerred.riotportals.config;

import org.bukkit.configuration.file.YamlConfiguration;

import com.shepherdjerred.riotportals.Main;


public class ConfigHelper {

	@SuppressWarnings("deprecation")
	public static void loadConfigs() {

		Main.getInstance().saveDefaultConfig();
		
		ConfigPortals.loadPortals();

		if (Main.getInstance().getConfig().getBoolean("debug")) {
			
			Main.getInstance().getConfig().setDefaults(YamlConfiguration.loadConfiguration(Main.getInstance().getResource("config.yml")));
			Main.getInstance().getConfig().options().copyDefaults(true);
			Main.getInstance().saveConfig();

		}

		FileManager.getInstance().loadFiles();

	}

}

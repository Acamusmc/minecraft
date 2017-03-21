
package com.shepherdjerred.riotportals.config;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import com.shepherdjerred.riotportals.Main;
import com.shepherdjerred.riotportals.objects.Portal;


public class ConfigPortals {

	public static List<Portal> portals = new ArrayList<>();

	public static void loadPortals() {

		for (String name : Main.getInstance().getConfig().getConfigurationSection("portals").getKeys(false)) {

			if (Main.getInstance().getConfig().getBoolean("debug"))
				Main.getInstance().getLogger().info("Loading portal " + name);

			portals.add(new Portal(getLocation(name, LocationType.POINT_ONE), getLocation(name, LocationType.POINT_TWO),
					Bukkit.getWorld(Main.getInstance().getConfig().getString("portals." + name + ".location.world")),
					Main.getInstance().getConfig().getString("portals." + name + ".permission"), Main.getInstance().getConfig().getString("portals." + name + ".server")));

		}

	}

	enum LocationType {

		POINT_ONE, POINT_TWO

	};

	static Location getLocation(String string, LocationType type) {

		String point;

		if (type == LocationType.POINT_ONE)
			point = "1";
		else
			point = "2";

		if (Main.getInstance().getConfig().getBoolean("debug")) {

			Main.getInstance().getLogger().info(new Location(Bukkit.getWorld(Main.getInstance().getConfig().getString("portals." + string + ".location.world")),
					Main.getInstance().getConfig().getDouble("portals." + string + ".location." + point + ".x"),
					Main.getInstance().getConfig().getDouble("portals." + string + ".location." + point + ".y"),
					Main.getInstance().getConfig().getDouble("portals." + string + ".location." + point + ".z")).toString());

		}

		return new Location(Bukkit.getWorld(Main.getInstance().getConfig().getString("portals." + string + ".location.world")),
				Main.getInstance().getConfig().getDouble("portals." + string + ".location." + point + ".x"),
				Main.getInstance().getConfig().getDouble("portals." + string + ".location." + point + ".y"),
				Main.getInstance().getConfig().getDouble("portals." + string + ".location." + point + ".z"));

	}

}

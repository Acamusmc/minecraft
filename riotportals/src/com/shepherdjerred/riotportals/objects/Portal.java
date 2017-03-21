
package com.shepherdjerred.riotportals.objects;

import java.util.Arrays;

import org.bukkit.Location;
import org.bukkit.World;


public class Portal {

	double minX, minY, minZ, maxX, maxY, maxZ;
	World portalWorld;
	String portalPermission;
	String portalServer;

	public Portal(Location location1, Location location2, World world, String permission, String server) {

		double[] x = new double[] { location1.getX(), location2.getX() };
		Arrays.sort(x);
		minX = x[0];
		maxX = x[1];

		double[] y = new double[] { location1.getY(), location2.getY() };
		Arrays.sort(y);
		minY = y[0];
		maxY = y[1];

		double[] z = new double[] { location1.getZ(), location2.getZ() };
		Arrays.sort(z);
		minZ = z[0];
		maxZ = z[1];

		portalWorld = world;
		portalPermission = permission;
		portalServer = server;

	}

	public String getServer() {
	
		return portalServer;
		
	}
	
	public String getPermission() {
		
		return portalPermission;
		
	}

	public boolean containsBlock(Location location) {

		if (!(location.getWorld() == portalWorld)) {

			return false;
		}

		if (location.getBlockX() < minX || location.getBlockX() > maxX) {

			return false;
		}

		if (location.getBlockZ() < minZ || location.getBlockZ() > maxZ) {

			return false;
		}

		if (location.getBlockY() < minY || location.getBlockY() > maxY) {

			return false;
		}

		return true;

	}

}

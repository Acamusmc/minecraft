
package com.shepherdjerred.riotportals.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.shepherdjerred.riotportals.Main;
import com.shepherdjerred.riotportals.config.ConfigPortals;
import com.shepherdjerred.riotportals.objects.Portal;


public class PlayerListeners implements Listener {

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {

		Player player = event.getPlayer();

		for (Portal portal : ConfigPortals.portals) {

			if (portal.containsBlock(player.getLocation()) && player.hasPermission(portal.getPermission())) {
				
				player.teleport(player.getWorld().getSpawnLocation()); 

				
				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF(portal.getServer());
				
				player.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
				
			}

		}

	}

}


package com.shepherdjerred.stservermessages.listeners;

import com.shepherdjerred.stservermessages.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class QuitEvent implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {

		// Set the quit message
		String leave = Main.getInstance().getMessagesString("messages.leave");

		event.setQuitMessage(leave.replaceAll("%player%", event.getPlayer().getName()));

	}

}

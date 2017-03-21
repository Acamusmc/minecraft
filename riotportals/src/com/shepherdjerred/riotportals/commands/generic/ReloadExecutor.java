
package com.shepherdjerred.riotportals.commands.generic;

import org.bukkit.command.CommandSender;

import com.shepherdjerred.riotportals.config.ConfigHelper;
import com.shepherdjerred.riotportals.messages.GenericMessages;


public class ReloadExecutor {

	public static void Executor(CommandSender sender, String[] args) {

		if (!sender.hasPermission("RiotPortals.reload")) {
			
			sender.sendMessage(GenericMessages.getNoPermsMessage());
			return;
			
		}
		
		ConfigHelper.loadConfigs();
		
		sender.sendMessage(GenericMessages.getReloadMessage());

	}

}


package com.shepherdjerred.riotportals.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.shepherdjerred.riotportals.commands.generic.ReloadExecutor;
import com.shepherdjerred.riotportals.messages.GenericMessages;


public class MainCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(args.length > 0)) {
			sender.sendMessage(GenericMessages.getNoArgsMessage("reload"));
			return true;
		}
		
		if (args[0].equalsIgnoreCase("reload")) {
			ReloadExecutor.Executor(sender, args);
			return true;
		}

		sender.sendMessage(GenericMessages.getInvalidArgsMessage(args[0], "reload"));
		return true;

	}

}
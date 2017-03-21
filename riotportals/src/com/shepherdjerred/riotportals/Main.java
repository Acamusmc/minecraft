
package com.shepherdjerred.riotportals;

import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.shepherdjerred.riotportals.commands.MainCommand;
import com.shepherdjerred.riotportals.config.ConfigHelper;
import com.shepherdjerred.riotportals.listeners.PlayerListeners;
import com.shepherdjerred.riotportals.metrics.MetricsLite;


public class Main extends JavaPlugin implements PluginMessageListener {

	private static Main instance;

	public Main() {
		instance = this;
	}

	public static Main getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {

		ConfigHelper.loadConfigs();

		getCommand("riotportals").setExecutor(new MainCommand());

		getServer().getPluginManager().registerEvents(new PlayerListeners(), this);

		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);

		// Start metrics
		try {
			MetricsLite metrics = new MetricsLite(this);
			metrics.start();
		} catch (IOException e) {

		}

	}

	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		
		if (!channel.equals("BungeeCord"))
			return;
		
		ByteArrayDataInput in = ByteStreams.newDataInput(message);
		String subchannel = in.readUTF();
		
		if (subchannel.equals("SomeSubChannel")) {
			
		}
	}

}

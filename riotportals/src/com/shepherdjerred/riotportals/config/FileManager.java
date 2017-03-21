
package com.shepherdjerred.riotportals.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.shepherdjerred.riotportals.Main;


public class FileManager {

	private static FileManager instance;

	public FileManager() {
		instance = this;
	}

	public static FileManager getInstance() {
		if (instance == null) {
			instance = new FileManager();
		}
		return instance;
	}

	File messagesFile;
	public FileConfiguration messages;

	// Load/reload files
	@SuppressWarnings("deprecation")
	public void loadFiles() {

		messagesFile = new File(Main.getInstance().getDataFolder(), "messages.yml");

		if (!messagesFile.exists()) {

			messagesFile.getParentFile().mkdirs();
			copy(Main.getInstance().getResource("messages.yml"), messagesFile);

		}

		messages = new YamlConfiguration();

		try {

			messages.load(messagesFile);

			messages.setDefaults(YamlConfiguration.loadConfiguration(Main.getInstance().getResource("messages.yml")));
			messages.options().copyDefaults(true);
			saveFiles(FileName.MESSAGES);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public enum FileName {

		MESSAGES

	};

	// Save files
	public void saveFiles(FileName file) {
		try {

			if (file == FileName.MESSAGES) {

				messages.save(messagesFile);

				return;

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Copy default files
	public void copy(InputStream in, File file) {

		try {

			OutputStream out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len;

			while ((len = in.read(buf)) > 0) {

				out.write(buf, 0, len);

			}

			out.close();
			in.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
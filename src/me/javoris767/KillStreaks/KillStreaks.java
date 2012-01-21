package me.javoris767.KillStreaks;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class KillStreaks extends JavaPlugin {
	public static KillStreaks plugin;
	Logger log = Logger.getLogger("Minecraft");
	File conf;
	FileConfiguration config;
	@Override
	public void onEnable() {
		if (conf == null) {
			conf = new File(getDataFolder(), "barracks.yml");
		}
		config = YamlConfiguration.loadConfiguration(conf);
		saveConf();
		log.info("[KillStreaks] Enabled!");
		getCommand("ks").setExecutor(new KillStreaksCMDs(this));
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_INTERACT_ENTITY, new KSPlayerListener(this), Priority.Normal, this);
		//pm.registerEvent(Event.Type.BLOCK_DAMAGE, new PrecisionAirstrikeListener(this), Priority.Highest, this);
		//pm.registerEvent(Event.Type.CREATURE_SPAWN, new AttackDogListener(this), Priority.Highest, this);
	}
	@Override
	public void onDisable() {
		log.info("[KillStreaks] Disabled!");
	}
	public void saveConf() {
		if (conf == null || config == null) {
		}
		try {
			config.save(conf);
		} catch (IOException e) {
			log.severe("[KillStreaks] Unable to Save Config.");
		}
	}
}
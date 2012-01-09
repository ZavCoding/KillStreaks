package me.javoris767.KillStreaks;

import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Event;

public class KillStreaks extends JavaPlugin {
	public static KillStreaks plugin;
	Config config;
	Logger log = Logger.getLogger("Minecraft");
	@Override
	public void onEnable() {
		log.info("[KillStreaks] Enabled!");
		getCommand("ks").setExecutor(new KillStreaksCMDs(this));
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_INTERACT_ENTITY, new KSPlayerListener(this), Priority.Normal, this);
		//pm.registerEvent(Event.Type.BLOCK_DAMAGE, new PrecisionAirstrikeListener(this), Priority.Highest, this);
		//pm.registerEvent(Event.Type.CREATURE_SPAWN, new AttackDogListener(this), Priority.Highest, this);
		config = new Config(this);
        config.loadConfig();
	}
	@Override
	public void onDisable() {
		log.info("[KillStreaks] Disabled!");
	}
}
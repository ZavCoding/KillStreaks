package me.javoris767.KillStreaks;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;

public class KillStreaks extends JavaPlugin {
	FileConfiguration config;
	Logger log = Logger.getLogger("Minecraft");
	@Override
	public void onEnable() {
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
}
package me.javoris767.KillStreaks;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

public class KillStreaks extends JavaPlugin {
	public static KillStreaks plugin;
	Logger log = Logger.getLogger("Minecraft");
	private Configuration config;
    File configFile = new File("plugins/KillSteaks/config.yml");
    public static String playername;
    private static File KillStreaks = new File("plugins", "ConfigTest");
    private static File configFile2 = new File(KillStreaks, playername + ".yml");
    String ks;
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
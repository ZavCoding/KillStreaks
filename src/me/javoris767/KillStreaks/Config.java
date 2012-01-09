package me.javoris767.KillStreaks;

import org.bukkit.configuration.Configuration;

public class Config {
	private final KillStreaks plugin;
    public Config(KillStreaks plugin) {
        this.plugin = plugin;
    }
    public Configuration config;

    public void loadConfig() {
        config = plugin.getConfig();
        config.addDefault("", "");
        config.options().copyDefaults(true);
        plugin.saveConfig();
    }
}


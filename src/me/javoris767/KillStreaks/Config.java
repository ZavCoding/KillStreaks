package me.javoris767.KillStreaks;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	public KillStreaks plugin;
    public Config(KillStreaks plugin) {
        this.plugin = plugin;
    }
    private static File KillStreaks = new File("plugins", "ConfigTest");
    public static String playername;
    private static File configFile = new File(KillStreaks, playername + ".yml");
    public static FileConfiguration config;

    public static void firstRun() {
        config = new YamlConfiguration();

        if (!KillStreaks.exists()) {
            try {
                KillStreaks.mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }

            config.set("Path.to.message", "Config message");
            try {
                config.save(configFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        loadConfig();
    }

    private static void loadConfig() {
        config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String msg = config.getString("Path.to.message");
        System.out.println(msg);
    }
}
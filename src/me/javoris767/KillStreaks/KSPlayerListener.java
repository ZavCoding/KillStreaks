package me.javoris767.KillStreaks;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class KSPlayerListener extends PlayerListener {
	public KillStreaks plugin;
	public KSPlayerListener(KillStreaks instance) {
		plugin = instance;
	}
	public void onPlayerJoin(PlayerJoinEvent event) {
}

}

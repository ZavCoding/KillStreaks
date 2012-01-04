package me.javoris767.KillStreaks;

import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;

public class KSEntityListener extends EntityListener {
	public KillStreaks plugin;
	public KSEntityListener(KillStreaks instance) {
		plugin = instance;
	}
	public void onEntityDeath(EntityDeathEvent event) {
		
	}
}

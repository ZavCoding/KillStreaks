package me.javoris767.KillStreaks;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillStreaksCMDs implements CommandExecutor {
	public String NotEarned = (ChatColor.GREEN + "Price:" + ChatColor.RED + " You have to earn your streak");
	public String NoPerms = (ChatColor.DARK_RED + "Makarov:" + ChatColor.RED + "You don't have permission!");
	public KillStreaks plugin;
	public KillStreaksCMDs(KillStreaks instance) {
		plugin = instance;
	}
		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
			if (sender instanceof Player) {
				if (sender.hasPermission("ks.help") || sender.isOp()) {
					if (args.length == 0) {
						sender.sendMessage(ChatColor.GOLD + "-------------------*KillStreaks*-----------------");
						sender.sendMessage(ChatColor.GOLD + "1. /ks streaks - Shows all kill streaks.");
						sender.sendMessage(ChatColor.GOLD + "2. /ks barracks - Displays your stats.");
						sender.sendMessage(ChatColor.GOLD + "3. /ks set <streak> - Set your kill streaks");
						sender.sendMessage(ChatColor.GOLD + "-------------------------------------------------");
					}else{
						sender.sendMessage(NoPerms);
					}
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("streaks") || sender.hasPermission("ks.streaks")) {
							sender.sendMessage(ChatColor.RED + "*****KillStreaks*****");
				            sender.sendMessage(ChatColor.DARK_RED + "Ballistic Vests -" + ChatColor.DARK_GREEN+" 3 kills");
				            sender.sendMessage(ChatColor.DARK_RED + "Precision Airstrike -" + ChatColor.DARK_GREEN+" 5 kills");
				            sender.sendMessage(ChatColor.DARK_RED + "Juggernaut -" + ChatColor.DARK_GREEN+" 7 kills");
				            sender.sendMessage(ChatColor.DARK_RED + "Attack Dogs -" + ChatColor.DARK_GREEN+" 11 kills");
						}
						if (args[0].equalsIgnoreCase("barracks") || sender.hasPermission("ks.barracks")) {
							sender.sendMessage(ChatColor.GOLD + "Feature not added yet - javoris767");
						}else{
							sender.sendMessage(NoPerms);
						}
						if (args[0].equalsIgnoreCase("set") || sender.hasPermission("ks.set")) {
							sender.sendMessage(ChatColor.GOLD + "Feature not added yet - javoris767");
						}else{
							sender.sendMessage(NoPerms);
						}
						// BallisticVests
							 if (args[1].equals("BallisticVests")) {
							 }else{
							     sender.sendMessage(NotEarned);
						 	}
					}
				}
			}
			return true;
		}
}
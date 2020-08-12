package ch.dempsey.wolfraam.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.dempsey.wolfraam.config.Config;

public class SetChatKleur implements CommandExecutor{
	
	Config c = new Config();
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.DARK_RED + "Nope!");
		}else {
			Player p = (Player) sender;
			if(p.hasPermission("wolfraam.setchatkleur")) {
				if(args.length == 0) {
					p.sendMessage(ChatColor.RED + "Voorbeeld: /setchatkleur &7");
				}else if(args.length == 1) {
					if(args[0].length() == 2) {
						if(args[0].startsWith("&")) {
							c.setup(Bukkit.getPluginManager().getPlugin("Wolfraam"), p).set("chatcolor", args[0]);
							c.save(Bukkit.getPluginManager().getPlugin("Wolfraam"), p);
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "Chatkleur naangepast naar " + args[0]) + args[0] + "!");
						}else {
							p.sendMessage(ChatColor.RED + "Ongeldige kleurcode!");
						}
					}else {
						p.sendMessage(ChatColor.RED + "Ongeldige kleurcode!");
					}
				}else {
					p.sendMessage(ChatColor.RED + "Voorbeeld: /setchatkleur &7");
				}
			}else {
				p.sendMessage(ChatColor.RED + "Je hebt geen toegang tot dit commando!");
			}
		}
		
		return true;
	}
}

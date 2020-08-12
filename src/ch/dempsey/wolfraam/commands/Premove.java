package ch.dempsey.wolfraam.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class Premove implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(args.length == 0) {
			sender.sendMessage(ChatColor.RED + "Gebruik: /premove <naam>");
		}else {
			Bukkit.dispatchCommand(sender, "as delfriend " + args[0]);
		}
		return true;
	}
	
}

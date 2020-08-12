package ch.dempsey.wolfraam.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Pinautomaat implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Eet een pannenkoek!");
		}else {
			Player p = (Player)sender;
			if(cmd.getName().equalsIgnoreCase("pinautomaat")) {
				if(p.hasPermission("wolfraam.pinautomaat")) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "cc open pinautomaat " + p.getName());
				}else {
					p.sendMessage(ChatColor.RED + "Je hebt geen toestemming om dit commando te gebruiken!");
				}
			}
		}
		
		return true;
	}
	
}

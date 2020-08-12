package ch.dempsey.wolfraam.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Discord implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		sender.sendMessage("§8(§b!§8) §7Discord link:§5 https://discord.gg/qUkcfys");
		return true;
	}
	
}

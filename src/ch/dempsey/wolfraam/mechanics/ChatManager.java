package ch.dempsey.wolfraam.mechanics;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import ch.dempsey.wolfraam.config.Config;
import net.md_5.bungee.api.ChatColor;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatManager implements Listener{

	Config c = new Config();
	Plugin pl = Bukkit.getServer().getPluginManager().getPlugin("Woflraam");
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		PermissionUser pu = PermissionsEx.getUser(e.getPlayer());
		String prefix = pu.getPrefix();
		String suffix = pu.getSuffix();
		int level = c.read(pl, e.getPlayer()).getInt("level");
		String message = e.getMessage().toLowerCase();
		String displayname = e.getPlayer().getDisplayName();
		String chatcolor = c.read(pl, e.getPlayer()).getString("chatcolor");
		String namecolor = c.read(pl, e.getPlayer()).getString("namecolor");
		e.setFormat("§b[" + String.valueOf(level) + "] " + suffix + " §7[" + prefix + "§7] " + ChatColor.translateAlternateColorCodes('&', namecolor) + displayname + "§7: " + ChatColor.translateAlternateColorCodes('&', chatcolor) + message);
		// [LVL] [SUFFIX] [PREFIX] [NAMECOLOR] [NAAM] [CHATCOLOR] [CHAT]
		
	}
	
}

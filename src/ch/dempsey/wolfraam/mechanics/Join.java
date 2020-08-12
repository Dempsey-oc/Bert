package ch.dempsey.wolfraam.mechanics;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ch.dempsey.wolfraam.config.Config;

public class Join implements Listener{

	Config c = new Config();
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		c.setup(Bukkit.getServer().getPluginManager().getPlugin("Wolfraam"), e.getPlayer());
		c.generateMultiplier(e.getPlayer());
	}
	
}

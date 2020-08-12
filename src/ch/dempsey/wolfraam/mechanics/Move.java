package ch.dempsey.wolfraam.mechanics;

import java.io.File;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

import ch.dempsey.wolfraam.config.Config;


public class Move implements Listener{

	// RAW COD
	// RAW SALMON
	// CLOWNFISH
	// PUFFERFISH
	
	Config c = new Config();
	Random r = new Random();
	
	Plugin p = Bukkit.getPluginManager().getPlugin("Wolfraam");
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent ev) {
		int res = r.nextInt(2000);
		if(c.getMultiplier(p, ev.getPlayer())==(res*2)) {
			Player p = ev.getPlayer();
			if(!p.isFlying()) {
				if((ev.getFrom().getX() != ev.getTo().getX()) || (ev.getFrom().getZ() != ev.getTo().getZ())) {
					File f = c.getFile(Bukkit.getPluginManager().getPlugin("Wolfraam"), ev.getPlayer());
					FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
					conf.set("level", conf.getInt("level")+1);
					conf.set("random", r.nextInt(1000));
					try {
						conf.save(f);
					}catch(Exception e) {
						e.printStackTrace();
					}
					YamlConfiguration.loadConfiguration(f);
					ev.getPlayer().sendMessage(ChatColor.GREEN + "Je bent een level omhoog gehaan naar: " + ChatColor.GRAY  + String.valueOf(c.read(Bukkit.getPluginManager().getPlugin("Wolfraam"), ev.getPlayer()).getInt("level")));
				}
			}
		}
	}
	
}

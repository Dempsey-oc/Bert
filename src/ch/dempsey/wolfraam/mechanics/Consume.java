package ch.dempsey.wolfraam.mechanics;

import java.io.File;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import ch.dempsey.wolfraam.config.Config;

public class Consume implements Listener{

	Config c = new Config();
	
	@EventHandler
	public void onPlayerItemConsume(PlayerItemConsumeEvent ev) {
		Random r = new Random();
		int res = r.nextInt(1000);
		if(c.setup(Bukkit.getPluginManager().getPlugin("Wolfraam"), ev.getPlayer()).getInt("random") ==  res && !ev.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.POTION)) {
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


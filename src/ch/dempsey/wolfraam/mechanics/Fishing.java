package ch.dempsey.wolfraam.mechanics;

import java.io.File;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import ch.dempsey.wolfraam.config.Config;

public class Fishing implements Listener{
	
	Config c = new Config();
	
	@EventHandler
	public void onPlayerFish(PlayerFishEvent e) {
		
		if(e.getCaught() instanceof Item) {
			e.setCancelled(true);
			
			ItemStack fish1 = new ItemStack(Material.RAW_FISH,1,(short)0); // 349:0
			ItemStack fish2 = new ItemStack(Material.RAW_FISH,1, (short)1); // 349:1
			ItemStack fish3 = new ItemStack(Material.RAW_FISH,1,(short)2); // :2
			ItemStack fish4 = new ItemStack(Material.RAW_FISH,1, (short)3); // :3
			
			Random r = new Random();
			int res = r.nextInt(20);
			
			if(res<=5) {
				e.getPlayer().getInventory().addItem(fish1);
			}else if(res>5 && res<=10) {
				e.getPlayer().getInventory().addItem(fish2);
			}else if(res>10 && res<=15) {
				e.getPlayer().getInventory().addItem(fish3);
			}else if(res>15 && res <=20) {
				e.getPlayer().getInventory().addItem(fish4);
			}
			
			int res2 = r.nextInt(1000);
			if(res2==c.read(Bukkit.getPluginManager().getPlugin("Wolfraam"), e.getPlayer()).getInt("random")) {
				File f = c.getFile(Bukkit.getPluginManager().getPlugin("Wolfraam"), e.getPlayer());
				FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
				conf.set("level", conf.getInt("level")+1);
				conf.set("random", r.nextInt(1000));
				try {
					conf.save(f);
				}catch(Exception es) {
					es.printStackTrace();
				}
				YamlConfiguration.loadConfiguration(f);
				e.getPlayer().sendMessage(ChatColor.GREEN + "Je bent een level omhoog gegaan naar: " + ChatColor.GRAY + String.valueOf(c.read(Bukkit.getPluginManager().getPlugin("Wolfraam"), e.getPlayer())));
			}
			
			
		}
		
	}
	
}
package ch.dempsey.wolfraam.mechanics;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class Place implements Listener {

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if(e.getBlock().getType().equals(Material.RED_SANDSTONE_STAIRS) || e.getBlock().getType().equals(Material.DROPPER)) {
			if(!e.getPlayer().hasPermission("wolfraam.maakpin")) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.DARK_RED + "Je hebt geen toestemming om deze pinautomaat te plaatsen!");
			}
		}else if(e.getBlock().getType().equals(Material.ENCHANTMENT_TABLE)) {
			if(!e.getPlayer().hasPermission("wolfraam.enchant")) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.RED + "Je hebt geen toestemming om de enchantingtable te plaatsen!");
			}
		}
	}
	
}

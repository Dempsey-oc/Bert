package ch.dempsey.wolfraam.mechanics;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Interact implements Listener{

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock().getType().equals(Material.RED_SANDSTONE_STAIRS)) {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "cc open pinautomaat " + e.getPlayer().getName());
			}else if(e.getClickedBlock().getType().equals(Material.ENCHANTMENT_TABLE)) {
				if(!e.getPlayer().hasPermission("wolfraam.enchant")) {
					e.setCancelled(true);
					e.getPlayer().sendMessage(ChatColor.RED + "Je hebt geen toestemming om de enchantingtable te plaatsen!");
				}
			}
		}
	}
	
}

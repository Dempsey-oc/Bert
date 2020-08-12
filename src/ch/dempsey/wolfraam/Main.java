package ch.dempsey.wolfraam;

import org.bukkit.plugin.java.JavaPlugin;

import ch.dempsey.wolfraam.commands.Discord;
import ch.dempsey.wolfraam.commands.Padd;
import ch.dempsey.wolfraam.commands.Pinautomaat;
import ch.dempsey.wolfraam.commands.Pinfo;
import ch.dempsey.wolfraam.commands.Premove;
import ch.dempsey.wolfraam.commands.SetChatKleur;
import ch.dempsey.wolfraam.commands.SetKleur;
import ch.dempsey.wolfraam.mechanics.ChatManager;
import ch.dempsey.wolfraam.mechanics.Fishing;
import ch.dempsey.wolfraam.mechanics.Interact;
import ch.dempsey.wolfraam.mechanics.Join;
import ch.dempsey.wolfraam.mechanics.Move;
import ch.dempsey.wolfraam.mechanics.Place;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		
		
		// Events
		getServer().getPluginManager().registerEvents(new Join(), this);
		getServer().getPluginManager().registerEvents(new Move(), this);
		getServer().getPluginManager().registerEvents(new Fishing(), this);
		getServer().getPluginManager().registerEvents(new ChatManager(), this);
		getServer().getPluginManager().registerEvents(new Interact(), this);
		getServer().getPluginManager().registerEvents(new Place(), this);
	
		// Commands
		getCommand("pinautomaat").setExecutor(new Pinautomaat());
		getCommand("setchatkleur").setExecutor(new SetChatKleur());
		getCommand("setkleur").setExecutor(new SetKleur());
		getCommand("padd").setExecutor(new Padd());
		getCommand("premove").setExecutor(new Premove());
		getCommand("pinfo").setExecutor(new Pinfo());
		getCommand("discord").setExecutor(new Discord());
		
	}
	
}

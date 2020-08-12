package ch.dempsey.wolfraam.config;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

public class Config {

	public File file;
	
	
	public FileConfiguration setup(Plugin p, Player pl) {
		
		
		file = new File(p.getDataFolder(), pl.getUniqueId().toString()+".yml");
		
		
		if(writeCheck(file)) {
			try {
				file.createNewFile();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		Random r = new Random();
		
		if(!config.contains("name")) {
			config.set("name", pl.getName());
			try {
				config.save(file);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(!config.contains("level")) {
			config.set("level", 1);
			try {
				config.save(file);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(!config.contains("random")) {
			config.set("random", r.nextInt(1000));
			try {
				config.save(file);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(!config.contains("namecolor")) {
			config.set("namecolor", "&7");
			try {
				config.save(file);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(!config.contains("chatcolor")) {
			config.set("chatcolor", "&7");
			try {
				config.save(file);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return config;
	}
	
	
	public static boolean writeCheck(File file){
	     boolean f = true;
	     if(!file.exists()) try
	     {
	       if(!file.getParentFile().exists() && !file.getParentFile().mkdirs())
	       {
	         System.err.println(
	             "writeCheck error: Cannot create parent file " + file.getParentFile().getAbsolutePath());
	         f = false;
	       }
	       if(!file.createNewFile())
	       {
	         System.err.println("writeCheck error: Cannot create file " + file.getAbsolutePath());
	         f = false;
	       }
	     }
	     catch(IOException e)
	     {
	       e.printStackTrace();
	       f = false;
	     }
	     if(!file.canWrite())
	       f = false;
	     return f;
	}
	
	public void updateName(Plugin p, Player pl) {
		FileConfiguration config = setup(p,pl);
		
		if(config.contains("name")) {
			if(!config.getString("name").equals(pl.getName())) {
				config.set("name", pl.getName());
				save(p,pl);
				p.getLogger().log(Level.INFO, "Name updated for: " + pl.getName() + ":" + pl.getUniqueId().toString());
			}
		}
	}
	
	
	public void reload(Plugin p, Player pl) {
		FileConfiguration conf = setup(p,pl);
		try {
			conf.save(getFile(p,pl));
		}catch(Exception e) {
			e.printStackTrace();
		}
		YamlConfiguration.loadConfiguration(getFile(p,pl));
	}
	
	public void save(Plugin p,Player pl) {
		FileConfiguration config = setup(p,pl);
		try {
			config.save(getFile(p,pl));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public File getFile(Plugin p, Player pl) {
		return new File(p.getDataFolder(), pl.getUniqueId().toString()+".yml");
	}
	
	public int getMultiplier(Plugin p,Player pl) {
		return read(p,pl).getInt("random");
	}
	
	public void generateMultiplier(Player pl) {
		Random r = new Random();
		read(Bukkit.getPluginManager().getPlugin("Wolfraam"),pl).set("random", r.nextInt(1000));
		reload(Bukkit.getPluginManager().getPlugin("Wolfraam"),pl);
	}
	
	public void levelUp(Player pl) {
		int level = read(Bukkit.getPluginManager().getPlugin("Wolfraam"),pl).getInt("level");
		setup(Bukkit.getPluginManager().getPlugin("Wolfraam"),pl).set("level", level+1);
		reload(Bukkit.getPluginManager().getPlugin("Wolfraam"),pl);
		pl.sendMessage(ChatColor.LIGHT_PURPLE + "You have leveled up!");
	}
	
	public FileConfiguration read(Plugin pl, Player p) {
		
		File res = new File(pl.getDataFolder(), p.getUniqueId().toString()+".yml");
		
		if(res.exists()) {
			FileConfiguration resconf = YamlConfiguration.loadConfiguration(res);
			return resconf;
		} else {
			return null;
		}
	}
	
}

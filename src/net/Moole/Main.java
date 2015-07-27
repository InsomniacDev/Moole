package net.Moole;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public static Main instance = null;
	
	@Override
	public void onEnable(){
		
		instance = this;

		getServer().getPluginManager().registerEvents(this, this);
		
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been enabled!");
	
}
	
	public static Main getInstance() {
		  return instance;
		}
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been disabled!");
}
	
	  @EventHandler(priority = EventPriority.NORMAL)
	  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		  
	      Player player = e.getPlayer();
	      String[] split = e.getMessage().split("\\s+");
	      String command = split[0].substring(1);
		  
	      if (command.equalsIgnoreCase("COMMAND HERE")) {
	    	  e.setCancelled(true);
	          if (player.hasPermission("perm.player")) {
	        	  
			      ByteArrayOutputStream b = new ByteArrayOutputStream();
			      DataOutputStream out = new DataOutputStream(b);
			      try
			      {
			        out.writeUTF("Connect");
			        out.writeUTF("COMMAND HERE");
			      }
			      catch (IOException localIOException) {}
			      player.sendPluginMessage(this, "BungeeCord", b.toByteArray());
			      
	          }
		  
	      }
	  }
	
}
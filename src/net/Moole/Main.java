package net.Moole;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
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
	
}
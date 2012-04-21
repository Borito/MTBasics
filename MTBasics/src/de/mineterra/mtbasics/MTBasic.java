package de.mineterra.mtbasics;

import java.util.logging.Logger;

import listeners.blockListener;
import listeners.playerListener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import commands.WetterCommand;
import commands.ZeitCommand;


public class MTBasic extends JavaPlugin{
Logger log = Logger.getLogger("Minecraft");
	
	@Override
	public void onDisable(){
	System.out.println(ChatColor.RED + "[MT Basics] " + ChatColor.WHITE + "wurde Deaktiviert");		
	}
	
	@Override
	public void onEnable(){
	System.out.println(ChatColor.RED + "[MT Basics] " + ChatColor.WHITE + "wurde Aktiviert");	
	}


		
				
				public void registerEvents() {
					PluginManager pm = getServer().getPluginManager();
					pm.registerEvents(new blockListener(), this);
					pm.registerEvents(new playerListener(), this);
				}
			
			public void registerCommand (){
				rc("zeit", new ZeitCommand());
				rc("wetter", new WetterCommand());
				}


			public void rc(String command, CommandExecutor ce) {
				if(this.getDescription().getCommands().toString().toLowerCase().contains(command)) {
					Bukkit.getServer().getPluginCommand(command).setExecutor(ce);
					}
				
			
		
		
			
	}

			public static boolean permissionCheck(Player player, String node) {
				if(Bukkit.getServer().getPluginManager().getPlugin("Permissions") != null) {
					return permissionHandler.has(player, node);
				} else {
					return player.hasPermission(node);
				}
			}
}

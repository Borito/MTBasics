package utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Chat {
	
	public static void pMessage(Player player, String message){
		player.sendMessage(ChatColor.GREEN + message);
	}
	public static void broadcastMessage(String message){
		Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + message);
	}
	public static void noPermissionMessage(Player player){
		player.sendMessage(ChatColor.RED + "Du hast keine Rechte dazu!");
	}
	public static void sendBoldMessage(Player player, String args){
		player.chat(ChatColor.BOLD + args);
	}
	public static void sendItalicMessage(Player player, String args){
		player.chat(ChatColor.ITALIC + args);
	}
	public static void sendStrikethroughMessage(Player player, String args){
		player.chat(ChatColor.STRIKETHROUGH + args);
	}
	public static void sendUnderlineMessage(Player player, String args){
		player.chat(ChatColor.UNDERLINE + args);
	}

}

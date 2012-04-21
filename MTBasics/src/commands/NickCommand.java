package commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class NickCommand extends JavaPlugin implements CommandExecutor{
	
	@Override
	public void onDisable(){
		System.out.println("[Nick] Aktiviert!");
	}
	
	@Override
	public void onEnable(){
		System.out.println("[Nick] Deaktiviert!");
	}


public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
Player player =(Player)sender;
{
if ((commandLabel.equalsIgnoreCase("nick")) && (player.hasPermission("MTBasic.nick"))) {
	if (args.length == 0){
		player.sendMessage(ChatColor.RED + "Du musst einen Namen angeben!");	
	} else if (args.length == 1){
		((Player)sender).setDisplayName(args[0]);
		((Player)sender).setDisplayName(args[0]);
		player.sendMessage(ChatColor.GREEN + "Dein Name wurde erfolgreich geaendert!");
	}
}
return false;





}
}
}
	
	
	
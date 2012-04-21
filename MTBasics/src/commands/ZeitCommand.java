package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import utilities.Chat;
import utilities.Zeit;

public class ZeitCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args){
		Player player = (Player)sender;
		
		if(cmdLabel.equalsIgnoreCase("zeit") && player.hasPermission("mtbasic.zeitset")){
			if(args.length < 1) return false;
			if (!(sender instanceof Player)) return false;
				
				return true;
			}
			if(args[0].equalsIgnoreCase("tag")){
				Zeit.setDay((Player)sender);
			}
			if(args[0].equalsIgnoreCase("nacht")){
				Zeit.setNight((Player)sender);
			}
			Chat.pMessage((Player) sender, "Zeit wurde auf " + args[0] + "geändert!");
		
		return true;
	}

}

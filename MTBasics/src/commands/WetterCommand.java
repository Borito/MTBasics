package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import utilities.Chat;
import utilities.Wetter;

public class WetterCommand implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		Player player = (Player)sender;
		
		if(cmdLabel.equalsIgnoreCase("wetter") && player.hasPermission("mtbasic.wetterset")) {
			if(args.length < 1) return false;
			if(!(sender instanceof Player)) return false;
				return true;
			}
			if(args[0].equalsIgnoreCase("sonne")) {
				Wetter.createSun((Player) sender);
				Chat.pMessage((Player) sender, "Das Wetter ist jetzt Sonnig!");
			}
			if(args[0].equalsIgnoreCase("regen")) {
				Wetter.createRain((Player) sender);
				Chat.pMessage((Player) sender, "Es Regnet jetzt!");
			}
		return true;
	}

}

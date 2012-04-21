package utilities;

import org.bukkit.entity.Player;

public class Zeit {
	
	public static void setDay(Player player){
		player.getWorld().setTime(0);
	}
	public static void setNight(Player player){
		player.getWorld().setTime(1000000);
	}

}

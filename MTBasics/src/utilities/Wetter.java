package utilities;

import org.bukkit.entity.Player;

public class Wetter {
	
	public static void createRain(Player player) {
		player.getWorld().setStorm(true);
	}

	public static void createSun(Player player) {
		player.getWorld().setStorm(false);
	}

}

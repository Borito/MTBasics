package listeners;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import utilities.Block;
import utilities.Lock;

public class blockListener implements Listener {

	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onBlockPlace(BlockPlaceEvent e) {
		if(Block.block.containsKey(e.getPlayer())) e.setCancelled(true);

		Player player = null;
		if(player.hasPermission ("mtbasic.lock")) {
		if(Lock.lockhash.containsKey("yes")) e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onBlockBreak(BlockBreakEvent e) {
		if(Block.block.containsKey(e.getPlayer())) e.setCancelled(true);
		
		Player player = null;
		if(player.hasPermission ("mtbasic.lock")) {
		if(Lock.lockhash.containsKey("yes")) e.setCancelled(true);
		}
	}

}

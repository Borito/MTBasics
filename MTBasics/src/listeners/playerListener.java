package listeners;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import de.mineterra.mtbasics.MTBasic;

import utilities.Chat;
import utilities.Handicap;

public class playerListener implements Listener {
	
	public static HashMap<String, Double> playerHashX = new HashMap<String, Double>();
	public static HashMap<String, Double> playerHashY = new HashMap<String, Double>();
	public static HashMap<String, Double> playerHashZ = new HashMap<String, Double>();
	public static HashMap<String, String> playerHashWorld = new HashMap<String, String>();

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		if(Handicap.hash.containsKey(e.getPlayer())) e.setCancelled(true);

		if(MTBasic.isConfigAvailable()) {
			if(MTBasic.mtbasicConfig.getBoolean("enable-debug-mode")) {
				System.out.println("[CommandBin] " + e.getPlayer().getName() + " entered command: " + e.getMessage());
			}
		}
		return;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerChat(PlayerChatEvent e) {
		if(Mute.hash.containsKey(e.getPlayer())) e.setCancelled(true);
		
		Player player;
		if(!player.hasPermission ("MTBasic.lock")) {
			if(Lock.lockhash.containsKey("yes")) e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerMove(PlayerMoveEvent e) {
		if(Freeze.freeze_hash.containsKey(e.getPlayer())) e.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoin(PlayerJoinEvent e) {
		// if(e.getPlayer().isOp()) Color.setOpColor(e.getPlayer());
		if(VanishCommand.vanish.containsKey(e.getPlayer().getName())) {
			for(Player otherPlayers : Bukkit.getServer().getOnlinePlayers()) {
				otherPlayers.hidePlayer(e.getPlayer());
			}
		}

		return;
	}

	// Könnte der God Mode sein
	@EventHandler(priority = EventPriority.NORMAL)
	public void onEntityDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player godGuy = ((Player) e.getEntity());
			if(God.godlist.containsKey(godGuy.getName())) {
				e.setCancelled(true);
				godGuy.getWorld().playEffect(godGuy.getLocation(), Effect.SMOKE, 20);
			}
		}
		return;
	}

	// Vermutlich /tp Befehl
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerTeleport(PlayerTeleportEvent e) {
		playerHashX.put(e.getPlayer().getName(), e.getFrom().getX());
		playerHashY.put(e.getPlayer().getName(), e.getFrom().getY());
		playerHashZ.put(e.getPlayer().getName(), e.getFrom().getZ());
		playerHashWorld.put(e.getPlayer().getName(), e.getFrom().getWorld().getName());
		{
		}
		
		return;
	}

}

package utilities;

public class Handicap {
	public static HashMap <Player, Boolean> hash = new HashMap<Player, Boolean>();

	public static void handicapPlayer(Player p) {
		hash.put(p, true);
	}

	public static void unhandicapPlayer(Player p) {
		hash.remove(p);
	}

}

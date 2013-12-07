package chatroom.bean;

import java.util.HashMap;

public class AliveChatterList {
	private static HashMap<String, Chatter> chatterMap = new HashMap<>();

	public static HashMap<String, Chatter> getChatterMap() {
		return chatterMap;
	}
	
	public static void addAliveChatter(Chatter chatter){
		chatterMap.put(chatter.getIpAddress(), chatter);
	}
	
	public static void removeAliveChatter(Chatter chatter){
		chatterMap.remove(chatter.getIpAddress());
	}
}

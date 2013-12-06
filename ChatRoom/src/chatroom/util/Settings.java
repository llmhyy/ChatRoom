package chatroom.util;

public class Settings {
	public static int aliveListenerPort = 8000;
	public static int messageListenerPort = 8001;
	public static String[] hosts;
	
	static {
		hosts = new String[255];
		for(int i=0; i<255; i++){
			hosts[i] = "10.131.252." + (i+1); 
		}
	}
	
}

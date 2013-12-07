package chatroom.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {
	public static int aliveListenerPort = 8000;
	public static int messageListenerPort = 8001;
	public static String[] hosts;

	static {
		Properties prop = new Properties();

		try {
			// load a properties file
			prop.load(new FileInputStream("config.properties"));

			// get the property value and print it out
			String networkSegment = prop.getProperty("network_segment");
			String chatterNumber = prop.getProperty("chatter_number");
			String messageListeningPort = prop.getProperty("message_listening_port");
			String aliveListeningPort = prop.getProperty("active_listening_port");
			
			aliveListenerPort = Integer.valueOf(aliveListeningPort);
			messageListenerPort = Integer.valueOf(messageListeningPort);
			
			String networkPrefix = networkSegment.substring(0, networkSegment.indexOf("*"));
			int count = Integer.valueOf(chatterNumber);
			hosts = new String[count];
			for(int i=0; i<count; i++){
				hosts[i] = networkPrefix + (i+2);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}

package chatroom.net.listener;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.ConnectException;

import chatroom.bean.AliveChatterList;
import chatroom.bean.Chatter;
import chatroom.util.Settings;

public class ActiveChatterTester implements Runnable {

	
	@Override
	public void run() {
		
		while(true){
			for(int i=0; i<Settings.hosts.length; i++){
				try {
					Socket socket = new Socket(Settings.hosts[i], Settings.aliveListenerPort);
					
					InetAddress address = socket.getInetAddress();
					String ipAddress = address.getHostAddress();
					String hostName = address.getHostName();
					
					Chatter chatter = new Chatter(ipAddress, hostName);
					
					AliveChatterList.addAliveChatter(chatter);
				} 
				catch (ConnectException e){
					Chatter chatter = AliveChatterList.getChatterMap().get(Settings.hosts[i]);
					AliveChatterList.removeAliveChatter(chatter);
				}
				catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

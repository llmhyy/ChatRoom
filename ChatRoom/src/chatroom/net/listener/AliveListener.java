package chatroom.net.listener;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.ConnectException;

import chatroom.bean.Chatter;
import chatroom.util.Settings;

public class AliveListener implements Runnable{
	
	public void run(){
		try {
			ServerSocket server = new ServerSocket(Settings.aliveListenerPort);
			while(true){
				
				Socket client = server.accept();
				client.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

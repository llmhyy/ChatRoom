package chatroom.net.listener;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Display;

import chatroom.bean.Message;
import chatroom.ui.Main;
import chatroom.util.Settings;

public class MessageListener implements Runnable{

	private Main main;
	
	public MessageListener(Main main){
		this.main = main;
	}
	
	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(Settings.messageListenerPort);
			
			while(true){
				Socket client = server.accept();
				
				if(!client.getInetAddress().getHostAddress().equals(server.getInetAddress().getHostAddress())){
					continue;
				}
				
				//BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				//read the content from reader
				ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
				Object obj = is.readObject();
				
				final Message message = (Message)obj;
				
				Display.getDefault().asyncExec(new Runnable(){

					@Override
					public void run() {
						
						main.getChatArea().getChatText().append(message.toString());
						
					}
					
				});
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

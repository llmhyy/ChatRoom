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
import chatroom.util.Settings;

public class MessageListener implements Runnable{

	private StyledText text;
	
	public MessageListener(StyledText text){
		this.text = text;
	}
	
	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(Settings.messageListenerPort);
			while(true){
				Socket client = server.accept();
				
				//BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				//read the content from reader
				ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
				Object obj = is.readObject();
				
				final Message message = (Message)obj;
				
				Display.getDefault().asyncExec(new Runnable(){

					@Override
					public void run() {
						text.append(message.toString());
						
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

package chatroom.net.sender;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import chatroom.bean.Message;
import chatroom.util.Settings;

public class MessageSender implements Runnable{
	
	//private Socket socket;
	private Message message;
	private String host;
	
	public MessageSender(Message message, String host){
		//this.socket = socket;
		this.message = message;
		this.host = host;
	}

	@Override
	public void run() {
		try {
			Socket socket = new Socket(this.host, Settings.messageListenerPort);
			
			/*PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(this.message);
			pw.flush();
			pw.close();*/
			
			ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
			os.writeObject(this.message);
			os.flush();
			
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

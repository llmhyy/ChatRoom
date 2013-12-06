package chatroom.net.business;

import java.sql.Timestamp;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

import chatroom.bean.Chatter;
import chatroom.bean.Message;
import chatroom.net.sender.MessageSender;
import chatroom.util.Settings;

public class MessageKeyAdapter implements KeyListener {

	private Message message;
	
	public MessageKeyAdapter(String message){
		
		Chatter chatter = new Chatter("10.131.252.131", "linyun");
		this.message = new Message(chatter, message, new Timestamp(new Date().getTime()));
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.keyCode == SWT.CR){
			
			for(int i=0; i<Settings.hosts.length; i++){
				MessageSender sender = new MessageSender(message, Settings.hosts[i]);
				Thread t = new Thread(sender);
				t.start();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

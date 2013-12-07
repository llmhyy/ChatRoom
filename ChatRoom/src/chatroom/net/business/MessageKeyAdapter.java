package chatroom.net.business;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Text;

import chatroom.bean.Chatter;
import chatroom.bean.Message;
import chatroom.net.sender.MessageSender;
import chatroom.util.Settings;

public class MessageKeyAdapter implements KeyListener {

	private Message message;
	private Text messageBox;
	
	public MessageKeyAdapter(Text messageBox){
		
		String messageContent = messageBox.getText();
		
		InetAddress addr;
		String ipAddress = "";
		String hostName = "";
		try {
			addr = InetAddress.getLocalHost();
			ipAddress = addr.getHostAddress();
			hostName = addr.getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Chatter chatter = new Chatter(ipAddress, hostName);
		this.message = new Message(chatter, messageContent, new Timestamp(new Date().getTime()));
		this.messageBox = messageBox;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.keyCode == SWT.CR){
			
			for(int i=0; i<Settings.hosts.length; i++){
				MessageSender sender = new MessageSender(message, Settings.hosts[i]);
				Thread t = new Thread(sender);
				t.start();
			}
			
			this.messageBox.setText("");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

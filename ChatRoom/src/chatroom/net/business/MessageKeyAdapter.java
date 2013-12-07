package chatroom.net.business;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Text;

import chatroom.bean.AliveChatterList;
import chatroom.bean.Chatter;
import chatroom.bean.Message;
import chatroom.net.sender.MessageSender;
import chatroom.util.Settings;

public class MessageKeyAdapter implements KeyListener {

	private Message message;
	private Text messageBox;
	private StyledText text;
	
	public MessageKeyAdapter(Text messageBox, StyledText text){
		
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
		this.text = text;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.keyCode == SWT.CR){
			
			message.setContent(messageBox.getText());
			
			for(String ipAddr: AliveChatterList.getChatterMap().keySet()){
				MessageSender sender = new MessageSender(message, ipAddr);
				Thread t = new Thread(sender);
				t.start();
				
			}
			
			this.text.append(message.toString());
			this.messageBox.setText("");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

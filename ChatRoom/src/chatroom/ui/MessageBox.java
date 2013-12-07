package chatroom.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import chatroom.bean.Message;
import chatroom.net.business.MessageKeyAdapter;

public class MessageBox extends ScrolledComposite {

	private Text messageText;
	
	public MessageBox(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		
		setLayout(new FillLayout());
		
		setExpandHorizontal(true);
		setExpandVertical(true);
		
		messageText = new Text(this, SWT.NONE | SWT.H_SCROLL | SWT.V_SCROLL);
		//messageText.setText("to-be sent message");
		messageText.addKeyListener(new MessageKeyAdapter(messageText));
		
		setContent(messageText);
		layout();
		
	}
}

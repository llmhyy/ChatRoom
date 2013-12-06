package chatroom.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class ChatArea extends ScrolledComposite {

	private StyledText chatText;
	
	public ChatArea(Composite parent, int style) {
		// TODO Auto-generated constructor stub
		super(parent, style);
		
		setLayout(new FillLayout());
		setExpandHorizontal(true);
		setExpandVertical(true);
		
		
		chatText = new StyledText(this, SWT.NONE | SWT.H_SCROLL | SWT.V_SCROLL);
		chatText.setText("chatting content");
		
		setContent(chatText);
		layout();
	}

}

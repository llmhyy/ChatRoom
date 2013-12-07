package chatroom.ui;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class ChatArea extends ScrolledComposite {

	private Main main;
	private StyledText chatText;
	
	public ChatArea(Composite parent, int style, Main main) {
		// TODO Auto-generated constructor stub
		super(parent, style);
		
		setLayout(new FillLayout());
		setExpandHorizontal(true);
		setExpandVertical(true);
		
		
		chatText = new StyledText(this, SWT.NONE | SWT.H_SCROLL | SWT.V_SCROLL);
		//chatText.setText("chatting content");
		
		setContent(chatText);
		layout();
		
		this.main = main;
	}

	public StyledText getChatText() {
		return chatText;
	}
	
	public void update(String ipAddress){
		String content = chatText.getText();
		
		StyleRange normalStyleRange = new StyleRange();
		normalStyleRange.start = 0;
		normalStyleRange.length = content.length();
		normalStyleRange.fontStyle = SWT.NORMAL;
		normalStyleRange.foreground = Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
		chatText.setStyleRange(normalStyleRange);
		
		
		int start = content.indexOf(ipAddress);
		while(start != -1){
			StyleRange styleRange = new StyleRange();
			styleRange.start = start;
			styleRange.length = ipAddress.length();
			styleRange.fontStyle = SWT.BOLD;
			styleRange.foreground = Display.getDefault().getSystemColor(SWT.COLOR_BLUE);
			
			chatText.setStyleRange(styleRange);
			
			start = content.indexOf(ipAddress, start+ipAddress.length()) ;
		}
	}

	public class Range{
		private int start;
		private int length;
		
		public Range(int start, int length){
			this.start = start;
			this.length = length;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}
		
		
	}
}

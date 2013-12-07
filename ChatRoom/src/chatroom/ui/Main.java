package chatroom.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import chatroom.bean.AliveChatterList;
import chatroom.net.listener.ActiveChatterTester;
import chatroom.net.listener.AliveListener;
import chatroom.net.listener.MessageListener;


public class Main {
	private ChatArea chatArea;
	private MessageBox messageBox;
	private ChattingList chattingList;
	private PropertyView propertyView;
	//public static AliveChatterList chatterList = new AliveChatterList();
	
	public static void main(String[] args){
		Main main = new Main();
		main.createUI();
		
		AliveListener aliveListener = new AliveListener();
		Thread aliveListeningThread = new Thread(aliveListener);
		aliveListeningThread.start();
		
		MessageListener messageListener = new MessageListener(main);
		Thread messageListeningTread = new Thread(messageListener);
		messageListeningTread.start();
		
		ActiveChatterTester activeChatterTester = new ActiveChatterTester();
		Thread testerThread = new Thread(activeChatterTester);
		testerThread.start();
		
	}
	
	public void createUI(){
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(600, 500);
		shell.setLayout(new FillLayout());
		
		
		SashForm form = new SashForm(shell, SWT.HORIZONTAL);
		form.setLayout(new FillLayout());
		
		SashForm messageForm = new SashForm(form, SWT.VERTICAL);
		chatArea = new ChatArea(messageForm, SWT.BORDER | SWT.H_SCROLL, this);
		messageBox = new MessageBox(messageForm, SWT.BORDER | SWT.H_SCROLL, this);
		messageForm.setWeights(new int[]{70, 30});
		
		SashForm friendForm = new SashForm(form, SWT.VERTICAL);
		chattingList = new ChattingList(friendForm, SWT.BORDER | SWT.H_SCROLL, this);
		propertyView = new PropertyView(friendForm, SWT.BORDER, this);
		friendForm.setWeights(new int[]{50, 50});
		
		form.setWeights(new int[] {70,30});
		
		shell.open();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}

	public ChatArea getChatArea() {
		return chatArea;
	}

	public MessageBox getMessageBox() {
		return messageBox;
	}

	public ChattingList getChattingList() {
		return chattingList;
	}

	public PropertyView getPropertyView() {
		return propertyView;
	}
	
	
}

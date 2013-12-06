package chatroom.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


public class MainFrame {
	public static void main(String[] args){
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(600, 500);
		shell.setLayout(new FillLayout());
		
		
		SashForm form = new SashForm(shell, SWT.HORIZONTAL);
		form.setLayout(new FillLayout());
		
		SashForm messageForm = new SashForm(form, SWT.VERTICAL);
		ChatArea chatArea = new ChatArea(messageForm, SWT.BORDER | SWT.H_SCROLL);
		MessageBox messageBox = new MessageBox(messageForm, SWT.BORDER | SWT.H_SCROLL);
		messageForm.setWeights(new int[]{70, 30});
		
		SashForm friendForm = new SashForm(form, SWT.VERTICAL);
		ChattingList friendList = new ChattingList(friendForm, SWT.BORDER | SWT.H_SCROLL);
		PropertyView propertyView = new PropertyView(friendForm, SWT.BORDER);
		friendForm.setWeights(new int[]{50, 50});
		
		form.setWeights(new int[] {70,30});
		
		shell.open();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}

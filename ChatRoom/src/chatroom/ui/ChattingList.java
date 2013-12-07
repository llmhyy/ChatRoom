package chatroom.ui;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import chatroom.bean.AliveChatterList;
import chatroom.bean.Chatter;

public class ChattingList extends ScrolledComposite {

	private Main main;
	private Tree tree;
	
	public ChattingList(Composite parent, int style, final Main main) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		
		setLayout(new FillLayout());
		
		setExpandHorizontal(true);
		setExpandVertical(true);
		
		tree = new Tree(this, SWT.V_SCROLL);
		tree.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem[] itemList = tree.getSelection();
				
				if(itemList != null){
					Chatter chatter = (Chatter)itemList[0].getData();
					main.getPropertyView().update(chatter.getIpAddress(), chatter.getNickName());
					main.getChatArea().update(chatter.getIpAddress());
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ChatterChecker checker = new ChatterChecker(tree);
		Thread checkerThread = new Thread(checker);
		checkerThread.start();
		
		setContent(tree);
		layout();
		
		this.main = main;
	}

}

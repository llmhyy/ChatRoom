package chatroom.ui;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
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
	
	public ChattingList(Composite parent, int style, Main main) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		
		setLayout(new FillLayout());
		
		setExpandHorizontal(true);
		setExpandVertical(true);
		
		tree = new Tree(this, SWT.V_SCROLL);
		
		ChatterChecker checker = new ChatterChecker(tree);
		Thread checkerThread = new Thread(checker);
		checkerThread.start();
		
		setContent(tree);
		layout();
		
		this.main = main;
	}

}

package chatroom.ui;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class ChattingList extends ScrolledComposite {

	
	private Tree tree;
	
	public ChattingList(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		
		setLayout(new FillLayout());
		
		setExpandHorizontal(true);
		setExpandVertical(true);
		
		tree = new Tree(this, SWT.V_SCROLL);
		TreeItem item1 = new TreeItem(tree, SWT.NONE);
		item1.setText("friend1");
		TreeItem item2 = new TreeItem(tree, SWT.NONE);
		item2.setText("friend2");
		
		setContent(tree);
		layout();
	}

}

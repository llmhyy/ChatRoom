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

	
	private Tree tree;
	
	public ChattingList(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		
		setLayout(new FillLayout());
		
		setExpandHorizontal(true);
		setExpandVertical(true);
		
		tree = new Tree(this, SWT.V_SCROLL);
		
		Display.getDefault().syncExec(new Runnable(){

			@Override
			public void run() {
				while(true){
					
					for(String ipAddr: AliveChatterList.getChatterMap().keySet()){
						Chatter chatter = AliveChatterList.getChatterMap().get(ipAddr);
						
						TreeItem item = new TreeItem(tree, SWT.NONE);
						item.setText(chatter.getNickName());
						item.setData(chatter);
					}
					
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		});
		
		setContent(tree);
		layout();
	}

}

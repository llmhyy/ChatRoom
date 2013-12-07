package chatroom.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import chatroom.bean.AliveChatterList;
import chatroom.bean.Chatter;

public class ChatterChecker implements Runnable {

	private Tree tree;

	public ChatterChecker(Tree tree) {
		this.tree = tree;
	}

	@Override
	public void run() {
		
		while(true){
			Display.getDefault().asyncExec(new Runnable() {
				
				@Override
				public void run() {
					
					for(TreeItem item: tree.getItems()){
						item.dispose();
					}
					
					for (String ipAddr : AliveChatterList.getChatterMap().keySet()) {
						Chatter chatter = AliveChatterList.getChatterMap().get(
								ipAddr);
						
						TreeItem item = new TreeItem(tree, SWT.NONE);
						item.setText(chatter.getNickName());
						item.setData(chatter);
					}
					
					//tree.redraw();
				}
				
			});
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}

}

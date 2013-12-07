package chatroom.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class PropertyView extends Composite {

	private Main main;
	
	private Label ipLabel;
	private Text ipText;
	
	private Label nicknameLabel;
	private Text nicknameText;
	
	private Button confirmButton;

	public PropertyView(Composite parent, int style, Main main) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		
		this.setLayout(gridLayout);
		confirmButton = new Button(this, SWT.NONE);
		confirmButton.setText("confirm modification");
		confirmButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		
		ipLabel = new Label(this, SWT.NONE);
		ipLabel.setText("IP");
		ipLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		ipText = new Text(this, SWT.NONE);
		ipText.setText("10.131.252.131");
		ipText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		
		this.main = main;
	}

}

package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class index {

	protected Shell index;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			index window = new index();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		index.open();
		index.layout();
		while (!index.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		index = new Shell();
		index.setSize(371, 330);
		index.setText("Index");
		
		Button btn_stock = new Button(index, SWT.NONE);
		btn_stock.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btn_stock.setBounds(107, 59, 125, 35);
		btn_stock.setText("Stock");
		
		Button btn_rdv = new Button(index, SWT.NONE);
		btn_rdv.setText("Rendez-vous");
		btn_rdv.setBounds(107, 167, 125, 35);

	}
}

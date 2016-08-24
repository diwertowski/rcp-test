package com.fullscreen;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
/*
public class Drawing {
	
	@Execute
	public void draws() {
		Display display = new Display();

		Shell shell = new Shell(display);
		
		shell.open();

		final ToolBar bar = new ToolBar(shell, SWT.HORIZONTAL);
		bar.setSize(150, 25);
		bar.setLocation(0, 0);

		final ToolItem fsToolItem = new ToolItem(bar, SWT.PUSH);
		fsToolItem.setText("Fullscreen");
		fsToolItem.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (shell.getFullScreen() == false) {
					shell.setFullScreen(true);
				} else {
					shell.setFullScreen(false);
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		final ToolItem drawToolItem = new ToolItem(bar, SWT.PUSH);
		drawToolItem.setText("Draw");
		drawToolItem.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (shell.getFullScreen() == true)
				shell.addPaintListener(new PaintListener() { 
			        public void paintControl(PaintEvent e) { 
			            Rectangle clientArea = shell.getClientArea(); 
			            int width = clientArea.width; 
			            int height = clientArea.height; 
			         
			            e.gc.setBackground(display.getSystemColor(SWT.COLOR_CYAN)); 
			         e.gc.fillPolygon(new int[] {0,0,width,0,width/2,height}); 
			         
			        } 
			    });
				shell.redraw();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
			
		});

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
			
		}

	

}*/

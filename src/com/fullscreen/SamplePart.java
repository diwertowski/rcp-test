package com.fullscreen;

import javax.annotation.PostConstruct;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;

public class SamplePart extends ApplicationWindow {

	/**ApplicationWindow Constructor
	 * super.setShellStyle hides the title bar
	 * */
	public SamplePart() {
		super(null);
		super.setShellStyle(SWT.NONE);
		//addToolBar(SWT.FLAT | SWT.WRAP | SWT.RIGHT);
	}
	
	@PostConstruct
	public void startup(Composite parent, Shell shell) {
		
		ToolBar toolBar = new ToolBar(parent, SWT.WRAP);
		toolBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		final ToolBarManager manager = new ToolBarManager(toolBar);
		
		final Action actionFullScreen = new Action("&FullScreen") {
			public void run() {
				if (shell.getFullScreen() == false) {
					shell.setFullScreen(true);
					shell.setMenuBar(null);
				} else {
					shell.setFullScreen(false);
				}
			}
		};

		final Action actionPopUp = new Action("&PopUp") {
			public void run() {
				foo();
			}
		};
			
		manager.add(actionFullScreen);
		manager.add(actionPopUp);
		manager.update(true);
		
		shell.open();
	}

	/**Creates the "pop-up" window*/
	public void foo() {
		SamplePart window = new SamplePart();
		window.open();
	}

	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NO_TRIM | SWT.ON_TOP);

		container.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				Rectangle clientArea = parent.getClientArea();
				int width = clientArea.width;
				int height = clientArea.height;
				e.gc.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_RED));
				e.gc.fillPolygon(new int[] { 0, 0, width, 0, width, height, 0, height });
			}
		});
		return container;
	}

	protected MenuManager createMenuManager() {

		MenuManager menuManager = new MenuManager("menu");
		MenuManager fileMenu = new MenuManager("&File");

		menuManager.add(fileMenu);
		return menuManager;
	}

	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		statusLineManager.setMessage(null, "");
		return statusLineManager;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
	}

	/**!!!*/
	protected void constrainShellSize() {
	    //super.constrainShellSize();
	    //getShell().setSize(300, 300);
	    getShell().setLocation(400, 0);
	}

	protected Point getInitialSize() {
		return new Point(300, 300);
	}
/*
	protected Point getInitialLocation(final Point initialSize) {
		int x = 400;
		int y = 0;
		return new Point(x, y);
	}
*/
	private ExitAction _exitAction = new ExitAction(this);

	private class ExitAction extends Action {
		ApplicationWindow _window;

		public ExitAction(ApplicationWindow window) {
			_window = window;
			setText("New Window");
			setToolTipText("Exit Application");
		}

		
		public void run() {
			SamplePart window = new SamplePart();
			window.open();

		}
	}
}

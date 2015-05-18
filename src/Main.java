import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

	private static JFrame frame = new JFrame();
	private static AnimatedPanel panel = new AnimatedPanel();
	private static MenuPanel menu = MenuPanel.getInstance();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
				}

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(menu);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
		});
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static AnimatedPanel getPanel() {
		return panel;
	}

	public static void changeToMenu() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panel);
		
		panel.repaint();
		panel.revalidate();
		
		frame.repaint();
		frame.revalidate();
		
		panel.animate();
		
		panel.requestFocusInWindow();

	}

}

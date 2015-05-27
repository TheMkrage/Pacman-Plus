import java.awt.EventQueue;
import javax.swing.JFrame;
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

	public static void changeToGame() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panel);

		panel.repaint();
		panel.revalidate();

		frame.repaint();
		frame.revalidate();

		panel.animate();

		panel.requestFocusInWindow();

	}

	public static void changeToMenu() {
		frame.dispose();
	}
}

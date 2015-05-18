import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	private static MenuPanel instance;
	public static MenuPanel getInstance() {
		if (instance == null) {
			instance = new MenuPanel();
		}
		return instance;
	}
	JButton start = new JButton("START");
	private MenuPanel() {
		this.setPreferredSize(new Dimension(600, 600));
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Main.changeToMenu();
				
			}
			
		});
		this.add(start);
	}
	protected static Component getPanel() {
		return instance;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
}

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuPanel extends JPanel {

	private static MenuPanel instance;

	public static MenuPanel getInstance() {
		if (instance == null) {
			instance = new MenuPanel();
		}
		return instance;
	}

	private JPanel centerPanel = new JPanel();
	private JTextField playTo = new JTextField("10", 4);
	JButton start = new JButton("START");

	private MenuPanel() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(600, 600));
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Main.changeToGame();
			}

		});
		JPanel title = new JPanel();
		JLabel lab = new JLabel("SUPER PONG");
		title.add(lab);
		
		this.centerPanel.setLayout(new FlowLayout());

		this.add(title, BorderLayout.NORTH);
		this.add(start, BorderLayout.SOUTH);
		this.add(centerPanel, BorderLayout.CENTER);

		this.centerPanel.add(new JLabel("Play Until:"));
		this.centerPanel.add(playTo);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

	public int getGoTo() {
		return Integer.parseInt(playTo.getText());
	}
}

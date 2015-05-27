import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.Action;

public class AnimatedPanel extends JPanel {

	private float progress = 0.0f; // a number between 0.0 and 1.0
	private int player1Score = 0;
	private int player2Score = 0;
	
	private Thread ballThread;
	private Thread p1Thread;
	private Thread p2Thread;
	
	private Timer timer;

	public AnimatedPanel() {
		setPreferredSize(new Dimension(600, 600));
		paddle1 = new Paddle(25, 250, "rectangle100.png");
		paddle2 = new Paddle(550, 250, "rectangle100.png");
		
		ballThread = (new Thread(Ball.getInstance()));
		p1Thread = (new Thread(paddle1));
		p2Thread = (new Thread(paddle2));
	}
	@SuppressWarnings("deprecation")
	public void stop() {
		timer.stop();
		//this.ballThread.stop();
		//this.p1Thread.stop();
		//this.p2Thread.stop();
	}
	static Paddle paddle1;
	static Paddle paddle2;

	public static Paddle getPaddle1() {
		return paddle1;
	}

	public static Paddle getPaddle2() {
		return paddle2;
	}

	public void animate() {

		this.getInputMap().put(KeyStroke.getKeyStroke("W"), "Move1Up");
		this.getActionMap().put("Move1Up", new MovePaddleAction(1, -5));

		this.getInputMap().put(KeyStroke.getKeyStroke("S"), "Move1Down");
		this.getActionMap().put("Move1Down", new MovePaddleAction(1, 5));

		this.getInputMap().put(KeyStroke.getKeyStroke("released W released S"),
				"Stop1");
		this.getActionMap().put("Stop1", new MovePaddleAction(1, 0));

		this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "Move2Up");
		this.getActionMap().put("Move2Up", new MovePaddleAction(2, -5));

		this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "Move2Down");
		this.getActionMap().put("Move2Down", new MovePaddleAction(2, 5));

		this.getInputMap().put(
				KeyStroke.getKeyStroke("released UP released DOWN"), "Stop2");
		this.getActionMap().put("Stop2", new MovePaddleAction(2, 0));

		
		ballThread.start();
		p1Thread.start();
		p2Thread.start();

		int framesPerSecond = 1000;
		int delay = 1000 / framesPerSecond;
		timer = new Timer(delay, null);

		timer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();

			}
		});
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(Ball.getInstance().getImage().getImage(), Ball
				.getInstance().getX(), Ball.getInstance().getY(), null);
		g2d.drawImage(paddle1.getImage().getImage(), paddle1.getX(),
				paddle1.getY(), null);
		g2d.drawImage(paddle2.getImage().getImage(), paddle2.getX(),
				paddle2.getY(), null);
		g2d.drawString(Ball.getInstance().get1Score(), 320, 20);
		g2d.drawString(Ball.getInstance().get2Score(), 280, 20);
		// System.out.println(paddle2.getY());
	}
}
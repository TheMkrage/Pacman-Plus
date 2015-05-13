import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

	public class AnimatedPanel extends JPanel {

		private float progress = 0.0f; // a number between 0.0 and 1.0
		private int player1Score = 0;
		private int player2Score = 0;
		
		public AnimatedPanel() {
			setPreferredSize(new Dimension(600, 600));
		}

		public static void setPlayerOneScore(int score) {
			
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

			
			paddle1 = new Paddle(25, 250, "rectangle100.png");
			paddle2 = new Paddle(550, 250, "rectangle100.png");
			
			(new Thread(Ball.getInstance())).start();
			(new Thread(paddle1)).start();
			(new Thread(paddle2)).start();
			

			// Paddle 1
			this.addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent e) {
					//System.out.println("HELLO");
					System.out.println("HOWDY");
					if (e.getKeyCode() == KeyEvent.VK_UP) {
						paddle2.setContiniousMovement(0, -4);
					} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						paddle2.setContiniousMovement(0, 4);
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_UP
							|| e.getKeyCode() == KeyEvent.VK_DOWN) {
						paddle2.stop();
					}

				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub

				}

			});
			System.out.println("ADDED");
			// Paddle 1
			this.addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_W) {
						paddle1.setContiniousMovement(0, -4);
					} else if (e.getKeyCode() == KeyEvent.VK_S) {
						paddle1.setContiniousMovement(0, 4);
					}
					
				}
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_W
							|| e.getKeyCode() == KeyEvent.VK_S) {
						paddle1.stop();
					}
				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub

				}

			});
			
			int framesPerSecond = 1000;
			int delay = 1000 / framesPerSecond;
			final long start = System.currentTimeMillis();
			final Timer timer = new Timer(delay, null);

			timer.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					final long now = System.currentTimeMillis();
					final long elapsed = now - start;

					int width = getWidth();
					int height = getHeight();
					int oldWidth = (int) (width * progress);

					progress = (float) elapsed / 1000;
					int newWidth = (int) (width * progress);

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
			g2d.drawString("0", 280, 20);
			g2d.drawString("0", 320, 20);
			//System.out.println(paddle2.getY());
		}
	}
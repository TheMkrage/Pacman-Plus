
public class Paddle extends GameObject implements Runnable{

	public Paddle(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Paddle(int x, int y, String name) {
		super(x, y, name);
		// TODO Auto-generated constructor stub
	}

	public Paddle(int x, int y, int width, int height, String name) {
		super(x, y, width, height, name);
		// TODO Auto-generated constructor stub
	}

	public Paddle(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		xRate = 0;
		yRate = 0;
		while (true) {
			if (yRate < 0 && this.getY() <= 0) {
				yRate = 0;
			}else if (yRate > 0 && this.getY() >= 600 - this.getHeight()) {
				yRate = 0; 
			}
			
			this.setX(this.getX() + xRate);
			this.setY(this.getY() + yRate);
			this.setContiniousMovement(xRate, yRate);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

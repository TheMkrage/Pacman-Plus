import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

public class MovePaddleAction implements Action {
	
	private int direction = 0;
	private Paddle player;
	
	public MovePaddleAction(int player, int direction) {
		this.direction = direction;
		if (player == 1) {
			this.player = AnimatedPanel.getPaddle1();
		}else {
			this.player = AnimatedPanel.getPaddle2();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		player.setContiniousMovement(0, direction);
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean b) {
		

	}
}

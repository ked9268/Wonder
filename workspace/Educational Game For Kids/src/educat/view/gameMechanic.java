package educat.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import educat.controllers.startAnim;

public class gameMechanic {

	public static class bb implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {	
			//Call a thread.
			startAnim c = new startAnim();
			Thread tm = new Thread(c);
			tm.start();
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

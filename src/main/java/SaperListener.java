
import java.awt.event.*;

/**
 * Klasa implementujaca klasę MouseListener, służąca do przekierowania
 * dalszej logiki przy kliknięciu na pole w rozgrywce
 */
public class SaperListener implements MouseListener{

	private SaperPanel panel;
	
	public SaperListener(SaperPanel sp) {
		panel = sp;
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			try {
				panel.uncover((Tile)e.getSource());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if(e.getButton() == MouseEvent.BUTTON3) {
			panel.setFlag((Tile)e.getSource());
		}
	}
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
		
	}
	public void mouseReleased(MouseEvent e) {
		
	}
}

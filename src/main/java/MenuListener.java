import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 * Klasa implementujaca klasę ActionListener, zajmująca się
 * logiką i działaniem menu gry umieszczonego w lewm górnym rogu gry
 */
public class MenuListener implements ActionListener{
	private SaperFrame frame;

	/**
	 * Konstruktor klasy MenuListener
	 * @param f - okno nadrzędne
	 */
	public MenuListener(SaperFrame f) {
		frame = f;
	}

	/**
	 * Przeciążona metoda actionPerformed, zajmująca się
	 * logiką każdej z opcji menu
	 * @param e - event do przetworzenia
	 */
	public void actionPerformed(ActionEvent e) {
		String actionString = e.getActionCommand();
		
		if(actionString.equals("Nowa Gra")) {
			frame.newGame();
			System.out.println("n");
		}
		else if(actionString.equals("Tablica wynikow")) {
			frame.highScoreTable();
			System.out.println("hs");
		}
		else if(actionString.equals("Wyjscie")) {
			frame.exit();
			System.out.println("e");
		}		
	}
}

import javax.swing.JFrame;

/**
 * Klasa dziedzicząca po klasie JFrame, będąca bazą pod okno
 * główne aplikacji
 */
public class SimpleFrame extends JFrame{
	/**
	 * Konstruktor klasy SimpleFrame
	 */
	public SimpleFrame() {
		setSize(200,200);
		setLocation(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Konstruktor klasy SimpleFrame
	 * @param x - szerokość
	 * @param y - wysokość
	 */
	public SimpleFrame(int x, int y) {
		setSize(x,y);
		setLocation(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Przesłonięta metoda pokazująca okienko
	 */
	public void showIt() {
		setVisible(true);
	}
	/**
	 * Przesłonięta metoda pokazująca okienko z tytułem
	 */
	public void showIt(String title) {
		setTitle(title);
		showIt();
	}
	/**
	 * Przesłonięta metoda pokazująca okienko z tytułem
	 */
	public void showIt(String title, int x, int y) {
		setLocation(x,y);
		showIt(title);
	}
	/**
	 * Metoda ukrywająca okienko
	 */
	public void hideIt() {
		setVisible(false);
	}
}

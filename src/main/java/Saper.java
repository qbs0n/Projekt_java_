
/**
 * Główna klasa programu w której istnieją dwa statyczne pola określające
 * szerokośc i wysokość okna rozgrwyki, instancja klasy SaperFrame oraz
 * główna metoda main
 *
 */

public class Saper {
	static int width = 600;
	static int height = 650;
	static SaperFrame frame1;
	public static void main(String[] args) throws Exception {
		frame1 = new SaperFrame();
		/**
		 * Ustawienie wielkości okna
		 */
		frame1.setSize(width,height);
		/**
		 * Centrowanie okna
		 */
		frame1.setLocationRelativeTo(null);
		frame1.showIt("Saper");
	}
	
}

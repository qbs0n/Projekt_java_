import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Klasa dziedziąca po klasie SimpleFrame, tworząca menu gry
 * oraz zawierająca funkcje służące do przepływu rozgrywki
 */

public class SaperFrame extends SimpleFrame{
	/**
	 * Deklaracja obiektu klasy SaperConfig
	 */
	SaperConfig defConfig;
	/**
	 * Deklaracja obiektu klasy SaperPanel
	 */
	SaperPanel saperPanel;
	/**
	 * Deklaracja i inicjalizacja obiektu klasy HighScore
	 */
	HighScore hs = new HighScore();
	/**
	 * Deklaracja obiektu klasy MeasureTime
	 */
	MeasureTime interval;
	public SaperFrame(){
		/**
		 * Tworzenie menu głównego umieszczonego w lewym rogu okna
		 */
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu menu = new JMenu("Opcje");
		
		menubar.add(menu);
		
		JMenuItem newItem = new JMenuItem("Nowa Gra");
		JMenuItem hsItem = new JMenuItem("Tablica wynikow");
		JMenuItem exitItem = new JMenuItem("Wyjscie");
		
		menu.add(newItem);
		menu.add(hsItem);
		menu.add(exitItem);

		/**
		 * Inicjalizacja obiektu defConfig
		 */
		defConfig = new SaperConfig(3,0);
		/**
		 * Inicjalizacja obiektu saperPanel
		 */
		saperPanel = new SaperPanel(defConfig);
		/**
		 * Dodanie obiektu saperPanel do okna głównego
		 */
		getContentPane().add(saperPanel);

		/**
		 * Event listener do menu
		 */
		MenuListener editorListener = new MenuListener(this);
		newItem.addActionListener(editorListener);
		hsItem.addActionListener(editorListener);
		exitItem.addActionListener(editorListener);
		
	}

	/**
	 * Metoda tworzacą nową grę przy wybraniu nowej gry z menu
	 */
	void newGame() {
		NewGameDialog n = new NewGameDialog(this,defConfig);
		n.showIt();
		if(n.cancel == true)
		{
			getContentPane().remove(saperPanel);
			getContentPane().revalidate();
			getContentPane().repaint();
			saperPanel = new SaperPanel(new SaperConfig(n.size,n.percent));
			defConfig.size = n.size;
			defConfig.percentOfBombs = n.percent;
			getContentPane().add(saperPanel);
		}
	}

	/**
	 * Metoda tworząca tabele wyników
	 */
	void highScoreTable() {
		HighScoreDialog go = new HighScoreDialog(this,hs);
		go.setVisible(true);
		
	}

	/**
	 * Metoda wyłączająca program
	 */
	void exit() {
		System.exit(0);
	}

	/**
	 * Metoda wyświetlająca okienko przegranej
	 * @param interval - czas rozgrwyki
	 * @param defConfig - ustawienia gry
	 */
	void gameOver(MeasureTime interval, SaperConfig defConfig) {
		GameOverDialog go = new GameOverDialog(this,interval, defConfig);
		go.setVisible(true);
		
		if(go.setNewGame == true) this.newGame();
	}

	/**
	 * Metoda wyświetlająca okienko wygranej
	 * @param interval - czas rozgrywki
	 * @param defConfig - ustawienia gry
	 */
	void win(MeasureTime interval, SaperConfig defConfig) {
		WinDialog go = new WinDialog(this,interval, defConfig);
		go.setVisible(true);
		
		if(go.setHS == true) {
			hs.amount++;
			hs.add(go.nick,defConfig.getSize(),defConfig.getPercent(),go.time);
		}
		if(go.setNewGame == true) this.newGame();
	}
	
	
}

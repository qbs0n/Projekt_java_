import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

/**
 * Klasa dziedzicząca po klasie JDialog, jej zadaniem jest
 * zajęcie sie logiką i wyglądem okienka dialogowego tablicy wyników
 */
public class HighScoreDialog extends JDialog  {
	private String[][] entries;
	private String[] columnNames = {"Nick","Rozmiar planszy","Procent bomb","Czas (s)"};

	/**
	 * Konstruktor klasy HighScoreDialog
	 * @param frame - okno nadrzędne
	 * @param hs - obiekt klasy HighScore
	 */
	public HighScoreDialog(JFrame frame,HighScore hs){
		super(frame, "Tabela wyników",true);
		setResizable(false);
		
		setModal(true);
		
		fillEntries(hs);
		
		JTable table = new JTable(entries,columnNames) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
		};
		JScrollPane scrollpane = new JScrollPane(table);
		getContentPane().add(scrollpane);
		
		pack();
		setLocationRelativeTo(frame);
	}

	/**
	 * Metoda wypełniająca tablice wyników z użyciem obiektu HighScore
	 * @param hs - obiekt HighScore
	 */
	void fillEntries(HighScore hs){
		entries = new String[hs.amount][4];
		
		for(int i=0;i<hs.amount;i++){
			entries[i][0] = hs.nicks.get(i);
			entries[i][1] = hs.sizes.get(i).toString();
			entries[i][2] = hs.percents.get(i).toString();
			entries[i][3] = hs.times.get(i).toString();
		}
	}
}

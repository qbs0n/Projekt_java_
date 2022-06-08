import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.*;
import javax.swing.SwingConstants;

import java.util.ArrayList;
/**
 * Klasa dziedziąca po klasie JPanel, tworząca panel na którym umieszczane
 * są odpowiednie elementy (przyciski) oraz zawierająca funkcje służące
 * do dalszego przepływu rozgrywki
 */
public class SaperPanel extends JPanel {
	/**
	 * Deklaracja obiektu klasy SaperConfig
	 */
	SaperConfig defConfig;
	/**
	 * Deklaracja obiektu klasy SaperModel
	 */
	SaperModel sModel;
	/**
	 * Deklaracja zmiennej tablicowej Tile
	 */
	Tile[][] tiles;
	/**
	 * Deklaracja zmiennej tablicowej typu int
	 */
	int[][] table;
	/**
	 * Deklaracja obiektu klasy IconHolder
	 */
	IconHolder holder;
	/**
	 * Deklaracja obiektu klasy SoundHolder
	 */
	SoundHolder sHolder;
	/**
	 * Deklaracja obiektu klasy SaperListener
	 */
	SaperListener listener;
	/**
	 * Deklaracja obiektu klasy MeasureTime
	 */
	MeasureTime interval;

	/**
	 * Konstruktor klasy
	 * @param def konfigyracja przekazana z obiektu klasy SaperFrame
	 */
	public SaperPanel(SaperConfig def){

		defConfig = def;
		sModel = new SaperModel(defConfig);
		
		sModel.checkTable();
		table = sModel.getTable();
		tiles = new Tile[defConfig.getSize()][defConfig.getSize()];	
		
		GridLayout border = new GridLayout(defConfig.getSize(),defConfig.getSize());
		setLayout(border);
		
		listener = new SaperListener(this);
		
		for (int i=0;i<defConfig.getSize();i++) {
			for(int j=0;j<defConfig.getSize();j++) {
				tiles[i][j] = new Tile();
				add(tiles[i][j]);
				tiles[i][j].addMouseListener(listener);
				tiles[i][j].setValue(table[i][j]);
				tiles[i][j].setPosX(i);
				tiles[i][j].setPosY(j);
			}
		}
		Tile.size = Saper.width / defConfig.size;
		System.out.println(Tile.size);
		
		holder = new IconHolder(defConfig);
		sHolder = new SoundHolder();
		
		interval = new MeasureTime();
		
	}

	/**
	 * Metoda grająca dźwięk bomby oraz wyzwalajaca
	 * odpowiednie dalsze metody z obiektu klasy SaperModel
	 * @param t - kliknięte pole
	 * @throws Exception - wyjątek do obsługi braku pliku (bomb.wav)
	 */
	public void uncover(Tile t) throws Exception{
		if(t.getValue()==9){
				sHolder.playSound("bomb");
				gameOver();
			}
		else sModel.cascadeClear(t,tiles,holder);
		
		if(sModel.numberOfEmpty == sModel.numberOfUncovered) {
			win();
		}
	}

	/**
	 * Metoda ustawiająca lub usuwajaca flage (zmieniająca wartosc flag obiektu t)
	 * oraz ustawiająca odpowiednią ikonę
	 * @param t - kliknięte pole
	 */
	public void setFlag(Tile t) {
		if(t.getFlag() == 1 && t.getCover() == 1) {
			t.setFlag(0);
			t.setImageIcon(null);
		}else if(t.getFlag() == 0 && t.getCover() == 1) {
			t.setFlag(1);
			t.setImageIcon(holder.icons.get("10"));
		}
	}

	/**
	 * Metoda obsługująca zdarzenie przegranej
	 * -usuwa MouseListener
	 * -odsłania pola
	 * -uruchamiająca metode gameOver klasy SaperFrame
	 */
	public void gameOver() {
		
		for (int i=0;i<defConfig.getSize();i++) {
			for(int j=0;j<defConfig.getSize();j++) {
				tiles[i][j].removeMouseListener(listener);
				if(tiles[i][j].getValue() == 9)
				{
					tiles[i][j].setCover(0);
					tiles[i][j].setImageIcon(holder.icons.get(""+tiles[i][j].getValue()));
				}
			}
		}
		
		Saper.frame1.gameOver(interval,defConfig);
	}

	/**
	 * Metoda obsługująca zdarzenie wygranej
	 * -usuwa MouseListener
	 * -uruchamiająca metode win klasy SaperFrame
	 */
	public void win() {
		for (int i=0;i<defConfig.getSize();i++) {
			for(int j=0;j<defConfig.getSize();j++) {
				tiles[i][j].removeMouseListener(listener);
			}
		}
		System.out.println("win");
		Saper.frame1.win(interval,defConfig);
	}
	
}

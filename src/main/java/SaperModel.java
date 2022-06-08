import javax.swing.JButton;
import java.lang.Math;
import javax.swing.ImageIcon;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Klasa będąca głównym trzonem logiki rozgrywki.
 */
public class SaperModel {

	///0 - puste
	///1,2,3,4,5,6,7,8 - liczba bomb wokol
	///9 - bomba
	///10 - flaga

	/**
	 * Tablica przechowująca wartości liczbowe odpowiadające odpowiednim polom
	 * ///0 - puste
	 * ///1,2,3,4,5,6,7,8 - liczba bomb wokol
	 * ///9 - bomba
	 * ///10 - flaga
	 */
	int[][] table;
	/**
	 * Wielkość planszy
	 */
	int size;
	/**
	 * Procent bomb na planszy
	 */
	double percent;
	/**
	 * Ilość pustych pól na planszy
	 */
	int numberOfEmpty = 0;
	/**
	 * Ilość odkrytych pól
	 */
	int numberOfUncovered = 0;

	/**
	 * Konstruktor główny klasy, inicjujący podstawowe wartości pobrane z
	 * konfiguracji, losujący z szansą równą 'percent' bombę dla każdego pola
	 * oraz uruchamiający funkcję checkNeighbours
	 * @param config - ustawienie gry
	 */
	SaperModel(SaperConfig config)
	{
		size = config.getSize();
		percent = config.getPercent();
		table = new int[size][size];
		
		for (int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				double rand = Math.random();
				if(rand<percent) table[i][j] = 9;
				else {
					table[i][j] = 0;
					numberOfEmpty++;
				}
			}
		}
		for (int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				table[i][j] = checkNeighbours(i,j,table);
			}
		}
		
	}

	/**
	 * Konstruktor pomocniczy używany do wykonania testu jednostkowego klasy SaperModel
	 * @param t - tablica pól
	 * @param s - wielkość
	 * @param noe - ilość pustych miejsc
	 */
	SaperModel(int[][] t, int s, int noe)
	{
		size = s;
		table = t;
		numberOfEmpty = noe;
	}


	/**
	 * Funkcja biorąca jako argumenty koordynaty pola oraz tablicę, zwracajaca
	 * -9 jeśli pole jest bombą
	 * -ilość sąsiednich bomb jeśli pole nie jest bombą
	 * @param i - koordynata pola
	 * @param j - koordynata pola
	 * @param table - tablica pól
	 * @return '9' jeśli pole jest bombą, 'ilość sąsiednich bomb' jeśli pole nie jest bombą
	 */
	int checkNeighbours(int i, int j, int[][] table)
	{
		int sum = 0;
        if(table[i][j] == 9) return 9;
        for(int k=-1; k<=1; k++)
        {
            for(int l=-1; l<=1; l++)
            {
            	if(i+k<0 || i+k>size-1 || j+l<0 || j+l>size-1) continue;
            	else if((table[i+k][j+l]) == 9) sum++;
            }
        }
		return sum;
	}

	/**
	 * Funkcja wykonująca kaskadowe odsłanianie przyległych pól pustych przy nacisnięciu na pole puste
	 * (tak jak w oryginalnym saperze)
	 * @param t - naciśnięte pole
	 * @param tiles - tablica pól
	 * @param holder - obiekt posiadający mapę ikon
	 */
	void cascadeClear(Tile t, Tile[][] tiles, IconHolder holder){
		int tempX = t.pos_x;
		int tempY = t.pos_y;
		
		t.setImageIcon(holder.icons.get(""+t.getValue()));
		if(t.covered == 1) numberOfUncovered++;
		t.covered = 0;
		if(t.getValue( )==0) {
			if(tempX != 0 && tempY != 0						&& tiles[tempX-1][tempY-1].covered == 1) {
				cascadeClear(tiles[tempX-1][tempY-1],tiles,holder);
			}
			if(tempX != 0 									&& tiles[tempX-1][tempY].covered == 1) {
				cascadeClear(tiles[tempX-1][tempY],tiles,holder);
			}
			if(tempX != 0 && tempY != size-1					&& tiles[tempX-1][tempY+1].covered == 1) {
				cascadeClear(tiles[tempX-1][tempY+1],tiles,holder);
			}
			if(tempY != 0 									&& tiles[tempX][tempY-1].covered == 1) {
				cascadeClear(tiles[tempX][tempY-1],tiles,holder);
			}
			if(tempY != size - 1 							&& tiles[tempX][tempY+1].covered == 1) {
				cascadeClear(tiles[tempX][tempY+1],tiles,holder);
			}
			if(tempX != size - 1 && tempY !=0 				&& tiles[tempX+1][tempY-1].covered == 1) {
				cascadeClear(tiles[tempX+1][tempY-1],tiles,holder);
			}
			if(tempX != size - 1 							&& tiles[tempX+1][tempY].covered == 1) {
				cascadeClear(tiles[tempX+1][tempY],tiles,holder);
			}
			if(tempX != size - 1 && tempY != size - 1 		&& tiles[tempX+1][tempY+1].covered == 1) {
				cascadeClear(tiles[tempX+1][tempY+1],tiles,holder);
			}
			
		}
		
	}

	/**
	 * Funkcja pomocnicza wyświetlająca w konsoli wartości wszystkich pól planszy
	 */
	void checkTable(){
		for (int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(table[i][j]);
			}
			System.out.println("");
		}
	}

	/**
	 * Funkcja zwracająca tablicę przechowującą wartości liczbowe odpowiadające odpowiednim polom
	 * @return tablicę przechowującą wartości liczbowe odpowiadające odpowiednim polom
	 */
	int[][] getTable(){
		return table;
	}
	
}

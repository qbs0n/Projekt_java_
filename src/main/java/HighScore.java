import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 * Klasa zajmująca się logiką tablicy wyników
 * oraz logiką odczytu i zapisu do pliku z wynikami
 */
public class HighScore {
	ArrayList<String> nicks = new ArrayList<String>();
	ArrayList<Integer> sizes = new ArrayList<Integer>();
	ArrayList<Double> percents = new ArrayList<Double>();
	ArrayList<Double> times = new ArrayList<Double>();
	
	int amount = 0;
	
	File file;
	FileInputStream fis;

	/**
	 * Konstruktor główny klasy inicjujący podstawowe wartości klasy
	 */
	HighScore(){
		BufferedReader br = null;
        try {
            File file = new File("src\\main\\resources\\highscore.txt");
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
              // process the line
            	StringTokenizer tok = new StringTokenizer(line,";");
            	nicks.add(tok.nextToken());
            	sizes.add(Integer.parseInt(tok.nextToken()));
            	percents.add(Double.parseDouble(tok.nextToken()));
            	times.add(Double.parseDouble(tok.nextToken()));
            	amount++;
            }
          }
          catch(IOException e) {
        	  e.printStackTrace();
        }

	}

	/**
	 * Metoda pomocnicza wyświetlająca w okienku konsoli wartości tablicy wyników
	 */
	void printHighScore() {
		for(String x : nicks) {
			System.out.print(x);
		}
		for(Integer x : sizes) {
			System.out.print(x);
		}
		for(Double x : percents) {
			System.out.print(x);
		}
		for(Double x : times) {
			System.out.print(x);
		}
	}

	/**
	 * Metoda dodająca do pliku z wynikami nowego wygranego
	 * @param nick - nick gracza
	 * @param size - wielkosc planszy
	 * @param percent - procent bomb
	 * @param time - zmierzony czas
	 */
	void add(String nick, int size, double percent, double time) {
		nicks.add(nick);
		sizes.add(size);
		percents.add(percent);
		times.add(time/1000);
		
		BufferedWriter wr = null;
		try {
            File file = new File("src\\main\\resources\\highscore.txt");
            FileWriter fr = new FileWriter(file,true);
            wr = new BufferedWriter(fr);
            wr.append('\n');
            wr.append(nick+";"+size+";"+percent+";"+time/1000);
            
            wr.close();
          }
          catch(IOException e) {
        	  e.printStackTrace();
        }
	};
}

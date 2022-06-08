import javax.swing.JButton;
import javax.swing.ImageIcon;

/**
 * Klasa dziedziąca po klasie JButton, posiadająca podstawowe parametry
 * (pozycja, wypełnienie) pola jako przycisku
 */
public class Tile extends JButton {

	/**
	 * Obraz pola (przycisku)
	 */
	ImageIcon img;
	/**
	 * Wartośc pola (przycisku)
	 */
	int value;
	/**
	 * Koordynaty x,y pola (przycisku)
	 */
	int pos_x, pos_y;
	/**
	 * Wartość określająca czy pole jest odkryte
	 * 1 - zakryte
	 * 0 - odkryte
	 */
	int covered = 1;
	/**
	 * Wartość określająca czy pole jest zaflagowane
	 * 1 - zaflagowane
	 * 0 - odflagowane
	 */
	int flag = 0;
	/**
	 * Wielkość pola (przycisku)
	 */
	static double size;
	///
	void setImageIcon(ImageIcon image){
		setIcon(image);
		img = image;
	}
	
	///
	void setValue(int v) {
		value = v;
	}
	
	int getValue() {
		return value;
	}
	
	///
	void setPosX(int x) {
		pos_x = x;
	}
	
	void setPosY(int y) {
		pos_y = y;
	}
	
	int getPosX() {
		return pos_x;
	}
	
	int getPosY() {
		return pos_y;
	}
	///
	void mySetSize(int s) {
		size = s;
	}
	
	double myGetSize() {
		return size;
	}
	///
	void uncover() {
		covered = 0;
	}
	
	///
	void setFlag(int f) {
		flag = f;
	}
	
	int getFlag() {
		return flag;
	}
	
	int getCover() {
		return covered;
	}
	
	void setCover(int c) {
		covered = c;
	}

	
}
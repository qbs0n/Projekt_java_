/**
 * Klasa której zadaniem jest przechowanie informacji od rozgrwywce
 * -wielkosc planszy
 * -procent bomb
 * Dodatkowo przechowuje parametr bWidth który jest używany do określenia
 * wielkości jednego pola
 *
 */
public class SaperConfig {
	int size;
	double percentOfBombs;
	int bWidth;
	
	
	SaperConfig(int s, double p){
		size = s;
		percentOfBombs = p;
		bWidth = Saper.width / size;
	}
	
	int getSize()
	{
		return size;
	}
	
	double getPercent()
	{
		return percentOfBombs;
	}
}

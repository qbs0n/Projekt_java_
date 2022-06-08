import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 * Klasa będąca pojemnikiem na wszystkie grafiki gry, zapisywane
 * w mapie <String,ImageIcon>
 */
public class IconHolder {

	Map<String, ImageIcon> icons;
	IconHolder(SaperConfig defConfig){
		icons = new HashMap<>();
		icons.put("0",new ImageIcon(((new ImageIcon("src/main/resources/b0.png")).getImage()).getScaledInstance(defConfig.bWidth, defConfig.bWidth, java.awt.Image.SCALE_SMOOTH)));
		icons.put("1",new ImageIcon(((new ImageIcon("src/main/resources/b1.png")).getImage()).getScaledInstance(defConfig.bWidth, defConfig.bWidth, java.awt.Image.SCALE_SMOOTH)));
		icons.put("2",new ImageIcon(((new ImageIcon("src/main/resources/b2.png")).getImage()).getScaledInstance(defConfig.bWidth, defConfig.bWidth, java.awt.Image.SCALE_SMOOTH)));
		icons.put("3",new ImageIcon(((new ImageIcon("src/main/resources/b3.png")).getImage()).getScaledInstance(defConfig.bWidth, defConfig.bWidth, java.awt.Image.SCALE_SMOOTH)));
		icons.put("4",new ImageIcon(((new ImageIcon("src/main/resources/b4.png")).getImage()).getScaledInstance(defConfig.bWidth, defConfig.bWidth, java.awt.Image.SCALE_SMOOTH)));
		icons.put("5",new ImageIcon(((new ImageIcon("src/main/resources/b5.png")).getImage()).getScaledInstance(defConfig.bWidth, defConfig.bWidth, java.awt.Image.SCALE_SMOOTH)));
		icons.put("6",new ImageIcon(((new ImageIcon("src/main/resources/b6.png")).getImage()).getScaledInstance(defConfig.bWidth, defConfig.bWidth, java.awt.Image.SCALE_SMOOTH)));
		icons.put("7",new ImageIcon(((new ImageIcon("src/main/resources/b7.png")).getImage()).getScaledInstance(defConfig.bWidth, defConfig.bWidth, java.awt.Image.SCALE_SMOOTH)));
		icons.put("8",new ImageIcon(((new ImageIcon("src/main/resources/b8.png")).getImage()).getScaledInstance(defConfig.bWidth, defConfig.bWidth, java.awt.Image.SCALE_SMOOTH)));
		icons.put("9",new ImageIcon(((new ImageIcon("src/main/resources/bomb.png")).getImage()).getScaledInstance(defConfig.bWidth, defConfig.bWidth, java.awt.Image.SCALE_SMOOTH)));
		icons.put("10",new ImageIcon(((new ImageIcon("src/main/resources/flag.png")).getImage()).getScaledInstance(defConfig.bWidth, defConfig.bWidth, java.awt.Image.SCALE_SMOOTH)));

	}
	
}

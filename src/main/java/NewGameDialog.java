import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;

import javax.swing.*;

/**
 * Klasa dziedzicząca po klasie JDialog, jej zadaniem jest
 * zajęcie sie logiką i wyglądem okienka dialogowego nowej gry
 */
public class NewGameDialog extends JDialog {
	private JPanel mainPanel				= new JPanel();
	private JButton plusSizeButton			= new JButton("+");
	private JButton minusSizeButton			= new JButton("-");
	private JButton plusPercentButton		= new JButton("+");
	private JButton minusPercentButton		= new JButton("-");
	private JButton acceptButton			= new JButton("Akceptuj");
	private JButton cancelButton			= new JButton("Wroc");
	
	JLabel newGame = new JLabel("Nowa Gra",SwingConstants.CENTER);
	JLabel nothing = new JLabel("",SwingConstants.CENTER);
	JLabel nothing2 = new JLabel("",SwingConstants.CENTER);
	JLabel nothing3 = new JLabel("", SwingConstants.CENTER);
	JLabel sizeL;
	JLabel percentL;
	
	int size;
	double percent;
	double[] percentList = {0,0.05,0.10,0.15,0.20,0.25,0.30,0.35,0.4,0.45,0.5};
	boolean cancel = false;
	int curIndex;

	/**
	 * Konstruktor klasy NewGameDialog
	 * @param frame - okno nadrzędne
	 * @param defConfig - konfiguracja gry
	 */
	public NewGameDialog(Frame frame, SaperConfig defConfig) {
		super(frame, "Nowa Gra",true);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(mainPanel,BorderLayout.CENTER);
		
		sizeL = new JLabel(""+defConfig.size, SwingConstants.CENTER);
		percentL = new JLabel(""+defConfig.percentOfBombs, SwingConstants.CENTER);
		size = defConfig.size;
		percent = defConfig.percentOfBombs;
		
		curIndex = findIndex(percent);
		
		mainPanel.setLayout(new GridLayout(4,3,50,0));
		mainPanel.add(nothing);
		mainPanel.add(newGame);
		mainPanel.add(nothing2);
		mainPanel.add(minusSizeButton);
		mainPanel.add(sizeL);
		mainPanel.add(plusSizeButton);
		mainPanel.add(minusPercentButton);
		mainPanel.add(percentL);
		mainPanel.add(plusPercentButton);
		mainPanel.add(acceptButton);
		mainPanel.add(nothing3);
		mainPanel.add(cancelButton);
		
		NewGameDialogListener listener = new NewGameDialogListener();
		plusSizeButton.addActionListener(listener);
		minusSizeButton.addActionListener(listener);
		plusPercentButton.addActionListener(listener);
		minusPercentButton.addActionListener(listener);
		acceptButton.addActionListener(listener);
		cancelButton.addActionListener(listener);
		
		pack();
		setLocationRelativeTo(frame);
	}

	/**
	 * Metoda ujawniająca okno nowej gry
	 */
	void showIt() {
		setVisible(true);
	}

	/**
	 * Metoda ustawiająca odpowiedni wskaźnik 'procent bomb' na ekranie nowej gry
	 * @param num - procent bomb
	 * @return wartość z tablicy percentList lub 0
	 */
	int findIndex(double num) {
		for(int i=0;i<percentList.length;i++){
			if(percentList[i]==num) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * Klasa wewnętrzna klasy NewGameDialog implementująca ActionListener
	 */
	class NewGameDialogListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {

			if(e.getSource().equals(plusSizeButton)) {
				size++;
				sizeL.setText(""+size);
			}
			else if(e.getSource().equals(minusSizeButton)) {
				size--;
				sizeL.setText(""+size);
			}
			else if(e.getSource().equals(plusPercentButton)) {
				if(++curIndex > percentList.length-1) curIndex--;
				percent = percentList[curIndex];
				percentL.setText(""+percent);
			}
			else if(e.getSource().equals(minusPercentButton)) {
				if(--curIndex < 0) curIndex++;
				percent = percentList[curIndex];
				percentL.setText(""+percent);
			}
			else if(e.getSource().equals(acceptButton)) {
				cancel = true;
				setVisible(false);
			}
			else if(e.getSource().equals(cancelButton)) {
				setVisible(false);
			}
		}
		
	}
	
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Klasa dziedzicząca po klasie JDialog, jej zadaniem jest
 * zajęcie sie logiką i wyglądem okienka dialogowego przegranej
 */
public class GameOverDialog extends JDialog {
	
	double time;
	boolean setNewGame = false;
	
	private JPanel mainPanel				= new JPanel();
	private JPanel buttonPanel				= new JPanel();
	JLabel t1 = new JLabel("Twoje statystyki", SwingConstants.CENTER);
	JLabel t2 = new JLabel("Tutaj bedą statystyki",  SwingConstants.CENTER);
	JLabel t3 = new JLabel("Czy chesz zagrać jeszcze raz?", SwingConstants.CENTER);
	JButton b1 = new JButton("Jeszcze raz");
	JButton b2 = new JButton("Wyjdź");

	/**
	 * Konstruktor klasy GameOverDialog
	 * @param frame - okno nadrzędne
	 * @param interval - mierzony czas
	 * @param defConfig - konfiguracja gry
	 */
	public GameOverDialog(JFrame frame, MeasureTime interval, SaperConfig defConfig) {
		super(frame, "Przegrałeś",true);
		setResizable(false);

		time = interval.endMeasure();
		t2.setText("<html>Czas : " + time/1000 + " sekundy" + "<br>" +
				   "Grałeś na planszy " + defConfig.getSize() +":"+ defConfig.getSize() + "<br>" +
				   "Zagęszczenie bomb w procentach " + defConfig.getPercent()  +"</html>"
					);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(mainPanel,BorderLayout.CENTER);
		getContentPane().add(buttonPanel,BorderLayout.SOUTH);
		
		mainPanel.setLayout(new GridLayout(4,1,50,0));
		mainPanel.add(t1);
		mainPanel.add(t2);
		mainPanel.add(t3);
		
		buttonPanel.setLayout(new GridLayout(1,2,50,0));
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		
		GameOverDialogListener listener = new GameOverDialogListener();
		b1.addActionListener(listener);
		b2.addActionListener(listener);
		
		pack();
		setLocationRelativeTo(frame);
	}

	/**
	 * Klasa wewnętrzna klasy GameOverDialog implementująca ActionListener
	 */
	class GameOverDialogListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {

			if(e.getSource().equals(b1)) {
				setNewGame = true;
				setVisible(false);
			}
			else if(e.getSource().equals(b2)) {
				System.exit(0);
			}
		}
	}
}

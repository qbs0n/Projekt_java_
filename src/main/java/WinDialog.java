import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Klasa dziedzicząca po klasie JDialog, jej zadaniem jest
 * zajęcie sie logiką i wyglądem okienka dialogowego wygranej
 */
public class WinDialog extends JDialog {
	
	double time;
	boolean setNewGame = false;
	boolean setHS = false;
	String nick;
	
	private JPanel mainPanel				= new JPanel();
	private JPanel addPanel					= new JPanel();
	private JPanel miniPanel				= new JPanel();
	private JPanel buttonPanel				= new JPanel();
	JLabel t1 = new JLabel("Twoje statystyki", SwingConstants.CENTER);
	JLabel t2 = new JLabel("Tutaj bedą statystyki",  SwingConstants.CENTER);
	JLabel t3 = new JLabel("Wpisz swój nick do tabeli wyników",  SwingConstants.CENTER);
	JLabel t4 = new JLabel("Czy chesz zagrać jeszcze raz?",  SwingConstants.CENTER);
	JButton b1 = new JButton("Jeszcze raz");
	JButton b2 = new JButton("Dodaj do tabeli wyników");
	JButton b3 = new JButton("Wyjdź");
	JTextField f = new JTextField(10);

	/**
	 * Konstruktor klasy WinDialog
	 * @param frame - okno nadrzędne
	 * @param interval - zmierzony czas
	 * @param defConfig - konfiguracja gry
	 */
	public WinDialog(JFrame frame, MeasureTime interval, SaperConfig defConfig) {
		super(frame, "Gratulacje",true);
		setResizable(false);

		time = interval.endMeasure();
		t2.setText("<html>Czas : " + time/1000 + " sekundy" + "<br>" +
				   "Grałeś na planszy " + defConfig.getSize() +":"+ defConfig.getSize() + "<br>" +
				   "Zagęszczenie bomb w procentach " + defConfig.getPercent()  +"</html>"
					);
		

		getContentPane().setLayout(new GridLayout(4,1));
		getContentPane().add(mainPanel);
		getContentPane().add(addPanel);
		getContentPane().add(miniPanel);
		getContentPane().add(buttonPanel);
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(t1,BorderLayout.CENTER);
		mainPanel.add(t2,BorderLayout.SOUTH);
		
		addPanel.setLayout(new FlowLayout());
		addPanel.add(t3);
		addPanel.add(f);
		addPanel.add(b2);
		
		miniPanel.setLayout(new FlowLayout());
		miniPanel.add(t4);
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(b1);
		buttonPanel.add(b3);
		
		WinDialogListener listener = new WinDialogListener();
		b1.addActionListener(listener);
		b2.addActionListener(listener);
		b3.addActionListener(listener);
		
		pack();
		setLocationRelativeTo(frame);
	}

	/**
	 * Klasa wewnętrzna klasy WinDialog implementująca ActionListener
	 */
	class WinDialogListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {

			if(e.getSource().equals(b1)) {
				setNewGame = true;
				setVisible(false);
			}
			else if(e.getSource().equals(b2)) {
				nick = f.getText();
				setHS = true;
			}
			else if(e.getSource().equals(b3)) {
				System.exit(0);
			}
		}
	}
}

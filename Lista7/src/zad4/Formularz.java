package zad4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import zad1.ArrayDate;

public class Formularz extends JFrame implements ActionListener, FocusListener {

	private JLabel lImie, lNazwisko, lPesel,lWypiszImie,lWypiszNazwisko,lWypiszPesel,lWypiszPlec,lWypiszDateUrodzenia;
	private JTextField tImie, tNazwisko, tPesel;
	private JButton bDodaj;

	public static void main(String[] args) throws ParseException {
		Formularz aplikacja = new Formularz();
		aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplikacja.setVisible(true);
	}

	public Formularz() {
		setSize(400, 500);
		setTitle("Formularz");
		setLayout(null);

		lImie = new JLabel("Podaj Imie: ");
		lImie.setBounds(20, 20, 150, 20);
		add(lImie);

		tImie = new JTextField("Imie");
		tImie.setBounds(170, 20, 150, 20);
		add(tImie);
		tImie.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (tImie.getText().equals("Imie"))
					tImie.setText("");
			}

			public void focusLost(FocusEvent e) {
				if (tImie.getText().length() == 0)
					tImie.setText("Imie");
			}

		});
		
		lNazwisko = new JLabel("Podaj Nazwisko: ");
		lNazwisko.setBounds(20, 70, 150, 20);
		add(lNazwisko);

		tNazwisko = new JTextField("Nazwisko");
		tNazwisko.setBounds(170, 70, 150, 20);
		add(tNazwisko);
		tNazwisko.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (tNazwisko.getText().equals("Nazwisko"))
					tNazwisko.setText("");
			}

			public void focusLost(FocusEvent e) {
				if (tNazwisko.getText().length() == 0)
					tNazwisko.setText("Nazwisko");
			}

		});
		
		lPesel = new JLabel("Podaj Pesel: ");
		lPesel.setBounds(20, 120, 150, 20);
		add(lPesel);

		tPesel = new JTextField("Pesel");
		tPesel.setBounds(170, 120, 150, 20);
		add(tPesel);
		tPesel.addActionListener(this);
		tPesel.setToolTipText("Tutaj Nalezy podac Pesel");
		tPesel.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (tPesel.getText().equals("Pesel"))
					tPesel.setText("");
			}

			public void focusLost(FocusEvent e) {
				if (tPesel.getText().length() == 0)
					tPesel.setText("Pesel");
			}

		});

		bDodaj = new JButton("Dodaj");
		bDodaj.setBounds(220, 170, 100, 20);
		add(bDodaj);
		bDodaj.addActionListener(this);

		lWypiszImie = new JLabel("Podaj Imie: ");
		lWypiszImie.setBounds(20, 220, 150, 20);
		add(lWypiszImie);
		lWypiszNazwisko = new JLabel("Podaj Imie: ");
		lWypiszNazwisko.setBounds(20, 235, 150, 20);
		add(lWypiszNazwisko);
		lWypiszPesel = new JLabel("Podaj Imie: ");
		lWypiszPesel.setBounds(20, 250, 150, 20);
		add(lWypiszPesel);
		lWypiszPlec = new JLabel("Podaj Imie: ");
		lWypiszPlec.setBounds(20, 265, 150, 20);
		add(lWypiszPlec);
		lWypiszDateUrodzenia = new JLabel("Podaj Imie: ");
		lWypiszDateUrodzenia.setBounds(20, 280, 300, 20);
		add(lWypiszDateUrodzenia);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			lWypiszImie.setText("Imie: " + tImie.getText());
			lWypiszNazwisko.setText("Nazwisko " + tNazwisko.getText());
			lWypiszPesel.setText("Pesel: " + tPesel.getText());

			long wiek = Long.parseLong(tPesel.getText());
			int day = 0, month = 0;
			
			day = Integer.parseInt(tPesel.getText().substring(4, 6));
			month = Integer.parseInt(tPesel.getText().substring(2, 4)) - 1;
			String months[] = { "Styczen", "Luty", "Marzec", "Kwiecen", "Maj", "Czerwiec", "Lipiec", "Sierpien", "Wrzesien",
					"Pazdziernik", "Listopad", "Grudzien" };
					
			lWypiszDateUrodzenia.setText("Data Urodzenia: "+ day + " " + months[month] + " " + tPesel.getText().substring(0, 2));
			
			if (tPesel.getText().charAt(9) % 2 == 0)
				lWypiszPlec.setText("Plec: Kobieta");
			else
				lWypiszPlec.setText("Plec: Mezczyzna");
			
		} catch (NumberFormatException n) {
			System.out.println("Bledne dane");
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

}
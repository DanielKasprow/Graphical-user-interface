package zad1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ArrayDate extends JFrame implements ActionListener, FocusListener {

	private JLabel lDate,lWyswietl;
	private JTextField tDate;
	private JButton bDodajDate, bWyswietlDaty;
	List<Date> lista1 = new ArrayList<Date>();
	Date n = null, g;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

	public static void main(String[] args) throws ParseException {
		ArrayDate aplikacja = new ArrayDate();
		aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplikacja.setVisible(true);
	}

	public ArrayDate() {
		setSize(400, 500);
		setTitle("Podawanie dat");
		setLayout(null);

		lDate = new JLabel("Podaj Date(dd.MM.yyyy): ");
		lDate.setBounds(20, 20, 150, 20);
		add(lDate);
		
		lWyswietl = new JLabel("");
		lWyswietl.setBounds(20, 220, 300, 100);
		add(lWyswietl);

		tDate = new JTextField("Podaj Date");
		tDate.setBounds(170, 20, 150, 20);
		add(tDate);
		tDate.addActionListener(this);
		tDate.setToolTipText("Podaj Date w formacie dd.MM.yyyy");
		tDate.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				if (tDate.getText().equals("Podaj Date"))
					tDate.setText("");
			}

			public void focusLost(FocusEvent e) {
				if (tDate.getText().length() == 0)
					tDate.setText("Podaj Date");
			}

		});

		bDodajDate = new JButton("Dodaj");
		bDodajDate.setBounds(20, 120, 150, 20);
		add(bDodajDate);
		bDodajDate.addActionListener(this);
		
		bWyswietlDaty = new JButton("Wyswietl Daty");
		bWyswietlDaty.setBounds(200, 120, 150, 20);
		add(bWyswietlDaty);
		bWyswietlDaty.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object zrodlo = e.getSource();
		if(zrodlo == bDodajDate)
		{
			if(lista1.size() < 4) {
				//System.out.println(lista1);
				try {
					String dane = tDate.getText();
					n = simpleDateFormat.parse(dane);// nowa data
					int x = 0;
					if (lista1.size() == 0)
						lista1.add(x, n);
					else {
						for (x = 0; x < lista1.size(); x++) {
							g = lista1.get(x);// stara data
							if ((g.equals(n)) == true) {
								break;
							} else {
								if ((g.compareTo(n)) == 1) {// nowa data > stara data
									lista1.add(x, n);
									break;
								} else if (x == lista1.size() - 1)// nowa najwieksza data
								{
									lista1.add(x + 1, n);
									break;
								}
							}
						}
					}
				} catch (ParseException ee) {				}
			}
		}
		else if(zrodlo == bWyswietlDaty)
		{
			String dane="";
			for(int x=0;x<lista1.size();x++)
				dane+=lista1+"\n";
			lWyswietl.setText(dane);
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

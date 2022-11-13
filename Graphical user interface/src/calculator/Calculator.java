package zad3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Calculator extends JFrame implements ActionListener, FocusListener {

	private JLabel lWynik;
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bDodawanie, bOdejmowanie, bMnozenie, bDzielenie, bRowne;
	String sWynik = "", sZnak = "";
	Double Liczba;

	public static void main(String[] args) throws ParseException {
		Calculator aplikacja = new Calculator();
		aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplikacja.setVisible(true);
	}

	public Calculator() {
		setSize(400, 500);
		setTitle("");
		setLayout(null);
		// setLayout(new BorderLayout());
		//setLayout(new GridLayout(0, 4));
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.weighty = 0.2;
		c.gridheight=1;
		c.gridwidth=4;
		c.gridx = 0;
		c.gridy = 0;
		lWynik = new JLabel("");
		add(lWynik,c);
		c.weightx = 0.25;
		c.gridwidth=1;
		c.gridx = 1;
		c.gridy = 3;
		b1 = new JButton("1");
		add(b1,c);
		c.gridx = 2;
		c.gridy = 3;
		b1.addActionListener(this);
		b2 = new JButton("2");
		add(b2,c);
		c.gridx = 3;
		c.gridy = 3;
		b2.addActionListener(this);
		b3 = new JButton("3");
		add(b3,c);
		c.gridx = 1;
		c.gridy = 2;
		b3.addActionListener(this);
		b4 = new JButton("4");
		add(b4,c);
		c.gridx = 2;
		c.gridy = 2;
		b4.addActionListener(this);
		b5 = new JButton("5");
		add(b5,c);
		c.gridx = 3;
		c.gridy = 2;
		b5.addActionListener(this);
		b6 = new JButton("6");
		add(b6,c);
		c.gridx = 1;
		c.gridy = 1;
		b6.addActionListener(this);
		b7 = new JButton("7");
		add(b7,c);
		c.gridx = 2;
		c.gridy = 1;
		b7.addActionListener(this);
		b8 = new JButton("8");
		add(b8,c);
		c.gridx = 3;
		c.gridy = 1;
		b8.addActionListener(this);
		b9 = new JButton("9");
		add(b9,c);
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth=2;
		b9.addActionListener(this);
		b0 = new JButton("0");
		add(b0,c);
		c.gridwidth=1;
		c.gridx = 4;
		c.gridy = 4;
		b0.addActionListener(this);
		bDodawanie = new JButton("+");
		add(bDodawanie,c);
		c.gridx = 4;
		c.gridy = 3;
		bDodawanie.addActionListener(this);
		bOdejmowanie = new JButton("-");
		add(bOdejmowanie,c);
		c.gridx = 4;
		c.gridy = 2;
		bOdejmowanie.addActionListener(this);
		bMnozenie = new JButton("*");
		add(bMnozenie,c);
		c.gridx = 4;
		c.gridy = 1;
		bMnozenie.addActionListener(this);
		bDzielenie = new JButton("/");
		add(bDzielenie,c);
		c.gridx = 3;
		c.gridy = 4;
		bDzielenie.addActionListener(this);
		bRowne = new JButton("=");
		add(bRowne,c);
		bRowne.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object zrodlo = e.getSource();
		if (zrodlo == b1 || zrodlo == b2 || zrodlo == b3 || zrodlo == b4 || zrodlo == b5 || zrodlo == b6 || zrodlo == b7
				|| zrodlo == b8 || zrodlo == b9 || zrodlo == b0) {
			sWynik = lWynik.getText() + ((AbstractButton) zrodlo).getText();
			lWynik.setText(sWynik);
		} else {
			if (sZnak == "")
				Liczba = Double.parseDouble(lWynik.getText());
			if (sZnak == "+")
				Liczba = Liczba + Integer.parseInt(lWynik.getText());
			else if (sZnak == "-")
				Liczba = Liczba - Integer.parseInt(lWynik.getText());
			else if (sZnak == "/")
				Liczba = Liczba / Integer.parseInt(lWynik.getText());
			else if (sZnak == "*")
				Liczba = Liczba * Integer.parseInt(lWynik.getText());
			sZnak = ((AbstractButton) zrodlo).getText();
			lWynik.setText("");
			if (sZnak == "=") {
				lWynik.setText("" + Liczba);
				Liczba = (double) 0;
				sZnak = "";
			}
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

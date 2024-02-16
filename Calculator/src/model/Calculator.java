package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

	
	//Butonlar panel ve font tanımlandı
	
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[10];
	JButton addButton,subButton,mulButton,divButton;
	JButton sinButton, equButton, delButton, clrButton, cosButton,sqrButton;
	JPanel panel;
	
	Font myFont = new Font("Ink Free",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
		//Frame özellikleri belirtildi
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		//Textfield özellikleri belirtildi
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		//Butonlar tanımlandı
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		sinButton = new JButton("sin");
		equButton = new JButton("=");
		delButton = new JButton("Sil");
		clrButton = new JButton("C");
		cosButton = new JButton("cos");
		sqrButton=new JButton("x^");
		
		//Tanımlanan butonlar listeye eklendi
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = sinButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = cosButton;
		functionButtons[9] = sqrButton;
		
		//Butonlara event verildi ve fontları ayarlandı
		for(int i =0;i<10;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		//Sayıların bulunduğu butonlara event verildi ve fontu atarlandı
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		//En altta yer alan butonların koordinatları ayarlandı
		clrButton.setBounds(50,430,70,50);
		numberButtons[0].setBounds(125, 430, 70, 50);
		delButton.setBounds(200,430,70,50);
		addButton.setBounds(280,430,70,50);
		
		//Panel oluşturuldu ve 4 e 4lük layout verildi
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,0,10));

		//Panele butonlar sırasıyla eklendi
		panel.add(sinButton);
		panel.add(cosButton);
		panel.add(sqrButton);
		panel.add(equButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(divButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(mulButton);
		
		//Frame e panel ve en alttaki butonlar eklendi
		frame.add(panel);
		frame.add(addButton);
		frame.add(numberButtons[0]);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	//Calculator sınıfı çağrıldı
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
	}
	
	
	//Tüm butonlara event verildi ve hepsi açıklandı
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if (e.getSource() == sinButton) {
            double sayi = Double.parseDouble(textfield.getText());
            double sonuc = Math.sin(Math.toRadians(sayi)); 
            textfield.setText(String.valueOf(sonuc));
		}
		
		
		if (e.getSource() == cosButton) {
            double sayi = Double.parseDouble(textfield.getText());
            double sonuc = Math.cos(Math.toRadians(sayi)); 
            textfield.setText(String.valueOf(sonuc));
		}
		if (e.getSource() == sqrButton) {
			 double sayi = Double.parseDouble(textfield.getText());
             double kare = sayi * sayi;
             textfield.setText(Double.toString(kare));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
					
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		
	}
}
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OyunGiris {
	private  int a  = 10;
	private int b = 10 ;
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}


	
	public  int Giris() {
		
		
		JFrame frame = new JFrame("OYUN GÝRÝÞ");
		
		JLabel  l = new JLabel("Mayýn tarlasý oyununa hoþgeldiniz ");
		
		JButton kolayb ;
		JButton ortab ;
		JButton zorb;
		
		kolayb = new JButton("KOLAY");
		ortab = new JButton("ORTA");
		zorb = new JButton("ZOR");
		
		kolayb.setBounds(80,150,120,50);
		ortab.setBounds(80,250,120,50);
		zorb.setBounds(80,350,120,50);
		
		l.setBounds(50,50,250,100);
		
		kolayb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MayinTarlasi t = new  MayinTarlasi();
				setA(5);
				setB(5);
			}
			

		
		});
		
		
	
		frame.add(l);
		frame.add(kolayb);
		frame.add(ortab);
		frame.add(zorb);
		frame.setLayout(null);
		frame.setSize(300,500);
		frame.setVisible(true);
		return 10 ;
		
	}

}

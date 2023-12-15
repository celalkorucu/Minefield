import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MayinTarlasi implements MouseListener {
	OyunGiris o = new OyunGiris();
	
	JFrame frame;
	Btn[][] board = new Btn[10][10];
	
public Btn[][] Board() {
	Btn[][] board = new Btn[10][10];
		return board ;
	}
	

	

	int openButton;

	public MayinTarlasi() {
		
		
	
		
		openButton = 0;
		frame = new JFrame("Mayın Tarlası ");

		frame.setSize(800, 800);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new GridLayout(10, 10));

		for (int row = 0; row < Board().length; row++) {
			for (int col = 0; col < Board()[0].length; col++) {
				Btn b = new Btn(row, col);
				frame.add(b);
				b.addMouseListener(this);
				Board()[row][col] = b;
			}
		}
		generateMine();
		updateCount();
		// printMine();
		frame.setVisible(true);

	}

	public void generateMine() {
		int i = 0;
		while (i < 3) {
			int randRow = (int) (Math.random() * Board().length);
			int randCol = (int) (Math.random() * Board()[0].length);
		
			Board()[randRow][randCol].setMine(true);
			i++;
		}
	}

	public void print() {
		for (int row = 0; row < Board().length; row++) {
			for (int col = 0; col < Board()[0].length; col++) {
				if (Board()[row][col].isMine()) {
					Board()[row][col].setIcon(new ImageIcon("mine.png"));
				} else {
					Board()[row][col].setText(Board()[row][col].getCount() + "");
					Board()[row][col].setEnabled(false);
				}
			}
		}
	}

	public void printMine() {
		for (int row = 0; row < Board().length; row++) {
			for (int col = 0; col < Board()[0].length; col++) {
				if (Board()[row][col].isMine()) {
					Board()[row][col].setIcon(new ImageIcon("mine.png"));
				}
			}
		}
	}

	public void updateCount() {
		for (int row = 0; row < Board().length; row++) {
			for (int col = 0; col < Board()[0].length; col++) {
				if (Board()[row][col].isMine()) {
					counting(row, col);
				}
			}
		}
	}

	public void counting(int row, int col) {
		for (int i = row - 1; i <= row + 1; i++) {
			for (int k = col - 1; k <= col + 1; k++) {
				try {
					int value = Board()[i][k].getCount();
					Board()[i][k].setCount(++value);
				} catch (Exception e) {
				}
			}
		}
	}

	public void open(int r, int c) {
		if (r < 0 || r >= Board().length || c < 0 || c >= Board()[0].length || Board()[r][c].getText().length() > 0
				|| Board()[r][c].isEnabled() == false) {
			return;
		} else if (Board()[r][c].getCount() != 0) {
			Board()[r][c].setText(Board()[r][c].getCount() + "");
			Board()[r][c].setEnabled(false);
			openButton++;
		} else {
			openButton++;
			Board()[r][c].setEnabled(false);
			open(r - 1, c);
			open(r + 1, c);
			open(r, c - 1);
			open(r, c + 1);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Btn b = (Btn) e.getComponent();
		if (e.getButton() == 1) {
			if (b.isMine()) {
				JOptionPane.showMessageDialog(frame, "Mayına Bastınız Oyun Bitti !");
				print();
			} else {
				open(b.getRow(), b.getCol());
				if (openButton == (Board().length * Board()[0].length) - 10) {
					JOptionPane.showMessageDialog(frame, "Tebrikler Oyunu Kazandınız !");
					print();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
					frame.setVisible(false);
				}
			}
		} else if (e.getButton() == 3) {
			if (!b.isFlag()) {
				b.setIcon(new ImageIcon("flag.png"));
				b.setFlag(true);
			} else {
				b.setIcon(null);
				b.setFlag(false);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}

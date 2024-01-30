package connect6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;

public class Player2Panel extends JPanel implements ActionListener{
	JLabel name = new JLabel();
	JLabel image = new JLabel();
	JLabel time = new JLabel(new ImageIcon("image/clock.png"), JLabel.LEFT);
	JButton exit = new JButton("EXIT");
	
	Timer timer = new Timer(1000, this);
		
	static int second = 30;

	Player2Panel(Player p) {
		setBounds(1120, 0, 320, 800);
		setBackground(new Color(255, 200, 120));
		setLayout(null);
		
		name.setBounds(95, 50, 300, 100);
		name.setText("Name : " + p.name);
		name.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		
		image.setBounds(96, 120, 170, 170);
		image.setBackground(new Color(255, 244, 164));
		image.setOpaque(true);
		image.setIcon(p.image);
		
		time.setBounds(40, 420, 140, 32);
		timer.start();
		
		exit.setBounds(39, 695, 250, 64);
        exit.setFont(new Font("Malgun Gothic", Font.BOLD, 45));

        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0); 
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                exit.setForeground(Color.red); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exit.setForeground(Color.black); 
            }
        });


        add(exit);	
		add(name);
		add(image);
		add(time);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.white);
		
		int x = 150; 
	    int y = 300; 
	    g.fillOval(x, y, 50, 50);
	    
		Graphics2D g2 = (Graphics2D) g;
		
		if(Board.color == Color.white) {
			g.setColor(new Color(255, 244, 164));
			g.fillRect(80,  426, second * 6, 20);
			g2.setStroke(new BasicStroke(5));
			g2.setColor(Color.white);
			g2.drawRect(65, 75, 230, 320);
		}
		else {
			g.setColor(new Color(255, 244, 164));
			g.fillRect(80,  426, 180, 20);
			second = 30;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(timer == e.getSource()) {
			second--;
			if(second == 0) {
				Board.color = Color.black;
				Board.p1Count = 0;
				Board.p2Count = 0;
			}
			repaint();
		}
	}
}

package example;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * 
 * @Project Snakee
 * @Description Spilaðu leikinn
 * @Author Sigurður Sigurðardóttir
 * @version Ekki viss
 */


public class Play extends MyFrame
{

	private static final long serialVersionUID = -3641221053272056036L;

	public MySnake mySnake = new MySnake(100, 100);// x , y
	public Food food = new Food();
	public int f=0;
	public Image background = ImageUtil.images.get("UI-background");
	public Image fail = ImageUtil.images.get("game-scene-01");

	@Override
	public void keyPressed(KeyEvent e)
	{
		super.keyPressed(e);
		mySnake.keyPressed(e);

	}

	@Override
	public void paint(Graphics g)
	{
		/*super.paint(g);
		g.drawImage(background, 0, 0, null);
		System.out.println("Çalisti paint\n");
		if (mySnake.l)
		{
			mySnake.draw(g);
			if (food.l)
			{
				food.draw(g);
				food.eaten(mySnake);
			} else
			{
				food = new Food();
			}
		} else
		{
			g.drawImage(fail, 0, 0, null);
		}
		drawScore(g);*/
	}

	public void drawScore(Graphics g)
	{
		System.out.println("Çalisti score\n");
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		g.setColor(Color.YELLOW);
		g.drawString("SCORE : " + mySnake.score, 20, 40);
	}

	public void drawMenu(Graphics g){
		JButton button = new JButton("Tıkla");

		// Butonun konumunu ve boyutunu ayarla
		button.setBounds(250, 250, 100, 40);
		Font defaultFont = new Font("Arial", Font.PLAIN, 12);
		button.setFont(defaultFont);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Butona tıklandığında yapılacak işlemler
				Font yeniFont = new Font("Arial", Font.BOLD, 14);
				button.setFont(yeniFont);
				button.setForeground(Color.BLUE); // Metin rengini mavi yap
				button.setText("Tıklandı!"); // Buton metnini değiştir
				jFrame.setVisible(false);
			}
		});
		// Butonu JFrame'e ekle
		jFrame.add(button);

	}

	public static void main(String[] args)
	{
		new Play().loadFrameMenu();
		//MusicPlayer.getMusicPlay("src/example/background.mp3");

	}

}

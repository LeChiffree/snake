package example;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Image;

public class Food extends MyFrame.SnakeObject
{

	private static final long serialVersionUID = -3641221053272056036L;
	private int foodNo;


	public Food()	{
		this.l = true;
		foodNo = new Random().nextInt(10);
		this.i = ImageUtil.images.get(String.valueOf(foodNo));

		this.w = i.getWidth(null);
		this.h = i.getHeight(null);

		this.x = (int) (Math.random() * (870 - w + 10));
		this.y = (int) (Math.random() * (560 - h - 40));
	}

	public void eaten(MyFrame.MySnake mySnake)	{

		if (mySnake.getRectangle().intersects(this.getRectangle()) && l && mySnake.l)		{
			this.l = false;
			if ( foodNo == 17){
				mySnake.l = false;
			}
			mySnake.changeLength(mySnake.getLength() + 1);
			mySnake.score += 521;
		}

	}
	@Override
	public void draw(Graphics g)
	{
		g.drawImage(i, x, y, null);
	}
}

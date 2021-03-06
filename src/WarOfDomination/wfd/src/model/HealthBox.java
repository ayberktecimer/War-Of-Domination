package model;

/**
 * @author Akant
 * @author Ayberk
 */
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class HealthBox {

	// constants
	float posX, posY, amount;
	static final int WIDTH = 38;
	static final int HEIGHT = 32;
	Image img;

	// constructor
	public HealthBox(float x, float y, int amount) throws SlickException {
		this.posX = x;
		this.posY = y;
		this.amount = amount;
		img = new Image("res/HealthBox.png");
	}

	public void setX(float x) {
		this.posX = x;
	}

	public void setY(float y) {
		this.posY = y;
	}

	public float getX() {
		return this.posX;
	}

	public float getY() {
		return this.posY;
	}

	public int getAmount() {
		return (int) this.amount;
	}

	// Draws healthbox at a location
	public void draw(Graphics g) {
		g.drawImage(this.img, this.posX - WIDTH / 2, this.posY - HEIGHT / 2);
	}

}
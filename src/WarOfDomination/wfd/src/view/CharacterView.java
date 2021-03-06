package view;

/**
 * @author Ayberk
 *
 */
import org.newdawn.slick.*;

import view.mapview.HealthBar;
import view.mapview.WeaponBar;

public class CharacterView extends MovingView {
	// Information bars
	HealthBar healthbar;
	WeaponBar weaponBar;
	// Character halfsize
	static final int halfSizeX = 16;
	static final int halfSizeY = 18;
	// Timer
	int[] duration = { 200, 200, 200 };

	// Constructor
	public CharacterView(String str) throws SlickException {
		super();
		// open image storages and initialize information bars
		healthbar = new HealthBar();
		weaponBar = new WeaponBar();
		walkUp = new Image[3];
		walkDown = new Image[3];
		walkLeft = new Image[3];
		walkRight = new Image[3];

		// initialize character pictures according to RoundData.character_choice values

		for (int i = 1; i < 4; i++) {
			walkUp[i - 1] = new Image("res/" + str + "_up_" + i + ".png");
		}
		for (int i = 1; i < 4; i++) {
			walkDown[i - 1] = new Image("res/" + str + "_down_" + i + ".png");
		}
		for (int i = 1; i < 4; i++) {
			walkLeft[i - 1] = new Image("res/" + str + "_left_" + i + ".png");
		}
		for (int i = 1; i < 4; i++) {
			walkRight[i - 1] = new Image("res/" + str + "_right_" + i + ".png");
		}

		// Create animations

		up = new Animation(walkUp, duration, false);
		down = new Animation(walkDown, duration, false);
		left = new Animation(walkLeft, duration, false);
		right = new Animation(walkRight, duration, false);
		animList = new Animation[4];
		animList[0] = up;
		animList[1] = right;
		animList[2] = left;
		animList[3] = down;
		bucky = down;
		for (int i = 0; i < animList.length; i++) {
			animList[i].setAutoUpdate(true);
		}
	}

	// Draws character and characters information bars on the screen individually
	public void draw(GameContainer gc, Graphics g) throws SlickException {
		this.getMainAnimation().draw(ch.getX() - halfSizeX, ch.getY() - halfSizeY);
		healthbar.render(gc, g, ch.getHealth(), ch.MAX_HEALTH, 0);
		weaponBar.render(gc, g, ch.getWeaponChoice(), 0, (int) ch.getAmmo(), (int) ch.returnShell());

	}

	public void setAnimation(String str) {
		if (str == "up")
			bucky = up;
		if (str == "down")
			bucky = down;
		if (str == "right")
			bucky = right;
		if (str == "left")
			bucky = left;
	}
}

package view.screenview;
import org.newdawn.slick.Color;
/**
 * @author Ayberk
 *
 */
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import controller.GameManager;
import model.RoundData;
/*
 * @Author Ayberk
 * */
public class StoryView extends BasicGameState{
	Input input;
	Image background;
	private float alpha1 = 0f;
	private boolean flag = true;
	public StoryView(int storyMode) {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		
		background = new Image("res/image_story.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame arg1, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0, null);
		g.setColor(new Color(1f, 1f, 1f, alpha1));
		alpha1 = alpha1 + 0.02f;
		g.drawString("ROUND "+ (RoundData.round-1)+ " STATISTICS", 300, 200);
		g.drawString("Shots Fired by Hero: " + RoundData.num_of_bullet_hero, 100, 400);
		g.drawString("Shots Fired by Enemy: " + RoundData.num_of_bullet_enemy, 400, 400);
		g.drawString("Hero Score: " + GameManager.hero_win, 100, 475);
		g.drawString("Enemy Score: " + GameManager.enemy_win, 400, 475);
		g.drawString("Press Enter for Next Round", 600, 575);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		input= gc.getInput();
		if(flag)
		{
			
			flag =false;
		}
		if(input.isKeyPressed(Input.KEY_ENTER))
		{
			sbg.getState(1).init(gc, sbg);
			sbg.enterState(1);
		}
	}

	@Override
	public int getID() {
		
		return 7;
	}

}

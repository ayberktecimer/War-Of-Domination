package controller;
/**
 * @author Ayberk
 *
 */
import org.newdawn.slick.SlickException;

import model.Map;
import model.Moving;
import model.Common.Direction;

public class MapControl {
	Map map;
	BulletManager bulletMngr;
	//String loc = "res/timmy_map.tmx";
	int layerIndex = -10000;
	int object;

	public boolean loadMap(String loc) throws SlickException {
		map = new Map(loc);
		bulletMngr = new BulletManager();
		return true;
	}

	public Map getMap() {
		return this.map;
	}

	public int getId(int x, int y, int layerIndex) {
		return this.map.getTileId(x, y, layerIndex);
	}

	public int getLayerIndex(String str) {
		return this.map.getLayerIndex(str);
	}

	public boolean canMove(Moving ch, float delta, Direction dir) {
		
		int check = 320;
		if(layerIndex == -10000)
		{
			layerIndex = map.getLayerIndex("Background");
			object = map.getTileId(1,1,layerIndex);
		}
		if(ch.character_id == 1)
			check = check + 200;
		if (dir == Direction.UP) {
			if (map.getTileId(((int) (check - ch.getX()) / 32), (((int) (check - ch.getY() - 4 - delta * .1f) /32)),
					layerIndex) != object) {
				return true;
			}
		}else if(dir== Direction.DOWN) {
			if (map.getTileId(((int) (check - ch.getX()) / 32),((int) (check - ch.getY() + 4 + delta * .1f) / 32), layerIndex) != object)
				return true;
		}else if(dir==Direction.RIGHT) {
			if (map.getTileId((((int) (check - ch.getX() + 4 + delta * .1f) / 32)),
					((int) (check - ch.getY()) / 32), layerIndex) != object)
				return true;
		}else if(dir== Direction.LEFT) {
			if (map.getTileId((((int) (check - ch.getX() - 4 - delta * .1f) / 32)),
					((int) (check - ch.getY()) / 32), layerIndex) != object)
				return true;
		}
		return false;
		
	}
	
	

}

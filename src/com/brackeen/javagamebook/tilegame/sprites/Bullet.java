package com.brackeen.javagamebook.tilegame.sprites;
import java.lang.reflect.Constructor;

import com.brackeen.javagamebook.graphics.Animation;
import com.brackeen.javagamebook.graphics.Sprite;

public class Bullet extends Sprite{

	private Animation left;
    private Animation right;
    private Animation deadLeft;
    private Animation deadRight;
    
	public Bullet (Animation left, Animation right,
	        Animation deadLeft, Animation deadRight)
	    {
		super(right);
        this.left = left;
        this.right = right;
        this.deadLeft = deadLeft;
        this.deadRight = deadRight;
	    }
	
	public void update(long elapsedTime) {
		
		
	}
	public Object clone() {
        // use reflection to create the correct subclass
        Constructor constructor = getClass().getConstructors()[0];
        try {
            return constructor.newInstance(new Object[] {
                (Animation)left.clone(),
                (Animation)right.clone(),
                (Animation)deadLeft.clone(),
                (Animation)deadRight.clone()
            });
        }
        catch (Exception ex) {
            // should never happen
            ex.printStackTrace();
            return null;
        }
    }
}
package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/**
    The Player.
*/
public class Player extends Creature {

    private static final float JUMP_SPEED = -.95f;

    private boolean onGround;
    public int maxhealth = 100;
    public int health = 3;
    public int minhealth = 1;
    

    public Player(Animation left, Animation right,
        Animation deadLeft, Animation deadRight)
    {
        super(left, right, deadLeft, deadRight);
        this.health = 3;
    }
    
    public void healthHurt() {
    	this.health -= 5;
    }
    
    public void boostHealth(int val){
    	if (this.health < maxhealth){
    		health += val; // distance
    	}
    }
    
    public void restHealth(long dt){
    	if (this.health < maxhealth){
    		health += (int) 5 * dt / 10000; // time
    	}
    }
    
    public void healthKill() {
    	if (this.health < maxhealth){
    		this.health += 10;
    	}
    }
    
    public void checkHealth(){
    	if (this.health < minhealth){
    		this.setState(Creature.STATE_DYING);
    	}
    }
    public int getHealth(){
    	return this.health;
    }

    public void collideHorizontal() {
        setVelocityX(0);
    }


    public void collideVertical() {
        // check if collided with ground
        if (getVelocityY() > 0) {
            onGround = true;
        }
        setVelocityY(0);
    }


    public void setY(float y) {
        // check if falling
        if (Math.round(y) > Math.round(getY())) {
            onGround = false;
        }
        super.setY(y);
    }


    public void wakeUp() {
        // do nothing
    }


    /**
        Makes the player jump if the player is on the ground or
        if forceJump is true.
    */
    public void jump(boolean forceJump) {
        if (onGround || forceJump) {
            onGround = false;
            setVelocityY(JUMP_SPEED);
        }
    }


    public float getMaxSpeed() {
        return 0.5f;
    }

}

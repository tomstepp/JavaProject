package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

/**
    The Player.
*/
public class Player extends Creature {

    private static final float JUMP_SPEED = -.95f;

    private boolean onGround;
    private int maxhealth = 40;
    private int health;
    private int minhealth = 1;
    

    public Player(Animation left, Animation right,
        Animation deadLeft, Animation deadRight)
    {
        super(left, right, deadLeft, deadRight);
        this.health = 20;
    }
    
    public void healthHurt() {
    	this.health -= 5;
    }
    
    public void healthMove() {
    	if (this.health < maxhealth){
    		this.health += 1;
    	}
    }
    
    public void healthRest() {
    	if (this.health < maxhealth){
    		this.health += 5;
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

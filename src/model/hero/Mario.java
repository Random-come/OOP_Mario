package model.hero;

import manager.Camera;
import manager.GameEngine;
import view.Animation;
import model.GameObject;
import view.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Mario extends GameObject{

    private int remainingLives;
    private int coins;
    private int points;
    private double invincibilityTimer;
    private MarioForm marioForm;
    private boolean toRight = true;

    public Mario(double x, double y){
        super(x, y, null);
        setDimension(48,48);

        remainingLives = 3;
        points = 0;
        coins = 0;
        invincibilityTimer = 0;

        ImageLoader imageLoader = new ImageLoader();
        BufferedImage[] leftFrames = imageLoader.getLeftFrames(MarioForm.SMALL);
        BufferedImage[] rightFrames = imageLoader.getRightFrames(MarioForm.SMALL);

        Animation animation = new Animation(leftFrames, rightFrames);
        marioForm = new MarioForm(animation, false, false);
        setStyle(marioForm.getCurrentStyle(toRight, false, false));
    }

    @Override
    public void draw(Graphics g){
        boolean movingInX = (getVelX() != 0);  //mario move vertcally if velocity different from 0
        boolean movingInY = (getVelY() != 0);  //mario move horizontally if velocity different from 0

        setStyle(marioForm.getCurrentStyle(toRight, movingInX, movingInY));

        super.draw(g);
    }

    public void jump(GameEngine engine) {
        if(!isJumping() && !isFalling()){  //state when mario stay at the ground (the mario Y= ground brick Y)
            setJumping(true);
            setVelY(12);
            engine.playJump();
        }
    }

    public void move(boolean toRight, Camera camera) {
        if(toRight){
            setVelX(5);
        }
        else if(camera.getX() < getX()){
            setVelX(-5);
        }

        this.toRight = toRight;
    }

    public boolean onTouchEnemy(GameEngine engine){

        if(!marioForm.isSuper() && !marioForm.isFire()){ //normal state take damage from enemy
            remainingLives--;
            engine.playMarioDies();
            return true;
        } 
        else{  //other state can't take damage and slain the enemy
            engine.shakeCamera();
            marioForm = marioForm.onTouchEnemy(engine.getImageLoader());
            setDimension(48, 48);
            return false;
        }
    }

    public Fireball fire(){
        return marioForm.fire(toRight, getX(), getY());
    }

    public void acquireCoin() {
        coins++;
    }

    public void acquirePoints(int point){
        points = points + point;
    }

    public int getRemainingLives() {
        return remainingLives;
    }

    public void setRemainingLives(int remainingLives) {
        this.remainingLives = remainingLives;
    }

    public int getPoints() {
        return points;
    }

    public int getCoins() {
        return coins;
    }

    public MarioForm getMarioForm() {
        return marioForm;
    }

    public void setMarioForm(MarioForm marioForm) {
        this.marioForm = marioForm;
    }

    public boolean isSuper() {
        return marioForm.isSuper();
    }

    public boolean getToRight() {
        return toRight;
    }

    public void resetLocation() {
        setVelX(0);
        setVelY(0);
        setX(50);
        setJumping(false);
        setFalling(true);
    }
}
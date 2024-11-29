package model.prize;

import manager.GameEngine;
import model.GameObject;
import model.hero.Mario;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Coin extends GameObject implements Prize{

    private int point;
    private boolean revealed, acquired = false;
    private int revealBoundary; //when collect the coin will pop up...

    public Coin(double x, double y, BufferedImage style, int point){//constructor
        super(x, y, style);
        this.point = point;
        revealed = false;
        setDimension(30, 42);
        revealBoundary = (int)getY() - getDimension().height;
    }

    @Override
    public int getPoint() {
        return point;
    }

    @Override
    public void reveal() {
        revealed = true;
    }

    @Override
    public void onTouch(Mario mario, GameEngine engine) {//check collision
        if(!acquired){
            acquired = true;
            mario.acquirePoints(point);//point++
            mario.acquireCoin();//coin++
            engine.playCoin();//sound
        }
    }

    @Override
    public void updateLocation(){//the coin when collected will float on 5 pixel for effect
        if(revealed){
            setY(getY() - 5);
        }
    }

    @Override
    public void draw(Graphics g){
        if(revealed){
            g.drawImage(getStyle(), (int)getX(), (int)getY(), null);
        }
    }

    public int getRevealBoundary() {
        return revealBoundary;
    }
}

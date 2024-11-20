package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
public class GameObject {
    private double x,y;
    private boolean falling,jumping;
    
    public GameObject(double x, double y){
        setLocation(x,y);
    }

    public double getX(){
        return x;
    }
    public void setX(double x){
        this.x=x;
    }

    public double getY(){
        return x;
    }
    public void setY(double y){
        this.y=y;
    }

    public boolean isFalling(){
        return falling;
    }
    public void setFalling(boolean falling){
        this.falling=falling;
    }

    public boolean isJumping(){
        return falling;
    }
    public void setJumping(boolean jumping){
        this.jumping=jumping;
    }
    
    public void setLocation(double x, double y) {
        setX(x);
        setY(y);
    }
}
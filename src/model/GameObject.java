package model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {

    private double x, y;
    private double velX, velY;
    private Dimension dimension;//width and height of object
    private BufferedImage style;
    private double gravityAcc;
    private boolean falling, jumping;

    //constructor
    public GameObject(double x, double y, BufferedImage style){
        setLocation(x, y);
        setStyle(style);
        if(style != null){
            setDimension(style.getWidth(), style.getHeight());}
        setVelX(0);
        setVelY(0);
        setGravityAcc(0.38);
        jumping = false;
        falling = true;
    }

    public void draw(Graphics g) {//render object
        BufferedImage style = getStyle();
        if(style != null){
            g.drawImage(style, (int)x, (int)y, null);
        }
    }

    public void updateLocation() {
        if(jumping && velY <= 0){//reach the peak of jumping -> falling
            jumping = false;
            falling = true;}
        else if(jumping){//while jumping state
            velY = velY - gravityAcc;
            y = y - velY;}
        if(falling){//while falling state
            y = y + velY;
            velY = velY + gravityAcc;}

        x = x + velX;//update location when running
    }

    //Getter and Setter
    public void setLocation(double x, double y) {
        setX(x);
        setY(y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Dimension getDimension(){
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public void setDimension(int width, int height){ this.dimension =  new Dimension(width, height); }

    public BufferedImage getStyle() {
        return style;
    }

    public void setStyle(BufferedImage style) {
        this.style = style;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public double getGravityAcc() {
        return gravityAcc;
    }

    public void setGravityAcc(double gravityAcc) {
        this.gravityAcc = gravityAcc;
    }

    public Rectangle getBounds() {//create a rectangle to check if this object touch another object
        return new Rectangle((int)x, (int)y, dimension.width, dimension.height);
    }
    public Rectangle getTopBounds(){ //top side
        return new Rectangle((int)x+dimension.width/6, (int)y, 2*dimension.width/3, dimension.height/2);
    }
    public Rectangle getBottomBounds(){ //under side
        return new Rectangle((int)x+dimension.width/6, (int)y + dimension.height/2, 2*dimension.width/3, dimension.height/2);
    }
    public Rectangle getLeftBounds(){ //left side
        return new Rectangle((int)x, (int)y + dimension.height/4, dimension.width/4, dimension.height/2);
    }
    public Rectangle getRightBounds(){ //right side
        return new Rectangle((int)x + 3*dimension.width/4, (int)y + dimension.height/4, dimension.width/4, dimension.height/2);
    }


    public boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }
}

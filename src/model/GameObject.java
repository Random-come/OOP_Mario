
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
public class GameObject {
    private double x;
    private double y;
    private boolean falling;
    private boolean jumping;
    private BufferedImage style;
    private double velocX; //velocity of vertical
    private double velocY; //velocity of horizontal
    private Dimension dimension;
    private double gravity;
    
    public GameObject(double x, double y, BufferedImage style){
        setLocation(x,y);
        setStyle(style);
        setDimension(style.getWidth(),style.getHeight());
        setVelocX(0);
        setVelocY(0);
        setGravity(0.55);
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

    public BufferedImage getStyle(){
        return style;
    }
    public void setStyle(BufferedImage style){
        this.style=style;
    }

    public double getVelocX(){
        return velocX;
    }
    public void setVelocX(double velocX){
        this.velocX=velocX;
    }

    public double getVelocY(){
        return velocX;
    }
    public void setVelocY(double velocY){
        this.velocY=velocY;
    }

    public void setLocation(double x, double y) {
        setX(x);
        setY(y);
    }

    public void changeLocation(){
        if (jumping && getVelocX()<=0){ // check if the object currently at the peak of the jump then falling down
            setJumping(false);
            setFalling(true); //begin falling down
        }

        if (jumping){
            setVelocY(0.69); //jumping with velocity of 0.69
        }

        if (falling){
            setVelocY(0.89); //falling down with velocity 0.89
        }
        x = x + getVelocX();  //update vertical position of object
    }

    public Dimension getDimension(){
        return dimension;
    }
    public void setDimension(int width,int height){
        this.dimension=new Dimension(width,height); //get width and height method from Dimension library
    }

    public double getGravity(){
        return gravity;
    }
    public void setGravity(double gravity){
        this.gravity=gravity;
    }

    public Rectangle getBounds(){ //create a rectangle to check if the object touch any other object
        return new Rectangle((int)x, (int)y, dimension.width, dimension.height);
    }

    public Rectangle getTopBounds(){ //the ceiling
        return new Rectangle((int)x+dimension.width/6, (int)y, 2*dimension.width/3, dimension.height/2);
    }

    public Rectangle getBottomBounds(){ //the ground
        return new Rectangle((int)x+dimension.width/6, (int)y + dimension.height/2, 2*dimension.width/3, dimension.height/2);
    }

    public Rectangle getLeftBounds(){ //the left wall
        return new Rectangle((int)x, (int)y + dimension.height/4, dimension.width/4, dimension.height/2);
    }

    public Rectangle getRightBounds(){ //the rigth wall
        return new Rectangle((int)x + 3*dimension.width/4, (int)y + dimension.height/4, dimension.width/4, dimension.height/2);
    }
}

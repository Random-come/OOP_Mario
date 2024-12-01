package model.Enemy;
import java.awt.image.BufferedImage;
import java.awt.*;
public class Turtle extends Enemy {
    private BufferedImage image;
    public Turtle(double x,double y,BufferedImage style){
        super(x,y,style);
        setVelX(10);
    }
    
    public BufferedImage image(){
        return image;
    }
    public void setRightImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void draw(Graphics g){
        if(getVelX() > 0){
            g.drawImage(image, (int)getX(), (int)getY(), null); //image move if turtle is moving
        }
        else
            super.draw(g); //turtle stop at 1 place
    }
}

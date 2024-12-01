import model.GameObject;
import java.awt.image.BufferedImage;
public class Enemy extends GameObject{
    public Enemy(double x,double y,BufferedImage style){
        super(x,y);
        setFalling(false);
        setJumping(false);
    }
}

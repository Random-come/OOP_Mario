package model.brick;
import java.awt.image.BufferedImage;
import model.GameObject;
public class GroundBrick extends Brick{
    public GroundBrick(double x,double y,BufferedImage style){
        super(x,y,style);
        setBreakable(false);
        setEmpty(true);
    }
}

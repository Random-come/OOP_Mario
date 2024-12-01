package model.hero;

import view.Animation;
import view.ImageLoader;

import java.awt.image.BufferedImage;

public class MarioForm {

    public static final int SMALL = 0, SUPER = 1, FIRE = 2;

    private Animation animation;
    private boolean isSuper, isFire; 
    private BufferedImage fireballStyle;

    public MarioForm(Animation animation, boolean isSuper, boolean isFire){
        this.animation = animation;
        this.isSuper = isSuper;
        this.isFire = isFire;

        ImageLoader imageLoader = new ImageLoader();
        BufferedImage fireball = imageLoader.loadImage("/sprite.png");
        fireballStyle = imageLoader.getSubImage(fireball, 3, 4, 24, 24);
    }

    public BufferedImage getCurrentStyle(boolean toRight, boolean movingInX, boolean movingInY){

        BufferedImage style;

        if(movingInY && toRight){
            style = animation.getRightFrames()[0]; //If Mario is moving right vertically (jumping with right direction)
        }
        else if(movingInY){
            style = animation.getLeftFrames()[0];  //If Mario is moving left vertically (jumping with right direction)
        }
        else if(movingInX){  //Mario velocity in vertical
            style = animation.animate(5, toRight);
        }
        else {
            if(toRight){ //move to the right direction
                style = animation.getRightFrames()[1];
            }
            else //move to the left direction
                style = animation.getLeftFrames()[1];
        }

        return style;
    }

    public MarioForm onTouchEnemy(ImageLoader imageLoader) {
        BufferedImage[] leftFrames = imageLoader.getLeftFrames(0);
        BufferedImage[] rightFrames= imageLoader.getRightFrames(0);

        Animation newAnimation = new Animation(leftFrames, rightFrames);

        return new MarioForm(newAnimation, false, false);
    }

    public Fireball fire(boolean toRight, double x, double y) {
        if(isFire){
            return new Fireball(x, y + 48, fireballStyle, toRight);
        }
        return null;
    }

    public boolean isSuper() {
        return isSuper;
    }

    public void setSuper(boolean aSuper) {
        isSuper = aSuper;
    }

    public boolean isFire() {
        return isFire;
    }
}
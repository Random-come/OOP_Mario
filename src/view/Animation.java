package view;
import java.awt.image.BufferedImage;
//This take responsibility for managing and controlling frames movement of Mario
public class Animation {

    private int index = 0, count = 0;
    private final BufferedImage[] leftFrames, rightFrames;
    private BufferedImage currentFrame;

    public Animation(BufferedImage[] leftFrames, BufferedImage[] rightFrames){
        this.leftFrames = leftFrames;
        this.rightFrames = rightFrames;

        currentFrame = rightFrames[1];
    }


// This is main method doing that jobs
    public BufferedImage animate(int speed, boolean toRight){
        count+=1;// control a speed of animations
        BufferedImage[] frames = toRight ? rightFrames : leftFrames;

        if(count > speed){
            nextFrame(frames);
            count = 0;// reset count
        }// if count is larger than speed, it will call nextFrame()

        return currentFrame;
    }

    private void nextFrame(BufferedImage[] frames) {
        if(index + 3 > frames.length)
            index = 0;
        //If the next frame exceed the frames, return the first frame

        currentFrame = frames[index+1];// select next frame
        index++;// increase index for preparing the next frame
    }

    public BufferedImage[] getLeftFrames() {
        return leftFrames;
    }

    public BufferedImage[] getRightFrames() {
        return rightFrames;
    }

}
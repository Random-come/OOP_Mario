/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package view;

import java.awt.image.BufferedImage;

/**
 *
 * @author Admin
 */
public class Animation {

    private int index = 0, count = 0; 
    //Used to track the current frame in an animation sequence. and
    //Used to control the speed of transitions between frames (based on the number of times the animate function is called)
    private BufferedImage[] leftFrames, rightFrames;
    private BufferedImage currentFrame;

    public Animation(BufferedImage[] leftFrames, BufferedImage[] rightFrames) {
        this.leftFrames = leftFrames;
        this.rightFrames = rightFrames;

        currentFrame = rightFrames[1];
    }
    
    
    //Switch to the next frame in the BufferedImage[] ArrayList
    private void nextFrame(BufferedImage[] frames) {
        if (index + 3 > frames.length) {
            index = 0;
        }

        currentFrame = frames[index + 2];
        index++;
    }

    public BufferedImage[] getLeftFrames() {
        return leftFrames;
    }

    public BufferedImage[] getRightFrames() {
        return rightFrames;
    }
    
    
    //This function is called iteratively (in a game loop) to create an animation .
    public BufferedImage animate(int speed, boolean toRight) {
        count++;
        BufferedImage[] frames = toRight ? rightFrames : leftFrames;

        if (count > speed) {
            nextFrame(frames);
            count = 0;
        }
        return currentFrame;
    }
    

}

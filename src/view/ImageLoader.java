/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package view;

/**
 *
 * @author Admin
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
// This class take responsible for loading and managing sprite of the game
public class ImageLoader {
    // Sprite that hold animations and different states of Mario
    private BufferedImage marioForms;
    // A sprite sheet for brick-breaking animations
    private BufferedImage brickAnimation;


    //Constructor
    public ImageLoader(){
        //Prepares the Mario and brick animation images for later use in the game

        marioForms = loadImage("/mario-forms.png");

        brickAnimation = loadImage("/brick-animation.png");
    }

    public BufferedImage loadImage(String path){
        BufferedImage imageToReturn = null;
        //Loads an image from the game's resources folder by using ImageIO to read image file

        try {
            //Searches in the "/media" subdirectory of the project's resources and handle potential errors
            imageToReturn = ImageIO.read(getClass().getResource("/media" + path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageToReturn;
    }


    // An overloaded version that can load images directly from a File object, for loading images from external sources or custom file selections
    public BufferedImage loadImage(File file){
        BufferedImage imageToReturn = null;

        try {
            imageToReturn = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageToReturn;
    }


    //Extracts a specific portion (subimage) from a larger sprite sheet
    public BufferedImage getSubImage(BufferedImage image, int col, int row, int w, int h){
        if((col == 1 || col == 4) && row == 3){ //koopa
            //special case for koopa
            return image.getSubimage((col-1)*48, 128, w, h);
        }
        //Calculates the correct pixel coordinates to extract the desired sprite
        return image.getSubimage((col-1)*48, (row-1)*48, w, h);
    }

    public BufferedImage[] getLeftFrames(int marioForm){
        BufferedImage[] leftFrames = new BufferedImage[5];
        int col = 1;
        int width = 52, height = 48;

        // Adjusts dimensions and column based on Mario's form
        if(marioForm == 1) { //super mario
            col = 4;
            width = 48;
            height = 96;
        }
        else if(marioForm == 2){ //fire mario
            col = 7;
            width = 48;
            height = 96;
        }

        // Extracts 5 frames of left-facing Mario
        for(int i = 0; i < 5; i++){
            leftFrames[i] = marioForms.getSubimage((col-1)*width, (i)*height, width, height);
        }
        return leftFrames;
    }

    public BufferedImage[] getRightFrames(int marioForm){
        BufferedImage[] rightFrames = new BufferedImage[5];
        int col = 2;
        int width = 52, height = 48;

        if(marioForm == 1) { //super mario
            col = 5;
            width = 48;
            height = 96;
        }
        else if(marioForm == 2){ //fire mario
            col = 8;
            width = 48;
            height = 96;
        }

        // Extracts 5 frames of Mario, but in the right
        for(int i = 0; i < 5; i++){
            rightFrames[i] = marioForms.getSubimage((col-1)*width, (i)*height, width, height);
        }
        return rightFrames;
    }

    public BufferedImage[] getBrickFrames() {
        BufferedImage[] frames = new BufferedImage[4];
        for(int i = 0; i < 4; i++){
            frames[i] = brickAnimation.getSubimage(i*105, 0, 105, 105);
        }
        return frames;
    }
}
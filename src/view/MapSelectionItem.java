/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 * @author Admin
 */
public class MapSelectionItem {

    private BufferedImage image;
    private String name;
    private Point location;
    private Dimension dimension;

    public MapSelectionItem(String map, Point location) {
        this.location = location;
        this.name = map;

        ImageLoader loader = new ImageLoader();
        this.image = loader.loadImage("/maps/" + map);

        this.dimension = new Dimension();
    }

}

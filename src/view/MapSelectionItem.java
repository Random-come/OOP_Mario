/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package view;

/**
 *
 * @author Admin
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/// This Manage Map's information
public class MapSelectionItem {

    private BufferedImage image;  // map image
    private String name;          // map file name
    private Point location;       // location to display
    private Dimension dimension;  // Size of map Item

    public MapSelectionItem(String map, Point location){
        this.location = location;
        this.name = map;

        ImageLoader loader = new ImageLoader();
        this.image = loader.loadImage("/maps/" + map);//load the map

        this.dimension = new Dimension();
    }


    public String getName() {
        return name;
    }

    public Point getLocation() {
        return location;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
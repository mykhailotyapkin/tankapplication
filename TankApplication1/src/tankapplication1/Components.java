/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankapplication1;

import java.awt.Image;

/**
 *
 * @author Michael
 */
public class Components {
    
    public double x = 0; 
    public double y = 0;
    public Image image = null;
    public double width = 0 ;
    public double height = 0 ;
    public boolean destroyable = false;

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param img the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the destroyable
     */
    public boolean isDestroyable() {
        return destroyable;
    }

    /**
     * @param destroyable the destroyable to set
     */
    public void setDestroyable(boolean destroyable) {
        this.destroyable = destroyable;
    }
}

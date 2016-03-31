/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankapplication1;

/**
 *
 * @author Michael
 */
public class Tank {
    
    protected int tankX = 100;
    protected int tankY = 100;
    protected int tankWidth = 80;
    protected int tankHeight = 100;
    protected double angle = 0;
    private boolean isRotating = false; 

    /**
     * @return the tankX
     */
    public int getTankX() {
        return tankX;
    }

    /**
     * @return the tankY
     */
    public int getTankY() {
        return tankY;
    }

    /**
     * @return the tankWidth
     */
    public int getTankWidth() {
        return tankWidth;
    }

    /**
     * @return the tankHeight
     */
    public int getTankHeight() {
        return tankHeight;
    }

    /**
     * @return the angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * @param angle the angle to set
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * @return the isRotating
     */
    public boolean IsRotating() {
        return isRotating;
    }

    /**
     * @param isRotating the isRotating to set
     */
    public void setIsRotating(boolean isRotating) {
        this.isRotating = isRotating;
    }
    
    
}

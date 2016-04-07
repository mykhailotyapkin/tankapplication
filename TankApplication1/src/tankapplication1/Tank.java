/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankapplication1;

import java.awt.MouseInfo;



class outOfFuelException extends Exception{
    
}
/**
 *
 * @author Michael
 */
public class Tank {
    
    private double tankX = 100;
    private double tankY = 100;
    private int tankWidth = 80;
    private int tankHeight = 100;
    private double angle = 0;
    private boolean isRotating = false;
    private double turretX = tankX+(tankWidth/4) ;
    private double turretY = tankY + tankHeight/2;
    private int turretRadius = 40;
    private double turretAngle =0 ;
    private double rotationTankX = tankX + tankWidth/2;
    private double rotationTankY = tankY + tankHeight/2;
    private double fuel = 10;
    private double k = 0.02;
    /**
     * @return the tankX
     */
    public double getTankX() {
        return tankX;
    }

    /**
     * @return the tankY
     */
    public double getTankY() {
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
        return isIsRotating();
    }

    /**
     * @param isRotating the isRotating to set
     */
    public void setIsRotating(boolean isRotating) {
        this.isRotating = isRotating;
    }

    /**
     * @return the turretX
     */
    public double getTurretX() {
        return turretX;
    }

    /**
     * @return the turretY
     */
    public double getTurretY() {
        return turretY;
    }

    /**
     * @return the turretRadius
     */
    public int getTurretRadius() {
        return turretRadius;
    }

    /**
     * @return the turretAnle
     */
    public double getTurretAngle() {
        return turretAngle;
    }

    /**
     * @param turretAnle the turretAnle to set
     */
    public void setTurretAngle(double turretAnle) {
        this.turretAngle = turretAnle;
    }

    /**
     * @param tankX the tankX to set
     */
    public void setTankX(double tankX) {
        this.tankX = tankX;
    }

    /**
     * @param tankY the tankY to set
     */
    public void setTankY(double tankY) {
        this.tankY = tankY;
    }

    /**
     * @param tankWidth the tankWidth to set
     */
    public void setTankWidth(int tankWidth) {
        this.tankWidth = tankWidth;
    }

    /**
     * @param tankHeight the tankHeight to set
     */
    public void setTankHeight(int tankHeight) {
        this.tankHeight = tankHeight;
    }

    /**
     * @return the isRotating
     */
    public boolean isIsRotating() {
        return isRotating;
    }

    /**
     * @param turretX the turretX to set
     */
    public void setTurretX(double turretX) {
        this.turretX = turretX;
    }

    /**
     * @param turretY the turretY to set
     */
    public void setTurretY(double turretY) {
        this.turretY = turretY;
    }

    /**
     * @param turretRadius the turretRadius to set
     */
    public void setTurretRadius(int turretRadius) {
        this.turretRadius = turretRadius;
    }

    /**
     * @return the rotationTankX
     */
    public double getRotationTankX() {
        return rotationTankX;
    }

    /**
     * @return the rotationTankY
     */
    public double getRotationTankY() {
        return rotationTankY;
    }

    /**
     * @param rotationTankX the rotationTankX to set
     */
    public void setRotationTankX(double rotationTankX) {
        this.rotationTankX = rotationTankX;
    }

    /**
     * @param rotationTankY the rotationTankY to set
     */
    public void setRotationTankY(double rotationTankY) {
        this.rotationTankY = rotationTankY;
    }

    /**
     * @return the fuel
     */
    public double getFuel() {
        return fuel;
    }

    /**
     * @param fuel the fuel to set
     */
    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    /**
     * @return the k
     */
    public double getK() {
        return k;
    }

    /**
     * @param k the k to set
     */
    public void setK(double k) {
        this.k = k;
    }
    
    
}
